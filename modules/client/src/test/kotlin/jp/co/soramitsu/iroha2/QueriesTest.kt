package jp.co.soramitsu.iroha2

import io.qameta.allure.Feature
import io.qameta.allure.Owner
import io.qameta.allure.Story
import jp.co.soramitsu.iroha2.annotations.Permission
import jp.co.soramitsu.iroha2.annotations.Query
import jp.co.soramitsu.iroha2.annotations.Sdk
import jp.co.soramitsu.iroha2.annotations.SdkTestId
import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AccountIdPredicateAtom
import jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AccountProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateAtom
import jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AssetDefinitionProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AssetType
import jp.co.soramitsu.iroha2.generated.AssetValue
import jp.co.soramitsu.iroha2.generated.CanBurnAssetWithDefinition
import jp.co.soramitsu.iroha2.generated.CanMintAssetWithDefinition
import jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetDefinition
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId
import jp.co.soramitsu.iroha2.generated.DomainId
import jp.co.soramitsu.iroha2.generated.DomainIdPredicateAtom
import jp.co.soramitsu.iroha2.generated.DomainIdProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.DomainProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.InstructionBox
import jp.co.soramitsu.iroha2.generated.Json
import jp.co.soramitsu.iroha2.generated.Metadata
import jp.co.soramitsu.iroha2.generated.Name
import jp.co.soramitsu.iroha2.generated.NameProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.RegisterBox
import jp.co.soramitsu.iroha2.generated.RoleIdPredicateAtom
import jp.co.soramitsu.iroha2.generated.RoleIdProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.RoleProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.SignedTransaction
import jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.StringPredicateAtom
import jp.co.soramitsu.iroha2.generated.TransactionHashPredicateAtom
import jp.co.soramitsu.iroha2.generated.TransactionHashProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.TriggerIdPredicateAtom
import jp.co.soramitsu.iroha2.generated.TriggerIdProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.query.QueryBuilder
import jp.co.soramitsu.iroha2.testengine.ALICE_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.ALICE_PUBLIC_KEY
import jp.co.soramitsu.iroha2.testengine.AliceCanMintXor
import jp.co.soramitsu.iroha2.testengine.AliceHas100XorAndPermissionToMintAndBurn
import jp.co.soramitsu.iroha2.testengine.AliceHasRoleWithAccessToBobsMetadata
import jp.co.soramitsu.iroha2.testengine.AliceWithTestAssets
import jp.co.soramitsu.iroha2.testengine.BOB_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.BOB_PUBLIC_KEY
import jp.co.soramitsu.iroha2.testengine.DEFAULT_ASSET_DEFINITION_ID
import jp.co.soramitsu.iroha2.testengine.DEFAULT_ASSET_ID
import jp.co.soramitsu.iroha2.testengine.DEFAULT_DOMAIN_ID
import jp.co.soramitsu.iroha2.testengine.DefaultGenesis
import jp.co.soramitsu.iroha2.testengine.IROHA_CONFIG_DELIMITER
import jp.co.soramitsu.iroha2.testengine.IrohaTest
import jp.co.soramitsu.iroha2.testengine.NewAccountWithMetadata
import jp.co.soramitsu.iroha2.testengine.NewDomain
import jp.co.soramitsu.iroha2.testengine.NewDomainWithMetadata
import jp.co.soramitsu.iroha2.testengine.StoreAssetWithMetadata
import jp.co.soramitsu.iroha2.testengine.VAL_DEFINITION_ID
import jp.co.soramitsu.iroha2.testengine.WithExecutableTrigger
import jp.co.soramitsu.iroha2.testengine.WithIroha
import jp.co.soramitsu.iroha2.testengine.WithManyDomains
import jp.co.soramitsu.iroha2.testengine.XOR_DEFINITION_ID
import jp.co.soramitsu.iroha2.testengine.XorAndValAssets
import jp.co.soramitsu.iroha2.transaction.Burn
import jp.co.soramitsu.iroha2.transaction.Mint
import jp.co.soramitsu.iroha2.transaction.Register
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.withTimeout
import org.apache.commons.lang3.RandomStringUtils
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigInteger
import java.security.KeyPair
import java.time.Instant
import kotlin.test.assertContains
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

