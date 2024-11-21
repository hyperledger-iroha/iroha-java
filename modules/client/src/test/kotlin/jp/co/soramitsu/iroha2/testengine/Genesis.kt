package jp.co.soramitsu.iroha2.testengine

import jp.co.soramitsu.iroha2.*
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.AssetType
import jp.co.soramitsu.iroha2.generated.BlockParameters
import jp.co.soramitsu.iroha2.generated.CanBurnAssetWithDefinition
import jp.co.soramitsu.iroha2.generated.CanManagePeers
import jp.co.soramitsu.iroha2.generated.CanManageRoles
import jp.co.soramitsu.iroha2.generated.CanMintAssetWithDefinition
import jp.co.soramitsu.iroha2.generated.CanModifyAccountMetadata
import jp.co.soramitsu.iroha2.generated.CanRegisterDomain
import jp.co.soramitsu.iroha2.generated.CanTransferAssetWithDefinition
import jp.co.soramitsu.iroha2.generated.CanUnregisterDomain
import jp.co.soramitsu.iroha2.generated.CanUpgradeExecutor
import jp.co.soramitsu.iroha2.generated.ChainId
import jp.co.soramitsu.iroha2.generated.DomainId
import jp.co.soramitsu.iroha2.generated.InstructionBox
import jp.co.soramitsu.iroha2.generated.Json
import jp.co.soramitsu.iroha2.generated.Metadata
import jp.co.soramitsu.iroha2.generated.Name
import jp.co.soramitsu.iroha2.generated.NonZeroOfu64
import jp.co.soramitsu.iroha2.generated.Parameters
import jp.co.soramitsu.iroha2.generated.RawGenesisTransaction
import jp.co.soramitsu.iroha2.generated.Repeats
import jp.co.soramitsu.iroha2.generated.RoleId
import jp.co.soramitsu.iroha2.generated.SmartContractParameters
import jp.co.soramitsu.iroha2.generated.SumeragiParameters
import jp.co.soramitsu.iroha2.generated.TransactionParameters
import jp.co.soramitsu.iroha2.generated.TriggerId
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

open class BobCanManageRoles :
    Genesis(
        rawGenesisTx(
            Instructions.grant(
                CanManageRoles(),
                BOB_ACCOUNT_ID,
            ),
        ),
    )

open class BobHasPermissionToRegisterDomain :
    Genesis(
        rawGenesisTx(
            Instructions.grant(
                CanRegisterDomain(),
                BOB_ACCOUNT_ID,
            ),
        ),
    )

open class AliceHasPermissionToRegisterDomain :
    Genesis(
        rawGenesisTx(
            Instructions.grant(
                CanRegisterDomain(),
                ALICE_ACCOUNT_ID,
            ),
        ),
    )

open class AliceCanUpgradeExecutor :
    Genesis(
        rawGenesisTx(
            Instructions.grant(
                CanUpgradeExecutor(),
                ALICE_ACCOUNT_ID,
            ),
        ),
    )

open class WithDomainTransferredToBob :
    Genesis(
        rawGenesisTx(
            Instructions.register(DOMAIN_ID),
            Instructions.transfer(GENESIS_ACCOUNT, DOMAIN_ID, BOB_ACCOUNT_ID),
        ),
    ) {
    companion object {
        val DOMAIN_ID = randomAlphabetic(10).asDomainId()
    }
}

open class AliceCanManagePeers :
    Genesis(
        rawGenesisTx(
            Instructions.grant(
                CanManagePeers(),
                ALICE_ACCOUNT_ID,
            ),
        ),
    )

open class AliceHasPermissionToUnregisterDomain :
    Genesis(
        rawGenesisTx(
            Instructions.register(NEW_DOMAIN_ID),
            Instructions.grant(
                CanUnregisterDomain(NEW_DOMAIN_ID),
                ALICE_ACCOUNT_ID,
            ),
        ),
    ) {
    companion object {
        val NEW_DOMAIN_ID = DomainId("NEW_DOMAIN".asName())
    }
}

open class WithManyDomains :
    Genesis(
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
        instructions.add(Instructions.register(DomainId("NEW_DOMAIN$i".asName())))
    }
    return instructions.toTypedArray()
}

/**
 * Give Alice access to Bob's metadata
 */
open class AliceHasRoleWithAccessToBobsMetadata :
    Genesis(
        rawGenesisTx(
            Instructions.register(
                ALICE_ACCOUNT_ID,
                ROLE_ID,
                CanModifyAccountMetadata(BOB_ACCOUNT_ID),
            ),
        ),
    ) {
    companion object {
        val ROLE_ID = RoleId("USER_METADATA_ACCESS".asName())
    }
}

