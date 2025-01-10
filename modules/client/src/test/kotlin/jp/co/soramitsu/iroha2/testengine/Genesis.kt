package jp.co.soramitsu.iroha2.testengine

import jp.co.soramitsu.iroha2.Genesis
import jp.co.soramitsu.iroha2.Permissions
import jp.co.soramitsu.iroha2.asDomainId
import jp.co.soramitsu.iroha2.asJsonString
import jp.co.soramitsu.iroha2.asName
import jp.co.soramitsu.iroha2.generateKeyPair
import jp.co.soramitsu.iroha2.generatePublicKey
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.AssetType
import jp.co.soramitsu.iroha2.generated.ChainId
import jp.co.soramitsu.iroha2.generated.DomainId
import jp.co.soramitsu.iroha2.generated.InstructionBox
import jp.co.soramitsu.iroha2.generated.Metadata
import jp.co.soramitsu.iroha2.generated.NonZeroOfu64
import jp.co.soramitsu.iroha2.generated.Parameter
import jp.co.soramitsu.iroha2.generated.Permission
import jp.co.soramitsu.iroha2.generated.RawGenesisTransaction
import jp.co.soramitsu.iroha2.generated.Repeats
import jp.co.soramitsu.iroha2.generated.RoleId
import jp.co.soramitsu.iroha2.generated.SmartContractParameter
import jp.co.soramitsu.iroha2.generated.TriggerId
import jp.co.soramitsu.iroha2.numeric
import jp.co.soramitsu.iroha2.toIrohaPublicKey
import jp.co.soramitsu.iroha2.transaction.Instructions
import org.apache.commons.lang3.RandomStringUtils.randomAlphabetic
import org.testcontainers.shaded.org.apache.commons.lang3.RandomStringUtils
import java.math.BigDecimal
import java.math.BigInteger
import kotlin.random.Random.Default.nextDouble

/**
 * Create a default genesis where there is just one domain with only Alice and Bob in it
 */
open class DefaultGenesis(transaction: RawGenesisTransaction? = null) : Genesis(transaction ?: rawGenesisTx())

open class AliceCanUpgradeExecutor : Genesis(
    rawGenesisTx(
        Instructions.grantPermissionToken(
            Permissions.CanUpgradeExecutor,
            destinationId = ALICE_ACCOUNT_ID,
        ),
    ),
)

open class WithDomainTransferredToBob : Genesis(
    rawGenesisTx(
        Instructions.registerDomain(DOMAIN_ID),
        Instructions.transferDomainOwnership(GENESIS_ACCOUNT, DOMAIN_ID, BOB_ACCOUNT_ID),
    ),
) {
    companion object {
        val DOMAIN_ID = randomAlphabetic(10).asDomainId()
    }
}

open class AliceCanUnregisterAnyPeer : Genesis(
    rawGenesisTx(
        Instructions.grantPermissionToken(
            Permissions.CanUnregisterAnyPeer,
            destinationId = ALICE_ACCOUNT_ID,
        ),
    ),
)

open class AliceAndBobHasPermissionToMintPublicKeys : Genesis(
    rawGenesisTx(
        Instructions.grantPermissionToken(
            Permissions.CanMintUserPublicKeys,
            ALICE_ACCOUNT_ID.asJsonString(),
            ALICE_ACCOUNT_ID,
        ),
        Instructions.grantPermissionToken(
            Permissions.CanMintUserPublicKeys,
            BOB_ACCOUNT_ID.asJsonString(),
            BOB_ACCOUNT_ID,
        ),
    ),
)

open class AliceHasPermissionToUnregisterDomain : Genesis(
    rawGenesisTx(
        Instructions.registerDomain(NEW_DOMAIN_ID),
        Instructions.grantPermissionToken(
            Permissions.CanUnregisterDomain,
            NEW_DOMAIN_ID.asJsonString(),
            ALICE_ACCOUNT_ID,
        ),
    ),
) {
    companion object {
        val NEW_DOMAIN_ID = DomainId("NEW_DOMAIN".asName())
    }
}

open class WithManyDomains : Genesis(
    rawGenesisTx(
        *registerDomains(DOMAINS_COUNT),
    ),
) {
    companion object {
        const val DOMAINS_COUNT = 25
    }
}

fun registerDomains(count: Int): Array<InstructionBox> {
    val instructions = mutableListOf<InstructionBox>()
    for (i in 1..count) {
        instructions.add(Instructions.registerDomain(DomainId("NEW_DOMAIN$i".asName())))
    }
    return instructions.toTypedArray()
}

