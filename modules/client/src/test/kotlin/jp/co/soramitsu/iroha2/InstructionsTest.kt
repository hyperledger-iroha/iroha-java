package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.engine.ALICE_ACCOUNT_ID
import jp.co.soramitsu.iroha2.engine.ALICE_KEYPAIR
import jp.co.soramitsu.iroha2.engine.AliceHas100XorAndPermissionToBurn
import jp.co.soramitsu.iroha2.engine.DEFAULT_ASSET_DEFINITION_ID
import jp.co.soramitsu.iroha2.engine.DEFAULT_ASSET_ID
import jp.co.soramitsu.iroha2.engine.DEFAULT_DOMAIN_NAME
import jp.co.soramitsu.iroha2.engine.DefaultGenesis
import jp.co.soramitsu.iroha2.engine.IrohaRunnerExtension
import jp.co.soramitsu.iroha2.engine.WithIroha
import jp.co.soramitsu.iroha2.generated.datamodel.Value
import jp.co.soramitsu.iroha2.generated.datamodel.asset.AssetValue
import jp.co.soramitsu.iroha2.generated.datamodel.asset.AssetValueType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import java.util.concurrent.TimeUnit
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.fail
import jp.co.soramitsu.iroha2.generated.datamodel.account.Id as AccountId

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(IrohaRunnerExtension::class)
@Timeout(20)
class InstructionsTest {

    lateinit var client: Iroha2Client

    @Test
    @WithIroha(DefaultGenesis::class)
    fun `register account instruction committed`() {
        val newAccountId = AccountId("foo", DEFAULT_DOMAIN_NAME)
        Assertions.assertDoesNotThrow {
            client.sendTransaction {
                accountId = ALICE_ACCOUNT_ID
                registerAccount(newAccountId, mutableListOf())
                buildSigned(ALICE_KEYPAIR)
            }.get(10, TimeUnit.SECONDS)
        }
        client.sendQuery(AccountExtractor) {
            accountId = ALICE_ACCOUNT_ID
            findAccountById(newAccountId)
            buildSigned(ALICE_KEYPAIR)
        }
    }

    @Test
    @WithIroha(DefaultGenesis::class)
    fun `register asset instruction committed`() {
        Assertions.assertDoesNotThrow {
            client.sendTransaction {
                accountId = ALICE_ACCOUNT_ID
                registerAsset(DEFAULT_ASSET_DEFINITION_ID, AssetValueType.Quantity())
                buildSigned(ALICE_KEYPAIR)
            }.get(10, TimeUnit.SECONDS)
        }
        val assetDefinitions = client.sendQuery(AssetDefinitionsExtractor) {
            accountId = ALICE_ACCOUNT_ID
            findAllAssetsDefinitions(DEFAULT_ASSET_DEFINITION_ID)
            buildSigned(ALICE_KEYPAIR)
        }
        assertFalse { assetDefinitions.isEmpty() }
        assetDefinitions.find { it.id == DEFAULT_ASSET_DEFINITION_ID }
            ?: fail("Expected query response contains assetDefinition $DEFAULT_ASSET_DEFINITION_ID, but it is not. Response was $assetDefinitions")
    }

    @Test
    @WithIroha(DefaultGenesis::class)
    fun `store asset instruction committed`() {
        val pair1 = "key1" to "bar".asValue()
        val pair2 = "key2" to true.asValue()
        val pair3 = "key3" to 12345.asValue()

        Assertions.assertDoesNotThrow {
            client.sendTransaction {
                account(ALICE_ACCOUNT_ID)
                registerAsset(DEFAULT_ASSET_DEFINITION_ID, AssetValueType.Store())
                storeAsset(DEFAULT_ASSET_ID, pair1.first, pair1.second)
                storeAsset(DEFAULT_ASSET_ID, pair2.first, pair2.second)
                storeAsset(DEFAULT_ASSET_ID, pair3.first, pair3.second)
                buildSigned(ALICE_KEYPAIR)
            }.get(10, TimeUnit.SECONDS)
        }

        val asset = client.sendQuery(AssetExtractor) {
            accountId = ALICE_ACCOUNT_ID
            findAssetById(DEFAULT_ASSET_ID)
            buildSigned(ALICE_KEYPAIR)
        }

        assertEquals(DEFAULT_ASSET_ID.definitionId.name, asset.id.definitionId.name)
        assertEquals(DEFAULT_ASSET_ID.definitionId.domainName, asset.id.definitionId.domainName)
        when (val value = asset.value) {
            is AssetValue.Store -> {
                assertEquals(pair1.second.string, value.metadata.map[pair1.first]?.cast<Value.String>()?.string)
                assertEquals(pair2.second.bool, value.metadata.map[pair2.first]?.cast<Value.Bool>()?.bool)
                assertEquals(pair3.second.u32, (value.metadata.map[pair3.first]?.cast<Value.U32>())?.u32)
            }
            else -> fail("Expected result asset value has type `AssetValue.Store`, but it was `${asset.value::class.simpleName}`")
        }

        // try to find saved assets by domain name
        val assetsByDomainName = client.sendQuery(AssetsExtractor) {
            accountId = ALICE_ACCOUNT_ID
            findAssetsByDomainName(DEFAULT_DOMAIN_NAME)
            buildSigned(ALICE_KEYPAIR)
        }
        assertEquals(asset, assetsByDomainName.first())
    }