/**
 * Give Alice 100 XOR and the permission to burn them
 */
open class AliceHas100XorAndPermissionToMintAndBurn :
    Genesis(
        rawGenesisTx(
            Instructions.register(DEFAULT_ASSET_DEFINITION_ID, AssetType.numeric()),
            Instructions.mint(DEFAULT_ASSET_ID, 100),
            Instructions.grant(
                CanMintAssetWithDefinition(DEFAULT_ASSET_DEFINITION_ID),
                ALICE_ACCOUNT_ID,
            ),
            Instructions.grant(
                CanBurnAssetWithDefinition(DEFAULT_ASSET_DEFINITION_ID),
                ALICE_ACCOUNT_ID,
            ),
            params = Parameters(
                sumeragi = SumeragiParameters(
                    blockTimeMs = BigInteger.valueOf(2000),
                    commitTimeMs = BigInteger.valueOf(4000),
                    maxClockDriftMs = BigInteger.valueOf(1000),
                ),
                block = BlockParameters(
                    maxTransactions = NonZeroOfu64(BigInteger.valueOf(4096)),
                ),
                smartContract = SmartContractParameters(
                    fuel = NonZeroOfu64(BigInteger.valueOf(5500000000)),
                    memory = NonZeroOfu64(BigInteger.valueOf(55000000)),
                ),
                executor = SmartContractParameters(
                    fuel = NonZeroOfu64(BigInteger.valueOf(5500000000)),
                    memory = NonZeroOfu64(BigInteger.valueOf(55000000)),
                ),
                transaction = TransactionParameters(
                    maxInstructions = NonZeroOfu64(BigInteger.valueOf(4096)),
                    smartContractSize = NonZeroOfu64(BigInteger.valueOf(4194304)),
                ),
                custom = emptyMap(),
            ),
        ),
    )

/**
 * Give Alice test assets
 */