@Owner("akostyuchenko")
@Sdk("Java/Kotlin")
@Permission("no_permission_required")
class QueriesTest : IrohaTest<Iroha2Client>() {
    @Test
    @WithIroha([NewAccountWithMetadata::class], configs = ["LOG_LEVEL${IROHA_CONFIG_DELIMITER}TRACE"])
    @Feature("Accounts")
    @Query("FindAllAccounts")
    @Story("Account queries all accounts")
    @SdkTestId("find_all_accounts")
    fun `find all accounts`(): Unit =
        runBlocking {
            client.submit(QueryBuilder.findAccounts()).also { accounts ->
                assert(accounts.any { ALICE_PUBLIC_KEY == it.id.signatory })
                assert(accounts.any { NewAccountWithMetadata.ACCOUNT_ID.signatory == it.id.signatory })
            }
        }

    @Test
    @WithIroha([NewAccountWithMetadata::class])
    @Feature("Accounts")
    @Query("FindAllAccountsWithFilter")
    @Story("Account queries all accounts with a filter")
    @SdkTestId("find_all_accounts_with_filter")
    fun `find all accounts with filter`(): Unit =
        runBlocking {
            val filter =
                CompoundPredicateOfAccount.Or(
                    listOf(
                        CompoundPredicateOfAccount.Atom(
                            AccountProjectionOfPredicateMarker.Id(
                                AccountIdProjectionOfPredicateMarker.Atom(
                                    AccountIdPredicateAtom.Equals(
                                        "ed0120CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03@wonderland".asAccountId(),
                                    ),
                                ),
                            ),
                        ),
                        CompoundPredicateOfAccount.Atom(
                            AccountProjectionOfPredicateMarker.Id(
                                AccountIdProjectionOfPredicateMarker.Atom(
                                    AccountIdPredicateAtom.Equals(
                                        "ed012004FF5B81046DDCCF19E2E451C45DFB6F53759D4EB30FA2EFA807284D1CC33016@wonderland".asAccountId(),
                                    ),
                                ),
                            ),
                        ),
                    ),
                )

            client.submit(QueryBuilder.findAccounts(filter)).also { accounts ->
                assertEquals(2, accounts.size)
                assert(accounts.any { it.id.signatory == ALICE_PUBLIC_KEY })
                assert(accounts.any { it.id.signatory == BOB_PUBLIC_KEY })
            }
        }

    @Test
    @WithIroha([NewAccountWithMetadata::class])
    @Feature("Accounts")
    @Query("FindAccountKeyValueByIdAndKey")
    @Story("Account queries account key value by ID and key")
    @SdkTestId("find_account_key_value_by_ID_and_key")
    fun `find account key value by ID and key`(): Unit =
        runBlocking {
            val metadata =
                client
                    .submit(
                        QueryBuilder.findAccountById(
                            NewAccountWithMetadata.ACCOUNT_ID,
                        ),
                    )!!
                    .metadata.sortedMapOfName
            assertEquals(NewAccountWithMetadata.VALUE, metadata[ NewAccountWithMetadata.KEY ]!!.readValue())
        }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Accounts")
    @Query("FindAccountsByDomainId")
    @Story("Account queries accounts by domain ID")
    @SdkTestId("find_accounts_by_domain_ID")
    fun `find accounts by domain ID`(): Unit =
        runBlocking {
            val byDomainIdFilter =
                CompoundPredicateOfAccount.Atom(
                    AccountProjectionOfPredicateMarker.Id(
                        AccountIdProjectionOfPredicateMarker.Domain(
                            DomainIdProjectionOfPredicateMarker.Atom(
                                DomainIdPredicateAtom.Equals(
                                    DEFAULT_DOMAIN_ID,
                                ),
                            ),
                        ),
                    ),
                )

            val accounts = client.submit(QueryBuilder.findAccounts(byDomainIdFilter))
            assert(accounts.all { it.id.domain == DEFAULT_DOMAIN_ID })
        }

//   @Test
    @WithIroha([XorAndValAssets::class, AliceCanMintXor::class])
    @Feature("Assets")
    @Query("FindTotalAssetQuantityByAssetDefinitionId")
    @Story("Account queries total asset quantity by AssetDefinitionId")
    @SdkTestId("find_total_asset_quantity_by_AssetDefinitionId")
    fun `find total asset quantity by AssetDefinitionId`(): Unit =
        runBlocking {
            val quantity = BigDecimal(10)
            client.submit(Mint.asset(AssetId(BOB_ACCOUNT_ID, XOR_DEFINITION_ID), quantity)).also {
                withTimeout(txTimeout) { it.await() }
            }

            val totalQuantity = client.submit(QueryBuilder.findAssetDefinitionById(XOR_DEFINITION_ID))!!.totalQuantity
            assertEquals(quantity + XorAndValAssets.XOR_QUANTITY, totalQuantity.asBigDecimal())
        }

