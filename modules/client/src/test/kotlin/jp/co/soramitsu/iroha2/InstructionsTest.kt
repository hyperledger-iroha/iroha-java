package jp.co.soramitsu.iroha2

import io.qameta.allure.Feature
import io.qameta.allure.Owner
import io.qameta.allure.Story
import jp.co.soramitsu.iroha2.annotations.Permission
import jp.co.soramitsu.iroha2.annotations.Sdk
import jp.co.soramitsu.iroha2.annotations.SdkTestId
import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.generated.*
import jp.co.soramitsu.iroha2.query.QueryBuilder
import jp.co.soramitsu.iroha2.testengine.ALICE_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.ALICE_KEYPAIR
import jp.co.soramitsu.iroha2.testengine.AliceAndBobEachHave100Xor
import jp.co.soramitsu.iroha2.testengine.AliceHas100XorAndPermissionToMintAndBurn
import jp.co.soramitsu.iroha2.testengine.AliceHasPermissionToRegisterDomain
import jp.co.soramitsu.iroha2.testengine.AliceHasPermissionToUnregisterDomain
import jp.co.soramitsu.iroha2.testengine.AliceHasRoleWithAccessToBobsMetadata
import jp.co.soramitsu.iroha2.testengine.AliceWithTestAssets
import jp.co.soramitsu.iroha2.testengine.BOB_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.BOB_KEYPAIR
import jp.co.soramitsu.iroha2.testengine.BobCanManageRoles
import jp.co.soramitsu.iroha2.testengine.BobHasPermissionToRegisterDomain
import jp.co.soramitsu.iroha2.testengine.DEFAULT_ASSET_DEFINITION_ID
import jp.co.soramitsu.iroha2.testengine.DEFAULT_ASSET_ID
import jp.co.soramitsu.iroha2.testengine.DEFAULT_DOMAIN_ID
import jp.co.soramitsu.iroha2.testengine.DefaultGenesis
import jp.co.soramitsu.iroha2.testengine.FatGenesis
import jp.co.soramitsu.iroha2.testengine.IROHA_CONFIG_DELIMITER
import jp.co.soramitsu.iroha2.testengine.IrohaTest
import jp.co.soramitsu.iroha2.testengine.NewAccountWithMetadata
import jp.co.soramitsu.iroha2.testengine.NewDomainWithMetadata
import jp.co.soramitsu.iroha2.testengine.RubbishToTestMultipleGenesis
import jp.co.soramitsu.iroha2.testengine.StoreAssetWithMetadata
import jp.co.soramitsu.iroha2.testengine.WithDomainTransferredToBob
import jp.co.soramitsu.iroha2.testengine.WithIroha
import jp.co.soramitsu.iroha2.testengine.WithIrohaManual
import jp.co.soramitsu.iroha2.testengine.XorAndValAssets
import jp.co.soramitsu.iroha2.transaction.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.withTimeout
import org.apache.commons.lang3.RandomStringUtils.randomAlphabetic
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.security.SecureRandom
import java.util.UUID
import kotlin.test.*