/**
 * Give Alice access to Bob's metadata
 */
open class AliceHasRoleWithAccessToBobsMetadata : Genesis(
    rawGenesisTx(
        Instructions.registerRole(
            ROLE_ID,
            Permission(
                Permissions.CanSetKeyValueInAccount.type,
                BOB_ACCOUNT_ID.asJsonString(true),
            ),
            Permission(
                Permissions.CanRemoveKeyValueInAccount.type,
                BOB_ACCOUNT_ID.asJsonString(true),
            ),
        ),
        Instructions.grantRole(ROLE_ID, ALICE_ACCOUNT_ID),
    ),
) {
    companion object {
        val ROLE_ID = RoleId("USER_METADATA_ACCESS".asName())
    }
}

/**
 * Give Alice 100 XOR and the permission to burn them
 */
open class AliceHas100XorAndPermissionToMintAndBurn : Genesis(
    rawGenesisTx(
        Instructions.registerAssetDefinition(DEFAULT_ASSET_DEFINITION_ID, AssetType.numeric()),
        Instructions.mintAsset(DEFAULT_ASSET_ID, 100),
        Instructions.grantPermissionToken(
            Permissions.CanMintAssetWithDefinition,
            DEFAULT_ASSET_DEFINITION_ID.asJsonString(),
            ALICE_ACCOUNT_ID,
        ),
        Instructions.grantPermissionToken(
            Permissions.CanBurnAssetWithDefinition,
            DEFAULT_ASSET_DEFINITION_ID.asJsonString(),
            ALICE_ACCOUNT_ID,
        ),
        params = listOf(
            Parameter.SmartContract(
                SmartContractParameter.Fuel(NonZeroOfu64(BigInteger.valueOf(5500000000))),
            ),
            Parameter.Executor(
                SmartContractParameter.Fuel(NonZeroOfu64(BigInteger.valueOf(5500000000))),
            ),
        ),
    ),
)

/**
 * Give Alice test assets
 */
open class AliceWithTestAssets : Genesis(
    rawGenesisTx(
        Instructions.registerAssetDefinition(TEST_ASSET_DEFINITION_ID, AssetType.Store()),
        Instructions.registerAssetDefinition(TEST_ASSET_DEFINITION_ID2, AssetType.Store()),
    ),
) {
    companion object {
        val TEST_ASSET_DEFINITION_ID = AssetDefinitionId(DEFAULT_DOMAIN_ID, "test".asName())
        val TEST_ASSET_DEFINITION_ID2 = AssetDefinitionId(DEFAULT_DOMAIN_ID, "test2".asName())
    }
}

/**
 * Register an executable trigger without instructions
 */
open class WithExecutableTrigger : Genesis(
    rawGenesisTx(
        Instructions.registerTrigger(
            TRIGGER_ID,
            listOf(),
            Repeats.Exactly(1L),
            ALICE_ACCOUNT_ID,
            Metadata(mapOf()),
        ),
    ),
) {
    companion object {
        val TRIGGER_ID = TriggerId("some_trigger".asName())
    }
}

/**
 * Mint 100 XOR for Alice and Bob
 */
open class AliceAndBobEachHave100Xor : Genesis(
    rawGenesisTx(
        Instructions.registerAssetDefinition(DEFAULT_ASSET_DEFINITION_ID, AssetType.numeric()),
        Instructions.grantPermissionToken(
            Permissions.CanTransferAssetWithDefinition,
            DEFAULT_ASSET_DEFINITION_ID.asJsonString(),
            ALICE_ACCOUNT_ID,
        ),
        Instructions.grantPermissionToken(
            Permissions.CanTransferAssetWithDefinition,
            DEFAULT_ASSET_DEFINITION_ID.asJsonString(),
            BOB_ACCOUNT_ID,
        ),
        Instructions.mintAsset(DEFAULT_ASSET_ID, 100),
        Instructions.mintAsset(BOB_ASSET_ID, 100),
    ),
) {
    companion object {
        val BOB_ASSET_ID = AssetId(BOB_ACCOUNT_ID, DEFAULT_ASSET_DEFINITION_ID)
    }
}

/**
 * Create a Store asset with metadata
 */