    @Test
    @WithIroha([XorAndValAssets::class])
    @Feature("Assets")
    @Query("FindAllAssets")
    @Story("Account queries all assets")
    @SdkTestId("find_all_assets")
    fun `find all assets`(): Unit =
        runBlocking {
            client.submit(QueryBuilder.findAssets()).also { assets ->
                assert(assets.any { it.id.definition == XOR_DEFINITION_ID })
                assert(assets.any { it.id.definition == VAL_DEFINITION_ID })
            }
        }

    @Test
    @WithIroha([XorAndValAssets::class])
    @Feature("Assets")
    @Query("FindAssetsByName")
    @Story("Account queries assets by name")
    @SdkTestId("find_assets_by_name")
    fun `find assets by name`(): Unit =
        runBlocking {
            val byNameFilter =
                CompoundPredicateOfAsset.Atom(
                    AssetProjectionOfPredicateMarker.Id(
                        AssetIdProjectionOfPredicateMarker.Definition(
                            AssetDefinitionIdProjectionOfPredicateMarker.Name(
                                NameProjectionOfPredicateMarker.Atom(
                                    StringPredicateAtom.Equals(
                                        XOR_DEFINITION_ID.name.string,
                                    ),
                                ),
                            ),
                        ),
                    ),
                )

            client.submit(QueryBuilder.findAssets(byNameFilter)).also { assets ->
                assert(assets.all { it.id.definition.name == XOR_DEFINITION_ID.name })
            }
        }

    @Test
    @WithIroha([XorAndValAssets::class])
    @Feature("Assets")
    @Query("FindAssetsByAccountId")
    @Story("Account queries assets by account ID")
    @SdkTestId("find_assets_by_account_ID")
    fun `find assets by account id`(): Unit =
        runBlocking {
            val byNameFilter =
                CompoundPredicateOfAsset.Atom(
                    AssetProjectionOfPredicateMarker.Id(
                        AssetIdProjectionOfPredicateMarker.Account(
                            AccountIdProjectionOfPredicateMarker.Atom(
                                AccountIdPredicateAtom.Equals(ALICE_ACCOUNT_ID),
                            ),
                        ),
                    ),
                )
            client.submit(QueryBuilder.findAssets(byNameFilter)).also { assets ->
                assert(assets.all { it.id.account == ALICE_ACCOUNT_ID })
                assert(assets.any { it.id.definition == XOR_DEFINITION_ID })
                assert(assets.any { it.id.definition == VAL_DEFINITION_ID })
            }
        }

    @Test
    @WithIroha([XorAndValAssets::class])
    @Feature("Assets")
    @Query("FindAssetsByDomainIdAndAssetDefinitionId")
    @Story("Account queries assets by domain name and asset definition ID")
    @SdkTestId("find_assets_by_domain_name_and_asset_definition_ID")
    fun `find assets by domain name and asset definition id`(): Unit =
        runBlocking {
            val byAccountDomainIdAndAssetDefinitionIdFilter =
                CompoundPredicateOfAsset.And(
                    listOf(
                        CompoundPredicateOfAsset.Atom(
                            AssetProjectionOfPredicateMarker.Id(
                                AssetIdProjectionOfPredicateMarker.Account(
                                    AccountIdProjectionOfPredicateMarker.Domain(
                                        DomainIdProjectionOfPredicateMarker.Atom(
                                            DomainIdPredicateAtom.Equals(DEFAULT_DOMAIN_ID),
                                        ),
                                    ),
                                ),
                            ),
                        ),
                        CompoundPredicateOfAsset.Atom(
                            AssetProjectionOfPredicateMarker.Id(
                                AssetIdProjectionOfPredicateMarker.Definition(
                                    AssetDefinitionIdProjectionOfPredicateMarker.Atom(
                                        AssetDefinitionIdPredicateAtom.Equals(XOR_DEFINITION_ID),
                                    ),
                                ),
                            ),
                        ),
                    ),
                )

            client.submit(QueryBuilder.findAssets(byAccountDomainIdAndAssetDefinitionIdFilter)).also { assets ->
                assert(assets.all { it.id.definition == XOR_DEFINITION_ID })
                assert(assets.all { it.id.account.domain == DEFAULT_DOMAIN_ID })
            }
        }

