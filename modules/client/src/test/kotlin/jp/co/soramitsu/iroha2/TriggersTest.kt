package jp.co.soramitsu.iroha2

import io.qameta.allure.Feature
import io.qameta.allure.Owner
import io.qameta.allure.Story
import jp.co.soramitsu.iroha2.annotations.Sdk
import jp.co.soramitsu.iroha2.annotations.SdkTestId
import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.AssetType
import jp.co.soramitsu.iroha2.generated.AssetValue
import jp.co.soramitsu.iroha2.generated.EventFilterBox
import jp.co.soramitsu.iroha2.generated.InstructionBox
import jp.co.soramitsu.iroha2.generated.Metadata
import jp.co.soramitsu.iroha2.generated.Name
import jp.co.soramitsu.iroha2.generated.Repeats
import jp.co.soramitsu.iroha2.generated.TriggerId
import jp.co.soramitsu.iroha2.query.QueryBuilder
import jp.co.soramitsu.iroha2.testengine.ALICE_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.ALICE_KEYPAIR
import jp.co.soramitsu.iroha2.testengine.ALICE_PUBLIC_KEY
import jp.co.soramitsu.iroha2.testengine.AliceHas100XorAndPermissionToMintAndBurn
import jp.co.soramitsu.iroha2.testengine.BOB_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.DEFAULT_ASSET_ID
import jp.co.soramitsu.iroha2.testengine.DEFAULT_DOMAIN_ID
import jp.co.soramitsu.iroha2.testengine.IROHA_CONFIG_DELIMITER
import jp.co.soramitsu.iroha2.testengine.IrohaTest
import jp.co.soramitsu.iroha2.testengine.WithIroha
import jp.co.soramitsu.iroha2.testengine.XOR_DEFINITION_ID
import jp.co.soramitsu.iroha2.transaction.EntityFilters
import jp.co.soramitsu.iroha2.transaction.EventFilters
import jp.co.soramitsu.iroha2.transaction.Filters
import jp.co.soramitsu.iroha2.transaction.Instructions
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.withTimeout
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigInteger
import java.security.KeyPair
import java.time.Duration
import java.time.Instant
import java.util.Date
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@Feature("Triggers")
@Owner("akostyuchenko")
@Sdk("Java/Kotlin")
class TriggersTest : IrohaTest<Iroha2Client>() {

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Story("Data created trigger mints asset upon asset definition creation")
    @SdkTestId("data_created_trigger")
    fun `data created trigger`(): Unit = runBlocking {
        val triggerId = TriggerId(name = "data_trigger".asName())
        val newAssetName = "token1"

        // check account assets before trigger
        val query = QueryBuilder.findAllAssetsDefinitions()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
        val assetDefinitions = client.sendQuery(query)
        assertEquals(1, assetDefinitions.size)
        val asset = assetDefinitions.first { it.id.name.string == "xor" }
        assertNotNull(asset)

        // Check default asset quantity before trigger
        val prevQuantity = checkDefaultAssetQuantity()
        assertEquals(100L, prevQuantity)

        val filter = EventFilterBox.Data(
            EntityFilters.byAssetDefinition(1),
        )
        client.sendTransaction {
            accountId = ALICE_ACCOUNT_ID
            registerEventTrigger(
                triggerId,
                listOf(Instructions.mintAsset(DEFAULT_ASSET_ID, 1)),
                Repeats.Indefinitely(),
                ALICE_ACCOUNT_ID,
                Metadata(mapOf()),
                filter,
            )
            buildSigned(ALICE_KEYPAIR)
        }.also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        // register new asset
        // after that trigger should mint DEFAULT_ASSET_ID
        createNewAsset(newAssetName, assetDefinitions.size)

        // check new quantity after trigger is run
        val newQuantity = checkDefaultAssetQuantity()
        assertEquals(prevQuantity + 1L, newQuantity)
    }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Story("Pre commit trigger mints asset to account for every transaction")
    @SdkTestId("pre_commit_trigger_should_mint_asset_to_account_for_every_transaction")
    fun `pre commit trigger should mint asset to account for every transaction`(): Unit = runBlocking {
        val triggerId = TriggerId(name = "pre_commit_trigger".asName())
        val newAssetName = "token1"

        // check account assets before trigger
        val query = QueryBuilder.findAllAssetsDefinitions()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
        val assetDefinitions = client.sendQuery(query)
        assertEquals(1, assetDefinitions.size)

        // check DEFAULT_ASSET_ID quantity before trigger
        val prevQuantity = checkDefaultAssetQuantity()
        assertEquals(100L, prevQuantity)

        // register pre commit trigger
        client.sendTransaction {
            accountId = ALICE_ACCOUNT_ID
            registerPreCommitTrigger(
                triggerId,
                listOf(Instructions.mintAsset(DEFAULT_ASSET_ID, 10)),
                Repeats.Indefinitely(),
                ALICE_ACCOUNT_ID,
            )
            buildSigned(ALICE_KEYPAIR)
        }.also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        // check DEFAULT_ASSET_ID quantity after trigger is run
        var newQuantity = checkDefaultAssetQuantity()
        assertEquals(110L, newQuantity)

        // register new asset
        // after that trigger should mint 10 more quantity to DEFAULT_ASSET_ID
        createNewAsset(newAssetName, assetDefinitions.size)

        // check DEFAULT_ASSET_ID quantity after trigger is run
        newQuantity = checkDefaultAssetQuantity()
        assertEquals(120L, newQuantity)

        // transfer asset instruction just to test trigger
        client.sendTransaction {
            account(ALICE_ACCOUNT_ID)
            transferAsset(DEFAULT_ASSET_ID, 100, BOB_ACCOUNT_ID)
            buildSigned(ALICE_KEYPAIR)
        }.also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        // check DEFAULT_ASSET_ID quantity after trigger is run
        newQuantity = checkDefaultAssetQuantity()
        assertEquals(30L, newQuantity)
    }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Story("Executable trigger mints asset")
    @SdkTestId("executable_trigger")
    fun `executable trigger`(): Unit = runBlocking {
        val triggerId = TriggerId(name = "executable_trigger".asName())

        client.sendTransaction {
            accountId = ALICE_ACCOUNT_ID
            registerExecutableTrigger(
                triggerId,
                listOf(Instructions.mintAsset(DEFAULT_ASSET_ID, 1)),
                Repeats.Exactly(1L),
                ALICE_ACCOUNT_ID,
            )
            executeTrigger(triggerId)
            buildSigned(ALICE_KEYPAIR)
        }.also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        assertEquals(101L, readQuantity())
    }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class], configs = ["LOG_LEVEL${IROHA_CONFIG_DELIMITER}TRACE"])
    @Story("Endless time trigger decreases asset quantity continuously")
    @SdkTestId("endless_time_trigger")
    fun `endless time trigger`(): Unit = runBlocking {
        val triggerId = TriggerId(name = Name("endless_time_trigger"))

        sendAndAwaitTimeTrigger(
            triggerId,
            Repeats.Indefinitely(),
            Instructions.burnAsset(DEFAULT_ASSET_ID, 1),
        )
        sendAndWait10Txs()

        delay(3000)
        val q = readQuantity()
        assert(q <= 90L)
    }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Story("Time trigger executes a limited number of times")
    @SdkTestId("time_trigger_execution_repeats_few_times")
    fun `time trigger execution repeats few times`(): Unit = runBlocking {
        val triggerId = TriggerId(name = Name("time_trigger"))

        sendAndAwaitTimeTrigger(
            triggerId,
            Repeats.Exactly(5L),
            Instructions.burnAsset(DEFAULT_ASSET_ID, 1),
        )
        sendAndWait10Txs()

        delay(3000)
        assertEquals(95, readQuantity())
    }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Story("Wasm trigger mints NFT for every user")
    @SdkTestId("wasm_trigger_to_mint_nft_for_every_user")
    fun `wasm trigger to mint nft for every user and update trigger metadata`(): Unit = runBlocking {
        val triggerId = TriggerId(name = "wasm_trigger".asName())

        val currentTime = Date().time + 10000
        val filter = EventFilterBox.Time(
            EventFilters.timeEventFilter(BigInteger.valueOf(currentTime), BigInteger.valueOf(1000L)),
        )
        val wasm = this.javaClass.classLoader
            .getResource("create_nft_for_alice_smartcontract.wasm")
            .readBytes()

        client.tx {
            registerWasmTrigger(
                triggerId,
                wasm,
                Repeats.Indefinitely(),
                ALICE_ACCOUNT_ID,
                Metadata(mapOf()),
                filter,
            )
        }
        keepNetworkBusyAndCheckAssetDefinitionIds()

        val testKey = "key02357123"
        val testValue = "value986441123"
        client.tx { setKeyValue(triggerId, testKey.asName(), testValue) }

        delay(15000)

        QueryBuilder.findTriggerById(triggerId)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .also { assertEquals(testValue, it.action.metadata.getStringValue(testKey)) }
    }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Story("Wasm trigger mints NFT for every user when trigger metadata is updated")
    @SdkTestId("wasm_trigger_to_mint_nft_for_every_user_on_update_trigger_metadata_event")
    fun `wasm trigger to mint nft for every user on update trigger metadata event`(): Unit = runBlocking {
        val wasmTriggerId = TriggerId(name = "wasm_trigger".asName())
        val setKeyValueTriggerId = TriggerId(name = "update_trigger".asName())

        val filter = Filters.data(
            EntityFilters.byTrigger(1, wasmTriggerId),
        )
        val wasm = this.javaClass.classLoader
            .getResource("create_nft_for_alice_smartcontract.wasm")
            .readBytes()

        client.tx {
            registerWasmTrigger(
                wasmTriggerId,
                wasm,
                Repeats.Indefinitely(),
                ALICE_ACCOUNT_ID,
                Metadata(mapOf()),
                filter,
            )
        }
        val testKey = "key"
        val testValue = "value"
        client.tx {
            registerExecutableTrigger(
                setKeyValueTriggerId,
                listOf(Instructions.setKeyValue(wasmTriggerId, testKey.asName(), testValue)),
                Repeats.Exactly(1L),
                ALICE_ACCOUNT_ID,
            )
            executeTrigger(setKeyValueTriggerId)
        }

        keepNetworkBusyAndCheckAssetDefinitionIds()

        QueryBuilder.findTriggerById(wasmTriggerId)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .also { assertEquals(testValue, it.action.metadata.getStringValue(testKey)) }
    }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Story("Unregister an executable trigger")
    @SdkTestId("unregister_executable_trigger")
    fun `unregister executable trigger`(): Unit = runBlocking {
        val triggerName = "executable_trigger"
        val triggerId = TriggerId(name = triggerName.asName())

        client.sendTransaction {
            accountId = ALICE_ACCOUNT_ID
            registerExecutableTrigger(
                triggerId,
                listOf(Instructions.mintAsset(DEFAULT_ASSET_ID, 1)),
                Repeats.Exactly(1L),
                ALICE_ACCOUNT_ID,
            )
            buildSigned(ALICE_KEYPAIR)
        }.also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        client.sendTransaction {
            accountId = ALICE_ACCOUNT_ID
            unregisterTrigger(triggerName)
            buildSigned(ALICE_KEYPAIR)
        }.also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        assertThrows<IrohaClientException> {
            runBlocking {
                QueryBuilder.findTriggerById(triggerId)
                    .account(ALICE_ACCOUNT_ID)
                    .buildSigned(ALICE_KEYPAIR)
                    .let { query -> client.sendQuery(query) }
            }
        }
    }

    private suspend fun sendAndWait10Txs() {
        repeat(10) { i ->
            client.sendTransaction {
                accountId = ALICE_ACCOUNT_ID
                setKeyValue(ALICE_ACCOUNT_ID, "key$i".asName(), "value$i")
                buildSigned(ALICE_KEYPAIR)
            }.also { d ->
                delay(1000)
                withTimeout(txTimeout) { d.await() }
            }
        }
    }

    private suspend fun readQuantity(
        assetId: AssetId = DEFAULT_ASSET_ID,
        accountId: AccountId = ALICE_ACCOUNT_ID,
        keyPair: KeyPair = ALICE_KEYPAIR,
    ): Long {
        return QueryBuilder.findAssetById(assetId)
            .account(accountId)
            .buildSigned(keyPair)
            .let { query -> client.sendQuery(query) }
            .value.cast<AssetValue.Numeric>().numeric.asLong()
    }

    private suspend fun sendAndAwaitTimeTrigger(
        triggerId: TriggerId,
        repeats: Repeats,
        instruction: InstructionBox,
        accountId: AccountId = ALICE_ACCOUNT_ID,
    ) {
        client.sendTransaction {
            this.accountId = accountId
            registerTimeTrigger(
                triggerId,
                listOf(instruction),
                repeats,
                accountId,
                EventFilters.timeEventFilter(
                    BigInteger.valueOf(Instant.now().toEpochMilli()),
                    BigInteger.valueOf(500L),
                ),
            )
            buildSigned(ALICE_KEYPAIR)
        }.also { d ->
            withTimeout(txTimeout) { d.await() }
        }
    }

    private suspend fun createNewAsset(assetName: String, prevSize: Int) {
        val newAsset = AssetDefinitionId(DEFAULT_DOMAIN_ID, assetName.asName())
        client.sendTransaction {
            accountId = ALICE_ACCOUNT_ID
            registerAssetDefinition(newAsset, AssetType.numeric())
            buildSigned(ALICE_KEYPAIR)
        }.also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        // check new asset is created
        val query = QueryBuilder.findAllAssetsDefinitions()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
        val assetDefinitions = client.sendQuery(query)
        assertEquals(prevSize + 1, assetDefinitions.size)
        val asset = assetDefinitions.first { it.id.name.string == assetName }
        assertNotNull(asset)
    }

    private suspend fun checkDefaultAssetQuantity(): Long {
        return QueryBuilder.findAssetById(DEFAULT_ASSET_ID)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .value.cast<AssetValue.Numeric>()
            .numeric.asLong()
    }

    private suspend fun keepNetworkBusyAndCheckAssetDefinitionIds() {
        // send some transactions to keep Iroha2 network busy
        repeat(5) { i ->
            client.sendTransaction {
                accountId = ALICE_ACCOUNT_ID
                setKeyValue(ALICE_ACCOUNT_ID, "test$i".asName(), "test$i")
                buildSigned(ALICE_KEYPAIR)
            }.also { d ->
                withTimeout(Duration.ofSeconds(60)) { d.await() }
            }
            delay(500)
        }
        QueryBuilder.findAssetsByAccountId(ALICE_ACCOUNT_ID)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .also { assets ->
                val expectedDefinition = AssetDefinitionId(
                    DEFAULT_DOMAIN_ID,
                    "nft_number_1_for_${ALICE_PUBLIC_KEY.payload.toHex(true)}".asName(),
                )
                assert(assets.size > 1)
                assert(assets.all { it.id.account == ALICE_ACCOUNT_ID })
                assert(assets.any { it.id.definition == XOR_DEFINITION_ID })
                assert(
                    assets.any {
                        it.id.definition.asString().lowercase() == expectedDefinition.asString().lowercase()
                    },
                )
            }
    }
}
