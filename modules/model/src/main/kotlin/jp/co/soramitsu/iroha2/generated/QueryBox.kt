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
    public data class FindDomains(public val queryWithFilterOfFindDomains: QueryWithFilterOfFindDomains) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindDomains>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindDomains> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindDomains = try {
                FindDomains(
                    QueryWithFilterOfFindDomains.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindDomains): Unit = try {
                QueryWithFilterOfFindDomains.write(writer, instance.queryWithFilterOfFindDomains)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAccounts' variant
     */
    public data class FindAccounts(public val queryWithFilterOfFindAccounts: QueryWithFilterOfFindAccounts) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccounts>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccounts> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAccounts = try {
                FindAccounts(
                    QueryWithFilterOfFindAccounts.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAccounts): Unit = try {
                QueryWithFilterOfFindAccounts.write(writer, instance.queryWithFilterOfFindAccounts)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAssets' variant
     */
    public data class FindAssets(public val queryWithFilterOfFindAssets: QueryWithFilterOfFindAssets) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssets>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssets> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAssets = try {
                FindAssets(
                    QueryWithFilterOfFindAssets.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAssets): Unit = try {
                QueryWithFilterOfFindAssets.write(writer, instance.queryWithFilterOfFindAssets)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAssetsDefinitions' variant
     */
    public data class FindAssetsDefinitions(public val queryWithFilterOfFindAssetsDefinitions: QueryWithFilterOfFindAssetsDefinitions) :
        QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsDefinitions>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsDefinitions> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsDefinitions = try {
                FindAssetsDefinitions(
                    QueryWithFilterOfFindAssetsDefinitions.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsDefinitions): Unit =
                try {
                    QueryWithFilterOfFindAssetsDefinitions.write(writer, instance.queryWithFilterOfFindAssetsDefinitions)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindRoles' variant
     */
    public data class FindRoles(public val queryWithFilterOfFindRoles: QueryWithFilterOfFindRoles) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindRoles>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindRoles> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindRoles = try {
                FindRoles(
                    QueryWithFilterOfFindRoles.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindRoles): Unit = try {
                QueryWithFilterOfFindRoles.write(writer, instance.queryWithFilterOfFindRoles)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindRoleIds' variant
     */
    public data class FindRoleIds(public val queryWithFilterOfFindRoleIds: QueryWithFilterOfFindRoleIds) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindRoleIds>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindRoleIds> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindRoleIds = try {
                FindRoleIds(
                    QueryWithFilterOfFindRoleIds.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindRoleIds): Unit = try {
                QueryWithFilterOfFindRoleIds.write(writer, instance.queryWithFilterOfFindRoleIds)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindPermissionsByAccountId' variant
     */
    public data class FindPermissionsByAccountId(
        public val queryWithFilterOfFindPermissionsByAccountId: QueryWithFilterOfFindPermissionsByAccountId,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindPermissionsByAccountId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindPermissionsByAccountId> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindPermissionsByAccountId = try {
                FindPermissionsByAccountId(
                    QueryWithFilterOfFindPermissionsByAccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindPermissionsByAccountId,
            ): Unit = try {
                QueryWithFilterOfFindPermissionsByAccountId.write(writer, instance.queryWithFilterOfFindPermissionsByAccountId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindRolesByAccountId' variant
     */
    public data class FindRolesByAccountId(public val queryWithFilterOfFindRolesByAccountId: QueryWithFilterOfFindRolesByAccountId) :
        QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindRolesByAccountId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindRolesByAccountId> {
            public const val DISCRIMINANT: Int = 7

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindRolesByAccountId = try {
                FindRolesByAccountId(
                    QueryWithFilterOfFindRolesByAccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindRolesByAccountId): Unit =
                try {
                    QueryWithFilterOfFindRolesByAccountId.write(writer, instance.queryWithFilterOfFindRolesByAccountId)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindAccountsWithAsset' variant
     */
    public data class FindAccountsWithAsset(public val queryWithFilterOfFindAccountsWithAsset: QueryWithFilterOfFindAccountsWithAsset) :
        QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsWithAsset>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsWithAsset> {
            public const val DISCRIMINANT: Int = 8

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsWithAsset = try {
                FindAccountsWithAsset(
                    QueryWithFilterOfFindAccountsWithAsset.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsWithAsset): Unit =
                try {
                    QueryWithFilterOfFindAccountsWithAsset.write(writer, instance.queryWithFilterOfFindAccountsWithAsset)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindPeers' variant
     */
    public data class FindPeers(public val queryWithFilterOfFindPeers: QueryWithFilterOfFindPeers) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindPeers>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindPeers> {
            public const val DISCRIMINANT: Int = 9

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindPeers = try {
                FindPeers(
                    QueryWithFilterOfFindPeers.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindPeers): Unit = try {
                QueryWithFilterOfFindPeers.write(writer, instance.queryWithFilterOfFindPeers)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindActiveTriggerIds' variant
     */
    public data class FindActiveTriggerIds(public val queryWithFilterOfFindActiveTriggerIds: QueryWithFilterOfFindActiveTriggerIds) :
        QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindActiveTriggerIds>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindActiveTriggerIds> {
            public const val DISCRIMINANT: Int = 10

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindActiveTriggerIds = try {
                FindActiveTriggerIds(
                    QueryWithFilterOfFindActiveTriggerIds.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindActiveTriggerIds): Unit =
                try {
                    QueryWithFilterOfFindActiveTriggerIds.write(writer, instance.queryWithFilterOfFindActiveTriggerIds)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindTriggers' variant
     */
    public data class FindTriggers(public val queryWithFilterOfFindTriggers: QueryWithFilterOfFindTriggers) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggers>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggers> {
            public const val DISCRIMINANT: Int = 11

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggers = try {
                FindTriggers(
                    QueryWithFilterOfFindTriggers.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggers): Unit = try {
                QueryWithFilterOfFindTriggers.write(writer, instance.queryWithFilterOfFindTriggers)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindTransactions' variant
     */
    public data class FindTransactions(public val queryWithFilterOfFindTransactions: QueryWithFilterOfFindTransactions) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactions>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactions> {
            public const val DISCRIMINANT: Int = 12

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactions = try {
                FindTransactions(
                    QueryWithFilterOfFindTransactions.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactions): Unit = try {
                QueryWithFilterOfFindTransactions.write(writer, instance.queryWithFilterOfFindTransactions)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindBlocks' variant
     */
    public data class FindBlocks(public val queryWithFilterOfFindBlocks: QueryWithFilterOfFindBlocks) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindBlocks>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindBlocks> {
            public const val DISCRIMINANT: Int = 13

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindBlocks = try {
                FindBlocks(
                    QueryWithFilterOfFindBlocks.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindBlocks): Unit = try {
                QueryWithFilterOfFindBlocks.write(writer, instance.queryWithFilterOfFindBlocks)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindBlockHeaders' variant
     */
    public data class FindBlockHeaders(public val queryWithFilterOfFindBlockHeaders: QueryWithFilterOfFindBlockHeaders) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindBlockHeaders>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindBlockHeaders> {
            public const val DISCRIMINANT: Int = 14

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindBlockHeaders = try {
                FindBlockHeaders(
                    QueryWithFilterOfFindBlockHeaders.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindBlockHeaders): Unit = try {
                QueryWithFilterOfFindBlockHeaders.write(writer, instance.queryWithFilterOfFindBlockHeaders)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<QueryBox>, ScaleWriter<QueryBox> {
        override fun read(reader: ScaleCodecReader): QueryBox = when (val discriminant = reader.readUByte()) {
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