    @Test
    @WithIroha([XorAndValAssets::class])
    @Feature("Assets")
    @Query("FindAssetQuantityById")
    @Story("Account queries asset quantity by asset ID")
    @SdkTestId("find_asset_quantity_by_ID")
    fun `find asset quantity by id`(): Unit =
        runBlocking {
            val assetId = AssetId(ALICE_ACCOUNT_ID, XOR_DEFINITION_ID)

            val asset = client.submit(QueryBuilder.findAssetById(assetId))!!
            assertEquals(
                XorAndValAssets.XOR_QUANTITY,
                asset.value
                    .cast<AssetValue.Numeric>()
                    .numeric
                    .asBigDecimal(),
            )
        }

    @Test
    @WithIroha([StoreAssetWithMetadata::class])
    @Feature("Assets")
    @Query("FindAssetKeyValueByIdAndKey")
    @Story("Account queries asset key value by ID and key")
    @SdkTestId("find_asset_key_value_by_ID_and_key")
    fun `find asset key value by ID and key`(): Unit =
        runBlocking {
            val metadata =
                client
                    .submit(
                        QueryBuilder.findAssetById(
                            StoreAssetWithMetadata.ASSET_ID,
                        ),
                    )!!
                    .metadata()

            assertEquals(StoreAssetWithMetadata.ASSET_VALUE, metadata[StoreAssetWithMetadata.ASSET_KEY]!!.readValue())
        }

    @Test
    @WithIroha([StoreAssetWithMetadata::class])
    @Feature("Assets")
    @Query("FindAssetDefinitionKeyValueByIdAndKey")
    @Story("Account queries asset definition key value by ID and key")
    @SdkTestId("find_asset_definition_key_value_by_ID_and_key")
    fun `find asset definition key value by ID and key`(): Unit =
        runBlocking {
            val metadata =
                client
                    .submit(
                        QueryBuilder.findAssetDefinitionById(
                            StoreAssetWithMetadata.DEFINITION_ID,
                        ),
                    )!!
                    .metadata.sortedMapOfName
            assertEquals(StoreAssetWithMetadata.ASSET_VALUE, metadata[StoreAssetWithMetadata.ASSET_KEY]!!.readValue())
        }

    @Test
    @WithIroha([StoreAssetWithMetadata::class])
    @Feature("Assets")
    @Query("FindAssetByMetadataFilters")
    @Story("Account queries asset by metadata filters")
    @SdkTestId("find_asset_by_metadata_filters")
    @Disabled // https://github.com/hyperledger/iroha/issues/2697
    fun `find asset by metadata filters`(): Unit =
        runBlocking {
            client.submit(QueryBuilder.findAssets()).also {
                assert(it.isNotEmpty())
            }
        }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Feature("Assets")
    @Query("FindAssetDefinitionById")
    @Story("Account queries asset definition by ID")
    @SdkTestId("find_asset_definition_by_ID")
    fun `find asset definition by ID`(): Unit =
        runBlocking {
            client
                .submit(QueryBuilder.findAssetDefinitionById(DEFAULT_ASSET_DEFINITION_ID))!!
                .also { assertEquals(it.id, DEFAULT_ASSET_DEFINITION_ID) }
        }

    @Test
    @WithIroha([NewDomain::class])
    @Feature("Domains")
    @Query("FindAllDomains")
    @Story("Account queries all domains")
    @SdkTestId("find_all_domains")
    fun `find all domains`(): Unit =
        runBlocking {
            client
                .submit(QueryBuilder.findDomains())
                .also { domains ->
                    assert(domains.any { it.id == DEFAULT_DOMAIN_ID })
                    assert(domains.any { it.id == NewDomain.DOMAIN_ID })
                }
        }

