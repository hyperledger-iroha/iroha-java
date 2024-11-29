package jp.co.soramitsu.iroha2

import io.qameta.allure.Feature
import io.qameta.allure.Owner
import io.qameta.allure.Story
import jp.co.soramitsu.iroha2.annotations.Sdk
import jp.co.soramitsu.iroha2.annotations.SdkTestId
import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AccountIdPredicateAtom
import jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AssetType
import jp.co.soramitsu.iroha2.generated.AssetValue
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset
import jp.co.soramitsu.iroha2.generated.EventFilterBox
import jp.co.soramitsu.iroha2.generated.ExecuteTriggerEventFilter
import jp.co.soramitsu.iroha2.generated.ExecutionTime
import jp.co.soramitsu.iroha2.generated.Repeats
import jp.co.soramitsu.iroha2.generated.TimeEventFilter
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
import jp.co.soramitsu.iroha2.transaction.Burn
import jp.co.soramitsu.iroha2.transaction.EntityFilters
import jp.co.soramitsu.iroha2.transaction.EventFilters
import jp.co.soramitsu.iroha2.transaction.Execute
import jp.co.soramitsu.iroha2.transaction.Filters
import jp.co.soramitsu.iroha2.transaction.Instruction
import jp.co.soramitsu.iroha2.transaction.Mint
import jp.co.soramitsu.iroha2.transaction.Register
import jp.co.soramitsu.iroha2.transaction.SetKeyValue
import jp.co.soramitsu.iroha2.transaction.Transfer
import jp.co.soramitsu.iroha2.transaction.Unregister
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.withTimeout
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigInteger
import java.security.KeyPair
import java.time.Duration
import java.time.Instant
import java.util.Date
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

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
        val query = QueryBuilder.findAssetsDefinitions()
        val assetDefinitions = client.submit(query)
        assertEquals(1, assetDefinitions.size)
        val asset = assetDefinitions.first { it.id.name.string == "xor" }
        assertNotNull(asset)

        // Check default asset quantity before trigger
        val prevQuantity = checkDefaultAssetQuantity()
        assertEquals(100L, prevQuantity)

        val filter = EventFilterBox.Data(
            EntityFilters.byAssetDefinition(1),
        )
        client.submit(
            Register.trigger(
                triggerId,
                listOf(Mint.asset(DEFAULT_ASSET_ID, BigDecimal(1))),
                Repeats.Indefinitely(),
                ALICE_ACCOUNT_ID,
                filter,
            ),
        )
            .also { d ->
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
        val query = QueryBuilder.findAssetsDefinitions()
        val assetDefinitions = client.submit(query)
        assertEquals(1, assetDefinitions.size)

        // check DEFAULT_ASSET_ID quantity before trigger
        val prevQuantity = checkDefaultAssetQuantity()
        assertEquals(100L, prevQuantity)

        // register pre commit trigger
        client.submit(
            Register.trigger(
                triggerId,
                listOf(Mint.asset(DEFAULT_ASSET_ID, BigDecimal(10))),
                Repeats.Indefinitely(),
                ALICE_ACCOUNT_ID,
                EventFilterBox.Time(TimeEventFilter(ExecutionTime.PreCommit())),
            ),
        ).also { d ->
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
        client.submit(Transfer.asset(DEFAULT_ASSET_ID, BigDecimal(100), BOB_ACCOUNT_ID))
            .also { d ->
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
        val triggerId = TriggerId("executable_trigger".asName())

        client.submit(
            Register.trigger(
                triggerId,
                listOf(Mint.asset(DEFAULT_ASSET_ID, BigDecimal(1))),
                Repeats.Exactly(1L),
                ALICE_ACCOUNT_ID,
                EventFilterBox.ExecuteTrigger(ExecuteTriggerEventFilter(triggerId)),
            ),
            Execute.trigger(triggerId),
        ).also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        assertEquals(101L, readQuantity())
    }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class], configs = ["LOG_LEVEL${IROHA_CONFIG_DELIMITER}TRACE"])
    @Story("Endless time trigger decreases asset quantity continuously")
    @SdkTestId("endless_time_trigger")
    fun `endless time trigger`(): Unit = runBlocking {
        val triggerId = TriggerId("endless_time_trigger".asName())

        sendAndAwaitTimeTrigger(
            triggerId,
            Repeats.Indefinitely(),
            Burn.asset(DEFAULT_ASSET_ID, BigDecimal(1)),
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
        val triggerId = TriggerId("time_trigger".asName())

        sendAndAwaitTimeTrigger(
            triggerId,
            Repeats.Exactly(5L),
            Burn.asset(DEFAULT_ASSET_ID, BigDecimal(1)),
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

        val currentTime = Date().time + 5000
        val filter = EventFilterBox.Time(
            EventFilters.timeEventFilter(BigInteger.valueOf(currentTime), BigInteger.valueOf(1000L)),
        )
        val wasm = this.javaClass.classLoader
            .getResource("create_nft_for_alice_smartcontract.wasm")
            .readBytes()

        client.submit(
            Register.trigger(
                triggerId,
                wasm,
                Repeats.Indefinitely(),
                ALICE_ACCOUNT_ID,
                filter,
            ),
        )
        keepNetworkBusyAndCheckAssetDefinitionIds()

        val testKey = "key02357123".asName()
        val testValue = "value986441123"
        client.submit(SetKeyValue.trigger(triggerId, testKey, testValue))
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        delay(15000)

        client.submit(QueryBuilder.findTriggerById(triggerId))!!
            .also { assertEquals(testValue, it.action.metadata.sortedMapOfName[testKey]!!.readValue()) }
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

        client.submit(
            Register.trigger(
                wasmTriggerId,
                wasm,
                Repeats.Indefinitely(),
                ALICE_ACCOUNT_ID,
                filter,
            ),
        )
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        val testKey = "key".asName()
        val testValue = "value"
        client.submit(
            Register.trigger(
                setKeyValueTriggerId,
                listOf(SetKeyValue.trigger(wasmTriggerId, testKey, testValue)),
                Repeats.Exactly(1L),
                ALICE_ACCOUNT_ID,
                EventFilterBox.ExecuteTrigger(ExecuteTriggerEventFilter(setKeyValueTriggerId)),
            ),
            Execute.trigger(setKeyValueTriggerId),
        )

        keepNetworkBusyAndCheckAssetDefinitionIds()

        client.submit(QueryBuilder.findTriggerById(wasmTriggerId))!!
            .also { assertEquals(testValue, it.action.metadata.sortedMapOfName[testKey]!!.readValue()) }
    }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Story("Unregister an executable trigger")
    @SdkTestId("unregister_executable_trigger")
    fun `unregister executable trigger`(): Unit = runBlocking {
        val triggerName = "executable_trigger"
        val triggerId = TriggerId(name = triggerName.asName())

        client.submit(
            Register.trigger(
                triggerId,
                listOf(Mint.asset(DEFAULT_ASSET_ID, BigDecimal(1))),
                Repeats.Exactly(1L),
                ALICE_ACCOUNT_ID,
                EventFilterBox.ExecuteTrigger(ExecuteTriggerEventFilter(triggerId)),
            ),
        )
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        client.submit(Unregister.trigger(triggerId))
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        client.submit(QueryBuilder.findTriggerById(triggerId)).also {
            assertNull(it)
        }
    }

    private suspend fun sendAndWait10Txs() {
        repeat(10) { i ->
            client.submit(SetKeyValue.account(ALICE_ACCOUNT_ID, "key$i".asName(), "value$i"))
                .also { d ->
                    delay(1000)
                    withTimeout(txTimeout) { d.await() }
                }
        }
    }

    private suspend fun readQuantity(
        assetId: AssetId = DEFAULT_ASSET_ID,
        accountId: AccountId = ALICE_ACCOUNT_ID,
        keyPair: KeyPair = ALICE_KEYPAIR,
    ): Long = client.submit(QueryBuilder.findAssetById(assetId))!!
        .value.cast<AssetValue.Numeric>().numeric.asLong()

    private suspend fun <I : Instruction> sendAndAwaitTimeTrigger(
        triggerId: TriggerId,
        repeats: Repeats,
        instruction: I,
        accountId: AccountId = ALICE_ACCOUNT_ID,
    ) {
        client.submit(
            Register.trigger(
                triggerId,
                listOf(instruction),
                repeats,
                accountId,
                EventFilterBox.Time(
                    EventFilters.timeEventFilter(
                        BigInteger.valueOf(Instant.now().toEpochMilli()),
                        BigInteger.valueOf(500L),
                    ),
                ),
            ),
        )
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
    }

    private suspend fun createNewAsset(assetName: String, prevSize: Int) {
        val newAsset = AssetDefinitionId(DEFAULT_DOMAIN_ID, assetName.asName())
        client.submit(Register.assetDefinition(newAsset, AssetType.numeric()))
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        // check new asset is created
        val query = QueryBuilder.findAssetsDefinitions()
        val assetDefinitions = client.submit(query)
        assertEquals(prevSize + 1, assetDefinitions.size)
        val asset = assetDefinitions.first { it.id.name.string == assetName }
        assertNotNull(asset)
    }

    private suspend fun checkDefaultAssetQuantity(): Long = client.submit(QueryBuilder.findAssetById(DEFAULT_ASSET_ID))!!
        .value.cast<AssetValue.Numeric>()
        .numeric.asLong()

    private suspend fun keepNetworkBusyAndCheckAssetDefinitionIds() {
        // send some transactions to keep Iroha2 network busy
        repeat(5) { i ->
            client.submit(SetKeyValue.account(ALICE_ACCOUNT_ID, "test$i".asName(), "test$i"))
                .also { d ->
                    withTimeout(Duration.ofSeconds(60)) { d.await() }
                }
            delay(500)
        }
        val byAccountIdFilter = CompoundPredicateOfAsset.Atom(
            AssetProjectionOfPredicateMarker.Id(
                AssetIdProjectionOfPredicateMarker.Account(
                    AccountIdProjectionOfPredicateMarker.Atom(
                        AccountIdPredicateAtom.Equals(
                            ALICE_ACCOUNT_ID,
                        ),
                    ),
                ),
            ),
        )
        client.submit(QueryBuilder.findAssets(byAccountIdFilter))
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
                        expectedDefinition.asString().lowercase() == it.id.definition.asString().lowercase()
                    },
                )
            }
    }
}