    @Test
    @WithIroha(DefaultGenesis::class)
    fun `grant access to asset key-value committed`() {
        val aliceAssetId = DEFAULT_ASSET_ID
        val bobAccountId = AccountId("bob", DEFAULT_DOMAIN_NAME)
        val bobKeypair = generateKeyPair()

        // transaction from behalf of Alice. Alice gives permission to Bob to set key-value Asset.Store in her account
        Assertions.assertDoesNotThrow {
            client.sendTransaction {
                account(ALICE_ACCOUNT_ID)
                // register asset with type store
                registerAsset(aliceAssetId.definitionId, AssetValueType.Store())
                // register Bob's account
                registerAccount(bobAccountId, mutableListOf(bobKeypair.public.toIrohaPublicKey()))
                // grant by Alice to Bob permissions to set key value in Asset.Store
                grantSetKeyValueAsset(aliceAssetId, bobAccountId)
                buildSigned(ALICE_KEYPAIR)
            }.get(10, TimeUnit.SECONDS)
        }

        // transaction from behalf of Bob. He tries to set key-value Asset.Store to the Alice account
        Assertions.assertDoesNotThrow {
            client.sendTransaction {
                account(bobAccountId)
                storeAsset(aliceAssetId, "foo", "bar".asValue())
                buildSigned(bobKeypair)
            }.get(10, TimeUnit.SECONDS)
        }

        val asset = client.sendQuery(AssetExtractor) {
            accountId = ALICE_ACCOUNT_ID
            findAssetById(aliceAssetId)
            buildSigned(ALICE_KEYPAIR)
        }

        assertEquals(aliceAssetId.definitionId.name, asset.id.definitionId.name)
        assertEquals(aliceAssetId.definitionId.domainName, asset.id.definitionId.domainName)
        when (val value = asset.value) {
            is AssetValue.Store -> {
                assertEquals("bar", (value.metadata.map["foo"]?.cast<Value.String>())?.string)
            }
            else -> fail("Expected result asset value has type `AssetValue.Store`, but it was `${asset.value::class.simpleName}`")
        }
    }

    @Test
    @WithIroha(DefaultGenesis::class)
    fun `mint asset instruction committed`() {
        // currently Iroha2 does not support registering an asset and minting the asset in the same transaction,
        // so below 2 separate transaction created
        Assertions.assertDoesNotThrow {
            client.sendTransaction {
                account(ALICE_ACCOUNT_ID)
                registerAsset(DEFAULT_ASSET_DEFINITION_ID, AssetValueType.Quantity())
                buildSigned(ALICE_KEYPAIR)
            }.get(10, TimeUnit.SECONDS)
        }

        Assertions.assertDoesNotThrow {
            client.sendTransaction {
                account(ALICE_ACCOUNT_ID)
                mintAsset(DEFAULT_ASSET_ID, 5U)
                buildSigned(ALICE_KEYPAIR)
            }.get(10, TimeUnit.SECONDS)
        }

        val result = client.sendQuery(AccountExtractor) {
            accountId = ALICE_ACCOUNT_ID
            findAccountById(ALICE_ACCOUNT_ID)
            buildSigned(ALICE_KEYPAIR)
        }
        assertEquals(5U, (result.assets[DEFAULT_ASSET_ID] ?.value as? AssetValue.Quantity)?.u32)
    }

    @Test
    @WithIroha(AliceHas100XorAndPermissionToBurn::class)
    fun `burn asset instruction committed`() {
        // check balance before burn
        var result = client.sendQuery(AccountExtractor) {
            accountId = ALICE_ACCOUNT_ID
            findAccountById(ALICE_ACCOUNT_ID)
            buildSigned(ALICE_KEYPAIR)
        }
        assertEquals(100U, (result.assets[DEFAULT_ASSET_ID] ?.value as? AssetValue.Quantity)?.u32)

        Assertions.assertDoesNotThrow {
            client.sendTransaction {
                account(ALICE_ACCOUNT_ID)
                burnAsset(DEFAULT_ASSET_ID, 50U)
                buildSigned(ALICE_KEYPAIR)
            }.get(10, TimeUnit.SECONDS)
        }

        // check balance after burn
        result = client.sendQuery(AccountExtractor) {
            accountId = ALICE_ACCOUNT_ID
            findAccountById(ALICE_ACCOUNT_ID)
            buildSigned(ALICE_KEYPAIR)
        }
        assertEquals(50U, (result.assets[DEFAULT_ASSET_ID] ?.value as? AssetValue.Quantity)?.u32)
    }

    @Test
    @WithIroha(DefaultGenesis::class)
    fun `burn public key instruction committed`() {
        val alicePubKey = ALICE_KEYPAIR.public.toIrohaPublicKey()
        // check public key before burn it
        val signatories = client.sendQuery(AccountExtractor) {
            accountId = ALICE_ACCOUNT_ID
            findAccountById(ALICE_ACCOUNT_ID)
            buildSigned(ALICE_KEYPAIR)
        }.signatories
        assertEquals(1, signatories.size)
        assertContentEquals(alicePubKey.payload, signatories.first().payload)

        Assertions.assertDoesNotThrow {
            client.sendTransaction {
                account(ALICE_ACCOUNT_ID)
                burnPublicKey(ALICE_ACCOUNT_ID, alicePubKey)
                buildSigned(ALICE_KEYPAIR)
            }.get(10, TimeUnit.SECONDS)
        }

        // if keys was burned, then peer should return an error due cannot verify signature
        assertFails {
            client.sendQuery(AccountExtractor) {
                accountId = ALICE_ACCOUNT_ID
                findAccountById(ALICE_ACCOUNT_ID)
                buildSigned(ALICE_KEYPAIR)
            }
        }
    }
}
