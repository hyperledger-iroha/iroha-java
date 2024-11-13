package jp.co.soramitsu.iroha2.testengine

import jp.co.soramitsu.iroha2.AdminIroha2AsyncClient
import jp.co.soramitsu.iroha2.AdminIroha2Client
import jp.co.soramitsu.iroha2.DEFAULT_API_PORT
import jp.co.soramitsu.iroha2.DEFAULT_P2P_PORT
import jp.co.soramitsu.iroha2.Genesis
import jp.co.soramitsu.iroha2.Genesis.Companion.toSingle
import jp.co.soramitsu.iroha2.IrohaSdkException
import jp.co.soramitsu.iroha2.asAccountId
import jp.co.soramitsu.iroha2.cast
import jp.co.soramitsu.iroha2.client.Iroha2AsyncClient
import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.generateKeyPair
import jp.co.soramitsu.iroha2.generated.ChainId
import jp.co.soramitsu.iroha2.generated.PeerId
import jp.co.soramitsu.iroha2.generated.SocketAddr
import jp.co.soramitsu.iroha2.generated.SocketAddrHost
import jp.co.soramitsu.iroha2.keyPairFromHex
import jp.co.soramitsu.iroha2.model.IrohaUrls
import jp.co.soramitsu.iroha2.toIrohaPublicKey
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.InvocationInterceptor
import org.junit.jupiter.api.extension.ReflectiveInvocationContext
import org.yaml.snakeyaml.Yaml
import java.io.File
import java.lang.reflect.Field
import java.lang.reflect.Method
import java.security.KeyPair
import java.util.Collections
import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.memberProperties

/**
 * Runner for Iroha2 Docker containers
 */
class IrohaRunnerExtension : InvocationInterceptor, BeforeEachCallback {

    private val resources: MutableMap<String, List<AutoCloseable>> = Collections.synchronizedMap(mutableMapOf())

    private val yaml = Yaml()

    override fun beforeEach(context: ExtensionContext) = runBlocking {
        // init container and client if annotation was passed on test method
        val testId = context.testId()
        resources[testId] = initIfRequested(context)
    }

    override fun interceptTestMethod(
        invocation: InvocationInterceptor.Invocation<Void>,
        invocationContext: ReflectiveInvocationContext<Method>,
        extensionContext: ExtensionContext,
    ) = runBlocking {
        val testId = extensionContext.testId()
        try {
            // invoke actual test method
            super.interceptTestMethod(invocation, invocationContext, extensionContext)
        } finally {
            // stop container and client if they were created
            resources[testId]?.forEach { it.close() }
        }
    }

    private suspend fun initIfRequested(
        extensionContext: ExtensionContext,
    ): List<AutoCloseable> = coroutineScope {
        val withIroha = extensionContext.element.get()
            .annotations.filterIsInstance<WithIroha>()
            .firstOrNull()
        val withIrohaManual = extensionContext.element.get()
            .annotations.filterIsInstance<WithIrohaManual>()
            .firstOrNull()

        return@coroutineScope when {
            withIroha != null -> withIroha.init(extensionContext)
            withIrohaManual != null -> withIrohaManual.init(extensionContext).let { emptyList() }
            else -> emptyList()
        }
    }

    private suspend fun WithIroha.init(extensionContext: ExtensionContext): List<AutoCloseable> {
        val testInstance = extensionContext.testInstance.get().cast<IrohaTest<*>>()
        val utilizedResources = mutableListOf<AutoCloseable>()

        // start containers
        val containers = createContainers(this, testInstance)
        utilizedResources.addAll(containers)

        val properties = testInstance::class.memberProperties

        // inject `KeyPair` if it is declared in test class
        setPropertyValue(properties, testInstance) { ALICE_ACCOUNT_ID }

        // inject `AccountId` if it is declared in test class
        setPropertyValue(properties, testInstance) { ALICE_KEYPAIR }

        // inject `List<IrohaContainer>` if it is declared in test class
        setPropertyValue(properties, testInstance) { containers }

        // inject `Iroha2Client` if it is declared in test class
        setPropertyValue(properties, testInstance) {
            Iroha2Client(
                containers.map { IrohaUrls(it.getApiUrl(), it.getP2pUrl()) }.toMutableList(),
            ).also { utilizedResources.add(it) }
        }

        // inject `AdminIroha2Client` if it is declared in test class
        setPropertyValue(properties, testInstance) {
            AdminIroha2Client(
                containers.map { IrohaUrls(it.getApiUrl(), it.getP2pUrl()) }.toMutableList(),
            ).also { utilizedResources.add(it) }
        }

        // inject `Iroha2AsyncClient` if it is declared in test class
        setPropertyValue(properties, testInstance) {
            Iroha2AsyncClient(
                containers.map { IrohaUrls(it.getApiUrl(), it.getP2pUrl()) }.toMutableList(),
            ).also { utilizedResources.add(it) }
        }

        // inject `AdminIroha2AsyncClient` if it is declared in test class
        setPropertyValue(properties, testInstance) {
            AdminIroha2AsyncClient(
                containers.map { IrohaUrls(it.getApiUrl(), it.getP2pUrl()) }.toMutableList(),
            ).also { utilizedResources.add(it) }
        }

        return utilizedResources
    }

