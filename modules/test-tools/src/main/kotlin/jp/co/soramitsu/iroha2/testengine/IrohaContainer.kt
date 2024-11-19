package jp.co.soramitsu.iroha2.testengine

import jp.co.soramitsu.iroha2.JSON_SERDE
import jp.co.soramitsu.iroha2.bytes
import jp.co.soramitsu.iroha2.client.Iroha2Client.Companion.STATUS_ENDPOINT
import jp.co.soramitsu.iroha2.toHex
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.wait.strategy.HttpWaitStrategy
import org.testcontainers.shaded.com.google.common.io.Resources.getResource
import org.testcontainers.utility.DockerImageName
import org.testcontainers.utility.MountableFile
import org.testcontainers.utility.MountableFile.forHostPath
import java.io.IOException
import java.net.URL
import java.nio.file.Files
import java.time.Duration
import java.util.UUID.randomUUID
import kotlin.io.path.Path
import kotlin.io.path.absolute
import kotlin.io.path.readBytes

/**
 * Docker container for Iroha
 *
 * @constructor Creates Iroha container with given configurations
 */

open class IrohaContainer : GenericContainer<IrohaContainer> {

    constructor(config: IrohaConfig.() -> Unit = {}) : this(IrohaConfig().apply(config))

    constructor(config: IrohaConfig) : super(config.getFullImageName()) {
        val publicKey = config.keyPair.public.bytes().toHex()
        val privateKey = config.keyPair.private.bytes().toHex()
        val containerName = when (config.submitGenesis) {
            true -> "MAIN_${config.alias}_${randomUUID().toString().split("-").last()}"
            false -> config.alias
        }

        val genesisPublicKey = config.genesisKeyPair.public.bytes().toHex()
        val genesisPrivateKey = config.genesisKeyPair.private.bytes().toHex()

        val topology = config.trustedPeers.map { it.id.publicKey.payload.toHex(true) }

        this.p2pPort = config.ports[IrohaConfig.P2P_PORT_IDX]
        this.apiPort = config.ports[IrohaConfig.API_PORT_IDX]

        this.config = config

        this.withNetwork(config.networkToJoin)
            .withEnv("CHAIN", "00000000-0000-0000-0000-000000000000")
            .withEnv(
                "TRUSTED_PEERS",
                "[" +
                    config.trustedPeers.joinToString(",") {
                        JSON_SERDE.writeValueAsString(it.id.publicKey).trimEnd('"') + "@" + JSON_SERDE.writeValueAsString(it.address).trimStart(
                            '"',
                        )
                    } + "]",
            )
            .withEnv("PUBLIC_KEY", "ed0120$publicKey")
            .withEnv("PRIVATE_KEY", "802620$privateKey")
            .withEnv("GENESIS_PUBLIC_KEY", "ed0120$genesisPublicKey")
            .withEnv("P2P_PUBLIC_ADDRESS", "${config.alias}:$p2pPort")
            .withEnv("P2P_ADDRESS", "${config.alias}:$p2pPort")
            .withEnv("API_ADDRESS", "${config.alias}:$apiPort")
            .withEnv("TORII_FETCH_SIZE", config.fetchSize.toString())
            .withCreateContainerCmdModifier { cmd -> cmd.withName(containerName) }
            .also { container ->
                if (config.submitGenesis) {
                    container.withEnv("GENESIS_PRIVATE_KEY", "802620$genesisPrivateKey")
                    container.withEnv("GENESIS", "/tmp/genesis.signed.scale")
                    container.withEnv("TOPOLOGY", JSON_SERDE.writeValueAsString(topology))
                }
            }
            .also { container -> config.envs.forEach { (k, v) -> container.withEnv(k, v) } }
            .withExposedPorts(p2pPort, apiPort)
            .withNetworkAliases(config.alias)
            .withLogConsumer(config.logConsumer)
            .withCopyToContainer(
                forHostPath(configDirLocation),
                "/$DEFAULT_CONFIG_DIR",
            )
            .withCopyToContainer(
                forHostPath(configDirLocation),
                "/app/.cache/wasmtime",
            ).also {
                config.genesis?.writeToFile(genesisFileLocation)
                config.genesisPath?.also { path -> Files.copy(Path(path).toAbsolutePath(), genesisFileLocation) }

                if (config.executorPath != null) {
                    Path(config.executorPath!!).toAbsolutePath().readBytes().let { content ->
                        executorFileLocation.toFile().writeBytes(content)
                    }
                } else {
                    getResource(DEFAULT_EXECUTOR_FILE_NAME).readBytes().let { content ->
                        executorFileLocation.toFile().writeBytes(content)
                    }
                }
            }.also { container ->
                if (config.submitGenesis) {
                    container.withCopyFileToContainer(
                        MountableFile.forClasspathResource("start.sh"),
                        "$configDirLocation/start.sh",
                    )
                    container.withCommand("sh", "$configDirLocation/start.sh")
                }
            }
            .withImagePullPolicy(config.pullPolicy)
            .also { container ->
                if (config.waitStrategy) {
                    container.waitingFor(
                        // await genesis was applied and seen in status
                        HttpWaitStrategy()
                            .forStatusCode(200)
                            .forPort(apiPort)
                            .forPath(STATUS_ENDPOINT)
                            .forResponsePredicate { it.readStatusBlocks()?.equals(1.0) ?: false }
                            .withStartupTimeout(CONTAINER_STARTUP_TIMEOUT),
                    )
                }
            }
    }

    val config: IrohaConfig

    private val p2pPort: Int
    private val apiPort: Int

    private val configDirLocation = createTempDir("$DEFAULT_CONFIG_DIR-", randomUUID().toString()).toPath()

    private val genesisFileLocation = Path("$configDirLocation/$DEFAULT_GENESIS_FILE_NAME")
    private val executorFileLocation = Path("$configDirLocation/$DEFAULT_EXECUTOR_FILE_NAME")

    override fun start() {
        logger().debug("Starting Iroha container")
        super.start()
        logger().debug("Iroha container started")
    }

    override fun stop() {
        logger().debug("Stopping Iroha container")
        super.stop()
        if (config.shouldCloseNetwork) {
            network!!.close()
        }
        try {
            configDirLocation.toFile().deleteRecursively()
        } catch (ex: IOException) {
            logger().warn(
                "Could not remove temporary genesis file '${genesisFileLocation.absolute()}', error: $ex",
            )
        }
        logger().debug("Iroha container stopped")
    }

    fun getP2pUrl(): URL = URL("http", host, this.getMappedPort(p2pPort), "")

    fun getApiUrl(): URL = URL("http", host, this.getMappedPort(apiPort), "")

    private fun String.readStatusBlocks() = JSON_SERDE.readTree(this).get("blocks")?.doubleValue()

    companion object {
        private fun IrohaConfig.getFullImageName() = when (this.imageTag.contains("sha256")) {
            true -> "${this.imageName}@${this.imageTag}"
            false -> "${this.imageName}:${this.imageTag}"
        }.let { DockerImageName.parse(it) }

        const val NETWORK_ALIAS = "iroha"
        const val DEFAULT_IMAGE_TAG = "dev"
        const val DEFAULT_IMAGE_NAME = "hyperledger/iroha"
        const val DEFAULT_EXECUTOR_FILE_NAME = "executor.wasm"
        const val DEFAULT_GENESIS_FILE_NAME = "genesis.json"
        const val DEFAULT_CONFIG_DIR = "config"

        val CONTAINER_STARTUP_TIMEOUT: Duration = Duration.ofSeconds(60)
    }
}
