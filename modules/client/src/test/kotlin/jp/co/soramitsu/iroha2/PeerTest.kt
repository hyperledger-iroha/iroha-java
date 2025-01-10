package jp.co.soramitsu.iroha2

import io.qameta.allure.Feature
import io.qameta.allure.Owner
import io.qameta.allure.Story
import jp.co.soramitsu.iroha2.annotations.Permission
import jp.co.soramitsu.iroha2.annotations.Sdk
import jp.co.soramitsu.iroha2.annotations.SdkTestId
import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.DomainId
import jp.co.soramitsu.iroha2.generated.PeerId
import jp.co.soramitsu.iroha2.generated.SocketAddr
import jp.co.soramitsu.iroha2.generated.SocketAddrHost
import jp.co.soramitsu.iroha2.query.QueryBuilder
import jp.co.soramitsu.iroha2.testengine.ALICE_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.ALICE_KEYPAIR
import jp.co.soramitsu.iroha2.testengine.AliceCanUnregisterAnyPeer
import jp.co.soramitsu.iroha2.testengine.DEFAULT_DOMAIN_ID
import jp.co.soramitsu.iroha2.testengine.DefaultGenesis
import jp.co.soramitsu.iroha2.testengine.IrohaConfig
import jp.co.soramitsu.iroha2.testengine.IrohaContainer
import jp.co.soramitsu.iroha2.testengine.IrohaTest
import jp.co.soramitsu.iroha2.testengine.WithIroha
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.withTimeout
import kotlinx.coroutines.withContext
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.security.KeyPair
import java.time.Duration
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@Timeout(1000)
@Owner("akostyuchenko")
@Sdk("Java/Kotlin")
@Feature("Peers")
@Disabled // https://github.com/hyperledger/iroha/issues/4999
class PeerTest : IrohaTest<AdminIroha2Client>() {

    companion object {
        private const val PEER_AMOUNT = 4
    }

    @Test
    @WithIroha([DefaultGenesis::class], amount = PEER_AMOUNT)
    @Story("Account registers a peer")
    @Permission("no_permission_required")
    @SdkTestId("register_peer")
    fun `register peer`(): Unit = runBlocking {
        val p2pPort = DEFAULT_P2P_PORT + PEER_AMOUNT
        val alias = "iroha$p2pPort"
        val address = "$alias:$p2pPort"
        val keyPair = generateKeyPair()
        val payload = keyPair.public.bytes()

        val containerJob = async {
            startNewContainer(keyPair, alias, PEER_AMOUNT)
        }
        val registerJob = async {
            registerPeer(PeerId(SocketAddr.Host(SocketAddrHost(address, p2pPort)), keyPair.public.toIrohaPublicKey()))
        }
        containerJob.await()
        registerJob.await()

        assertTrue(isPeerAvailable(address, payload))
    }

    @Disabled // https://app.zenhub.com/workspaces/iroha-v2-60ddb820813b9100181fc060/issues/gh/hyperledger/iroha-java/372
    @Test
    @WithIroha([AliceCanUnregisterAnyPeer::class], amount = PEER_AMOUNT)
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
            registerPeer(PeerId(SocketAddr.Host(SocketAddrHost(address, p2pPort)), keyPair.public.toIrohaPublicKey()))
            repeat(PEER_AMOUNT) { assertTrue(isPeerAvailable(address, payload)) }

            unregisterPeer(PeerId(SocketAddr.Host(SocketAddrHost(address, p2pPort)), keyPair.public.toIrohaPublicKey()))
            repeat(PEER_AMOUNT) { assertFalse(isPeerAvailable(address, payload)) }
        }
    }

    @Test
    @WithIroha([DefaultGenesis::class], amount = PEER_AMOUNT)
    fun `registered peer should return consistent data`(): Unit = runBlocking {
        val p2pPort = DEFAULT_P2P_PORT
        val alias = "iroha$p2pPort"
        val address = "$alias:$p2pPort"
        val keyPair = generateKeyPair()
        val payload = keyPair.public.bytes()

        startNewContainer(keyPair, alias, PEER_AMOUNT).use { container ->
            registerPeer(PeerId(SocketAddr.Host(SocketAddrHost(address, p2pPort)), keyPair.public.toIrohaPublicKey()))
            assertTrue(isPeerAvailable(address, payload))

            delay(5000)

            val peersCount = QueryBuilder.findAllPeers()
                .account(ALICE_ACCOUNT_ID)
                .buildSigned(ALICE_KEYPAIR)
                .let { client.sendQuery(it) }
                .size

            repeat(5) {
                runCatching {
                    QueryBuilder.findAllPeers()
                        .account(ALICE_ACCOUNT_ID)
                        .buildSigned(ALICE_KEYPAIR)
                        .let {
                            Iroha2Client(
                                container.getApiUrl(),
                                container.getP2pUrl(),
                            ).sendQuery(it)
                        }
                        .also { peers -> assertEquals(peers.size, peersCount) }
                        .also { return@repeat }
                }
                delay(2000)
            }
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
            this.trustedPeers = containers.map { it.extractPeerId() }
        }.also {
            withContext(Dispatchers.IO) {
                it.start()
            }
        }
    }

    private suspend fun isPeerAvailable(
        address: String,
        payload: ByteArray,
        keyPair: KeyPair = ALICE_KEYPAIR,
    ): Boolean {
        return QueryBuilder.findAllPeers()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(keyPair)
            .let { query ->
                client.sendQuery(query)
            }.any { peer ->
                val peerAddr = peer.id.address.cast<SocketAddr.Host>().socketAddrHost
                "${peerAddr.host}:${peerAddr.port}" == address && peer.id.publicKey.payload.contentEquals(payload)
            }
    }

    private suspend fun unregisterPeer(
        peerId: PeerId,
        keyPair: KeyPair = ALICE_KEYPAIR,
    ) {
        client.sendTransaction {
            account(ALICE_ACCOUNT_ID)
            unregisterPeer(peerId)
            buildSigned(keyPair)
        }.also { d ->
            withTimeout(txTimeout.plus(Duration.ofSeconds(20))) { d.await() }
        }
    }

    private suspend fun registerPeer(
        peerId: PeerId,
        account: AccountId = ALICE_ACCOUNT_ID,
        keyPair: KeyPair = ALICE_KEYPAIR,
    ) {
        client.sendTransaction {
            account(account)
            registerPeer(peerId)
            buildSigned(keyPair)
        }.also { d ->
            withTimeout(txTimeout.plus(Duration.ofSeconds(20))) { d.await() }
        }
    }

    private fun IrohaContainer.extractPeerId() = PeerId(
        SocketAddr.Host(
            SocketAddrHost(
                this.config.alias,
                this.config.ports[IrohaConfig.P2P_PORT_IDX],
            ),
        ),
        this.config.keyPair.public.toIrohaPublicKey(),
    )

    private suspend fun findDomain(id: DomainId = DEFAULT_DOMAIN_ID) = QueryBuilder
        .findDomainById(id)
        .account(super.account)
        .buildSigned(super.keyPair)
        .let { client.sendQuery(it) }
}
