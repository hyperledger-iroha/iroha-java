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
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.AssetType
import jp.co.soramitsu.iroha2.generated.DomainId
import jp.co.soramitsu.iroha2.generated.InstructionBox
import jp.co.soramitsu.iroha2.generated.Metadata
import jp.co.soramitsu.iroha2.generated.Name
import jp.co.soramitsu.iroha2.generated.RegisterBox
import jp.co.soramitsu.iroha2.generated.SignedTransaction
import jp.co.soramitsu.iroha2.generated.StringPredicate
import jp.co.soramitsu.iroha2.query.QueryBuilder
import jp.co.soramitsu.iroha2.testengine.ALICE_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.ALICE_KEYPAIR
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
import jp.co.soramitsu.iroha2.transaction.QueryFilters
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.withTimeout
import org.apache.commons.lang3.RandomStringUtils
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.math.BigInteger
import java.security.KeyPair
import java.time.Instant
import kotlin.test.assertContains
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertTrue

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
    fun `find all accounts`(): Unit = runBlocking {
        QueryBuilder.findAllAccounts()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also { accounts ->
                assert(accounts.any { it.id.signatory == ALICE_PUBLIC_KEY })
                assert(accounts.any { it.id.signatory == NewAccountWithMetadata.ACCOUNT_ID.signatory })
            }
    }

    @Test
    @WithIroha([NewAccountWithMetadata::class])
    @Feature("Accounts")
    @Query("FindAllAccountsWithFilter")
    @Story("Account queries all accounts with a filter")
    @SdkTestId("find_all_accounts_with_filter")
    fun `find all accounts with filter`(): Unit = runBlocking {
        val filter = QueryFilters.or(
            StringPredicate.Is("ed0120CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03@wonderland"),
            StringPredicate.Is("ed012004FF5B81046DDCCF19E2E451C45DFB6F53759D4EB30FA2EFA807284D1CC33016@wonderland"),
        )
        QueryBuilder.findAllAccounts(filter)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also { accounts ->
                assert(accounts.size == 2)
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
    fun `find account key value by ID and key`(): Unit = runBlocking {
        QueryBuilder.findAccountKeyValueByIdAndKey(
            NewAccountWithMetadata.ACCOUNT_ID,
            NewAccountWithMetadata.KEY,
        )
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also {
                assertEquals(NewAccountWithMetadata.VALUE, it)
            }
    }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Accounts")
    @Query("FindAccountsByDomainId")
    @Story("Account queries accounts by domain ID")
    @SdkTestId("find_accounts_by_domain_ID")
    fun `find accounts by domain ID`(): Unit = runBlocking {
        QueryBuilder.findAccountsByDomainId(DEFAULT_DOMAIN_ID)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also { accounts ->
                assert(accounts.all { it.id.domain == DEFAULT_DOMAIN_ID })
            }
    }

    @Test
    @WithIroha([XorAndValAssets::class, AliceCanMintXor::class])
    @Feature("Assets")
    @Query("FindTotalAssetQuantityByAssetDefinitionId")
    @Story("Account queries total asset quantity by AssetDefinitionId")
    @SdkTestId("find_total_asset_quantity_by_AssetDefinitionId")
    fun `find total asset quantity by AssetDefinitionId`(): Unit = runBlocking {
        val quantity = 10
        client.tx { mintAsset(AssetId(definition = XOR_DEFINITION_ID, account = BOB_ACCOUNT_ID), quantity) }

        QueryBuilder.findTotalAssetQuantityByAssetDefinitionId(XOR_DEFINITION_ID)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .also { assertEquals(quantity + XorAndValAssets.XOR_QUANTITY, it.asInt()) }
    }

    @Test
    @WithIroha([XorAndValAssets::class])
    @Feature("Assets")
    @Query("FindAllAssets")
    @Story("Account queries all assets")
    @SdkTestId("find_all_assets")
    fun `find all assets`(): Unit = runBlocking {
        QueryBuilder.findAllAssets()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also { assets ->
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
    fun `find assets by name`(): Unit = runBlocking {
        QueryBuilder.findAssetsByName(XOR_DEFINITION_ID.name)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also { assets ->
                assert(assets.all { it.id.definition.name == XOR_DEFINITION_ID.name })
            }
    }

    @Test
    @WithIroha([XorAndValAssets::class])
    @Feature("Assets")
    @Query("FindAssetsByAccountId")
    @Story("Account queries assets by account ID")
    @SdkTestId("find_assets_by_account_ID")
    fun `find assets by account id`(): Unit = runBlocking {
        QueryBuilder.findAssetsByAccountId(ALICE_ACCOUNT_ID)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also { assets ->
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
    fun `find assets by domain name and asset definition id`(): Unit = runBlocking {
        QueryBuilder.findAssetsByDomainIdAndAssetDefinitionId(
            DEFAULT_DOMAIN_ID,
            XOR_DEFINITION_ID,
        )
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also { assets ->
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
    fun `find asset quantity by id`(): Unit = runBlocking {
        val assetId = AssetId(definition = XOR_DEFINITION_ID, account = ALICE_ACCOUNT_ID)
        QueryBuilder.findAssetQuantityById(assetId)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also { quantity ->
                assert(quantity.asInt() == XorAndValAssets.XOR_QUANTITY)
            }
    }

    @Test
    @WithIroha([StoreAssetWithMetadata::class])
    @Feature("Assets")
    @Query("FindAssetKeyValueByIdAndKey")
    @Story("Account queries asset key value by ID and key")
    @SdkTestId("find_asset_key_value_by_ID_and_key")
    fun `find asset key value by ID and key`(): Unit = runBlocking {
        QueryBuilder.findAssetKeyValueByIdAndKey(
            StoreAssetWithMetadata.ASSET_ID,
            StoreAssetWithMetadata.ASSET_KEY,
        )
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also { value ->
                assert(value == StoreAssetWithMetadata.ASSET_VALUE)
            }
    }

    @Test
    @WithIroha([StoreAssetWithMetadata::class])
    @Feature("Assets")
    @Query("FindAssetDefinitionKeyValueByIdAndKey")
    @Story("Account queries asset definition key value by ID and key")
    @SdkTestId("find_asset_definition_key_value_by_ID_and_key")
    fun `find asset definition key value by ID and key`(): Unit = runBlocking {
        QueryBuilder.findAssetDefinitionKeyValueByIdAndKey(
            StoreAssetWithMetadata.DEFINITION_ID,
            StoreAssetWithMetadata.ASSET_KEY,
        )
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also {
                assertEquals(it, StoreAssetWithMetadata.ASSET_VALUE)
            }
    }

    @Test
    @WithIroha([StoreAssetWithMetadata::class])
    @Feature("Assets")
    @Query("FindAssetByMetadataFilters")
    @Story("Account queries asset by metadata filters")
    @SdkTestId("find_asset_by_metadata_filters")
    @Disabled // https://github.com/hyperledger/iroha/issues/2697
    fun `find asset by metadata filters`(): Unit = runBlocking {
        QueryBuilder.findAllAssets()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also {
                assert(it.isNotEmpty())
            }
    }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Feature("Assets")
    @Query("FindAssetDefinitionById")
    @Story("Account queries asset definition by ID")
    @SdkTestId("find_asset_definition_by_ID")
    fun `find asset definition by ID`(): Unit = runBlocking {
        QueryBuilder.findAssetDefinitionById(DEFAULT_ASSET_DEFINITION_ID)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { client.sendQuery(it) }
            .also { assetDefinition ->
                assertEquals(assetDefinition.id, DEFAULT_ASSET_DEFINITION_ID)
            }
    }

    @Test
    @WithIroha([NewDomain::class])
    @Feature("Domains")
    @Query("FindAllDomains")
    @Story("Account queries all domains")
    @SdkTestId("find_all_domains")
    fun `find all domains`(): Unit = runBlocking {
        QueryBuilder.findAllDomains()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also { domains ->
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
    fun `find all domains with filter`(): Unit = runBlocking {
        val filter = QueryFilters.startsWith("wonder")
        QueryBuilder.findAllDomains(filter)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also { domains ->
                assert(domains.size == 1)
                assert(domains.any { it.id == DEFAULT_DOMAIN_ID })
            }
    }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Domains")
    @Query("FindDomainById")
    @Story("Domain queries domain by ID")
    @SdkTestId("find_domain_by_ID")
    fun `find domain by ID`(): Unit = runBlocking {
        QueryBuilder.findDomainById(DEFAULT_DOMAIN_ID)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also { domain ->
                assert(domain.id == DEFAULT_DOMAIN_ID)
            }
    }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Peers")
    @Query("FindAllPeers")
    @Story("Peer queries all peers")
    @SdkTestId("find_all_peers")
    fun `find all peers`(): Unit = runBlocking {
        QueryBuilder.findAllPeers()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also { peers ->
                assert(peers.isNotEmpty())
            }
    }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Transactions")
    @Query("FindTransactionsByAccountId")
    @Story("Transaction queries transactions by account id")
    @SdkTestId("find_transactions_by_account_id")
    fun `find transactions by account id`(): Unit = runBlocking {
        client.sendTransaction {
            account(ALICE_ACCOUNT_ID)
            registerAssetDefinition(DEFAULT_ASSET_DEFINITION_ID, AssetType.numeric())
            buildSigned(ALICE_KEYPAIR)
        }

        QueryBuilder.findTransactionsByAccountId(ALICE_ACCOUNT_ID)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.let { txValues ->
                txValues.all { value ->
                    value.transaction.value
                        .cast<SignedTransaction.V1>().signedTransactionV1
                        .payload.authority == ALICE_ACCOUNT_ID
                }
            }.also {
                assert(it)
            }
    }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Feature("PermissionTokens")
    @Query("FindPermissionTokensByAccountId")
    @Story("PermissionToken queries permission tokens by account id")
    @SdkTestId("find_permission_tokens_by_account_id")
    fun `find permission tokens by account id`(): Unit = runBlocking {
        QueryBuilder.findPermissionsByAccountId(ALICE_ACCOUNT_ID)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }
            .let { tokens ->
                tokens.any { "{\"asset_definition\":\"xor#wonderland\"}" == it.payload }
            }.also {
                assert(it)
            }
    }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Transactions")
    @Query("FindTransactionByHash")
    @Story("Transaction queries transaction by hash")
    @SdkTestId("find_transaction_by_hash")
    fun `find transaction by hash`(): Unit = runBlocking {
        client.sendTransaction {
            account(ALICE_ACCOUNT_ID)
            registerAssetDefinition(DEFAULT_ASSET_DEFINITION_ID, AssetType.numeric())
            buildSigned(ALICE_KEYPAIR)
        }.let { d ->
            withTimeout(txTimeout) { d.await() }
        }

        val transactions = QueryBuilder.findAllTransactions()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }

        val hash = SignedTransaction.encode(transactions[2].transaction.value).hash()

        val txByHash = QueryBuilder.findTransactionByHash(hash)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
        assertEquals(
            DEFAULT_ASSET_DEFINITION_ID.domain,
            txByHash.transaction.value
                .extractInstruction<InstructionBox.Register>()
                .registerBox.cast<RegisterBox.Domain>().registerOfDomain.`object`.id,
        )
        txByHash.transaction.value
            .let { SignedTransaction.encode(it).hash() }
            .also { assertContentEquals(hash, it) }
    }

    @Test
    @WithIroha([NewDomainWithMetadata::class])
    @Feature("Domains")
    @Query("FindDomainKeyValueByIdAndKey")
    @Story("Domain queries domain key value by ID and key")
    @SdkTestId("find_domain_key_value_by_ID_and_key")
    fun `find domain key value by ID and key`(): Unit = runBlocking {
        QueryBuilder.findDomainKeyValueByIdAndKey(
            NewDomainWithMetadata.DOMAIN_ID,
            NewDomainWithMetadata.KEY,
        ).account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .also { assertEquals(NewDomainWithMetadata.VALUE, it) }
    }

    @Test
    @WithIroha([WithExecutableTrigger::class])
    @Feature("Triggers")
    @Query("FindTriggerById")
    @Story("Trigger queries trigger by ID")
    @SdkTestId("find_trigger_by_id")
    fun `find trigger by ID`(): Unit = runBlocking {
        val triggerId = WithExecutableTrigger.TRIGGER_ID

        QueryBuilder.findTriggerById(triggerId)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { client.sendQuery(it) }
            .also { trigger -> assertTrue { trigger.id == triggerId } }
    }

    @Test
    @WithIroha([WithExecutableTrigger::class])
    @Feature("Triggers")
    @Query("FindTriggersByDomainId")
    @Story("Trigger queries triggers by domain ID")
    @SdkTestId("find_triggers_by_domain_id")
    fun `find triggers by domain ID`(): Unit = runBlocking {
        QueryBuilder.findTriggersByAuthorityDomainId(ALICE_ACCOUNT_ID.domain)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { client.sendQuery(it) }
            .also { triggers -> assert(triggers.all { it.id == WithExecutableTrigger.TRIGGER_ID }) }
    }

    @Test
    @WithIroha([WithExecutableTrigger::class])
    @Feature("Triggers")
    @Query("FindAllActiveTriggerIds")
    @Story("Trigger queries all active trigger IDs")
    @SdkTestId("find_all_active_trigger_ids")
    fun `find all active trigger IDs`(): Unit = runBlocking {
        val triggerId = WithExecutableTrigger.TRIGGER_ID

        QueryBuilder.findAllActiveTriggerIds()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { client.sendQuery(it) }
            .also { ids ->
                assertTrue { ids.all { it == triggerId } }
            }
    }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Accounts")
    @Query("FindAllAccountsWithPaginationAndSorting")
    @Story("Account queries all accounts with pagination and sorting by metadata key")
    @SdkTestId("pagination_plus_sorting_by_metadata_key")
    fun `pagination plus sorting by metadata key`(): Unit = runBlocking {
        val key1 = RandomStringUtils.randomAlphabetic(5).asName()
        val key2 = RandomStringUtils.randomAlphabetic(5).asName()

        createAccount(metadata = mapOf(key1 to "1", key2 to "1"))
        createAccount(metadata = mapOf(key1 to "0", key2 to "0"))
        createAccount(metadata = mapOf(key1 to "2", key2 to "2"))

        listOf(key1, key2).forEach { key ->
            QueryBuilder.findAllAccounts()
                .account(ALICE_ACCOUNT_ID)
                .sorting(key.string)
                .buildSigned(ALICE_KEYPAIR)
                .let { query -> client.sendQuery(query) }
                .let { accounts ->
                    assertEquals("0", accounts[0].metadata.sortedMapOfName[key])
                    assertEquals("1", accounts[1].metadata.sortedMapOfName[key])
                    assertEquals("2", accounts[2].metadata.sortedMapOfName[key])
                }
        }
    }

    @Test
    @WithIroha([NewDomainWithMetadata::class])
    @Feature("Accounts")
    @Query("FindAllAccountsWithPagination")
    @Story("Account queries all accounts with pagination after inserting some new accounts")
    @SdkTestId("pagination_works_correct_after_inserting_some_new_accounts")
    fun `pagination works correct after inserting some new accounts`(): Unit = runBlocking {
        val key = "ts".asName()
        val limit = 3L

        val metadata0 = Instant.now().toEpochMilli().toString()
        createAccount(domainId = NewDomainWithMetadata.DOMAIN_ID, metadata = mapOf(key to metadata0))
        val metadata1 = Instant.now().toEpochMilli().toString()
        createAccount(domainId = NewDomainWithMetadata.DOMAIN_ID, metadata = mapOf(key to metadata1))
        val metadata2 = Instant.now().toEpochMilli().toString()
        createAccount(domainId = NewDomainWithMetadata.DOMAIN_ID, metadata = mapOf(key to metadata2))
        val metadata3 = Instant.now().toEpochMilli().toString()
        createAccount(domainId = NewDomainWithMetadata.DOMAIN_ID, metadata = mapOf(key to metadata3))
        val metadata4 = Instant.now().toEpochMilli().toString()
        createAccount(domainId = NewDomainWithMetadata.DOMAIN_ID, metadata = mapOf(key to metadata4))

        QueryBuilder.findAccountsByDomainId(NewDomainWithMetadata.DOMAIN_ID)
            .account(ALICE_ACCOUNT_ID)
            .pagination(limit = limit)
            .sorting(key)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .let { accounts ->
                assertEquals(limit, accounts.size.toLong())
                assertEquals(metadata2, accounts[2].metadata.sortedMapOfName[key])
            }
        QueryBuilder.findAccountsByDomainId(NewDomainWithMetadata.DOMAIN_ID)
            .account(ALICE_ACCOUNT_ID)
            .pagination(start = limit.toBigInteger(), limit = limit)
            .sorting(key)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .let { accounts ->
                assertEquals(2, accounts.size)
                assertEquals(metadata4, accounts[1].metadata.sortedMapOfName[key])
            }

        val metadata5 = Instant.now().toEpochMilli().toString()
        createAccount(domainId = NewDomainWithMetadata.DOMAIN_ID, metadata = mapOf(key to metadata5))
        val metadata6 = Instant.now().toEpochMilli().toString()
        createAccount(domainId = NewDomainWithMetadata.DOMAIN_ID, metadata = mapOf(key to metadata6))
        val metadata7 = Instant.now().toEpochMilli().toString()
        createAccount(domainId = NewDomainWithMetadata.DOMAIN_ID, metadata = mapOf(key to metadata7))
        val metadata8 = Instant.now().toEpochMilli().toString()
        createAccount(domainId = NewDomainWithMetadata.DOMAIN_ID, metadata = mapOf(key to metadata8))

        QueryBuilder.findAccountsByDomainId(NewDomainWithMetadata.DOMAIN_ID)
            .account(ALICE_ACCOUNT_ID)
            .pagination(start = BigInteger.valueOf(2).multiply(limit.toBigInteger()), limit = limit)
            .sorting(key)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .let { accounts ->
                assertEquals(3, accounts.size)
                assertEquals(metadata6, accounts[0].metadata.sortedMapOfName[key])
                assertEquals(metadata8, accounts[2].metadata.sortedMapOfName[key])
            }
        print(metadata5)
        print(metadata7)
    }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Feature("Accounts")
    @Query("FindAllAccountsWithPagination")
    @Story("Account queries all accounts with pagination")
    @SdkTestId("find_all_account_with_pagination")
    fun `find all account with pagination`(): Unit = runBlocking {
        val limit = 5L
        val start = 3L
        var accounts = QueryBuilder.findAllAccounts()
            .account(ALICE_ACCOUNT_ID)
            .pagination(limit = 5)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
        assertEquals(3, accounts.size)

        repeat(2) { createAccount() }

        accounts = QueryBuilder.findAllAccounts()
            .account(ALICE_ACCOUNT_ID)
            .pagination(start = BigInteger.valueOf(start), limit = limit)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
        assertEquals(limit - start, accounts.size.toLong())
    }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Feature("Transactions")
    @Query("FindAllTransactions")
    @Story("Account queries all transactions")
    @SdkTestId("find_all_transactions")
    fun `find all transactions`(): Unit = runBlocking {
        repeat(5) {
            client.sendTransaction {
                account(ALICE_ACCOUNT_ID)
                burnAsset(DEFAULT_ASSET_ID, 1)
                buildSigned(ALICE_KEYPAIR)
            }.also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        }
        QueryBuilder.findAllTransactions()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { client.sendQuery(it) }
            .also { txs ->
                assertTrue(txs.size == 9) // 5 + 4 genesis txs
            }
    }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Feature("Blocks")
    @Query("FindAllBlocks")
    @Story("Account queries all blocks")
    @SdkTestId("find_all_blocks")
    fun `find all blocks`(): Unit = runBlocking {
        client.sendTransaction {
            account(ALICE_ACCOUNT_ID)
            burnAsset(DEFAULT_ASSET_ID, 1)
            buildSigned(ALICE_KEYPAIR)
        }.also { d ->
            withTimeout(txTimeout) { d.await() }
        }
        QueryBuilder.findAllBlocks()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { client.sendQuery(it) }
            .also { blocks ->
                assertTrue(blocks.size == 2)
            }
    }

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Feature("Blocks")
    @Query("FindAllBlockHeaders")
    @Story("Account queries all block headers")
    @SdkTestId("find_all_block_headers")
    fun `find all block headers`(): Unit = runBlocking {
        client.sendTransaction {
            account(ALICE_ACCOUNT_ID)
            burnAsset(DEFAULT_ASSET_ID, 1)
            buildSigned(ALICE_KEYPAIR)
        }.also { d ->
            withTimeout(txTimeout) { d.await() }
        }
        QueryBuilder.findAllBlockHeaders()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { client.sendQuery(it) }
            .also { headers ->
                assertTrue(headers.size == 2)
            }
    }

    @Test
    @WithIroha([AliceHasRoleWithAccessToBobsMetadata::class])
    @Feature("Roles")
    @Query("FindAllRoleIds")
    @Story("Account queries all role IDs")
    @SdkTestId("find_all_role_IDs")
    fun `find all role IDs`(): Unit = runBlocking {
        QueryBuilder.findAllRoleIds()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .also { ids ->
                assertContains(ids, AliceHasRoleWithAccessToBobsMetadata.ROLE_ID)
            }
    }

    @Test
    @WithIroha([AliceHasRoleWithAccessToBobsMetadata::class])
    @Feature("Roles")
    @Query("FindRolesByAccountId")
    @Story("Account queries roles by account ID")
    @SdkTestId("find_roles_by_account_ID")
    fun `find roles by account ID`(): Unit = runBlocking {
        QueryBuilder.findRolesByAccountId(ALICE_ACCOUNT_ID)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .also { ids ->
                assertContains(ids, AliceHasRoleWithAccessToBobsMetadata.ROLE_ID)
            }
    }

    @Test
    @WithIroha([AliceHasRoleWithAccessToBobsMetadata::class])
    @Feature("Roles")
    @Query("FindAllRoles")
    @Story("Account queries all roles")
    @SdkTestId("find_all_roles")
    fun `find all roles`(): Unit = runBlocking {
        QueryBuilder.findAllRoles()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .also { roles ->
                assertContains(
                    roles.map { it.id },
                    AliceHasRoleWithAccessToBobsMetadata.ROLE_ID,
                )
            }
    }

    @Test
    @WithIroha([AliceHasRoleWithAccessToBobsMetadata::class])
    @Feature("Roles")
    @Query("FindRoleByRoleId")
    @Story("Account queries role by role ID")
    @SdkTestId("find_role_by_role_ID")
    fun `find role by ID`(): Unit = runBlocking {
        val roleId = AliceHasRoleWithAccessToBobsMetadata.ROLE_ID
        QueryBuilder.findRoleByRoleId(roleId)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .also { role -> assertEquals(role.id, roleId) }
    }

    @Test
    @WithIroha([AliceWithTestAssets::class])
    @Feature("Assets")
    @Query("FindAssetDefinitionsWithOrFilter")
    @Story("Account queries asset definitions with or filter")
    @SdkTestId("find_asset_definitions_with_or_filter")
    fun `find asset definitions with or filter`(): Unit = runBlocking {
        val definitionId = AliceWithTestAssets.TEST_ASSET_DEFINITION_ID
        val filter = QueryFilters.or(
            StringPredicate.Is("${definitionId.name.string}#${definitionId.domain.name.string}"),
        )
        QueryBuilder.findAllAssetsDefinitions(filter)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query ->
                client.sendQuery(query)
            }.also { assets ->
                assertEquals(1, assets.size)
                assertEquals(definitionId, assets[0].id)
            }
    }

    @WithIroha([WithManyDomains::class])
    @Feature("Domains")
    @Query("FindAllDomains")
    @Story("Account queries all domains using cursor pagination")
    @SdkTestId("querying_multiple_domains_with_cursor_test")
    fun `find multiple domains with cursor test`(): Unit = runBlocking {
        val domains = QueryBuilder.findAllDomains()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
        assertEquals(WithManyDomains.DOMAINS_COUNT + 2, domains.size)
    }

    private suspend fun createAccount(
        domainId: DomainId = DEFAULT_DOMAIN_ID,
        keyPair: KeyPair = generateKeyPair(),
        metadata: Map<Name, String> = mapOf(),
    ) {
        val newAccountId = AccountId(domainId, keyPair.public.toIrohaPublicKey())
        client.sendTransaction {
            accountId = ALICE_ACCOUNT_ID
            registerAccount(newAccountId, Metadata(metadata))
            buildSigned(ALICE_KEYPAIR)
        }.also { d ->
            withTimeout(txTimeout) { d.await() }
        }
    }
}