open class StoreAssetWithMetadata : Genesis(
    rawGenesisTx(
        Instructions.registerAssetDefinition(
            DEFINITION_ID,
            AssetType.Store(),
            Metadata(mapOf(ASSET_KEY to ASSET_VALUE)),
        ),
        Instructions.setKeyValue(ASSET_ID, ASSET_KEY, ASSET_VALUE),
    ),
) {
    companion object {
        val ASSET_KEY = "key".asName()
        val ASSET_VALUE: String = RandomStringUtils.randomAlphabetic(50)
        val DEFINITION_ID = AssetDefinitionId(DEFAULT_DOMAIN_ID, "foo".asName())
        val ASSET_ID = AssetId(ALICE_ACCOUNT_ID, DEFINITION_ID)
    }
}

open class AliceCanMintXor : Genesis(
    rawGenesisTx(
        Instructions.grantPermissionToken(
            Permissions.CanMintAssetWithDefinition,
            XOR_DEFINITION_ID.asJsonString(),
            ALICE_ACCOUNT_ID,
        ),
    ),
)

/**
 * Create XOR and VAL assets with one token for each and metadata
 */
open class XorAndValAssets : Genesis(
    rawGenesisTx(
        Instructions.registerAssetDefinition(XOR_DEFINITION_ID, AssetType.numeric()),
        Instructions.mintAsset(AssetId(ALICE_ACCOUNT_ID, XOR_DEFINITION_ID), XOR_QUANTITY),

        Instructions.registerAssetDefinition(VAL_DEFINITION_ID, AssetType.numeric()),
        Instructions.mintAsset(AssetId(ALICE_ACCOUNT_ID, VAL_DEFINITION_ID), VAL_QUANTITY),
    ),
) {
    companion object {
        const val XOR_QUANTITY = 1
        const val VAL_QUANTITY = 1
    }
}

/**
 * Create a new account with metadata
 */
open class NewAccountWithMetadata : Genesis(
    rawGenesisTx(
        Instructions.registerAccount(
            id = ACCOUNT_ID,
            metadata = Metadata(mapOf(KEY to VALUE)),
        ),
    ),
) {
    companion object {
        const val VALUE = "value"

        val KEY = "key".asName()
        val KEYPAIR = generateKeyPair()
        val ACCOUNT_ID = AccountId(DEFAULT_DOMAIN_ID, KEYPAIR.public.toIrohaPublicKey())
    }
}

/**
 * Create a new domain with metadata
 */
open class NewDomainWithMetadata : Genesis(
    rawGenesisTx(
        Instructions.registerDomain(
            domainId = DOMAIN_ID,
            metadata = mapOf(KEY to VALUE),
        ),
        Instructions.transferDomainOwnership(GENESIS_ACCOUNT, DOMAIN_ID, ALICE_ACCOUNT_ID),
    ),
) {
    companion object {
        val KEY = "key".asName()
        val VALUE = "value"
        val DOMAIN_ID = DomainId("foo_domain".asName())
    }
}

/**
 * Create a new domain
 */
open class NewDomain : Genesis(
    rawGenesisTx(
        Instructions.registerDomain(DOMAIN_ID),
    ),
) {
    companion object {
        val DOMAIN_ID = "foo_domain".asDomainId()
    }
}

/**
 * Specific genesis to test multiple genesis case
 */
open class RubbishToTestMultipleGenesis : Genesis(
    rawGenesisTx(
        Instructions.registerDomain(
            DEFAULT_DOMAIN_ID,
            mapOf(DOMAIN_KEY_VALUE.asName() to DOMAIN_KEY_VALUE),
        ),
        Instructions.registerAccount(
            ALICE_ACCOUNT_ID,
            Metadata(mapOf(ALICE_KEY_VALUE.asName() to ALICE_KEY_VALUE)),
        ),
        Instructions.registerAccount(
            BOB_ACCOUNT_ID,
            Metadata(mapOf(BOB_KEY_VALUE.asName() to BOB_KEY_VALUE)),
        ),
    ),
) {
    companion object {
        val DOMAIN_KEY_VALUE: String = RandomStringUtils.randomAlphabetic(10)
        val ALICE_KEY_VALUE: String = RandomStringUtils.randomAlphabetic(10)
        val BOB_KEY_VALUE: String = RandomStringUtils.randomAlphabetic(10)
    }
}

/**
 * To test serializers
 */