    @Test
    @WithIroha([NewDomain::class])
    @Feature("Domains")
    @Query("FindAllDomainsWithFilter")
    @Story("Account queries all domains with filter")
    @SdkTestId("find_all_domains_with_filter")
    fun `find all domains with filter`(): Unit =
        runBlocking {
            val filter =
                CompoundPredicateOfDomain.Atom(
                    DomainProjectionOfPredicateMarker.Id(
                        DomainIdProjectionOfPredicateMarker.Name(
                            NameProjectionOfPredicateMarker.Atom(
                                StringPredicateAtom.StartsWith("wonder"),
                            ),
                        ),
                    ),
                )

            val domains = client.submit(QueryBuilder.findDomains(filter))
            assertEquals(1, domains.size)
            assertEquals(DEFAULT_DOMAIN_ID, domains[0].id)
        }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Domains")
    @Query("FindDomainById")
    @Story("Domain queries domain by ID")
    @SdkTestId("find_domain_by_ID")
    fun `find domain by ID`(): Unit =
        runBlocking {
            client.submit(QueryBuilder.findDomainById(DEFAULT_DOMAIN_ID))!!.also {
                assertEquals(DEFAULT_DOMAIN_ID, it.id)
            }
        }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Peers")
    @Query("FindAllPeers")
    @Story("Peer queries all peers")
    @SdkTestId("find_all_peers")
    fun `find all peers`(): Unit =
        runBlocking {
            client
                .submit(QueryBuilder.findPeers())
                .also { assert(it.isNotEmpty()) }
        }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Transactions")
    @Query("FindTransactionsByAccountId")
    @Story("Transaction queries transactions by account id")
    @SdkTestId("find_transactions_by_account_id")
    fun `find transactions by account id`(): Unit =
        runBlocking {
            client.submit(Register.assetDefinition(DEFAULT_ASSET_DEFINITION_ID, AssetType.numeric())).also {
                withTimeout(txTimeout) { it.await() }
            }

            val result =
                client.submit(
                    QueryBuilder.findTransactions(
                        CompoundPredicateOfCommittedTransaction.Atom(
                            CommittedTransactionProjectionOfPredicateMarker.Value(
                                SignedTransactionProjectionOfPredicateMarker.Authority(
                                    AccountIdProjectionOfPredicateMarker.Atom(
                                        AccountIdPredicateAtom.Equals(ALICE_ACCOUNT_ID),
                                    ),
                                ),
                            ),
                        ),
                    ),
                )

            assertEquals(1, result.size)
        }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Feature("PermissionTokens")
    @Query("FindPermissionTokensByAccountId")
    @Story("PermissionToken queries permission tokens by account id")
    @SdkTestId("find_permission_tokens_by_account_id")
    fun `find permission tokens by account id`(): Unit =
        runBlocking {
            val result =
                client.submit(QueryBuilder.findPermissionsByAccountId(ALICE_ACCOUNT_ID)).filter {
                    it.name == CanMintAssetWithDefinition::class.simpleName &&
                        CanMintAssetWithDefinition("xor#wonderland".asAssetDefinitionId()) ==
                        it.payload.readValue<CanMintAssetWithDefinition>() ||
                        it.name == CanBurnAssetWithDefinition::class.simpleName &&
                        CanBurnAssetWithDefinition("xor#wonderland".asAssetDefinitionId()) ==
                        it.payload.readValue<CanBurnAssetWithDefinition>()
                }

            assertEquals(2, result.size)
        }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Transactions")
    @Query("FindTransactionByHash")
    @Story("Transaction queries transaction by hash")
    @SdkTestId("find_transaction_by_hash")
    fun `find transaction by hash`(): Unit =
        runBlocking {
            client.submit(Register.assetDefinition(DEFAULT_ASSET_DEFINITION_ID, AssetType.numeric())).let {
                withTimeout(txTimeout) { it.await() }
            }

            var transactions = client.submit(QueryBuilder.findTransactions())
            val hash = SignedTransaction.encode(transactions[2].value).hash()

            transactions =
                client.submit(
                    QueryBuilder.findTransactions(
                        CompoundPredicateOfCommittedTransaction.Atom(
                            CommittedTransactionProjectionOfPredicateMarker.Value(
                                SignedTransactionProjectionOfPredicateMarker.Hash(
                                    TransactionHashProjectionOfPredicateMarker.Atom(
                                        TransactionHashPredicateAtom.Equals(hash.asHashOf<SignedTransaction>()),
                                    ),
                                ),
                            ),
                        ),
                    ),
                )

            assertEquals(1, transactions.size)
            assertEquals(
                DEFAULT_ASSET_DEFINITION_ID.domain,
                transactions[0]
                    .value
                    .extractInstruction<InstructionBox.Register>()
                    .registerBox
                    .cast<RegisterBox.Domain>()
                    .registerOfDomain.`object`.id,
            )
            transactions[0]
                .value
                .let { SignedTransaction.encode(it).hash() }
                .also { assertContentEquals(hash, it) }
        }

    @Test
    @WithIroha([NewDomainWithMetadata::class])
    @Feature("Domains")
    @Query("FindDomainKeyValueByIdAndKey")
    @Story("Domain queries domain key value by ID and key")
    @SdkTestId("find_domain_key_value_by_ID_and_key")
    fun `find domain key value by ID and key`(): Unit =
        runBlocking {
            val metadata =
                client
                    .submit(
                        QueryBuilder.findDomainById(NewDomainWithMetadata.DOMAIN_ID),
                    )!!
                    .metadata.sortedMapOfName

            assertEquals(NewDomainWithMetadata.VALUE, metadata[NewDomainWithMetadata.KEY]!!.readValue())
        }

