//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.ModelEnum
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Int
import kotlin.Unit

/**
 * QueryBox
 *
 * Generated from 'QueryBox' enum
 */
public sealed class QueryBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'FindDomains' variant
     */
    public data class FindDomains(
        public val queryWithFilterOfFindDomainsAndDomainPredicateBox: QueryWithFilterOfFindDomainsAndDomainPredicateBox,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindDomains>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindDomains> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindDomains = try {
                FindDomains(
                    QueryWithFilterOfFindDomainsAndDomainPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindDomains): Unit = try {
                QueryWithFilterOfFindDomainsAndDomainPredicateBox.write(
                    writer,
                    instance.queryWithFilterOfFindDomainsAndDomainPredicateBox,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAccounts' variant
     */
    public data class FindAccounts(
        public val queryWithFilterOfFindAccountsAndAccountPredicateBox: QueryWithFilterOfFindAccountsAndAccountPredicateBox,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccounts>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccounts> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAccounts = try {
                FindAccounts(
                    QueryWithFilterOfFindAccountsAndAccountPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAccounts): Unit = try {
                QueryWithFilterOfFindAccountsAndAccountPredicateBox.write(
                    writer,
                    instance.queryWithFilterOfFindAccountsAndAccountPredicateBox,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAssets' variant
     */
    public data class FindAssets(
        public val queryWithFilterOfFindAssetsAndAssetPredicateBox: QueryWithFilterOfFindAssetsAndAssetPredicateBox,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssets>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssets> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAssets = try {
                FindAssets(
                    QueryWithFilterOfFindAssetsAndAssetPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAssets): Unit = try {
                QueryWithFilterOfFindAssetsAndAssetPredicateBox.write(
                    writer,
                    instance.queryWithFilterOfFindAssetsAndAssetPredicateBox,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAssetsDefinitions' variant
     */
    public data class FindAssetsDefinitions(
        public val queryWithFilterOfFindAssetsDefinitionsAndAssetDefinitionPredicateBox:
        QueryWithFilterOfFindAssetsDefinitionsAndAssetDefinitionPredicateBox,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsDefinitions>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsDefinitions> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsDefinitions = try {
                FindAssetsDefinitions(
                    QueryWithFilterOfFindAssetsDefinitionsAndAssetDefinitionPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsDefinitions): Unit =
                try {
                    QueryWithFilterOfFindAssetsDefinitionsAndAssetDefinitionPredicateBox.write(
                        writer,
                        instance.queryWithFilterOfFindAssetsDefinitionsAndAssetDefinitionPredicateBox,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindRoles' variant
     */
    public data class FindRoles(public val queryWithFilterOfFindRolesAndRolePredicateBox: QueryWithFilterOfFindRolesAndRolePredicateBox) :
        QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindRoles>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindRoles> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindRoles = try {
                FindRoles(
                    QueryWithFilterOfFindRolesAndRolePredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindRoles): Unit = try {
                QueryWithFilterOfFindRolesAndRolePredicateBox.write(
                    writer,
                    instance.queryWithFilterOfFindRolesAndRolePredicateBox,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindRoleIds' variant
     */
    public data class FindRoleIds(
        public val queryWithFilterOfFindRoleIdsAndRoleIdPredicateBox: QueryWithFilterOfFindRoleIdsAndRoleIdPredicateBox,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindRoleIds>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindRoleIds> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindRoleIds = try {
                FindRoleIds(
                    QueryWithFilterOfFindRoleIdsAndRoleIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindRoleIds): Unit = try {
                QueryWithFilterOfFindRoleIdsAndRoleIdPredicateBox.write(
                    writer,
                    instance.queryWithFilterOfFindRoleIdsAndRoleIdPredicateBox,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindPermissionsByAccountId' variant
     */
    public data class FindPermissionsByAccountId(
        public val queryWithFilterOfFindPermissionsByAccountIdAndPermissionPredicateBox:
        QueryWithFilterOfFindPermissionsByAccountIdAndPermissionPredicateBox,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindPermissionsByAccountId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindPermissionsByAccountId> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindPermissionsByAccountId = try {
                FindPermissionsByAccountId(
                    QueryWithFilterOfFindPermissionsByAccountIdAndPermissionPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindPermissionsByAccountId,
            ): Unit = try {
                QueryWithFilterOfFindPermissionsByAccountIdAndPermissionPredicateBox.write(
                    writer,
                    instance.queryWithFilterOfFindPermissionsByAccountIdAndPermissionPredicateBox,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindRolesByAccountId' variant
     */
    public data class FindRolesByAccountId(
        public val queryWithFilterOfFindRolesByAccountIdAndRoleIdPredicateBox: QueryWithFilterOfFindRolesByAccountIdAndRoleIdPredicateBox,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindRolesByAccountId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindRolesByAccountId> {
            public const val DISCRIMINANT: Int = 7

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindRolesByAccountId = try {
                FindRolesByAccountId(
                    QueryWithFilterOfFindRolesByAccountIdAndRoleIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindRolesByAccountId): Unit =
                try {
                    QueryWithFilterOfFindRolesByAccountIdAndRoleIdPredicateBox.write(
                        writer,
                        instance.queryWithFilterOfFindRolesByAccountIdAndRoleIdPredicateBox,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindAccountsWithAsset' variant
     */
    public data class FindAccountsWithAsset(
        public val queryWithFilterOfFindAccountsWithAssetAndAccountPredicateBox:
        QueryWithFilterOfFindAccountsWithAssetAndAccountPredicateBox,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsWithAsset>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsWithAsset> {
            public const val DISCRIMINANT: Int = 8

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsWithAsset = try {
                FindAccountsWithAsset(
                    QueryWithFilterOfFindAccountsWithAssetAndAccountPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsWithAsset): Unit =
                try {
                    QueryWithFilterOfFindAccountsWithAssetAndAccountPredicateBox.write(
                        writer,
                        instance.queryWithFilterOfFindAccountsWithAssetAndAccountPredicateBox,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindPeers' variant
     */
    public data class FindPeers(public val queryWithFilterOfFindPeersAndPeerPredicateBox: QueryWithFilterOfFindPeersAndPeerPredicateBox) :
        QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindPeers>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindPeers> {
            public const val DISCRIMINANT: Int = 9

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindPeers = try {
                FindPeers(
                    QueryWithFilterOfFindPeersAndPeerPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindPeers): Unit = try {
                QueryWithFilterOfFindPeersAndPeerPredicateBox.write(
                    writer,
                    instance.queryWithFilterOfFindPeersAndPeerPredicateBox,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindActiveTriggerIds' variant
     */
    public data class FindActiveTriggerIds(
        public val queryWithFilterOfFindActiveTriggerIdsAndTriggerIdPredicateBox:
        QueryWithFilterOfFindActiveTriggerIdsAndTriggerIdPredicateBox,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindActiveTriggerIds>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindActiveTriggerIds> {
            public const val DISCRIMINANT: Int = 10

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindActiveTriggerIds = try {
                FindActiveTriggerIds(
                    QueryWithFilterOfFindActiveTriggerIdsAndTriggerIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindActiveTriggerIds): Unit =
                try {
                    QueryWithFilterOfFindActiveTriggerIdsAndTriggerIdPredicateBox.write(
                        writer,
                        instance.queryWithFilterOfFindActiveTriggerIdsAndTriggerIdPredicateBox,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindTriggers' variant
     */
    public data class FindTriggers(
        public val queryWithFilterOfFindTriggersAndTriggerPredicateBox: QueryWithFilterOfFindTriggersAndTriggerPredicateBox,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggers>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggers> {
            public const val DISCRIMINANT: Int = 11

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggers = try {
                FindTriggers(
                    QueryWithFilterOfFindTriggersAndTriggerPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggers): Unit = try {
                QueryWithFilterOfFindTriggersAndTriggerPredicateBox.write(
                    writer,
                    instance.queryWithFilterOfFindTriggersAndTriggerPredicateBox,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindTransactions' variant
     */
    public data class FindTransactions(
        public val queryWithFilterOfFindTransactionsAndCommittedTransactionPredicateBox:
        QueryWithFilterOfFindTransactionsAndCommittedTransactionPredicateBox,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactions>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactions> {
            public const val DISCRIMINANT: Int = 12

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactions = try {
                FindTransactions(
                    QueryWithFilterOfFindTransactionsAndCommittedTransactionPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactions): Unit = try {
                QueryWithFilterOfFindTransactionsAndCommittedTransactionPredicateBox.write(
                    writer,
                    instance.queryWithFilterOfFindTransactionsAndCommittedTransactionPredicateBox,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindBlocks' variant
     */
    public data class FindBlocks(
        public val queryWithFilterOfFindBlocksAndSignedBlockPredicateBox: QueryWithFilterOfFindBlocksAndSignedBlockPredicateBox,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindBlocks>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindBlocks> {
            public const val DISCRIMINANT: Int = 13

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindBlocks = try {
                FindBlocks(
                    QueryWithFilterOfFindBlocksAndSignedBlockPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindBlocks): Unit = try {
                QueryWithFilterOfFindBlocksAndSignedBlockPredicateBox.write(
                    writer,
                    instance.queryWithFilterOfFindBlocksAndSignedBlockPredicateBox,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindBlockHeaders' variant
     */
    public data class FindBlockHeaders(
        public val queryWithFilterOfFindBlockHeadersAndBlockHeaderPredicateBox: QueryWithFilterOfFindBlockHeadersAndBlockHeaderPredicateBox,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindBlockHeaders>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindBlockHeaders> {
            public const val DISCRIMINANT: Int = 14

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindBlockHeaders = try {
                FindBlockHeaders(
                    QueryWithFilterOfFindBlockHeadersAndBlockHeaderPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindBlockHeaders): Unit = try {
                QueryWithFilterOfFindBlockHeadersAndBlockHeaderPredicateBox.write(
                    writer,
                    instance.queryWithFilterOfFindBlockHeadersAndBlockHeaderPredicateBox,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<QueryBox>, ScaleWriter<QueryBox> {
        override fun read(reader: ScaleCodecReader): QueryBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> FindDomains.read(reader)
            1 -> FindAccounts.read(reader)
            2 -> FindAssets.read(reader)
            3 -> FindAssetsDefinitions.read(reader)
            4 -> FindRoles.read(reader)
            5 -> FindRoleIds.read(reader)
            6 -> FindPermissionsByAccountId.read(reader)
            7 -> FindRolesByAccountId.read(reader)
            8 -> FindAccountsWithAsset.read(reader)
            9 -> FindPeers.read(reader)
            10 -> FindActiveTriggerIds.read(reader)
            11 -> FindTriggers.read(reader)
            12 -> FindTransactions.read(reader)
            13 -> FindBlocks.read(reader)
            14 -> FindBlockHeaders.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> FindDomains.write(writer, instance as FindDomains)
                1 -> FindAccounts.write(writer, instance as FindAccounts)
                2 -> FindAssets.write(writer, instance as FindAssets)
                3 -> FindAssetsDefinitions.write(writer, instance as FindAssetsDefinitions)
                4 -> FindRoles.write(writer, instance as FindRoles)
                5 -> FindRoleIds.write(writer, instance as FindRoleIds)
                6 -> FindPermissionsByAccountId.write(writer, instance as FindPermissionsByAccountId)
                7 -> FindRolesByAccountId.write(writer, instance as FindRolesByAccountId)
                8 -> FindAccountsWithAsset.write(writer, instance as FindAccountsWithAsset)
                9 -> FindPeers.write(writer, instance as FindPeers)
                10 -> FindActiveTriggerIds.write(writer, instance as FindActiveTriggerIds)
                11 -> FindTriggers.write(writer, instance as FindTriggers)
                12 -> FindTransactions.write(writer, instance as FindTransactions)
                13 -> FindBlocks.write(writer, instance as FindBlocks)
                14 -> FindBlockHeaders.write(writer, instance as FindBlockHeaders)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