@Owner("akostyuchenko")
@Sdk("Java/Kotlin")
class InstructionsTest : IrohaTest<Iroha2Client>() {
    @Test
    @Disabled // EXAMPLE
    @WithIrohaManual(
        ["http://localhost:8080", "http://localhost:8081", "http://localhost:8082", "http://localhost:8083"],
        account = "7233bfc89dcbd68c19fde6ce6158225298ec1131b6a130d1aeb454c1ab5183c0${ACCOUNT_ID_DELIMITER}wonderland",
        "7233bfc89dcbd68c19fde6ce6158225298ec1131b6a130d1aeb454c1ab5183c0",
        "9ac47abf59b356e0bd7dcbbbb4dec080e302156a48ca907e47cb6aea1d32719e",
    )
    fun `register domain with manual initialized Iroha`(): Unit = runBlocking {
        val domainId = "new_domain_name".asDomainId()

        Register.domain(domainId).execute(client).also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        QueryBuilder.findDomainById(domainId).account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query)!! }
            .also { result -> assertEquals(result.id, domainId) }
    }

    @Test
    @Disabled // EXAMPLE
    @WithIrohaManual(
        account = "7233bfc89dcbd68c19fde6ce6158225298ec1131b6a130d1aeb454c1ab5183c0${ACCOUNT_ID_DELIMITER}wonderland",
        publicKey = "7233bfc89dcbd68c19fde6ce6158225298ec1131b6a130d1aeb454c1ab5183c0",
        privateKey = "9ac47abf59b356e0bd7dcbbbb4dec080e302156a48ca907e47cb6aea1d32719e",
        dockerComposeFile = "../../docker-compose/docker-compose.yaml",
    )
    fun `register domain with manual initialized Iroha via docker-compose`(): Unit = runBlocking {
        val domainId = "new_domain_name".asDomainId()

        Register.domain(domainId).execute(client).also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        QueryBuilder.findDomainById(domainId)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query)!! }
            .also { result -> assertEquals(result.id, domainId) }
    }

    /**
     * Using for docs generation
     */
    // #region java_register_domain
    @Test
    @WithIroha([AliceHasPermissionToRegisterDomain::class])
    @Feature("Domains")
    @Story("Account registers a domain")
    @Permission("no_permission_required")
    @SdkTestId("register_domain")
    fun `register domain`(): Unit = runBlocking {
        val domainId = "new_domain_name".asDomainId()

        Register.domain(domainId).execute(client).also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        QueryBuilder.findDomainById(domainId)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query)!! }
            .also { result -> assertEquals(result.id, domainId) }
    }
    // #endregion java_register_domain

    /**
     * Using for docs generation
     */
    // #region java_register_account
    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Accounts")
    @Story("Account registers an account")
    @Permission("no_permission_required")
    @SdkTestId("register_account")
    fun `register account`(): Unit = runBlocking {
        val accountId = AccountId(DEFAULT_DOMAIN_ID, generatePublicKey())

        Register.account(accountId).execute(client).also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        QueryBuilder.findAccountById(accountId)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query)!! }
            .also { account -> assertEquals(account.id, accountId) }
    }
    // #endregion java_register_account

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Accounts")
    @Story("Account registers an account")
    @Story("Account unregisters an account")
    @Permission("no_permission_required")
    @SdkTestId("register_account")
    @SdkTestId("unregister_account")
    fun `register and unregister account`(): Unit = runBlocking {
        val joeKeyPair = generateKeyPair()
        val joeId = AccountId(DEFAULT_DOMAIN_ID, joeKeyPair.public.toIrohaPublicKey())
        Register.account(joeId).execute(client).also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        QueryBuilder.findAccountById(joeId)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query)!! }
            .also { account -> assertEquals(account.id, joeId) }

        Unregister.account(joeId).executeAs(joeId, joeKeyPair, client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        QueryBuilder.findAccountById(joeId)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query) }
            .also { account -> assertNull(account) }
    }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Assets")
    @Story("Account registers an asset definition")
    @Story("Account unregisters an asset definition")
    @Permission("no_permission_required")
    @SdkTestId("register_asset_definition")
    @SdkTestId("unregister_asset_definition")
    fun `register and unregister asset`(): Unit = runBlocking {
        val assetDefinitionId = AssetDefinitionId(DEFAULT_DOMAIN_ID, "XSTUSD".asName())
        Register.assetDefinition(assetDefinitionId, AssetType.numeric()).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        val assetId = AssetId(ALICE_ACCOUNT_ID, assetDefinitionId)
        Register.asset(assetId, AssetValue.Numeric(0.asNumeric())).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        QueryBuilder.findAssetById(assetId)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query)!! }
            .also { asset -> assertEquals(asset.id, assetId) }

        Unregister.asset(assetId).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        QueryBuilder.findAssetById(assetId)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query) }
            .also { asset -> assertNull(asset) }

        Unregister.assetDefinition(assetDefinitionId).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        QueryBuilder.findAssetDefinitionById(assetDefinitionId)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query) }
            .also { definition -> assertNull(definition) }
    }

    @Test
    @WithIroha([AliceHasPermissionToUnregisterDomain::class])
    @Feature("Domains")
    @Story("Account unregisters a domain")
    @Permission("CanUnregisterDomain")
    @SdkTestId("unregister_domain")
    fun `unregister domain`(): Unit = runBlocking {
        Unregister.domain(AliceHasPermissionToUnregisterDomain.NEW_DOMAIN_ID).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        QueryBuilder.findDomainById(AliceHasPermissionToUnregisterDomain.NEW_DOMAIN_ID)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query) }
            .also { domain -> assertNull(domain) }
    }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Accounts")
    @Story("Account registers an account")
    @Permission("no_permission_required")
    @SdkTestId("register_account_with_metadata")
    fun `register account with metadata`(): Unit = runBlocking {
        val addressKey = "address".asName()
        val phoneKey = "phone".asName()
        val emailKey = "email".asName()
        val cityKey = "city".asName()
        val addressValue = "address"
        val phoneValue = "phone"
        val emailValue = "email"
        val cityValue = "city"
        val metadata = Metadata(
            mapOf(
                Pair(addressKey, Json.writeValue(addressValue)),
                Pair(phoneKey, Json.writeValue(phoneValue)),
                Pair(emailKey, Json.writeValue(emailValue)),
                Pair(cityKey, Json.writeValue(cityValue)),
            ),
        )
        val newAccountId = AccountId(DEFAULT_DOMAIN_ID, generatePublicKey())
        Register.account(newAccountId, metadata).execute(client).also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        val accountMetadata = QueryBuilder.findAccountById(newAccountId)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query)!! }
            .also { account -> assertEquals(account.id, newAccountId) }
            .metadata
        assertEquals(4, accountMetadata.sortedMapOfName.size)
        assertEquals(addressValue, accountMetadata.sortedMapOfName[addressKey]!!.readValue())
        assertEquals(phoneValue, accountMetadata.sortedMapOfName[phoneKey]!!.readValue())
        assertEquals(emailValue, accountMetadata.sortedMapOfName[emailKey]!!.readValue())
        assertEquals(cityValue, accountMetadata.sortedMapOfName[cityKey]!!.readValue())
    }

    /**
     * Using for docs generation
     */
    // #region java_register_asset
    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Assets")
    @Story("Account registers an asset definition")
    @Permission("no_permission_required")
    @SdkTestId("DEPRECATE CANDIDATE")
    fun `register asset`(): Unit = runBlocking {
        Register.assetDefinition(DEFAULT_ASSET_DEFINITION_ID, AssetType.numeric()).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        val assetDefinitions = QueryBuilder.findAssetsDefinitions()
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { q -> client.sendQuery(q) }

        assetDefinitions.find { it.id == DEFAULT_ASSET_DEFINITION_ID } ?: fail(
            "Expected query response contains assetDefinition $DEFAULT_ASSET_DEFINITION_ID, " +
                "but it is not. Response was $assetDefinitions",
        )
    }
    // #endregion java_register_asset

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Assets")
    @Story("Account registers an asset definition")
    @Permission("no_permission_required")
    @SdkTestId("register_asset_definition_with_store_value_type")
    fun `store asset`(): Unit = runBlocking {
        val pair1 = "key1".asName() to "bar"
        val pair2 = "key2".asName() to "true"
        val pair3 = "key3".asName() to "12345"

        listOf(
            Register.assetDefinition(DEFAULT_ASSET_DEFINITION_ID, AssetType.Store()),
            SetKeyValue.asset(DEFAULT_ASSET_ID, pair1.first, pair1.second),
            SetKeyValue.asset(DEFAULT_ASSET_ID, pair2.first, pair2.second),
            SetKeyValue.asset(DEFAULT_ASSET_ID, pair3.first, pair3.second),
        ).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        val findAssetByIdQry = QueryBuilder.findAssetById(DEFAULT_ASSET_ID)
            .account(client.authority)
            .buildSigned(client.keyPair)
        val asset = client.sendQuery(findAssetByIdQry)

        assertEquals(DEFAULT_ASSET_ID.definition.name, asset?.id?.definition?.name)
        assertEquals(DEFAULT_ASSET_ID.definition.domain, asset?.id?.definition?.domain)
        when (val value = asset?.value) {
            is AssetValue.Store -> {
                assertEquals(pair1.second, value.metadata.sortedMapOfName[pair1.first]!!.readValue())
                assertEquals(pair2.second, value.metadata.sortedMapOfName[pair2.first]!!.readValue())
                assertEquals(pair3.second, value.metadata.sortedMapOfName[pair3.first]!!.readValue())
            }

            else -> fail("Expected result asset value has type `AssetValue.Store`, but it was `${asset!!.value::class.simpleName}`")
        }

        // try to find saved assets by domain name
        val findAssetsByDomainNameQry = QueryBuilder.findAssetsByDomainId(DEFAULT_DOMAIN_ID)
            .account(client.authority)
            .buildSigned(client.keyPair)
        val assetsByDomainName = client.sendQuery(findAssetsByDomainNameQry)
        assertEquals(1, assetsByDomainName.size)
        assertEquals(asset.id, assetsByDomainName.first().id)
    }

    @Test
    @WithIroha(
        [DefaultGenesis::class],
        configs = ["WSV_ACCOUNT_METADATA_LIMITS$IROHA_CONFIG_DELIMITER{\"max_entry_byte_size\": 65536, \"max_len\": 1048576}"],
    )
    @Feature("Accounts")
    @Story("Account metadata limit adjustment")
    @Permission("no_permission_required")
    @SdkTestId("account_metadata_limit_increased")
    fun `account metadata limit increased`(): Unit = runBlocking {
        val key = "key".asName()
        val value = randomAlphabetic(5000)

        // 5000 characters string would be rejected by Iroha with default WSV_ACCOUNT_METADATA_LIMITS config
        SetKeyValue.account(ALICE_ACCOUNT_ID, key, Json.writeValue(value)).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
    }

    @Test
    @Feature("Accounts")
    @Story("Account sets key value pair")
    @Permission("CanModifyDomainMetadata")
    @SdkTestId("modify_metadata_for_another_account_domain_definition")
    @WithIroha([BobHasPermissionToRegisterDomain::class])
    fun `domain metadata set key value with permissions`(): Unit = runBlocking {
        val domainId = DomainId(randomAlphabetic(10).asName())

        listOf(
            Register.domain(domainId),
            Grant.accountPermission(
                CanModifyDomainMetadata(domainId),
                ALICE_ACCOUNT_ID,
            ),
        ).executeAs(BOB_ACCOUNT_ID, BOB_KEYPAIR, client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        SetKeyValue.domain(domainId, randomAlphabetic(10).asName(), Json.writeValue(randomAlphabetic(10))).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
    }

//    @Test
//    @WithIroha([DefaultGenesis::class])
//    @Feature("Accounts")
//    @Story("Account sets key value pair")
//    @Permission("CanModifyAssetMetadata")
//    @SdkTestId("modify_metadata_for_another_account_asset_definition")
//    fun `grant access to asset key-value and then revoke`(): Unit = runBlocking {
//        val aliceAssetId = DEFAULT_ASSET_ID
//
//        listOf(
//            registerAssetDefinition(aliceAssetId.definition, AssetType.Store())
//            // grant by Alice to Bob permissions to set key value in Asset.Store
//            grantPermission(
//                Permissions.CanModifyAssetMetadata,
//                aliceAssetId.asJson(true),
//                BOB_ACCOUNT_ID,
//            )
//        ).execute(client)
//            .also { d ->
//                withTimeout(txTimeout) { d.await() }
//        client.tx(BOB_ACCOUNT_ID, BOB_KEYPAIR) {
//            SetKeyValue.setKeyValue(aliceAssetId, "foo".asName(), Json("bar"))
//        }
//
//        val query = QueryBuilder.findAssetById(aliceAssetId)
//            .account(client.authority)
//            .buildSigned(client.keyPair)
//        val asset = client.sendQuery(query)
//
//        assertEquals(aliceAssetId.definition.name, asset?.id?.definition?.name)
//        assertEquals(aliceAssetId.definition.domain, asset?.id?.definition?.domain)
//        when (val value = asset?.value) {
//            is AssetValue.Store -> assertEquals("bar", value.metadata.sortedMapOfName["foo".asName()]!!.readValue())
//            else -> fail("Expected result asset value has type `AssetValue.Store`, but it was `${asset!!.value::class.simpleName}`")
//        }
//
//        revokeSetKeyValueAsset(aliceAssetId, BOB_ACCOUNT_ID).execute(client)
//            .also { d ->
//                withTimeout(txTimeout) { d.await() }
//        QueryBuilder.findPermissionsByAccountId(BOB_ACCOUNT_ID)
//            .account(BOB_ACCOUNT_ID)
//            .buildSigned(BOB_KEYPAIR)
//            .let { client.sendQuery(it) }
//            .also { permissions -> assertTrue { permissions.isEmpty() } }
//    }

    /**
     * Using for docs generation
     */
    // #region java_mint_asset
    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Assets")
    @Story("Account mints an asset")
    @Permission("no_permission_required")
    @SdkTestId("mint_asset_for_account_in_same_domain")
    fun `mint asset`(): Unit = runBlocking {
        listOf<Instruction>(
            Register.assetDefinition(DEFAULT_ASSET_DEFINITION_ID, AssetType.numeric()),
            Mint.asset(DEFAULT_ASSET_ID, BigDecimal(5)),
        ).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        QueryBuilder.findAssetsByAccountId(ALICE_ACCOUNT_ID)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query) }
            .also { result ->
                assertEquals(5, result.get(DEFAULT_ASSET_ID)!!.value.cast<AssetValue.Numeric>().numeric.asInt())
            }
    }
    // #endregion java_mint_asset

    @Test
    @WithIroha([AliceHas100XorAndPermissionToMintAndBurn::class])
    @Feature("Assets")
    @Story("Account burns an asset")
    @Permission("no_permission_required")
    @SdkTestId("burn_asset_for_account_in_same_domain")
    fun `burn asset`(): Unit = runBlocking {
        // check balance before burn
        val query = QueryBuilder.findAssetsByAccountId(ALICE_ACCOUNT_ID)
            .account(client.authority)
            .buildSigned(client.keyPair)
        var result = client.sendQuery(query)
        assertEquals(100, result.get(DEFAULT_ASSET_ID)!!.value.cast<AssetValue.Numeric>().numeric.asInt())

        Burn.asset(DEFAULT_ASSET_ID, BigDecimal(50)).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        // check balance after burn
        result = client.sendQuery(query)
        assertEquals(50, result.get(DEFAULT_ASSET_ID)!!.value.cast<AssetValue.Numeric>().numeric.asInt())
    }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Assets")
    @Story("Account burns an asset")
    @Permission("CanBurnAssetsWithDefinition")
    @SdkTestId("burn_other_user_xasset")
    fun `burn other user asset`(): Unit = runBlocking {
        listOf(
            Register.assetDefinition(DEFAULT_ASSET_DEFINITION_ID, AssetType.numeric()),
            Mint.asset(DEFAULT_ASSET_ID, BigDecimal(100)),
            Grant.accountPermission(
                CanBurnAssetWithDefinition(DEFAULT_ASSET_DEFINITION_ID),
                BOB_ACCOUNT_ID,
            ),
        ).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        Burn.asset(DEFAULT_ASSET_ID, BigDecimal(50)).executeAs(BOB_ACCOUNT_ID, BOB_KEYPAIR, client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        val result = QueryBuilder.findAssetsByAccountId(ALICE_ACCOUNT_ID)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query) }
        assertEquals(50, result.get(DEFAULT_ASSET_ID)!!.value.cast<AssetValue.Numeric>().numeric.asInt())
    }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Accounts")
    @Story("Account changes account metadata")
    @Permission("CanSetKeyValueInAccount")
    @SdkTestId("change_account_metadata_by_granted_account")
    fun `change user account metadata`(): Unit = runBlocking {
        val saltKey = "salt"

        // grant permission to Alice to change Bob's account metadata
        Grant.accountPermission(
            CanModifyAccountMetadata(BOB_ACCOUNT_ID),
            ALICE_ACCOUNT_ID,
        ).executeAs(BOB_ACCOUNT_ID, BOB_KEYPAIR, client).also { d ->
            withTimeout(txTimeout) { d.await() }
        }

        // add/update salt value in Bob's account metadata
        val salt = randomAlphabetic(10)
        SetKeyValue.account(BOB_ACCOUNT_ID, saltKey.asName(), salt).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        // check new metadata in Bob's account
        val bobAccountMetadata = QueryBuilder.findAccountById(BOB_ACCOUNT_ID)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query)!!.metadata.sortedMapOfName }
        assertEquals(salt, bobAccountMetadata["salt".asName()]!!.readValue())
    }

    @Test
    @WithIroha([AliceAndBobEachHave100Xor::class, AliceHasPermissionToRegisterDomain::class])
    @Feature("Assets")
    @Story("Account transfers assets")
    @Permission("CanTransferUserAsset")
    @SdkTestId("transfer_asset")
    fun `transfer asset`(): Unit = runBlocking {
        val aliceAssetId = DEFAULT_ASSET_ID
        val bobAssetId = AliceAndBobEachHave100Xor.BOB_ASSET_ID

        assertEquals(100, getAccountAmount(aliceAssetId))
        assertEquals(100, getAccountAmount(bobAssetId))

        Transfer.asset(aliceAssetId, BigDecimal(40), BOB_ACCOUNT_ID).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        assertEquals(60, getAccountAmount(aliceAssetId))
        assertEquals(140, getAccountAmount(bobAssetId))

        Transfer.asset(bobAssetId, BigDecimal(40), ALICE_ACCOUNT_ID).executeAs(BOB_ACCOUNT_ID, BOB_KEYPAIR, client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        assertEquals(100, getAccountAmount(aliceAssetId))
        assertEquals(100, getAccountAmount(bobAssetId))

        val joeDomain = "joe_domain".asDomainId()
        Register.domain(joeDomain).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        val joeKeyPair = generateKeyPair()
        val joeId = AccountId(joeDomain, joeKeyPair.public.toIrohaPublicKey())
        Register.account(joeId).execute(client)

        Grant.accountPermission(CanTransferAsset(aliceAssetId), joeId).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        Transfer.asset(bobAssetId, BigDecimal(40), ALICE_ACCOUNT_ID)
            .executeAs(BOB_ACCOUNT_ID, BOB_KEYPAIR, client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        assertEquals(60, getAccountAmount(aliceAssetId))
        assertEquals(140, getAccountAmount(bobAssetId))
    }

    @Test
    @WithIroha([StoreAssetWithMetadata::class])
    @Feature("Assets")
    @Story("Account removes asset metadata")
    @Permission("no_permission_required")
    @SdkTestId("remove_asset_metadata")
    fun `remove asset`(): Unit = runBlocking {
        val assetId = StoreAssetWithMetadata.ASSET_ID
        val assetKey = StoreAssetWithMetadata.ASSET_KEY

        val assetBefore = getAsset(assetId)
        val value = assetBefore.value.cast<AssetValue.Store>().metadata.sortedMapOfName[assetKey]!!
        assertEquals(StoreAssetWithMetadata.ASSET_VALUE, value.readValue())
        RemoveKeyValue.asset(assetId, assetKey).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        val assetAfter = getAsset(assetId)
        assert(assetAfter.value.cast<AssetValue.Store>().metadata.sortedMapOfName.isEmpty())
    }

    @Test
    @WithIroha([DefaultGenesis::class])
    @Feature("Assets")
    @Story("Account registers an asset definition")
    @SdkTestId("register_fixed_asset_definition")
    @Story("Account mints an asset")
    @SdkTestId("mint_fixed_asset")
    @Story("Account burns an asset")
    @Permission("no_permission_required")
    @SdkTestId("burn_fixed_asset")
    fun `check assets with type Fixed are properly minted and burned`(): Unit = runBlocking {
        Register.assetDefinition(DEFAULT_ASSET_DEFINITION_ID, AssetType.numeric()).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        // counter to track all changes in balance
        var counter = BigDecimal.ZERO
        // count of changes (both mint and burn)
        val probes = 20
        val random = SecureRandom()
        // return positive random number what is never greater than counter
        val getFpNumber = {
            BigDecimal(random.nextDouble() + random.nextInt())
                .abs()
                .stripTrailingZeros()
                .remainder(counter, MathContext.DECIMAL64)
                .setScale(random.nextInt(DEFAULT_SCALE), RoundingMode.DOWN)
        }
        val mintAsset: suspend (BigDecimal) -> Unit = {
            Mint.asset(DEFAULT_ASSET_ID, it).execute(client)
                .also { d ->
                    withTimeout(txTimeout) { d.await() }
                }
            counter += it
        }
        val burnAsset: suspend (BigDecimal) -> Unit = {
            Burn.asset(DEFAULT_ASSET_ID, it).execute(client)
                .also { d ->
                    withTimeout(txTimeout) { d.await() }
                }
            counter -= it
        }
        val assertBalance: suspend (BigDecimal) -> Unit = { expectedBalance ->
            val asset = QueryBuilder.findAssetsByAccountId(ALICE_ACCOUNT_ID)
                .account(client.authority)
                .buildSigned(client.keyPair)
                .let { query -> client.sendQuery(query) }.get(DEFAULT_ASSET_ID)

            asset?.value?.cast<AssetValue.Numeric>()?.numeric?.asBigDecimal() ?: BigDecimal.ZERO
                .also { actualBalance ->
                    assertTrue("expected value `$expectedBalance`, but was `$actualBalance`") {
                        expectedBalance.compareTo(actualBalance) == 0
                    }
                }
        }
        assertBalance(counter)
        mintAsset(BigDecimal.TEN)
        assertBalance(counter)
        for (i in 0..probes) {
            if (i % 2 == 0) {
                mintAsset(getFpNumber())
            } else {
                burnAsset(getFpNumber())
            }
            assertBalance(counter)
        }
    }

//    @Test
//    @WithIroha([DefaultGenesis::class])
//    @Feature("Assets")
//    @Story("Account registers an asset definition")
//    @Permission("no_permission_required")
//    @SdkTestId("register_asset_definition_with_metadata")
//    fun `register asset with metadata`(): Unit = runBlocking {
//        val assetKey = "asset_metadata_key".asName()
//        val assetValue = "some string value"
//        val metadata = Metadata(mapOf(assetKey to Json.writeValue(assetValue)))
//
//        register(DEFAULT_ASSET_DEFINITION_ID, AssetType.Store(), metadata).execute(client)
//            .also { d ->
//                withTimeout(txTimeout) { d.await() }
//            }
//
//        Queries.findAssetDefinitionMetadata(DEFAULT_ASSET_DEFINITION_ID, assetKey)
//            .let { query -> client.sendQuery(query) }
//            .also { value ->
//                Assertions.assertEquals(value, assetValue)
//            }
//    }

    @Test
    @WithIroha([DefaultGenesis::class, AliceHasPermissionToRegisterDomain::class])
    @Feature("Domains")
    @Story("Account registers a domain")
    @Permission("no_permission_required")
    @SdkTestId("register_existence_domain")
    fun `double domain registration should fail`(): Unit = runBlocking {
        val domainId = UUID.randomUUID().toString().asDomainId()
        Register.domain(domainId).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        assertThrows<TransactionRejectedException> {
            runBlocking { Register.domain(domainId).execute(client) }
                .also { d ->
                    withTimeout(txTimeout) { d.await() }
                }
        }
    }

    @Test
    @WithIroha([BobCanManageRoles::class, BobHasPermissionToRegisterDomain::class])
    @Feature("Assets")
    @Story("Account registers an asset definition")
    @SdkTestId("register_asset_definition_with_store_value_type")
    @Permission("CanRemoveKeyValueInUserAsset")
    @Story("Account registers a role")
    @SdkTestId("register_role")
    @SdkTestId("attach_permissions_to_role")
    @SdkTestId("grant_role_to_account")
    @Story("Account sets key value pair")
    @Permission("CanSetKeyValueInUserAsset")
    @Feature("Accounts")
    @SdkTestId("set_key_value_in_foreign_asset_after_granting_role")
    fun `register and grant role to account and then revoke it`(): Unit = runBlocking {
        val domainId = "Kingdom".asDomainId()
        val assetDefinitionName = AssetDefinitionId(domainId, "kita".asName())
        listOf(
            Register.domain(domainId),
            Register.assetDefinition(assetDefinitionName, AssetType.Store()),
        ).executeAs(BOB_ACCOUNT_ID, BOB_KEYPAIR, client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        val assetId = AssetId(BOB_ACCOUNT_ID, assetDefinitionName)
        val roleId = RoleId("BOB_ASSET_ACCESS".asName())
        listOf(
            Register.role(BOB_ACCOUNT_ID, roleId),
            Grant.accountRole(roleId, ALICE_ACCOUNT_ID),
            SetKeyValue.asset(assetId, "key".asName(), "value"),
        ).executeAs(BOB_ACCOUNT_ID, BOB_KEYPAIR, client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        QueryBuilder.findAssetById(assetId)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query)!! }
            .also { asset ->
                assertEquals(
                    asset.value.cast<AssetValue.Store>().metadata.sortedMapOfName["key".asName()]!!.readValue(),
                    "value",
                )
            }

        Revoke.accountRole(roleId, ALICE_ACCOUNT_ID)
            .executeAs(BOB_ACCOUNT_ID, BOB_KEYPAIR, client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        QueryBuilder.findRolesByAccountId(ALICE_ACCOUNT_ID)
            .account(BOB_ACCOUNT_ID)
            .buildSigned(BOB_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .also { roles ->
                assertTrue(
                    roles.isEmpty(),
                )
            }
        QueryBuilder.findRoles()
            .account(BOB_ACCOUNT_ID)
            .buildSigned(BOB_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .firstOrNull { it.id == roleId }
            .also { Assertions.assertNotNull(it) }

        Unregister.role(roleId)
            .executeAs(BOB_ACCOUNT_ID, BOB_KEYPAIR, client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        QueryBuilder.findRoles()
            .account(BOB_ACCOUNT_ID)
            .buildSigned(BOB_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .firstOrNull { it.id == roleId }
            .also { Assertions.assertNull(it) }
    }

    @Test
    @WithIroha(
        [
            DefaultGenesis::class,
            AliceHas100XorAndPermissionToMintAndBurn::class,
            StoreAssetWithMetadata::class,
            AliceHasRoleWithAccessToBobsMetadata::class,
            AliceWithTestAssets::class,
            AliceAndBobEachHave100Xor::class,
            XorAndValAssets::class,
            NewAccountWithMetadata::class,
            NewDomainWithMetadata::class,
            RubbishToTestMultipleGenesis::class,
        ],
    )
    @Feature("Configurations")
    @Permission("no_permission_required")
    fun `multiple genesis`(): Unit = runBlocking {
        val assetId = StoreAssetWithMetadata.ASSET_ID
        val assetKey = StoreAssetWithMetadata.ASSET_KEY

        val assetBefore = getAsset(assetId)
        assertEquals(
            StoreAssetWithMetadata.ASSET_VALUE,
            assetBefore.value.cast<AssetValue.Store>().metadata.sortedMapOfName[assetKey]!!.readValue(),
        )
        QueryBuilder.findAccountById(ALICE_ACCOUNT_ID)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query)!! }
            .also { alice ->
                assertEquals(
                    RubbishToTestMultipleGenesis.ALICE_KEY_VALUE,
                    alice.metadata.sortedMapOfName[RubbishToTestMultipleGenesis.ALICE_KEY_VALUE.asName()]!!.readValue(),
                )
            }
        QueryBuilder.findAccountById(BOB_ACCOUNT_ID)
            .account(BOB_ACCOUNT_ID)
            .buildSigned(BOB_KEYPAIR)
            .let { query -> client.sendQuery(query)!! }
            .also { bob ->
                assertEquals(
                    RubbishToTestMultipleGenesis.BOB_KEY_VALUE,
                    bob.metadata.sortedMapOfName[RubbishToTestMultipleGenesis.BOB_KEY_VALUE.asName()]!!.readValue(),
                )
            }
        QueryBuilder.findDomainById(DEFAULT_DOMAIN_ID)
            .account(client.authority)
            .buildSigned(client.keyPair)
            .let { query -> client.sendQuery(query)!! }
            .also { domain ->
                assertEquals(
                    RubbishToTestMultipleGenesis.DOMAIN_KEY_VALUE,
                    domain.metadata.sortedMapOfName[RubbishToTestMultipleGenesis.DOMAIN_KEY_VALUE.asName()]!!.readValue(),
                )
            }
    }

    @Test
    @WithIroha([WithDomainTransferredToBob::class])
    @Feature("Domains")
    @Story("Account transfers domain ownership")
    @SdkTestId("transfer_domain_ownership_in_genesis")
    fun `transfer domain ownership in genesis`(): Unit = runBlocking {
        val key = randomAlphabetic(5).asName()
        val value = randomAlphabetic(5)
        SetKeyValue.domain(WithDomainTransferredToBob.DOMAIN_ID, key, value).executeAs(BOB_ACCOUNT_ID, BOB_KEYPAIR, client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        val extractedValue: String = QueryBuilder.findDomainById(WithDomainTransferredToBob.DOMAIN_ID)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query)!! }
            .metadata.sortedMapOfName[key]!!.readValue()
        assertEquals(value, extractedValue)
    }

    @Test
    @WithIroha([DefaultGenesis::class, AliceHasPermissionToRegisterDomain::class])
    @Feature("Domains")
    @Story("Account transfers domain ownership")
    @SdkTestId("transfer_domain_ownership")
    fun `transfer domain ownership`(): Unit = runBlocking {
        val domainId = "Kingdom".asDomainId()
        Register.domain(domainId).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        assertFailsWith(TransactionRejectedException::class) {
            SetKeyValue.domain(domainId, randomAlphabetic(5).asName(), randomAlphabetic(5)).executeAs(BOB_ACCOUNT_ID, BOB_KEYPAIR, client)
                .also { d ->
                    withTimeout(txTimeout) { d.await() }
                }
        }
        var kingdomDomainOwnedBy = QueryBuilder.findDomainById(domainId)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query)!! }.ownedBy
        assertEquals(ALICE_ACCOUNT_ID, kingdomDomainOwnedBy)

        Transfer.domain(ALICE_ACCOUNT_ID, domainId, BOB_ACCOUNT_ID).execute(client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }
        kingdomDomainOwnedBy = QueryBuilder.findDomainById(domainId)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query)!! }.ownedBy
        assertEquals(BOB_ACCOUNT_ID, kingdomDomainOwnedBy)

        val key = randomAlphabetic(5).asName()
        val value = randomAlphabetic(5)
        SetKeyValue.domain(domainId, key, value).executeAs(BOB_ACCOUNT_ID, BOB_KEYPAIR, client)
            .also { d ->
                withTimeout(txTimeout) { d.await() }
            }

        val extractedValue: String = QueryBuilder.findDomainById(domainId)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query)!! }
            .metadata.sortedMapOfName[key]!!.readValue()
        assertEquals(value, extractedValue)
    }

    @Test
    @Permission("no_permission_required")
    @Feature("Сonfiguration")
    @Story("Initiator starts network with fat genesis")
    @SdkTestId("initiator_start_network_with_fat_genesis")
    @WithIroha([FatGenesis::class])
    fun `fat genesis apply`(): Unit = runBlocking {
        QueryBuilder.findAccounts()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .also { accounts -> assert(accounts.any { it.id == ALICE_ACCOUNT_ID }) }
            .also { accounts -> assert(accounts.any { it.id == BOB_ACCOUNT_ID }) }
    }

    private suspend fun registerAccount(id: AccountId) {
        Register.account(id).execute(client).also { d ->
            withTimeout(txTimeout) { d.await() }
        }
    }

    private suspend fun getAccountAmount(assetId: AssetId = DEFAULT_ASSET_ID) = QueryBuilder
        .findAssetById(assetId)
        .account(client.authority)
        .buildSigned(client.keyPair)
        .let { query ->
            client.sendQuery(query)!!.value
        }.let { value ->
            (value as AssetValue.Numeric).numeric.asLong()
        }

    private suspend fun getAsset(assetId: AssetId? = null) = QueryBuilder
        .findAssetById(assetId ?: DEFAULT_ASSET_ID)
        .account(client.authority)
        .buildSigned(client.keyPair)
        .let { query ->
            client.sendQuery(query)
        }!!

    private fun List<Asset>.get(id: AssetId) = this.find { it.id == id }
}