    @Test
    @WithIroha([WithExecutableTrigger::class])
    @Feature("Triggers")
    @Query("FindTriggerById")
    @Story("Trigger queries trigger by ID")
    @SdkTestId("find_trigger_by_id")
    fun `find trigger by ID`(): Unit =
        runBlocking {
            val triggerId = WithExecutableTrigger.TRIGGER_ID

            val trigger = client.submit(QueryBuilder.findTriggerById(triggerId))!!
            assertEquals(triggerId, trigger.id)
        }

    @Test
    @WithIroha([WithExecutableTrigger::class])
    @Feature("Triggers")
    @Query("FindAllActiveTriggerIds")
    @Story("Trigger queries all active trigger IDs")
    @SdkTestId("find_all_active_trigger_ids")
    fun `find all active trigger IDs`(): Unit =
        runBlocking {
            val triggerId = WithExecutableTrigger.TRIGGER_ID

            val triggers =
                client.submit(
                    QueryBuilder.findActiveTriggerIds(
                        CompoundPredicateOfTriggerId.Atom(
                            TriggerIdProjectionOfPredicateMarker.Atom(
                                TriggerIdPredicateAtom.Equals(triggerId),
                            ),
                        ),
                    ),
                )

            assertEquals(1, triggers.size)
            assertEquals(triggerId, triggers[0])
        }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Accounts")
    @Query("FindAllAccountsWithPaginationAndSorting")
    @Story("Account queries all accounts with pagination and sorting by metadata key")
    @SdkTestId("pagination_plus_sorting_by_metadata_key")
    fun `pagination plus sorting by metadata key`(): Unit =
        runBlocking {
            val key1 = RandomStringUtils.randomAlphabetic(5).asName()
            val key2 = RandomStringUtils.randomAlphabetic(5).asName()

            createAccount(metadata = mapOf(key1 to Json.writeValue("1"), key2 to Json.writeValue("1")))
            createAccount(metadata = mapOf(key1 to Json.writeValue("0"), key2 to Json.writeValue("0")))
            createAccount(metadata = mapOf(key1 to Json.writeValue("2"), key2 to Json.writeValue("2")))

            listOf(key1, key2).forEach { key ->
                client.submit(QueryBuilder.findAccounts().sorting(key.string)).let { accounts ->
                    assertEquals("0", accounts[0].metadata.sortedMapOfName[key]!!.readValue())
                    assertEquals("1", accounts[1].metadata.sortedMapOfName[key]!!.readValue())
                    assertEquals("2", accounts[2].metadata.sortedMapOfName[key]!!.readValue())
                }
            }
        }

