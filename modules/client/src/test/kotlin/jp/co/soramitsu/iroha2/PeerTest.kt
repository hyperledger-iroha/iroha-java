package jp.co.soramitsu.iroha2

import io.qameta.allure.Feature
import io.qameta.allure.Owner
import io.qameta.allure.Story
import jp.co.soramitsu.iroha2.annotations.Permission
import jp.co.soramitsu.iroha2.annotations.Sdk
import jp.co.soramitsu.iroha2.annotations.SdkTestId
import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.generated.DomainId
import jp.co.soramitsu.iroha2.generated.Peer
import jp.co.soramitsu.iroha2.generated.PeerId
import jp.co.soramitsu.iroha2.generated.SocketAddr
import jp.co.soramitsu.iroha2.generated.SocketAddrHost
import jp.co.soramitsu.iroha2.query.QueryBuilder
import jp.co.soramitsu.iroha2.testengine.ALICE_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.ALICE_KEYPAIR
import jp.co.soramitsu.iroha2.testengine.AliceCanManagePeers
import jp.co.soramitsu.iroha2.testengine.DEFAULT_DOMAIN_ID
import jp.co.soramitsu.iroha2.testengine.DefaultGenesis
import jp.co.soramitsu.iroha2.testengine.IrohaConfig
import jp.co.soramitsu.iroha2.testengine.IrohaContainer
import jp.co.soramitsu.iroha2.testengine.IrohaTest
import jp.co.soramitsu.iroha2.testengine.WithIroha
import jp.co.soramitsu.iroha2.transaction.Register
import jp.co.soramitsu.iroha2.transaction.Unregister
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.withTimeout
import kotlinx.coroutines.withContext
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.security.KeyPair
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@Timeout(1000)
@Owner("akostyuchenko")
@Sdk("Java/Kotlin")
@Feature("Peers")
class PeerTest : IrohaTest<AdminIroha2Client>() {

    companion object {
        private const val PEER_AMOUNT = 4
    }

    @Test
    @WithIroha([AliceCanManagePeers::class], amount = PEER_AMOUNT)
    @Story("Account registers a peer")
    @Permission("no_permission_required")
    @SdkTestId("register_peer")
    fun `register peer`(): Unit = runBlocking {
        val keyPair = generateKeyPair()
        val payload = keyPair.public.bytes()

        Register.peer(PeerId(keyPair.public.toIrohaPublicKey())).execute(client).also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        assertTrue(isPeerRegistered(payload))
    }

    @Test
    @WithIroha([AliceCanManagePeers::class], amount = PEER_AMOUNT)
    @Story("Account unregisters a peer")
    @Permission("no_permission_required")
    @SdkTestId("unregister_peer")
    fun `unregister peer`(): Unit = runBlocking {
        val p2pPort = DEFAULT_P2P_PORT
        val alias = "iroha$p2pPort"
        val address = "$alias:$p2pPort"
        val keyPair = generateKeyPair()
        val payload = keyPair.public.bytes()

        startNewContainer(keyPair, alias, PEER_AMOUNT).use {
            Register.peer(PeerId(keyPair.public.toIrohaPublicKey())).execute(client).also { d ->
                withTimeout(txTimeout) { d.await() }
            }

            assertTrue(isPeerRegistered(payload))
            Unregister.peer(PeerId(keyPair.public.toIrohaPublicKey())).execute(client).also { d ->
                withTimeout(txTimeout) { d.await() }
            }

            assertFalse(isPeerRegistered(payload))
        }
    }

    @Test
    @WithIroha([AliceCanManagePeers::class], amount = PEER_AMOUNT)
    fun `registered peer should return consistent data`(): Unit = runBlocking {
        val p2pPort = DEFAULT_P2P_PORT
        val alias = "iroha$p2pPort"
        val address = "$alias:$p2pPort"
        val keyPair = generateKeyPair()
        val payload = keyPair.public.bytes()

        startNewContainer(keyPair, alias, PEER_AMOUNT).use { container ->
            Register.peer(PeerId(keyPair.public.toIrohaPublicKey())).execute(client).also { d ->
                withTimeout(txTimeout) { d.await() }
            }
            assertTrue(isPeerRegistered(payload))

            delay(5000)
            val peersCount = QueryBuilder.findPeers()
                .account(ALICE_ACCOUNT_ID)
                .buildSigned(ALICE_KEYPAIR)
                .let { client.sendQuery(it) }
                .size

            QueryBuilder.findPeers()
                .account(ALICE_ACCOUNT_ID)
                .buildSigned(ALICE_KEYPAIR)
                .let {
                    Iroha2Client(
                        listOf(container.getApiUrl()),
                        container.config.chain,
                        ALICE_ACCOUNT_ID,
                        ALICE_KEYPAIR,
                    ).sendQuery(it)
                }
                .also { peers -> assertEquals(peers.size, peersCount) }
        }
    }

    @Test
    @WithIroha([DefaultGenesis::class], amount = PEER_AMOUNT)
    fun `round-robin load balancing test`(): Unit = runBlocking {
        repeat(PEER_AMOUNT + 1) {
            assertEquals(findDomain(DEFAULT_DOMAIN_ID).id, DEFAULT_DOMAIN_ID)
        }
    }

    private suspend fun startNewContainer(
        keyPair: KeyPair,
        alias: String,
        amount: Int,
    ): IrohaContainer = coroutineScope {
        IrohaContainer {
            this.waitStrategy = false
            this.keyPair = keyPair
            this.alias = alias
            this.networkToJoin = containers.first().network ?: throw IrohaSdkException("Container network not found")
            this.submitGenesis = false
            this.ports = listOf(DEFAULT_P2P_PORT + amount, DEFAULT_API_PORT + amount)
            this.trustedPeers = containers.map { it.extractPeer() }
        }.also {
            withContext(Dispatchers.IO) {
                it.start()
            }
        }
    }

    private suspend fun isPeerRegistered(payload: ByteArray, keyPair: KeyPair = ALICE_KEYPAIR): Boolean = QueryBuilder.findPeers()
        .account(ALICE_ACCOUNT_ID)
        .buildSigned(keyPair)
        .let { query ->
            client.sendQuery(query)
        }.any { peer ->
            peer.publicKey.payload.contentEquals(payload)
        }

    private fun IrohaContainer.extractPeer() = Peer(
        SocketAddr.Host(
            SocketAddrHost(
                this.config.alias,
                this.config.ports[IrohaConfig.P2P_PORT_IDX],
            ),
        ),
        PeerId(this.config.keyPair.public.toIrohaPublicKey()),
    )

    private suspend fun findDomain(id: DomainId = DEFAULT_DOMAIN_ID) = QueryBuilder
        .findDomainById(id)
        .account(client.authority)
        .buildSigned(client.keyPair)
        .let { client.sendQuery(it)!! }
}