open class FatGenesis : Genesis(
    rawGenesisTx(
        Instructions.registerDomain(
            randomAlphabetic(10).asDomainId(),
            mapOf(randomAlphabetic(10).asName() to randomAlphabetic(10)),
        ),
        Instructions.registerAccount(
            AccountId(domain = DEFAULT_DOMAIN_ID, signatory = generatePublicKey()),
            Metadata(mapOf(randomAlphabetic(10).asName() to randomAlphabetic(10))),
        ),
        Instructions.registerAssetDefinition(DEFAULT_ASSET_DEFINITION_ID, AssetType.numeric()),
        Instructions.grantPermissionToken(
            Permissions.CanTransferAssetWithDefinition,
            DEFAULT_ASSET_DEFINITION_ID.asJsonString(),
            ALICE_ACCOUNT_ID,
        ),
        Instructions.grantPermissionToken(
            Permissions.CanTransferAssetWithDefinition,
            DEFAULT_ASSET_DEFINITION_ID.asJsonString(),
            BOB_ACCOUNT_ID,
        ),
        Instructions.registerAssetDefinition(
            DEFINITION_ID,
            AssetType.Store(),
            Metadata(mapOf(randomAlphabetic(10).asName() to randomAlphabetic(10))),
        ),
        Instructions.registerRole(
            ROLE_ID,
            Permission(
                Permissions.CanSetKeyValueInAccount.type,
                BOB_ACCOUNT_ID.asJsonString(true),
            ),
            Permission(
                Permissions.CanRemoveKeyValueInAccount.type,
                BOB_ACCOUNT_ID.asJsonString(true),
            ),
        ),
        Instructions.grantRole(ROLE_ID, ALICE_ACCOUNT_ID),
        Instructions.mintAsset(AssetId(BOB_ACCOUNT_ID, DEFAULT_ASSET_DEFINITION_ID), 100),
        Instructions.burnAsset(AssetId(BOB_ACCOUNT_ID, DEFAULT_ASSET_DEFINITION_ID), 100),
        Instructions.setKeyValue(ASSET_ID, randomAlphabetic(10).asName(), Int.MAX_VALUE.toString()),
        Instructions.setKeyValue(ASSET_ID, randomAlphabetic(10).asName(), (Int.MAX_VALUE * 10L).toString()),
        Instructions.setKeyValue(ASSET_ID, randomAlphabetic(10).asName(), nextDouble().toString()),
        Instructions.setKeyValue(
            ASSET_ID,
            randomAlphabetic(10).asName(),
            BigDecimal(nextDouble()).toString(),
        ),
        Instructions.setKeyValue(
            ASSET_ID,
            randomAlphabetic(10).asName(),
            (BigInteger.valueOf(Long.MAX_VALUE) * BigInteger.valueOf(2)).toString(),
        ),
        Instructions.setKeyValue(ASSET_ID, randomAlphabetic(10).asName(), randomAlphabetic(10)),
        Instructions.setKeyValue(
            DEFAULT_DOMAIN_ID,
            randomAlphabetic(10).asName(),
            randomAlphabetic(10),
        ),
    ),
) {
    companion object {
        val DEFINITION_ID = AssetDefinitionId(DEFAULT_DOMAIN_ID, "foo".asName())
        val ASSET_ID = AssetId(BOB_ACCOUNT_ID, DEFINITION_ID)
        val ROLE_ID = RoleId("USER_METADATA_ACCESS".asName())
    }
}

/**
 * Grant permission token to unregister any role
 */
open class BobCanUnregisterAnyRole : Genesis(
    rawGenesisTx(
        Instructions.grantPermissionToken(
            permission = Permissions.CanUnregisterAnyRole,
            destinationId = BOB_ACCOUNT_ID,
        ),
        transferTo = BOB_ACCOUNT_ID,
    ),
)

/**
 * Return [RawGenesisTransaction] with instructions to init genesis
 */
fun rawGenesisTx(
    vararg isi: InstructionBox,
    params: List<Parameter> = emptyList(),
    transferTo: AccountId = ALICE_ACCOUNT_ID,
) = RawGenesisTransaction(
    chain = ChainId("00000000-0000-0000-0000-000000000000"),
    executor = Genesis.EXECUTOR_FILE_NAME,
    parameters = params,
    instructions = listOf(
        Instructions.registerDomain(DEFAULT_DOMAIN_ID),
        Instructions.registerAccount(ALICE_ACCOUNT_ID, Metadata(emptyMap())),
        Instructions.registerAccount(BOB_ACCOUNT_ID, Metadata(emptyMap())),
        Instructions.transferDomainOwnership(GENESIS_ACCOUNT, DEFAULT_DOMAIN_ID, transferTo),
        *isi,
    ),
    topology = emptyList(),
)
