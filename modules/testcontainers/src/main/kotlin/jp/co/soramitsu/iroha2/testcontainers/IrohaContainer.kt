package jp.co.soramitsu.iroha2.testcontainers

import com.github.dockerjava.api.model.ExposedPort
import com.github.dockerjava.api.model.PortBinding
import com.github.dockerjava.api.model.Ports
import jp.co.soramitsu.iroha2.JSON_SERDE
import jp.co.soramitsu.iroha2.bytes
import jp.co.soramitsu.iroha2.client.Iroha2Client.Companion.STATUS_ENDPOINT
import jp.co.soramitsu.iroha2.toHex
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.wait.strategy.HttpWaitStrategy
import org.testcontainers.utility.DockerImageName
import org.testcontainers.utility.MountableFile
import org.testcontainers.utility.MountableFile.forHostPath
import java.io.IOException
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path
import java.time.Duration
import java.util.UUID.randomUUID
import kotlin.io.path.absolute
import kotlin.io.path.createTempFile

/**
 * Docker container for Iroha
 *
 * @constructor Creates Iroha container with given configurations
 */

open class IrohaContainer : GenericContainer<IrohaContainer> {

    constructor(config: IrohaConfig.() -> Unit = {}) : this(IrohaConfig().apply(config))

    constructor(config: IrohaConfig) : super(
        DockerImageName.parse("${config.imageName}:${config.imageTag}")
    ) {
        val publicKey = config.keyPair.public.bytes().toHex()
        val privateKey = config.keyPair.private.bytes().toHex()

        this.p2pPort = config.ports[IrohaConfig.P2P_PORT_IDX]
        this.apiPort = config.ports[IrohaConfig.API_PORT_IDX]
        this.telemetryPort = config.ports[IrohaConfig.TELEMETRY_PORT_IDX]

        this.config = config
        this.withNetwork(config.networkToJoin)
            .withEnv("IROHA2_GENESIS_PATH", DEFAULT_GENESIS_FILE_NAME)
            .withEnv("IROHA2_CONFIG_PATH", DEFAULT_CONFIG_FILE_NAME)
            .withEnv("SUMERAGI_TRUSTED_PEERS", JSON_SERDE.writeValueAsString(config.trustedPeers))
            .withEnv("IROHA_PUBLIC_KEY", "ed0120$publicKey")
            .withEnv("IROHA_PRIVATE_KEY", "{\"digest_function\": \"ed25519\", \"payload\": \"$privateKey$publicKey\"}")
            .withEnv("TORII_P2P_ADDR", "${config.alias}:$p2pPort")
            .withEnv("TORII_API_URL", "${config.alias}:$apiPort")
            .withEnv("TORII_TELEMETRY_URL", "${config.alias}:$telemetryPort")
            .withEnv("WSV_WASM_RUNTIME_CONFIG", "{\"FUEL_LIMIT\":20000000, \"MAX_MEMORY\": 524288000}")
            .withEnv("RUST_BACKTRACE", "full")
            .withExposedPorts(p2pPort, apiPort, telemetryPort)
            .withCreateContainerCmdModifier {
                it.hostConfig!!.withPortBindings(
                    PortBinding(Ports.Binding.bindPort(p2pPort), ExposedPort(p2pPort)),
                    PortBinding(Ports.Binding.bindPort(apiPort), ExposedPort(apiPort)),
                    PortBinding(Ports.Binding.bindPort(telemetryPort), ExposedPort(telemetryPort))
                )
            }
            .withNetworkAliases(config.alias)
            .withLogConsumer(config.logConsumer)
            .withCopyFileToContainer(
                forHostPath(config.genesis.writeToFile(genesisFileLocation.value)),
                DEFAULT_GENESIS_FILE_NAME
            )
            .withCopyFileToContainer(
                MountableFile.forClasspathResource(DEFAULT_CONFIG_FILE_NAME),
                DEFAULT_CONFIG_FILE_NAME
            ).also { container ->
                val command = when (config.submitGenesis) {
                    true -> "$PEER_START_COMMAND --submit-genesis"
                    false -> PEER_START_COMMAND
                }
                container.withCommand(command)
            }
            .withImagePullPolicy(config.pullPolicy)
            .also { container ->
                if (config.waitStrategy) {
                    container.waitingFor(
                        // await genesis was applied and seen in status
                        HttpWaitStrategy()
                            .forStatusCode(200)
                            .forPort(telemetryPort)
                            .forPath(STATUS_ENDPOINT)
                            .forResponsePredicate { it.readStatusBlocks()?.equals(1.0) ?: false }
                            .withStartupTimeout(CONTAINER_STARTUP_TIMEOUT)
                    )
                }
            }
    }

    val config: IrohaConfig

    private val p2pPort: Int
    private val apiPort: Int
    private val telemetryPort: Int

    private val genesisFileLocation: Lazy<Path> = lazy {
        createTempFile("genesis-", randomUUID().toString())
    }

    override fun start() {
        logger().debug("Starting Iroha container")
        if (logger().isDebugEnabled) {
            val genesisAsJson = config.genesis.asJson()
            logger().debug("Serialized genesis block: {}", genesisAsJson)
        }
        super.start()
        logger().debug("Iroha container started")
    }

    override fun stop() {
        logger().debug("Stopping Iroha container")
        super.stop()
        if (config.shouldCloseNetwork) {
            network.close()
        }
        try {
            Files.deleteIfExists(genesisFileLocation.value)
        } catch (ex: IOException) {
            logger().warn(
                "Could not remove temporary genesis file '${genesisFileLocation.value.absolute()}', error: $ex"
            )
        }
        logger().debug("Iroha container stopped")
    }

    fun getP2pUrl(): URL = URL("http", containerIpAddress, p2pPort, "")

    fun getApiUrl(): URL = URL("http", containerIpAddress, apiPort, "")

    fun getTelemetryUrl(): URL = URL("http", containerIpAddress, telemetryPort, "")

    private fun String.readStatusBlocks() = JSON_SERDE.readTree(this).get("blocks")?.doubleValue()

    // TODO: move env variables to IrohaConfig
    companion object {
        const val NETWORK_ALIAS = "iroha"
        const val DEFAULT_IMAGE_TAG = "stable"
        const val DEFAULT_IMAGE_NAME = "hyperledger/iroha2"
        const val DEFAULT_GENESIS_FILE_NAME = "genesis.json"
        const val DEFAULT_CONFIG_FILE_NAME = "config.json"
        const val PEER_START_COMMAND = "./iroha"

        val CONTAINER_STARTUP_TIMEOUT: Duration = Duration.ofSeconds(60)
    }
}
