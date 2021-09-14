//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.query

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Int

/**
 * QueryBox
 *
 * Generated from 'iroha_data_model::query::QueryBox' enum
 */
public sealed class QueryBox {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'FindAllAccounts' variant
     */
    public data class FindAllAccounts(
        public val findAllAccounts:
            jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAllAccounts
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAllAccounts>, ScaleWriter<FindAllAccounts> {
            public const val DISCRIMINANT: Int = 0

            public override fun read(reader: ScaleCodecReader): FindAllAccounts = FindAllAccounts(
                jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAllAccounts.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: FindAllAccounts) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAllAccounts.write(
                    writer,
                    instance.findAllAccounts
                )
            }
        }
    }

    /**
     * 'FindAccountById' variant
     */
    public data class FindAccountById(
        public val findAccountById:
            jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountById
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAccountById>, ScaleWriter<FindAccountById> {
            public const val DISCRIMINANT: Int = 1

            public override fun read(reader: ScaleCodecReader): FindAccountById = FindAccountById(
                jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountById.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: FindAccountById) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountById.write(
                    writer,
                    instance.findAccountById
                )
            }
        }
    }

    /**
     * 'FindAccountKeyValueByIdAndKey' variant
     */
    public data class FindAccountKeyValueByIdAndKey(
        public val findAccountKeyValueByIdAndKey:
            jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountKeyValueByIdAndKey
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAccountKeyValueByIdAndKey>,
            ScaleWriter<FindAccountKeyValueByIdAndKey> {
            public const val DISCRIMINANT: Int = 2

            public override fun read(reader: ScaleCodecReader): FindAccountKeyValueByIdAndKey =
                FindAccountKeyValueByIdAndKey(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountKeyValueByIdAndKey.read(reader),
                )

            public override fun write(writer: ScaleCodecWriter, instance: FindAccountKeyValueByIdAndKey) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountKeyValueByIdAndKey.write(
                    writer,
                    instance.findAccountKeyValueByIdAndKey
                )
            }
        }
    }

    /**
     * 'FindAccountsByName' variant
     */
    public data class FindAccountsByName(
        public val findAccountsByName:
            jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountsByName
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAccountsByName>, ScaleWriter<FindAccountsByName> {
            public const val DISCRIMINANT: Int = 3

            public override fun read(reader: ScaleCodecReader): FindAccountsByName = FindAccountsByName(
                jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountsByName.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: FindAccountsByName) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountsByName.write(
                    writer,
                    instance.findAccountsByName
                )
            }
        }
    }

    /**
     * 'FindAccountsByDomainName' variant
     */
    public data class FindAccountsByDomainName(
        public val findAccountsByDomainName:
            jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountsByDomainName
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAccountsByDomainName>,
            ScaleWriter<FindAccountsByDomainName> {
            public const val DISCRIMINANT: Int = 4

            public override fun read(reader: ScaleCodecReader): FindAccountsByDomainName =
                FindAccountsByDomainName(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountsByDomainName.read(reader),
                )

            public override fun write(writer: ScaleCodecWriter, instance: FindAccountsByDomainName) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountsByDomainName.write(
                    writer,
                    instance.findAccountsByDomainName
                )
            }
        }
    }

    /**
     * 'FindAllAssets' variant
     */
    public data class FindAllAssets(
        public val findAllAssets: jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAllAssets
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAllAssets>, ScaleWriter<FindAllAssets> {
            public const val DISCRIMINANT: Int = 5

            public override fun read(reader: ScaleCodecReader): FindAllAssets = FindAllAssets(
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAllAssets.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: FindAllAssets) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAllAssets.write(
                    writer,
                    instance.findAllAssets
                )
            }
        }
    }

    /**
     * 'FindAllAssetsDefinitions' variant
     */
    public data class FindAllAssetsDefinitions(
        public val findAllAssetsDefinitions:
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAllAssetsDefinitions
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAllAssetsDefinitions>,
            ScaleWriter<FindAllAssetsDefinitions> {
            public const val DISCRIMINANT: Int = 6

            public override fun read(reader: ScaleCodecReader): FindAllAssetsDefinitions =
                FindAllAssetsDefinitions(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAllAssetsDefinitions.read(reader),
                )

            public override fun write(writer: ScaleCodecWriter, instance: FindAllAssetsDefinitions) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAllAssetsDefinitions.write(
                    writer,
                    instance.findAllAssetsDefinitions
                )
            }
        }
    }

    /**
     * 'FindAssetById' variant
     */
    public data class FindAssetById(
        public val findAssetById: jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetById
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAssetById>, ScaleWriter<FindAssetById> {
            public const val DISCRIMINANT: Int = 7

            public override fun read(reader: ScaleCodecReader): FindAssetById = FindAssetById(
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetById.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: FindAssetById) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetById.write(
                    writer,
                    instance.findAssetById
                )
            }
        }
    }

    /**
     * 'FindAssetsByName' variant
     */
    public data class FindAssetsByName(
        public val findAssetsByName:
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByName
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAssetsByName>, ScaleWriter<FindAssetsByName> {
            public const val DISCRIMINANT: Int = 8

            public override fun read(reader: ScaleCodecReader): FindAssetsByName = FindAssetsByName(
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByName.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: FindAssetsByName) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByName.write(
                    writer,
                    instance.findAssetsByName
                )
            }
        }
    }

    /**
     * 'FindAssetsByAccountId' variant
     */
    public data class FindAssetsByAccountId(
        public val findAssetsByAccountId:
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByAccountId
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAssetsByAccountId>, ScaleWriter<FindAssetsByAccountId> {
            public const val DISCRIMINANT: Int = 9

            public override fun read(reader: ScaleCodecReader): FindAssetsByAccountId =
                FindAssetsByAccountId(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByAccountId.read(reader),
                )

            public override fun write(writer: ScaleCodecWriter, instance: FindAssetsByAccountId) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByAccountId.write(
                    writer,
                    instance.findAssetsByAccountId
                )
            }
        }
    }

    /**
     * 'FindAssetsByAssetDefinitionId' variant
     */
    public data class FindAssetsByAssetDefinitionId(
        public val findAssetsByAssetDefinitionId:
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByAssetDefinitionId
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAssetsByAssetDefinitionId>,
            ScaleWriter<FindAssetsByAssetDefinitionId> {
            public const val DISCRIMINANT: Int = 10

            public override fun read(reader: ScaleCodecReader): FindAssetsByAssetDefinitionId =
                FindAssetsByAssetDefinitionId(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByAssetDefinitionId.read(reader),
                )

            public override fun write(writer: ScaleCodecWriter, instance: FindAssetsByAssetDefinitionId) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByAssetDefinitionId.write(
                    writer,
                    instance.findAssetsByAssetDefinitionId
                )
            }
        }
    }

    /**
     * 'FindAssetsByDomainName' variant
     */
    public data class FindAssetsByDomainName(
        public val findAssetsByDomainName:
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByDomainName
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAssetsByDomainName>,
            ScaleWriter<FindAssetsByDomainName> {
            public const val DISCRIMINANT: Int = 11

            public override fun read(reader: ScaleCodecReader): FindAssetsByDomainName =
                FindAssetsByDomainName(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByDomainName.read(reader),
                )

            public override fun write(writer: ScaleCodecWriter, instance: FindAssetsByDomainName) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByDomainName.write(
                    writer,
                    instance.findAssetsByDomainName
                )
            }
        }
    }

    /**
     * 'FindAssetsByDomainNameAndAssetDefinitionId' variant
     */
    public data class FindAssetsByDomainNameAndAssetDefinitionId(
        public val findAssetsByDomainNameAndAssetDefinitionId:
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByDomainNameAndAssetDefinitionId
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAssetsByDomainNameAndAssetDefinitionId>,
            ScaleWriter<FindAssetsByDomainNameAndAssetDefinitionId> {
            public const val DISCRIMINANT: Int = 12

            public override fun read(reader: ScaleCodecReader): FindAssetsByDomainNameAndAssetDefinitionId =
                FindAssetsByDomainNameAndAssetDefinitionId(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByDomainNameAndAssetDefinitionId.read(reader),
                )

            public override fun write(
                writer: ScaleCodecWriter,
                instance: FindAssetsByDomainNameAndAssetDefinitionId
            ) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByDomainNameAndAssetDefinitionId.write(
                    writer,
                    instance.findAssetsByDomainNameAndAssetDefinitionId
                )
            }
        }
    }

    /**
     * 'FindAssetQuantityById' variant
     */
    public data class FindAssetQuantityById(
        public val findAssetQuantityById:
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetQuantityById
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAssetQuantityById>, ScaleWriter<FindAssetQuantityById> {
            public const val DISCRIMINANT: Int = 13

            public override fun read(reader: ScaleCodecReader): FindAssetQuantityById =
                FindAssetQuantityById(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetQuantityById.read(reader),
                )

            public override fun write(writer: ScaleCodecWriter, instance: FindAssetQuantityById) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetQuantityById.write(
                    writer,
                    instance.findAssetQuantityById
                )
            }
        }
    }

    /**
     * 'FindAssetKeyValueByIdAndKey' variant
     */
    public data class FindAssetKeyValueByIdAndKey(
        public val findAssetKeyValueByIdAndKey:
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetKeyValueByIdAndKey
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAssetKeyValueByIdAndKey>,
            ScaleWriter<FindAssetKeyValueByIdAndKey> {
            public const val DISCRIMINANT: Int = 14

            public override fun read(reader: ScaleCodecReader): FindAssetKeyValueByIdAndKey =
                FindAssetKeyValueByIdAndKey(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetKeyValueByIdAndKey.read(reader),
                )

            public override fun write(writer: ScaleCodecWriter, instance: FindAssetKeyValueByIdAndKey) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetKeyValueByIdAndKey.write(
                    writer,
                    instance.findAssetKeyValueByIdAndKey
                )
            }
        }
    }

    /**
     * 'FindAssetDefinitionKeyValueByIdAndKey' variant
     */
    public data class FindAssetDefinitionKeyValueByIdAndKey(
        public val findAssetDefinitionKeyValueByIdAndKey:
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetDefinitionKeyValueByIdAndKey
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAssetDefinitionKeyValueByIdAndKey>,
            ScaleWriter<FindAssetDefinitionKeyValueByIdAndKey> {
            public const val DISCRIMINANT: Int = 15

            public override fun read(reader: ScaleCodecReader): FindAssetDefinitionKeyValueByIdAndKey =
                FindAssetDefinitionKeyValueByIdAndKey(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetDefinitionKeyValueByIdAndKey.read(reader),
                )

            public override fun write(
                writer: ScaleCodecWriter,
                instance: FindAssetDefinitionKeyValueByIdAndKey
            ) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetDefinitionKeyValueByIdAndKey.write(
                    writer,
                    instance.findAssetDefinitionKeyValueByIdAndKey
                )
            }
        }
    }

    /**
     * 'FindAllDomains' variant
     */
    public data class FindAllDomains(
        public val findAllDomains:
            jp.co.soramitsu.iroha2.generated.datamodel.query.domain.FindAllDomains
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAllDomains>, ScaleWriter<FindAllDomains> {
            public const val DISCRIMINANT: Int = 16

            public override fun read(reader: ScaleCodecReader): FindAllDomains = FindAllDomains(
                jp.co.soramitsu.iroha2.generated.datamodel.query.domain.FindAllDomains.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: FindAllDomains) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.domain.FindAllDomains.write(
                    writer,
                    instance.findAllDomains
                )
            }
        }
    }

    /**
     * 'FindDomainByName' variant
     */
    public data class FindDomainByName(
        public val findDomainByName:
            jp.co.soramitsu.iroha2.generated.datamodel.query.domain.FindDomainByName
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindDomainByName>, ScaleWriter<FindDomainByName> {
            public const val DISCRIMINANT: Int = 17

            public override fun read(reader: ScaleCodecReader): FindDomainByName = FindDomainByName(
                jp.co.soramitsu.iroha2.generated.datamodel.query.domain.FindDomainByName.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: FindDomainByName) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.domain.FindDomainByName.write(
                    writer,
                    instance.findDomainByName
                )
            }
        }
    }

    /**
     * 'FindAllPeers' variant
     */
    public data class FindAllPeers(
        public val findAllPeers: jp.co.soramitsu.iroha2.generated.datamodel.query.peer.FindAllPeers
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAllPeers>, ScaleWriter<FindAllPeers> {
            public const val DISCRIMINANT: Int = 18

            public override fun read(reader: ScaleCodecReader): FindAllPeers = FindAllPeers(
                jp.co.soramitsu.iroha2.generated.datamodel.query.peer.FindAllPeers.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: FindAllPeers) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.peer.FindAllPeers.write(
                    writer,
                    instance.findAllPeers
                )
            }
        }
    }

    /**
     * 'FindTransactionsByAccountId' variant
     */
    public data class FindTransactionsByAccountId(
        public val findTransactionsByAccountId:
            jp.co.soramitsu.iroha2.generated.datamodel.query.transaction.FindTransactionsByAccountId
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindTransactionsByAccountId>,
            ScaleWriter<FindTransactionsByAccountId> {
            public const val DISCRIMINANT: Int = 19

            public override fun read(reader: ScaleCodecReader): FindTransactionsByAccountId =
                FindTransactionsByAccountId(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.transaction.FindTransactionsByAccountId.read(reader),
                )

            public override fun write(writer: ScaleCodecWriter, instance: FindTransactionsByAccountId) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.transaction.FindTransactionsByAccountId.write(
                    writer,
                    instance.findTransactionsByAccountId
                )
            }
        }
    }

    /**
     * 'FindPermissionTokensByAccountId' variant
     */
    public data class FindPermissionTokensByAccountId(
        public val findPermissionTokensByAccountId:
            jp.co.soramitsu.iroha2.generated.datamodel.query.permissions.FindPermissionTokensByAccountId
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindPermissionTokensByAccountId>,
            ScaleWriter<FindPermissionTokensByAccountId> {
            public const val DISCRIMINANT: Int = 20

            public override fun read(reader: ScaleCodecReader): FindPermissionTokensByAccountId =
                FindPermissionTokensByAccountId(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.permissions.FindPermissionTokensByAccountId.read(reader),
                )

            public override fun write(
                writer: ScaleCodecWriter,
                instance: FindPermissionTokensByAccountId
            ) {
                jp.co.soramitsu.iroha2.generated.datamodel.query.permissions.FindPermissionTokensByAccountId.write(
                    writer,
                    instance.findPermissionTokensByAccountId
                )
            }
        }
    }

    public companion object : ScaleReader<QueryBox>, ScaleWriter<QueryBox> {
        public override fun read(reader: ScaleCodecReader): QueryBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> FindAllAccounts.read(reader)
            1 -> FindAccountById.read(reader)
            2 -> FindAccountKeyValueByIdAndKey.read(reader)
            3 -> FindAccountsByName.read(reader)
            4 -> FindAccountsByDomainName.read(reader)
            5 -> FindAllAssets.read(reader)
            6 -> FindAllAssetsDefinitions.read(reader)
            7 -> FindAssetById.read(reader)
            8 -> FindAssetsByName.read(reader)
            9 -> FindAssetsByAccountId.read(reader)
            10 -> FindAssetsByAssetDefinitionId.read(reader)
            11 -> FindAssetsByDomainName.read(reader)
            12 -> FindAssetsByDomainNameAndAssetDefinitionId.read(reader)
            13 -> FindAssetQuantityById.read(reader)
            14 -> FindAssetKeyValueByIdAndKey.read(reader)
            15 -> FindAssetDefinitionKeyValueByIdAndKey.read(reader)
            16 -> FindAllDomains.read(reader)
            17 -> FindDomainByName.read(reader)
            18 -> FindAllPeers.read(reader)
            19 -> FindTransactionsByAccountId.read(reader)
            20 -> FindPermissionTokensByAccountId.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        public override fun write(writer: ScaleCodecWriter, instance: QueryBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> FindAllAccounts.write(writer, instance as FindAllAccounts)
                1 -> FindAccountById.write(writer, instance as FindAccountById)
                2 -> FindAccountKeyValueByIdAndKey.write(writer, instance as FindAccountKeyValueByIdAndKey)
                3 -> FindAccountsByName.write(writer, instance as FindAccountsByName)
                4 -> FindAccountsByDomainName.write(writer, instance as FindAccountsByDomainName)
                5 -> FindAllAssets.write(writer, instance as FindAllAssets)
                6 -> FindAllAssetsDefinitions.write(writer, instance as FindAllAssetsDefinitions)
                7 -> FindAssetById.write(writer, instance as FindAssetById)
                8 -> FindAssetsByName.write(writer, instance as FindAssetsByName)
                9 -> FindAssetsByAccountId.write(writer, instance as FindAssetsByAccountId)
                10 -> FindAssetsByAssetDefinitionId.write(writer, instance as FindAssetsByAssetDefinitionId)
                11 -> FindAssetsByDomainName.write(writer, instance as FindAssetsByDomainName)
                12 -> FindAssetsByDomainNameAndAssetDefinitionId.write(
                    writer,
                    instance as
                        FindAssetsByDomainNameAndAssetDefinitionId
                )
                13 -> FindAssetQuantityById.write(writer, instance as FindAssetQuantityById)
                14 -> FindAssetKeyValueByIdAndKey.write(writer, instance as FindAssetKeyValueByIdAndKey)
                15 -> FindAssetDefinitionKeyValueByIdAndKey.write(
                    writer,
                    instance as
                        FindAssetDefinitionKeyValueByIdAndKey
                )
                16 -> FindAllDomains.write(writer, instance as FindAllDomains)
                17 -> FindDomainByName.write(writer, instance as FindDomainByName)
                18 -> FindAllPeers.write(writer, instance as FindAllPeers)
                19 -> FindTransactionsByAccountId.write(writer, instance as FindTransactionsByAccountId)
                20 -> FindPermissionTokensByAccountId.write(
                    writer,
                    instance as
                        FindPermissionTokensByAccountId
                )
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