    @Test
    @WithIroha([NewDomainWithMetadata::class])
    @Feature("Accounts")
    @Query("FindAllAccountsWithPagination")
    @Story("Account queries all accounts with pagination after inserting some new accounts")
    @SdkTestId("pagination_works_correct_after_inserting_some_new_accounts")
    fun `pagination works correct after inserting some new accounts`(): Unit =
        runBlocking {
            val key = "ts".asName()
            val limit = 3L

            val metadata0 = Instant.now().toEpochMilli()
            val metadata1 = Instant.now().toEpochMilli()
            val metadata2 = Instant.now().toEpochMilli()
            val metadata3 = Instant.now().toEpochMilli()
            val metadata4 = Instant.now().toEpochMilli()

            createAccount(NewDomainWithMetadata.DOMAIN_ID, mapOf(key to Json.writeValue(metadata0)))
            createAccount(NewDomainWithMetadata.DOMAIN_ID, mapOf(key to Json.writeValue(metadata1)))
            createAccount(NewDomainWithMetadata.DOMAIN_ID, mapOf(key to Json.writeValue(metadata2)))
            createAccount(NewDomainWithMetadata.DOMAIN_ID, mapOf(key to Json.writeValue(metadata3)))
            createAccount(NewDomainWithMetadata.DOMAIN_ID, mapOf(key to Json.writeValue(metadata4)))

            val byDomainIdFilter =
                CompoundPredicateOfAccount.Atom(
                    AccountProjectionOfPredicateMarker.Id(
                        AccountIdProjectionOfPredicateMarker.Domain(
                            DomainIdProjectionOfPredicateMarker.Atom(
                                DomainIdPredicateAtom.Equals(
                                    NewDomainWithMetadata.DOMAIN_ID,
                                ),
                            ),
                        ),
                    ),
                )
            client
                .submit(
                    QueryBuilder
                        .findAccounts(byDomainIdFilter)
                        .pagination(limit.toBigInteger())
                        .sorting(key),
                ).map { it.metadata.sortedMapOfName }
                .let { accounts ->
                    assertEquals(limit, accounts.size.toLong())
                    assertEquals(metadata2, accounts[2][key]!!.readValue())
                }
            client
                .submit(
                    QueryBuilder
                        .findAccounts(byDomainIdFilter)
                        .pagination(limit.toBigInteger(), limit.toBigInteger())
                        .sorting(key),
                ).map { it.metadata.sortedMapOfName }
                .let { accounts ->
                    assertEquals(2, accounts.size)
                    assertEquals(metadata4, accounts[1][key]!!.readValue())
                }

            val metadata5 = Instant.now().toEpochMilli()
            val metadata6 = Instant.now().toEpochMilli()
            val metadata7 = Instant.now().toEpochMilli()
            val metadata8 = Instant.now().toEpochMilli()

            createAccount(NewDomainWithMetadata.DOMAIN_ID, mapOf(key to Json.writeValue(metadata5)))
            createAccount(NewDomainWithMetadata.DOMAIN_ID, mapOf(key to Json.writeValue(metadata6)))
            createAccount(NewDomainWithMetadata.DOMAIN_ID, mapOf(key to Json.writeValue(metadata7)))
            createAccount(NewDomainWithMetadata.DOMAIN_ID, mapOf(key to Json.writeValue(metadata8)))

            client
                .submit(
                    QueryBuilder
                        .findAccounts(byDomainIdFilter)
                        .pagination(limit.toBigInteger(), BigInteger.valueOf(2).multiply(limit.toBigInteger()))
                        .sorting(key),
                ).map { it.metadata.sortedMapOfName }
                .let { accounts ->
                    assertEquals(3, accounts.size)
                    assertEquals(metadata6, accounts[0][key]!!.readValue())
                    assertEquals(metadata8, accounts[2][key]!!.readValue())
                }
        }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Feature("Accounts")
    @Query("FindAllAccountsWithPagination")
    @Story("Account queries all accounts with pagination")
    @SdkTestId("find_all_account_with_pagination")
    fun `find all account with pagination`(): Unit =
        runBlocking {
            val limit = 5L
            val start = 3L

            var accounts = client.submit(QueryBuilder.findAccounts().pagination(BigInteger.valueOf(5)))
            assertEquals(3, accounts.size)

            repeat(2) { createAccount() }
            accounts =
                client.submit(
                    QueryBuilder
                        .findAccounts()
                        .pagination(BigInteger.valueOf(limit), BigInteger.valueOf(start)),
                )
            assertEquals(limit - start, accounts.size.toLong())
        }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Feature("Transactions")
    @Query("FindAllTransactions")
    @Story("Account queries all transactions")
    @SdkTestId("find_all_transactions")
    fun `find all transactions`(): Unit =
        runBlocking {
            repeat(5) {
                client.submit(Burn.asset(DEFAULT_ASSET_ID, BigDecimal(1))).also {
                    withTimeout(txTimeout) { it.await() }
                }
            }
            client.submit(QueryBuilder.findTransactions()).also {
                assertEquals(9, it.size) // 5 + 4 genesis txs
            }
        }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Feature("Blocks")
    @Query("FindAllBlocks")
    @Story("Account queries all blocks")
    @SdkTestId("find_all_blocks")
    fun `find all blocks`(): Unit =
        runBlocking {
            client.submit(Burn.asset(DEFAULT_ASSET_ID, BigDecimal(1))).also {
                withTimeout(txTimeout) { it.await() }
            }
            client.submit(QueryBuilder.findBlocks()).also {
                assertEquals(2, it.size)
            }
        }

//    @Test
//    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
//    @Feature("Blocks")
//    @Query("FindAllBlockHeaders")
//    @Story("Account queries all block headers")
//    @SdkTestId("find_all_block_headers")
//    fun `find all block headers`(): Unit = runBlocking {
//        client.submit(Burn.asset(DEFAULT_ASSET_ID, BigDecimal(1))).also {
//            withTimeout(txTimeout) { it.await() }
//        }
//        val headers: List<BlockHeader> = client.submit(
//            QueryBuilder.findBlocks(
//                selector = SelectorTupleOfSignedBlock(
//                    listOf(
//                        SignedBlockProjectionOfSelectorMarker.Header(BlockHeaderProjectionOfSelectorMarker.Atom()),
//                    ),
//                ),
//            ),
//        )
//        assertEquals(2, headers.size)
//    }

//    @Test
//    @WithIroha([AliceHasRoleWithAccessToBobsMetadata::class])
//    @Feature("Roles")
//    @Query("FindAllRoleIds")
//    @Story("Account queries all role IDs")
//    @SdkTestId("find_all_role_IDs")
//    fun `find all role IDs`(): Unit = runBlocking {
//        val roles: List<RoleId> = client.submit(
//            QueryBuilder.findRoles(
//                selector = SelectorTupleOfRole(
//                    listOf(
//                        RoleProjectionOfSelectorMarker.Id(RoleIdProjectionOfSelectorMarker.Atom()),
//                    ),
//                ),
//            ),
//        )
//        assertContains(roles, AliceHasRoleWithAccessToBobsMetadata.ROLE_ID)
//    }

