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
     * 'FindAllAccounts' variant
     */
    public data class FindAllAccounts(
        public val findAllAccounts: jp.co.soramitsu.iroha2.generated.FindAllAccounts,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllAccounts>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllAccounts> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAllAccounts = try {
                FindAllAccounts(
                    jp.co.soramitsu.iroha2.generated.FindAllAccounts.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAllAccounts,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAllAccounts.write(writer, instance.findAllAccounts)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAccountById' variant
     */
    public data class FindAccountById(
        public val findAccountById: jp.co.soramitsu.iroha2.generated.FindAccountById,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountById>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountById> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountById = try {
                FindAccountById(
                    jp.co.soramitsu.iroha2.generated.FindAccountById.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountById,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAccountById.write(writer, instance.findAccountById)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAccountKeyValueByIdAndKey' variant
     */
    public data class FindAccountKeyValueByIdAndKey(
        public val findAccountKeyValueByIdAndKey:
        jp.co.soramitsu.iroha2.generated.FindAccountKeyValueByIdAndKey,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountKeyValueByIdAndKey>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountKeyValueByIdAndKey> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountKeyValueByIdAndKey = try {
                FindAccountKeyValueByIdAndKey(
                    jp.co.soramitsu.iroha2.generated.FindAccountKeyValueByIdAndKey.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountKeyValueByIdAndKey,
            ): Unit =
                try {
                    jp.co.soramitsu.iroha2.generated.FindAccountKeyValueByIdAndKey.write(
                        writer,
                        instance.findAccountKeyValueByIdAndKey,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindAccountsByDomainId' variant
     */
    public data class FindAccountsByDomainId(
        public val findAccountsByDomainId: jp.co.soramitsu.iroha2.generated.FindAccountsByDomainId,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsByDomainId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsByDomainId> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsByDomainId = try {
                FindAccountsByDomainId(
                    jp.co.soramitsu.iroha2.generated.FindAccountsByDomainId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsByDomainId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAccountsByDomainId.write(
                    writer,
                    instance.findAccountsByDomainId,
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
        public val findAccountsWithAsset: jp.co.soramitsu.iroha2.generated.FindAccountsWithAsset,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsWithAsset>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsWithAsset> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsWithAsset = try {
                FindAccountsWithAsset(
                    jp.co.soramitsu.iroha2.generated.FindAccountsWithAsset.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAccountsWithAsset,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAccountsWithAsset.write(
                    writer,
                    instance.findAccountsWithAsset,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAllAssets' variant
     */
    public data class FindAllAssets(
        public val findAllAssets: jp.co.soramitsu.iroha2.generated.FindAllAssets,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllAssets>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllAssets> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAllAssets = try {
                FindAllAssets(
                    jp.co.soramitsu.iroha2.generated.FindAllAssets.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAllAssets,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAllAssets.write(writer, instance.findAllAssets)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAllAssetsDefinitions' variant
     */
    public data class FindAllAssetsDefinitions(
        public val findAllAssetsDefinitions: jp.co.soramitsu.iroha2.generated.FindAllAssetsDefinitions,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllAssetsDefinitions>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllAssetsDefinitions> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAllAssetsDefinitions = try {
                FindAllAssetsDefinitions(
                    jp.co.soramitsu.iroha2.generated.FindAllAssetsDefinitions.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAllAssetsDefinitions,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAllAssetsDefinitions.write(
                    writer,
                    instance.findAllAssetsDefinitions,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAssetById' variant
     */
    public data class FindAssetById(
        public val findAssetById: jp.co.soramitsu.iroha2.generated.FindAssetById,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetById>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetById> {
            public const val DISCRIMINANT: Int = 7

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetById = try {
                FindAssetById(
                    jp.co.soramitsu.iroha2.generated.FindAssetById.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetById,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAssetById.write(writer, instance.findAssetById)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAssetDefinitionById' variant
     */
    public data class FindAssetDefinitionById(
        public val findAssetDefinitionById: jp.co.soramitsu.iroha2.generated.FindAssetDefinitionById,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetDefinitionById>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetDefinitionById> {
            public const val DISCRIMINANT: Int = 8

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetDefinitionById = try {
                FindAssetDefinitionById(
                    jp.co.soramitsu.iroha2.generated.FindAssetDefinitionById.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetDefinitionById,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAssetDefinitionById.write(
                    writer,
                    instance.findAssetDefinitionById,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAssetsByName' variant
     */
    public data class FindAssetsByName(
        public val findAssetsByName: jp.co.soramitsu.iroha2.generated.FindAssetsByName,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByName>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByName> {
            public const val DISCRIMINANT: Int = 9

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByName = try {
                FindAssetsByName(
                    jp.co.soramitsu.iroha2.generated.FindAssetsByName.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByName,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAssetsByName.write(writer, instance.findAssetsByName)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAssetsByAccountId' variant
     */
    public data class FindAssetsByAccountId(
        public val findAssetsByAccountId: jp.co.soramitsu.iroha2.generated.FindAssetsByAccountId,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByAccountId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByAccountId> {
            public const val DISCRIMINANT: Int = 10

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByAccountId = try {
                FindAssetsByAccountId(
                    jp.co.soramitsu.iroha2.generated.FindAssetsByAccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByAccountId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAssetsByAccountId.write(
                    writer,
                    instance.findAssetsByAccountId,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAssetsByAssetDefinitionId' variant
     */
    public data class FindAssetsByAssetDefinitionId(
        public val findAssetsByAssetDefinitionId:
        jp.co.soramitsu.iroha2.generated.FindAssetsByAssetDefinitionId,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByAssetDefinitionId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByAssetDefinitionId> {
            public const val DISCRIMINANT: Int = 11

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByAssetDefinitionId = try {
                FindAssetsByAssetDefinitionId(
                    jp.co.soramitsu.iroha2.generated.FindAssetsByAssetDefinitionId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByAssetDefinitionId,
            ): Unit =
                try {
                    jp.co.soramitsu.iroha2.generated.FindAssetsByAssetDefinitionId.write(
                        writer,
                        instance.findAssetsByAssetDefinitionId,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindAssetsByDomainId' variant
     */
    public data class FindAssetsByDomainId(
        public val findAssetsByDomainId: jp.co.soramitsu.iroha2.generated.FindAssetsByDomainId,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByDomainId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByDomainId> {
            public const val DISCRIMINANT: Int = 12

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByDomainId = try {
                FindAssetsByDomainId(
                    jp.co.soramitsu.iroha2.generated.FindAssetsByDomainId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByDomainId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAssetsByDomainId.write(
                    writer,
                    instance.findAssetsByDomainId,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAssetsByDomainIdAndAssetDefinitionId' variant
     */
    public data class FindAssetsByDomainIdAndAssetDefinitionId(
        public val findAssetsByDomainIdAndAssetDefinitionId:
        jp.co.soramitsu.iroha2.generated.FindAssetsByDomainIdAndAssetDefinitionId,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByDomainIdAndAssetDefinitionId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByDomainIdAndAssetDefinitionId> {
            public const val DISCRIMINANT: Int = 13

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByDomainIdAndAssetDefinitionId = try {
                FindAssetsByDomainIdAndAssetDefinitionId(
                    jp.co.soramitsu.iroha2.generated.FindAssetsByDomainIdAndAssetDefinitionId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetsByDomainIdAndAssetDefinitionId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAssetsByDomainIdAndAssetDefinitionId.write(
                    writer,
                    instance.findAssetsByDomainIdAndAssetDefinitionId,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAssetQuantityById' variant
     */
    public data class FindAssetQuantityById(
        public val findAssetQuantityById: jp.co.soramitsu.iroha2.generated.FindAssetQuantityById,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetQuantityById>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetQuantityById> {
            public const val DISCRIMINANT: Int = 14

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetQuantityById = try {
                FindAssetQuantityById(
                    jp.co.soramitsu.iroha2.generated.FindAssetQuantityById.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetQuantityById,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAssetQuantityById.write(
                    writer,
                    instance.findAssetQuantityById,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindTotalAssetQuantityByAssetDefinitionId' variant
     */
    public data class FindTotalAssetQuantityByAssetDefinitionId(
        public val findTotalAssetQuantityByAssetDefinitionId:
        jp.co.soramitsu.iroha2.generated.FindTotalAssetQuantityByAssetDefinitionId,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindTotalAssetQuantityByAssetDefinitionId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindTotalAssetQuantityByAssetDefinitionId> {
            public const val DISCRIMINANT: Int = 15

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindTotalAssetQuantityByAssetDefinitionId = try {
                FindTotalAssetQuantityByAssetDefinitionId(
                    jp.co.soramitsu.iroha2.generated.FindTotalAssetQuantityByAssetDefinitionId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindTotalAssetQuantityByAssetDefinitionId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindTotalAssetQuantityByAssetDefinitionId.write(
                    writer,
                    instance.findTotalAssetQuantityByAssetDefinitionId,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAssetKeyValueByIdAndKey' variant
     */
    public data class FindAssetKeyValueByIdAndKey(
        public val findAssetKeyValueByIdAndKey:
        jp.co.soramitsu.iroha2.generated.FindAssetKeyValueByIdAndKey,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetKeyValueByIdAndKey>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetKeyValueByIdAndKey> {
            public const val DISCRIMINANT: Int = 16

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetKeyValueByIdAndKey = try {
                FindAssetKeyValueByIdAndKey(
                    jp.co.soramitsu.iroha2.generated.FindAssetKeyValueByIdAndKey.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetKeyValueByIdAndKey,
            ): Unit =
                try {
                    jp.co.soramitsu.iroha2.generated.FindAssetKeyValueByIdAndKey.write(
                        writer,
                        instance.findAssetKeyValueByIdAndKey,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindAssetDefinitionKeyValueByIdAndKey' variant
     */
    public data class FindAssetDefinitionKeyValueByIdAndKey(
        public val findAssetDefinitionKeyValueByIdAndKey:
        jp.co.soramitsu.iroha2.generated.FindAssetDefinitionKeyValueByIdAndKey,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetDefinitionKeyValueByIdAndKey>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetDefinitionKeyValueByIdAndKey> {
            public const val DISCRIMINANT: Int = 17

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetDefinitionKeyValueByIdAndKey = try {
                FindAssetDefinitionKeyValueByIdAndKey(
                    jp.co.soramitsu.iroha2.generated.FindAssetDefinitionKeyValueByIdAndKey.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAssetDefinitionKeyValueByIdAndKey,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAssetDefinitionKeyValueByIdAndKey.write(
                    writer,
                    instance.findAssetDefinitionKeyValueByIdAndKey,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAllDomains' variant
     */
    public data class FindAllDomains(
        public val findAllDomains: jp.co.soramitsu.iroha2.generated.FindAllDomains,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllDomains>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllDomains> {
            public const val DISCRIMINANT: Int = 18

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAllDomains = try {
                FindAllDomains(
                    jp.co.soramitsu.iroha2.generated.FindAllDomains.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAllDomains,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAllDomains.write(writer, instance.findAllDomains)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindDomainById' variant
     */
    public data class FindDomainById(
        public val findDomainById: jp.co.soramitsu.iroha2.generated.FindDomainById,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindDomainById>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindDomainById> {
            public const val DISCRIMINANT: Int = 19

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindDomainById = try {
                FindDomainById(
                    jp.co.soramitsu.iroha2.generated.FindDomainById.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindDomainById,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindDomainById.write(writer, instance.findDomainById)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindDomainKeyValueByIdAndKey' variant
     */
    public data class FindDomainKeyValueByIdAndKey(
        public val findDomainKeyValueByIdAndKey:
        jp.co.soramitsu.iroha2.generated.FindDomainKeyValueByIdAndKey,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindDomainKeyValueByIdAndKey>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindDomainKeyValueByIdAndKey> {
            public const val DISCRIMINANT: Int = 20

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindDomainKeyValueByIdAndKey = try {
                FindDomainKeyValueByIdAndKey(
                    jp.co.soramitsu.iroha2.generated.FindDomainKeyValueByIdAndKey.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindDomainKeyValueByIdAndKey,
            ): Unit =
                try {
                    jp.co.soramitsu.iroha2.generated.FindDomainKeyValueByIdAndKey.write(
                        writer,
                        instance.findDomainKeyValueByIdAndKey,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindAllPeers' variant
     */
    public data class FindAllPeers(
        public val findAllPeers: jp.co.soramitsu.iroha2.generated.FindAllPeers,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllPeers>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllPeers> {
            public const val DISCRIMINANT: Int = 21

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAllPeers = try {
                FindAllPeers(
                    jp.co.soramitsu.iroha2.generated.FindAllPeers.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAllPeers,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAllPeers.write(writer, instance.findAllPeers)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAllBlocks' variant
     */
    public data class FindAllBlocks(
        public val findAllBlocks: jp.co.soramitsu.iroha2.generated.FindAllBlocks,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllBlocks>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllBlocks> {
            public const val DISCRIMINANT: Int = 22

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAllBlocks = try {
                FindAllBlocks(
                    jp.co.soramitsu.iroha2.generated.FindAllBlocks.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAllBlocks,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAllBlocks.write(writer, instance.findAllBlocks)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAllBlockHeaders' variant
     */
    public data class FindAllBlockHeaders(
        public val findAllBlockHeaders: jp.co.soramitsu.iroha2.generated.FindAllBlockHeaders,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllBlockHeaders>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllBlockHeaders> {
            public const val DISCRIMINANT: Int = 23

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAllBlockHeaders = try {
                FindAllBlockHeaders(
                    jp.co.soramitsu.iroha2.generated.FindAllBlockHeaders.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAllBlockHeaders,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAllBlockHeaders.write(
                    writer,
                    instance.findAllBlockHeaders,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindBlockHeaderByHash' variant
     */
    public data class FindBlockHeaderByHash(
        public val findBlockHeaderByHash: jp.co.soramitsu.iroha2.generated.FindBlockHeaderByHash,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindBlockHeaderByHash>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindBlockHeaderByHash> {
            public const val DISCRIMINANT: Int = 24

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindBlockHeaderByHash = try {
                FindBlockHeaderByHash(
                    jp.co.soramitsu.iroha2.generated.FindBlockHeaderByHash.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindBlockHeaderByHash,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindBlockHeaderByHash.write(
                    writer,
                    instance.findBlockHeaderByHash,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAllTransactions' variant
     */
    public data class FindAllTransactions(
        public val findAllTransactions: jp.co.soramitsu.iroha2.generated.FindAllTransactions,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllTransactions>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllTransactions> {
            public const val DISCRIMINANT: Int = 25

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAllTransactions = try {
                FindAllTransactions(
                    jp.co.soramitsu.iroha2.generated.FindAllTransactions.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAllTransactions,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAllTransactions.write(
                    writer,
                    instance.findAllTransactions,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindTransactionsByAccountId' variant
     */
    public data class FindTransactionsByAccountId(
        public val findTransactionsByAccountId:
        jp.co.soramitsu.iroha2.generated.FindTransactionsByAccountId,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactionsByAccountId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactionsByAccountId> {
            public const val DISCRIMINANT: Int = 26

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactionsByAccountId = try {
                FindTransactionsByAccountId(
                    jp.co.soramitsu.iroha2.generated.FindTransactionsByAccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactionsByAccountId,
            ): Unit =
                try {
                    jp.co.soramitsu.iroha2.generated.FindTransactionsByAccountId.write(
                        writer,
                        instance.findTransactionsByAccountId,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindTransactionByHash' variant
     */
    public data class FindTransactionByHash(
        public val findTransactionByHash: jp.co.soramitsu.iroha2.generated.FindTransactionByHash,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactionByHash>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactionByHash> {
            public const val DISCRIMINANT: Int = 27

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactionByHash = try {
                FindTransactionByHash(
                    jp.co.soramitsu.iroha2.generated.FindTransactionByHash.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindTransactionByHash,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindTransactionByHash.write(
                    writer,
                    instance.findTransactionByHash,
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
        public val findPermissionsByAccountId:
        jp.co.soramitsu.iroha2.generated.FindPermissionsByAccountId,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindPermissionsByAccountId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindPermissionsByAccountId> {
            public const val DISCRIMINANT: Int = 28

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindPermissionsByAccountId = try {
                FindPermissionsByAccountId(
                    jp.co.soramitsu.iroha2.generated.FindPermissionsByAccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindPermissionsByAccountId,
            ): Unit =
                try {
                    jp.co.soramitsu.iroha2.generated.FindPermissionsByAccountId.write(
                        writer,
                        instance.findPermissionsByAccountId,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindExecutorDataModel' variant
     */
    public data class FindExecutorDataModel(
        public val findExecutorDataModel: jp.co.soramitsu.iroha2.generated.FindExecutorDataModel,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindExecutorDataModel>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindExecutorDataModel> {
            public const val DISCRIMINANT: Int = 29

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindExecutorDataModel = try {
                FindExecutorDataModel(
                    jp.co.soramitsu.iroha2.generated.FindExecutorDataModel.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindExecutorDataModel,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindExecutorDataModel.write(
                    writer,
                    instance.findExecutorDataModel,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAllActiveTriggerIds' variant
     */
    public data class FindAllActiveTriggerIds(
        public val findAllActiveTriggerIds: jp.co.soramitsu.iroha2.generated.FindAllActiveTriggerIds,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllActiveTriggerIds>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllActiveTriggerIds> {
            public const val DISCRIMINANT: Int = 30

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAllActiveTriggerIds = try {
                FindAllActiveTriggerIds(
                    jp.co.soramitsu.iroha2.generated.FindAllActiveTriggerIds.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAllActiveTriggerIds,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAllActiveTriggerIds.write(
                    writer,
                    instance.findAllActiveTriggerIds,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindTriggerById' variant
     */
    public data class FindTriggerById(
        public val findTriggerById: jp.co.soramitsu.iroha2.generated.FindTriggerById,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggerById>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggerById> {
            public const val DISCRIMINANT: Int = 31

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggerById = try {
                FindTriggerById(
                    jp.co.soramitsu.iroha2.generated.FindTriggerById.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggerById,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindTriggerById.write(writer, instance.findTriggerById)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindTriggerKeyValueByIdAndKey' variant
     */
    public data class FindTriggerKeyValueByIdAndKey(
        public val findTriggerKeyValueByIdAndKey:
        jp.co.soramitsu.iroha2.generated.FindTriggerKeyValueByIdAndKey,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggerKeyValueByIdAndKey>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggerKeyValueByIdAndKey> {
            public const val DISCRIMINANT: Int = 32

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggerKeyValueByIdAndKey = try {
                FindTriggerKeyValueByIdAndKey(
                    jp.co.soramitsu.iroha2.generated.FindTriggerKeyValueByIdAndKey.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggerKeyValueByIdAndKey,
            ): Unit =
                try {
                    jp.co.soramitsu.iroha2.generated.FindTriggerKeyValueByIdAndKey.write(
                        writer,
                        instance.findTriggerKeyValueByIdAndKey,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindTriggersByAuthorityId' variant
     */
    public data class FindTriggersByAuthorityId(
        public val findTriggersByAuthorityId:
        jp.co.soramitsu.iroha2.generated.FindTriggersByAuthorityId,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggersByAuthorityId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggersByAuthorityId> {
            public const val DISCRIMINANT: Int = 33

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggersByAuthorityId = try {
                FindTriggersByAuthorityId(
                    jp.co.soramitsu.iroha2.generated.FindTriggersByAuthorityId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggersByAuthorityId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindTriggersByAuthorityId.write(
                    writer,
                    instance.findTriggersByAuthorityId,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindTriggersByAuthorityDomainId' variant
     */
    public data class FindTriggersByAuthorityDomainId(
        public val findTriggersByAuthorityDomainId:
        jp.co.soramitsu.iroha2.generated.FindTriggersByAuthorityDomainId,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggersByAuthorityDomainId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggersByAuthorityDomainId> {
            public const val DISCRIMINANT: Int = 34

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggersByAuthorityDomainId = try {
                FindTriggersByAuthorityDomainId(
                    jp.co.soramitsu.iroha2.generated.FindTriggersByAuthorityDomainId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindTriggersByAuthorityDomainId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindTriggersByAuthorityDomainId.write(
                    writer,
                    instance.findTriggersByAuthorityDomainId,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAllRoles' variant
     */
    public data class FindAllRoles(
        public val findAllRoles: jp.co.soramitsu.iroha2.generated.FindAllRoles,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllRoles>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllRoles> {
            public const val DISCRIMINANT: Int = 35

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAllRoles = try {
                FindAllRoles(
                    jp.co.soramitsu.iroha2.generated.FindAllRoles.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAllRoles,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAllRoles.write(writer, instance.findAllRoles)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAllRoleIds' variant
     */
    public data class FindAllRoleIds(
        public val findAllRoleIds: jp.co.soramitsu.iroha2.generated.FindAllRoleIds,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllRoleIds>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllRoleIds> {
            public const val DISCRIMINANT: Int = 36

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAllRoleIds = try {
                FindAllRoleIds(
                    jp.co.soramitsu.iroha2.generated.FindAllRoleIds.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAllRoleIds,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAllRoleIds.write(writer, instance.findAllRoleIds)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindRoleByRoleId' variant
     */
    public data class FindRoleByRoleId(
        public val findRoleByRoleId: jp.co.soramitsu.iroha2.generated.FindRoleByRoleId,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindRoleByRoleId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindRoleByRoleId> {
            public const val DISCRIMINANT: Int = 37

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindRoleByRoleId = try {
                FindRoleByRoleId(
                    jp.co.soramitsu.iroha2.generated.FindRoleByRoleId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindRoleByRoleId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindRoleByRoleId.write(writer, instance.findRoleByRoleId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindRolesByAccountId' variant
     */
    public data class FindRolesByAccountId(
        public val findRolesByAccountId: jp.co.soramitsu.iroha2.generated.FindRolesByAccountId,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindRolesByAccountId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindRolesByAccountId> {
            public const val DISCRIMINANT: Int = 38

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindRolesByAccountId = try {
                FindRolesByAccountId(
                    jp.co.soramitsu.iroha2.generated.FindRolesByAccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindRolesByAccountId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindRolesByAccountId.write(
                    writer,
                    instance.findRolesByAccountId,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAllParameters' variant
     */
    public data class FindAllParameters(
        public val findAllParameters: jp.co.soramitsu.iroha2.generated.FindAllParameters,
    ) : QueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllParameters>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryBox.FindAllParameters> {
            public const val DISCRIMINANT: Int = 39

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryBox.FindAllParameters = try {
                FindAllParameters(
                    jp.co.soramitsu.iroha2.generated.FindAllParameters.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryBox.FindAllParameters,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAllParameters.write(writer, instance.findAllParameters)
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
            0 -> FindAllAccounts.read(reader)
            1 -> FindAccountById.read(reader)
            2 -> FindAccountKeyValueByIdAndKey.read(reader)
            3 -> FindAccountsByDomainId.read(reader)
            4 -> FindAccountsWithAsset.read(reader)
            5 -> FindAllAssets.read(reader)
            6 -> FindAllAssetsDefinitions.read(reader)
            7 -> FindAssetById.read(reader)
            8 -> FindAssetDefinitionById.read(reader)
            9 -> FindAssetsByName.read(reader)
            10 -> FindAssetsByAccountId.read(reader)
            11 -> FindAssetsByAssetDefinitionId.read(reader)
            12 -> FindAssetsByDomainId.read(reader)
            13 -> FindAssetsByDomainIdAndAssetDefinitionId.read(reader)
            14 -> FindAssetQuantityById.read(reader)
            15 -> FindTotalAssetQuantityByAssetDefinitionId.read(reader)
            16 -> FindAssetKeyValueByIdAndKey.read(reader)
            17 -> FindAssetDefinitionKeyValueByIdAndKey.read(reader)
            18 -> FindAllDomains.read(reader)
            19 -> FindDomainById.read(reader)
            20 -> FindDomainKeyValueByIdAndKey.read(reader)
            21 -> FindAllPeers.read(reader)
            22 -> FindAllBlocks.read(reader)
            23 -> FindAllBlockHeaders.read(reader)
            24 -> FindBlockHeaderByHash.read(reader)
            25 -> FindAllTransactions.read(reader)
            26 -> FindTransactionsByAccountId.read(reader)
            27 -> FindTransactionByHash.read(reader)
            28 -> FindPermissionsByAccountId.read(reader)
            29 -> FindExecutorDataModel.read(reader)
            30 -> FindAllActiveTriggerIds.read(reader)
            31 -> FindTriggerById.read(reader)
            32 -> FindTriggerKeyValueByIdAndKey.read(reader)
            33 -> FindTriggersByAuthorityId.read(reader)
            34 -> FindTriggersByAuthorityDomainId.read(reader)
            35 -> FindAllRoles.read(reader)
            36 -> FindAllRoleIds.read(reader)
            37 -> FindRoleByRoleId.read(reader)
            38 -> FindRolesByAccountId.read(reader)
            39 -> FindAllParameters.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: QueryBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> FindAllAccounts.write(writer, instance as FindAllAccounts)
                1 -> FindAccountById.write(writer, instance as FindAccountById)
                2 -> FindAccountKeyValueByIdAndKey.write(writer, instance as FindAccountKeyValueByIdAndKey)
                3 -> FindAccountsByDomainId.write(writer, instance as FindAccountsByDomainId)
                4 -> FindAccountsWithAsset.write(writer, instance as FindAccountsWithAsset)
                5 -> FindAllAssets.write(writer, instance as FindAllAssets)
                6 -> FindAllAssetsDefinitions.write(writer, instance as FindAllAssetsDefinitions)
                7 -> FindAssetById.write(writer, instance as FindAssetById)
                8 -> FindAssetDefinitionById.write(writer, instance as FindAssetDefinitionById)
                9 -> FindAssetsByName.write(writer, instance as FindAssetsByName)
                10 -> FindAssetsByAccountId.write(writer, instance as FindAssetsByAccountId)
                11 -> FindAssetsByAssetDefinitionId.write(writer, instance as FindAssetsByAssetDefinitionId)
                12 -> FindAssetsByDomainId.write(writer, instance as FindAssetsByDomainId)
                13 -> FindAssetsByDomainIdAndAssetDefinitionId.write(
                    writer,
                    instance as
                        FindAssetsByDomainIdAndAssetDefinitionId,
                )
                14 -> FindAssetQuantityById.write(writer, instance as FindAssetQuantityById)
                15 -> FindTotalAssetQuantityByAssetDefinitionId.write(
                    writer,
                    instance as
                        FindTotalAssetQuantityByAssetDefinitionId,
                )
                16 -> FindAssetKeyValueByIdAndKey.write(writer, instance as FindAssetKeyValueByIdAndKey)
                17 -> FindAssetDefinitionKeyValueByIdAndKey.write(
                    writer,
                    instance as
                        FindAssetDefinitionKeyValueByIdAndKey,
                )
                18 -> FindAllDomains.write(writer, instance as FindAllDomains)
                19 -> FindDomainById.write(writer, instance as FindDomainById)
                20 -> FindDomainKeyValueByIdAndKey.write(writer, instance as FindDomainKeyValueByIdAndKey)
                21 -> FindAllPeers.write(writer, instance as FindAllPeers)
                22 -> FindAllBlocks.write(writer, instance as FindAllBlocks)
                23 -> FindAllBlockHeaders.write(writer, instance as FindAllBlockHeaders)
                24 -> FindBlockHeaderByHash.write(writer, instance as FindBlockHeaderByHash)
                25 -> FindAllTransactions.write(writer, instance as FindAllTransactions)
                26 -> FindTransactionsByAccountId.write(writer, instance as FindTransactionsByAccountId)
                27 -> FindTransactionByHash.write(writer, instance as FindTransactionByHash)
                28 -> FindPermissionsByAccountId.write(writer, instance as FindPermissionsByAccountId)
                29 -> FindExecutorDataModel.write(writer, instance as FindExecutorDataModel)
                30 -> FindAllActiveTriggerIds.write(writer, instance as FindAllActiveTriggerIds)
                31 -> FindTriggerById.write(writer, instance as FindTriggerById)
                32 -> FindTriggerKeyValueByIdAndKey.write(writer, instance as FindTriggerKeyValueByIdAndKey)
                33 -> FindTriggersByAuthorityId.write(writer, instance as FindTriggersByAuthorityId)
                34 -> FindTriggersByAuthorityDomainId.write(
                    writer,
                    instance as
                        FindTriggersByAuthorityDomainId,
                )
                35 -> FindAllRoles.write(writer, instance as FindAllRoles)
                36 -> FindAllRoleIds.write(writer, instance as FindAllRoleIds)
                37 -> FindRoleByRoleId.write(writer, instance as FindRoleByRoleId)
                38 -> FindRolesByAccountId.write(writer, instance as FindRolesByAccountId)
                39 -> FindAllParameters.write(writer, instance as FindAllParameters)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