open class AliceWithTestAssets :
    Genesis(
        rawGenesisTx(
            Instructions.register(TEST_ASSET_DEFINITION_ID, AssetType.Store()),
            Instructions.register(TEST_ASSET_DEFINITION_ID2, AssetType.Store()),
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
open class WithExecutableTrigger :
    Genesis(
        rawGenesisTx(
            Instructions.register(
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
open class AliceAndBobEachHave100Xor :
    Genesis(
        rawGenesisTx(
            Instructions.register(DEFAULT_ASSET_DEFINITION_ID, AssetType.numeric()),
            Instructions.grant(
                CanTransferAssetWithDefinition(DEFAULT_ASSET_DEFINITION_ID),
                ALICE_ACCOUNT_ID,
            ),
            Instructions.grant(
                CanTransferAssetWithDefinition(DEFAULT_ASSET_DEFINITION_ID),
                BOB_ACCOUNT_ID,
            ),
            Instructions.mint(DEFAULT_ASSET_ID, 100),
            Instructions.mint(BOB_ASSET_ID, 100),
        ),
    ) {
    companion object {
        val BOB_ASSET_ID = AssetId(BOB_ACCOUNT_ID, DEFAULT_ASSET_DEFINITION_ID)
    }
}

/**
 * Create a Store asset with metadata
 */
open class StoreAssetWithMetadata :
    Genesis(
        rawGenesisTx(
            Instructions.register(
                DEFINITION_ID,
                AssetType.Store(),
                Metadata(mapOf(ASSET_KEY to Json.writeValue(ASSET_VALUE))),
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

open class AliceCanMintXor :
    Genesis(
        rawGenesisTx(
            Instructions.grant(
                CanMintAssetWithDefinition(XOR_DEFINITION_ID),
                ALICE_ACCOUNT_ID,
            ),
        ),
    )

/**
 * Create XOR and VAL assets with one token for each and metadata
 */
open class XorAndValAssets :
    Genesis(
        rawGenesisTx(
            Instructions.register(XOR_DEFINITION_ID, AssetType.numeric()),
            Instructions.mint(AssetId(ALICE_ACCOUNT_ID, XOR_DEFINITION_ID), XOR_QUANTITY),

            Instructions.register(VAL_DEFINITION_ID, AssetType.numeric()),
            Instructions.mint(AssetId(ALICE_ACCOUNT_ID, VAL_DEFINITION_ID), VAL_QUANTITY),
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
open class NewAccountWithMetadata :
    Genesis(
        rawGenesisTx(
            Instructions.register(
                id = ACCOUNT_ID,
                metadata = Metadata(mapOf(KEY to Json.writeValue(VALUE))),
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
open class NewDomainWithMetadata :
    Genesis(
        rawGenesisTx(
            Instructions.register(
                domainId = DOMAIN_ID,
                metadata = mapOf(KEY to Json.writeValue(VALUE)),
            ),
            Instructions.transfer(GENESIS_ACCOUNT, DOMAIN_ID, ALICE_ACCOUNT_ID),
        ),
    ) {
    companion object {
        val KEY: Name = "key".asName()
        val VALUE: String = "value"
        val DOMAIN_ID: DomainId = DomainId("foo_domain".asName())
    }
}

/**
 * Create a new domain
 */
open class NewDomain : Genesis(rawGenesisTx(Instructions.register(DOMAIN_ID))) {
    companion object {
        val DOMAIN_ID = "foo_domain".asDomainId()
    }
}

/**
 * Specific genesis to test multiple genesis case
 */
open class RubbishToTestMultipleGenesis :
    Genesis(
        rawGenesisTx(
            Instructions.register(
                DEFAULT_DOMAIN_ID,
                mapOf(DOMAIN_KEY_VALUE.asName() to Json.writeValue(DOMAIN_KEY_VALUE)),
            ),
            Instructions.register(
                ALICE_ACCOUNT_ID,
                Metadata(mapOf(ALICE_KEY_VALUE.asName() to Json.writeValue(ALICE_KEY_VALUE))),
            ),
            Instructions.register(
                BOB_ACCOUNT_ID,
                Metadata(mapOf(BOB_KEY_VALUE.asName() to Json.writeValue(BOB_KEY_VALUE))),
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
open class FatGenesis :
    Genesis(
        rawGenesisTx(
            Instructions.register(
                randomAlphabetic(10).asDomainId(),
                mapOf(randomAlphabetic(10).asName() to Json.writeValue(randomAlphabetic(10))),
            ),
            Instructions.register(
                AccountId(domain = DEFAULT_DOMAIN_ID, signatory = generatePublicKey()),
                Metadata(mapOf(randomAlphabetic(10).asName() to Json.writeValue(randomAlphabetic(10)))),
            ),
            Instructions.register(DEFAULT_ASSET_DEFINITION_ID, AssetType.numeric()),
            Instructions.grant(
                CanTransferAssetWithDefinition(DEFAULT_ASSET_DEFINITION_ID),
                ALICE_ACCOUNT_ID,
            ),
            Instructions.grant(
                CanTransferAssetWithDefinition(DEFAULT_ASSET_DEFINITION_ID),
                BOB_ACCOUNT_ID,
            ),
            Instructions.register(
                DEFINITION_ID,
                AssetType.Store(),
                Metadata(mapOf(randomAlphabetic(10).asName() to Json.writeValue(randomAlphabetic(10)))),
            ),
            Instructions.register(
                BOB_ACCOUNT_ID,
                ROLE_ID,
                CanModifyAccountMetadata(BOB_ACCOUNT_ID),
            ),
            Instructions.grant(ROLE_ID, ALICE_ACCOUNT_ID),
            Instructions.mint(AssetId(BOB_ACCOUNT_ID, DEFAULT_ASSET_DEFINITION_ID), 100),
            Instructions.burn(AssetId(BOB_ACCOUNT_ID, DEFAULT_ASSET_DEFINITION_ID), 100),
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
 * Return [RawGenesisTransaction] with instructions to init genesis
 */
fun rawGenesisTx(
    vararg isi: InstructionBox,
    params: Parameters? = null,
    transferTo: AccountId = ALICE_ACCOUNT_ID,
) = RawGenesisTransaction(
    chain = ChainId("00000000-0000-0000-0000-000000000000"),
    executor = Genesis.EXECUTOR_FILE_NAME,
    parameters = params ?: DEFAULT_GENESIS_PARAMETERS,
    instructions = listOf(
        Instructions.register(DEFAULT_DOMAIN_ID),
        Instructions.register(ALICE_ACCOUNT_ID, Metadata(emptyMap())),
        Instructions.register(BOB_ACCOUNT_ID, Metadata(emptyMap())),
        Instructions.transfer(GENESIS_ACCOUNT, DEFAULT_DOMAIN_ID, transferTo),
        *isi,
    ),
    wasmDir = "libs",
    wasmTriggers = emptyList(),
    topology = emptyList(),
)