    @Test
    @WithIroha([AliceHasRoleWithAccessToBobsMetadata::class])
    @Feature("Roles")
    @Query("FindAllRoles")
    @Story("Account queries all roles")
    @SdkTestId("find_all_roles")
    fun `find all roles`(): Unit =
        runBlocking {
            val roles = client.submit(QueryBuilder.findRoles())
            assertEquals(1, roles.size)
        }

    @Test
    @WithIroha([AliceHasRoleWithAccessToBobsMetadata::class])
    @Feature("Roles")
    @Query("FindRolesByAccountId")
    @Story("Account queries roles by account ID")
    @SdkTestId("find_roles_by_account_ID")
    fun `find roles by account ID`(): Unit =
        runBlocking {
            client.submit(QueryBuilder.findRolesByAccountId(ALICE_ACCOUNT_ID)).also {
                assertContains(it, AliceHasRoleWithAccessToBobsMetadata.ROLE_ID)
            }
        }

    @Test
    @WithIroha([AliceHasRoleWithAccessToBobsMetadata::class])
    @Feature("Roles")
    @Query("FindRoleByRoleId")
    @Story("Account queries role by role ID")
    @SdkTestId("find_role_by_role_ID")
    fun `find role by ID`(): Unit =
        runBlocking {
            val roleId = AliceHasRoleWithAccessToBobsMetadata.ROLE_ID

            val result =
                client.submit(
                    QueryBuilder.findRoles(
                        CompoundPredicateOfRole.Atom(
                            RoleProjectionOfPredicateMarker.Id(RoleIdProjectionOfPredicateMarker.Atom(RoleIdPredicateAtom.Equals(roleId))),
                        ),
                    ),
                )

            assertEquals(1, result.size)
            assertEquals(roleId, result[0].id)
        }

    @Test
    @WithIroha([AliceWithTestAssets::class])
    @Feature("Assets")
    @Query("FindAssetDefinitionsWithOrFilter")
    @Story("Account queries asset definitions with or filter")
    @SdkTestId("find_asset_definitions_with_or_filter")
    fun `find asset definitions with or filter`(): Unit =
        runBlocking {
            val definitionId = AliceWithTestAssets.TEST_ASSET_DEFINITION_ID

            val assets =
                client.submit(
                    QueryBuilder.findAssetsDefinitions(
                        CompoundPredicateOfAssetDefinition.Atom(
                            AssetDefinitionProjectionOfPredicateMarker.Id(
                                AssetDefinitionIdProjectionOfPredicateMarker.Atom(AssetDefinitionIdPredicateAtom.Equals(definitionId)),
                            ),
                        ),
                    ),
                )

            assertEquals(1, assets.size)
            assertEquals(definitionId, assets[0].id)
        }

    @WithIroha([WithManyDomains::class])
    @Feature("Domains")
    @Query("FindAllDomains")
    @Story("Account queries all domains using cursor pagination")
    @SdkTestId("querying_multiple_domains_with_cursor_test")
    fun `find multiple domains with cursor test`(): Unit =
        runBlocking {
            val domains = client.submit(QueryBuilder.findDomains())
            assertEquals(WithManyDomains.DOMAINS_COUNT + 2, domains.size)
        }

    private suspend fun createAccount(
        domainId: DomainId = DEFAULT_DOMAIN_ID,
        metadata: Map<Name, Json> = mapOf(),
    ) {
        val keyPair: KeyPair = generateKeyPair()
        val newAccountId = AccountId(domainId, keyPair.public.toIrohaPublicKey())

        client.submit(Register.account(newAccountId, Metadata(metadata))).also {
            withTimeout(txTimeout) { it.await() }
        }
    }
}
