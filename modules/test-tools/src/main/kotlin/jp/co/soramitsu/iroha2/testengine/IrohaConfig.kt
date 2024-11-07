package jp.co.soramitsu.iroha2.testengine

import jp.co.soramitsu.iroha2.DEFAULT_API_PORT
import jp.co.soramitsu.iroha2.DEFAULT_P2P_PORT
import jp.co.soramitsu.iroha2.Genesis
import jp.co.soramitsu.iroha2.generateKeyPair
import jp.co.soramitsu.iroha2.generated.PeerId
import jp.co.soramitsu.iroha2.generated.SocketAddr
import jp.co.soramitsu.iroha2.generated.SocketAddrHost
import jp.co.soramitsu.iroha2.keyPairFromHex
import jp.co.soramitsu.iroha2.toIrohaPublicKey
import org.slf4j.LoggerFactory.getLogger
import org.testcontainers.containers.Network
import org.testcontainers.containers.Network.newNetwork
import org.testcontainers.containers.output.OutputFrame
import org.testcontainers.containers.output.Slf4jLogConsumer
import org.testcontainers.images.ImagePullPolicy
import org.testcontainers.images.PullPolicy
import java.security.KeyPair
import java.time.Duration
import java.util.function.Consumer

/**
 * Iroha configuration
 */
class IrohaConfig(
    var networkToJoin: Network = newNetwork(),
    var logConsumer: Consumer<OutputFrame> = Slf4jLogConsumer(getLogger(IrohaContainer::class.java)),
    var genesisPath: String? = null, // first option
    var genesis: Genesis? = null, // second option
    var imageTag: String = IrohaContainer.DEFAULT_IMAGE_TAG,
    var imageName: String = IrohaContainer.DEFAULT_IMAGE_NAME,
    var pullPolicy: ImagePullPolicy = PullPolicy.ageBased(Duration.ofMinutes(10)),
    var alias: String = IrohaContainer.NETWORK_ALIAS + DEFAULT_P2P_PORT,
    var keyPair: KeyPair = generateKeyPair(),
    var genesisKeyPair: KeyPair = keyPairFromHex(GENESIS_ADDRESS, GENESIS_PRIVATE_KEY),
    var trustedPeers: List<PeerId> = listOf(
        PeerId(SocketAddr.Host(SocketAddrHost(alias, DEFAULT_P2P_PORT)), keyPair.public.toIrohaPublicKey()),
    ),
    var ports: List<Int> = listOf(DEFAULT_P2P_PORT, DEFAULT_API_PORT),
    var shouldCloseNetwork: Boolean = true,
    var waitStrategy: Boolean = true,
    var submitGenesis: Boolean = true,
    var envs: Map<String, String> = emptyMap(),
    var fetchSize: Int = 10,
    var executorPath: String? = null,
) {
    companion object {
        const val P2P_PORT_IDX = 0
        const val API_PORT_IDX = 1
    }
}