    private fun WithIrohaManual.init(extensionContext: ExtensionContext) {
        val testInstance = extensionContext.testInstance.get()
        val properties = testInstance::class.memberProperties

        val urls = when (this.dockerComposeFile.isEmpty()) {
            true -> this.apiUrls.mapIndexed { idx, url -> IrohaUrls(url, peerUrls[idx]) }
            else -> File(this.dockerComposeFile).readDockerComposeData()
        } ?: throw IrohaSdkException("Iroha URLs required")

        // inject `KeyPair` if it is declared in test class
        setPropertyValue(properties, testInstance) { keyPairFromHex(this.publicKey, this.privateKey) }

        // inject `AccountId` if it is declared in test class
        setPropertyValue(properties, testInstance) { this.account.asAccountId() }

        // inject `Iroha2Client` if it is declared in test class
        setPropertyValue(properties, testInstance) { Iroha2Client(urls) }

        // inject `AdminIroha2Client` if it is declared in test class
        setPropertyValue(properties, testInstance) { AdminIroha2Client(urls) }

        // inject `Iroha2AsyncClient` if it is declared in test class
        setPropertyValue(properties, testInstance) { Iroha2AsyncClient(urls) }

        // inject `AdminIroha2AsyncClient` if it is declared in test class
        setPropertyValue(properties, testInstance) { AdminIroha2AsyncClient(urls) }
    }

    private fun File.readDockerComposeData(): List<IrohaUrls>? {
        fun String?.convertUrl() = this
            ?.replace("${IrohaContainer.NETWORK_ALIAS}[0-9]*".toRegex(), "localhost")
            ?.let { "http://$it" }
            ?: throw IllegalArgumentException("Invalid docker-compose file")

        val all = runCatching {
            yaml.load<Map<String, *>>(this.inputStream())["services"]
                ?.cast<Map<String, *>>()?.values?.toList()
                ?.map { it?.cast<Map<String, *>>()?.get("environment") }
                ?.cast<List<Map<String, String>>>() ?: return null
        }.onFailure { return null }.getOrThrow()

        return all.map {
            IrohaUrls(
                it["TORII_API_URL"].convertUrl(),
                it["TORII_P2P_ADDR"].convertUrl(),
            )
        }
    }

    private inline fun <reified V : Any> setPropertyValue(
        declaredProperties: Collection<KProperty1<out Any, *>>,
        testClassInstance: Any,
        valueToSet: () -> V,
    ) {
        declaredProperties
            .filter { it.returnType.classifier == V::class }
            .filterIsInstance<KMutableProperty1<out Any, V>>()
            .also {
                check(it.size <= 1) {
                    """
                        "Found more than one property with type `${V::class.qualifiedName}`
                         in test class `${testClassInstance::class::qualifiedName}`"
                    """.trimIndent()
                }
            }.firstOrNull()
            ?.setter
            ?.call(testClassInstance, valueToSet())
    }

    private suspend fun createContainers(
        withIroha: WithIroha,
        testInstance: IrohaTest<*>,
    ): List<IrohaContainer> = coroutineScope {
        val keyPairs = mutableListOf<KeyPair>()
        val portsList = mutableListOf<List<Int>>()

        repeat(withIroha.amount) { n ->
            keyPairs.add(generateKeyPair())
            portsList.add(listOf(DEFAULT_P2P_PORT + n, DEFAULT_API_PORT + n))
        }
        val peerIds = keyPairs.mapIndexed { i: Int, kp: KeyPair ->
            val p2pPort = portsList[i][IrohaConfig.P2P_PORT_IDX]
            kp.toPeerId(IrohaContainer.NETWORK_ALIAS + p2pPort, p2pPort)
        }
        val deferredSet = mutableSetOf<Deferred<*>>()
        val containers = Collections.synchronizedList(ArrayList<IrohaContainer>(withIroha.amount))
        repeat(withIroha.amount) { n ->
            async {
                val p2pPort = portsList[n][IrohaConfig.P2P_PORT_IDX]
                val container = IrohaContainer {
                    this.networkToJoin = testInstance.network
                    when {
                        withIroha.source.isNotEmpty() -> genesisPath = withIroha.source
                        else -> genesis = withIroha.sources.map { genesisInstance(it) }.toSingle()
                    }
                    this.alias = IrohaContainer.NETWORK_ALIAS + p2pPort
                    this.keyPair = keyPairs[n]
                    this.trustedPeers = peerIds
                    this.ports = portsList[n]
                    this.imageName = testInstance.imageName
                    this.imageTag = testInstance.imageTag
                    this.envs = withIroha.configs.associate { config ->
                        config.split(IROHA_CONFIG_DELIMITER).let {
                            it.first() to it.last()
                        }
                    }
                    // only first peer should have --submit-genesis in peer start command
                    this.submitGenesis = n == 0
                    if (withIroha.executorSource.isNotEmpty()) {
                        this.executorPath = withIroha.executorSource
                    }
                }
                withContext(Dispatchers.IO) {
                    container.start()
                }
                containers.add(container)
            }.let { deferredSet.add(it) }
        }

        withContext(Dispatchers.IO) {
            deferredSet.forEach { it.await() }
        }

        containers
    }

    private fun KeyPair.toPeerId(host: String, port: Int) = PeerId(
        SocketAddr.Host(SocketAddrHost(host, port)),
        this.public.toIrohaPublicKey(),
    )

    private fun ExtensionContext.testId() = "${this.testClass.get().name}_${this.testMethod.get().name}"

    private fun genesisInstance(clazz: KClass<out Genesis>): Genesis = clazz.createInstance().let { genesis ->
        val tx = genesis.transaction.copy(
            chain = ChainId("00000000-0000-0000-0000-000000000000"),
        )
        val transactionField = findField(clazz.java, "transaction")
        transactionField.isAccessible = true
        transactionField.set(genesis, tx)

        return genesis
    }

    private fun findField(clazz: Class<*>, fieldName: String): Field {
        return try {
            clazz.getDeclaredField(fieldName)
        } catch (e: NoSuchFieldException) {
            when (clazz.superclass == null) {
                true -> throw e
                false -> findField(clazz.superclass, fieldName)
            }
        }
    }
}
