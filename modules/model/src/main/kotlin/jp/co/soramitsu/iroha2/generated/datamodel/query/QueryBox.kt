//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.query

import jp.co.soramitsu.iroha2.ModelEnum
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Int

/**
 * QueryBox
 *
 * Generated from 'iroha_data_model::query::QueryBox' enum
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
        public val findAllAccounts:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAllAccounts
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAllAccounts>, ScaleWriter<FindAllAccounts> {
            public const val DISCRIMINANT: Int = 0

            public override fun read(reader: ScaleCodecReader): FindAllAccounts = try {
                FindAllAccounts(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAllAccounts.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAllAccounts) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAllAccounts.write(
                    writer,
                    instance.findAllAccounts
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
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

            public override fun read(reader: ScaleCodecReader): FindAccountById = try {
                FindAccountById(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountById.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAccountById) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountById.write(
                    writer,
                    instance.findAccountById
                )
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
            jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountKeyValueByIdAndKey
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAccountKeyValueByIdAndKey>,
            ScaleWriter<FindAccountKeyValueByIdAndKey> {
            public const val DISCRIMINANT: Int = 2

            public override fun read(reader: ScaleCodecReader): FindAccountKeyValueByIdAndKey = try {
                FindAccountKeyValueByIdAndKey(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountKeyValueByIdAndKey.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAccountKeyValueByIdAndKey) =
                try {
                    jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountKeyValueByIdAndKey.write(
                        writer,
                        instance.findAccountKeyValueByIdAndKey
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
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

            public override fun read(reader: ScaleCodecReader): FindAccountsByName = try {
                FindAccountsByName(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountsByName.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAccountsByName) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountsByName.write(
                    writer,
                    instance.findAccountsByName
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
        public val findAccountsByDomainId:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountsByDomainId
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAccountsByDomainId>,
            ScaleWriter<FindAccountsByDomainId> {
            public const val DISCRIMINANT: Int = 4

            public override fun read(reader: ScaleCodecReader): FindAccountsByDomainId = try {
                FindAccountsByDomainId(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountsByDomainId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAccountsByDomainId) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountsByDomainId.write(
                    writer,
                    instance.findAccountsByDomainId
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
        public val findAccountsWithAsset:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountsWithAsset
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAccountsWithAsset>, ScaleWriter<FindAccountsWithAsset> {
            public const val DISCRIMINANT: Int = 5

            public override fun read(reader: ScaleCodecReader): FindAccountsWithAsset = try {
                FindAccountsWithAsset(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountsWithAsset.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAccountsWithAsset) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.account.FindAccountsWithAsset.write(
                    writer,
                    instance.findAccountsWithAsset
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
        public val findAllAssets: jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAllAssets
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAllAssets>, ScaleWriter<FindAllAssets> {
            public const val DISCRIMINANT: Int = 6

            public override fun read(reader: ScaleCodecReader): FindAllAssets = try {
                FindAllAssets(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAllAssets.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAllAssets) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAllAssets.write(
                    writer,
                    instance.findAllAssets
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
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
            public const val DISCRIMINANT: Int = 7

            public override fun read(reader: ScaleCodecReader): FindAllAssetsDefinitions = try {
                FindAllAssetsDefinitions(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAllAssetsDefinitions.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAllAssetsDefinitions) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAllAssetsDefinitions.write(
                    writer,
                    instance.findAllAssetsDefinitions
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
        public val findAssetById: jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetById
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAssetById>, ScaleWriter<FindAssetById> {
            public const val DISCRIMINANT: Int = 8

            public override fun read(reader: ScaleCodecReader): FindAssetById = try {
                FindAssetById(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetById.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAssetById) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetById.write(
                    writer,
                    instance.findAssetById
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAssetDefinitionById' variant
     */
    public data class FindAssetDefinitionById(
        public val findAssetDefinitionById:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetDefinitionById
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAssetDefinitionById>,
            ScaleWriter<FindAssetDefinitionById> {
            public const val DISCRIMINANT: Int = 9

            public override fun read(reader: ScaleCodecReader): FindAssetDefinitionById = try {
                FindAssetDefinitionById(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetDefinitionById.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAssetDefinitionById) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetDefinitionById.write(
                    writer,
                    instance.findAssetDefinitionById
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
        public val findAssetsByName:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByName
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAssetsByName>, ScaleWriter<FindAssetsByName> {
            public const val DISCRIMINANT: Int = 10

            public override fun read(reader: ScaleCodecReader): FindAssetsByName = try {
                FindAssetsByName(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByName.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAssetsByName) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByName.write(
                    writer,
                    instance.findAssetsByName
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
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
            public const val DISCRIMINANT: Int = 11

            public override fun read(reader: ScaleCodecReader): FindAssetsByAccountId = try {
                FindAssetsByAccountId(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByAccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAssetsByAccountId) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByAccountId.write(
                    writer,
                    instance.findAssetsByAccountId
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
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByAssetDefinitionId
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAssetsByAssetDefinitionId>,
            ScaleWriter<FindAssetsByAssetDefinitionId> {
            public const val DISCRIMINANT: Int = 12

            public override fun read(reader: ScaleCodecReader): FindAssetsByAssetDefinitionId = try {
                FindAssetsByAssetDefinitionId(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByAssetDefinitionId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAssetsByAssetDefinitionId) =
                try {
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByAssetDefinitionId.write(
                        writer,
                        instance.findAssetsByAssetDefinitionId
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
        public val findAssetsByDomainId:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByDomainId
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAssetsByDomainId>, ScaleWriter<FindAssetsByDomainId> {
            public const val DISCRIMINANT: Int = 13

            public override fun read(reader: ScaleCodecReader): FindAssetsByDomainId = try {
                FindAssetsByDomainId(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByDomainId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAssetsByDomainId) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByDomainId.write(
                    writer,
                    instance.findAssetsByDomainId
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
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByDomainIdAndAssetDefinitionId
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAssetsByDomainIdAndAssetDefinitionId>,
            ScaleWriter<FindAssetsByDomainIdAndAssetDefinitionId> {
            public const val DISCRIMINANT: Int = 14

            public override fun read(reader: ScaleCodecReader): FindAssetsByDomainIdAndAssetDefinitionId =
                try {
                    FindAssetsByDomainIdAndAssetDefinitionId(
                        jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByDomainIdAndAssetDefinitionId.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public override fun write(
                writer: ScaleCodecWriter,
                instance: FindAssetsByDomainIdAndAssetDefinitionId
            ) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetsByDomainIdAndAssetDefinitionId.write(
                    writer,
                    instance.findAssetsByDomainIdAndAssetDefinitionId
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
        public val findAssetQuantityById:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetQuantityById
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAssetQuantityById>, ScaleWriter<FindAssetQuantityById> {
            public const val DISCRIMINANT: Int = 15

            public override fun read(reader: ScaleCodecReader): FindAssetQuantityById = try {
                FindAssetQuantityById(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetQuantityById.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAssetQuantityById) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetQuantityById.write(
                    writer,
                    instance.findAssetQuantityById
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
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetKeyValueByIdAndKey
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAssetKeyValueByIdAndKey>,
            ScaleWriter<FindAssetKeyValueByIdAndKey> {
            public const val DISCRIMINANT: Int = 16

            public override fun read(reader: ScaleCodecReader): FindAssetKeyValueByIdAndKey = try {
                FindAssetKeyValueByIdAndKey(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetKeyValueByIdAndKey.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAssetKeyValueByIdAndKey) =
                try {
                    jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetKeyValueByIdAndKey.write(
                        writer,
                        instance.findAssetKeyValueByIdAndKey
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
            jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetDefinitionKeyValueByIdAndKey
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAssetDefinitionKeyValueByIdAndKey>,
            ScaleWriter<FindAssetDefinitionKeyValueByIdAndKey> {
            public const val DISCRIMINANT: Int = 17

            public override fun read(reader: ScaleCodecReader): FindAssetDefinitionKeyValueByIdAndKey =
                try {
                    FindAssetDefinitionKeyValueByIdAndKey(
                        jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetDefinitionKeyValueByIdAndKey.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public override fun write(
                writer: ScaleCodecWriter,
                instance: FindAssetDefinitionKeyValueByIdAndKey
            ) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.asset.FindAssetDefinitionKeyValueByIdAndKey.write(
                    writer,
                    instance.findAssetDefinitionKeyValueByIdAndKey
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
        public val findAllDomains:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.domain.FindAllDomains
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAllDomains>, ScaleWriter<FindAllDomains> {
            public const val DISCRIMINANT: Int = 18

            public override fun read(reader: ScaleCodecReader): FindAllDomains = try {
                FindAllDomains(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.domain.FindAllDomains.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAllDomains) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.domain.FindAllDomains.write(
                    writer,
                    instance.findAllDomains
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindDomainById' variant
     */
    public data class FindDomainById(
        public val findDomainById:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.domain.FindDomainById
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindDomainById>, ScaleWriter<FindDomainById> {
            public const val DISCRIMINANT: Int = 19

            public override fun read(reader: ScaleCodecReader): FindDomainById = try {
                FindDomainById(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.domain.FindDomainById.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindDomainById) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.domain.FindDomainById.write(
                    writer,
                    instance.findDomainById
                )
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
            jp.co.soramitsu.iroha2.generated.datamodel.query.domain.FindDomainKeyValueByIdAndKey
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindDomainKeyValueByIdAndKey>,
            ScaleWriter<FindDomainKeyValueByIdAndKey> {
            public const val DISCRIMINANT: Int = 20

            public override fun read(reader: ScaleCodecReader): FindDomainKeyValueByIdAndKey = try {
                FindDomainKeyValueByIdAndKey(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.domain.FindDomainKeyValueByIdAndKey.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindDomainKeyValueByIdAndKey) =
                try {
                    jp.co.soramitsu.iroha2.generated.datamodel.query.domain.FindDomainKeyValueByIdAndKey.write(
                        writer,
                        instance.findDomainKeyValueByIdAndKey
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
        public val findAllPeers: jp.co.soramitsu.iroha2.generated.datamodel.query.peer.FindAllPeers
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAllPeers>, ScaleWriter<FindAllPeers> {
            public const val DISCRIMINANT: Int = 21

            public override fun read(reader: ScaleCodecReader): FindAllPeers = try {
                FindAllPeers(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.peer.FindAllPeers.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAllPeers) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.peer.FindAllPeers.write(
                    writer,
                    instance.findAllPeers
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAllBlocks' variant
     */
    public data class FindAllBlocks(
        public val findAllBlocks: jp.co.soramitsu.iroha2.generated.datamodel.query.block.FindAllBlocks
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAllBlocks>, ScaleWriter<FindAllBlocks> {
            public const val DISCRIMINANT: Int = 22

            public override fun read(reader: ScaleCodecReader): FindAllBlocks = try {
                FindAllBlocks(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.block.FindAllBlocks.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAllBlocks) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.block.FindAllBlocks.write(
                    writer,
                    instance.findAllBlocks
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAllBlockHeaders' variant
     */
    public data class FindAllBlockHeaders(
        public val findAllBlockHeaders:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.block.FindAllBlockHeaders
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAllBlockHeaders>, ScaleWriter<FindAllBlockHeaders> {
            public const val DISCRIMINANT: Int = 23

            public override fun read(reader: ScaleCodecReader): FindAllBlockHeaders = try {
                FindAllBlockHeaders(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.block.FindAllBlockHeaders.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAllBlockHeaders) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.block.FindAllBlockHeaders.write(
                    writer,
                    instance.findAllBlockHeaders
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
        public val findBlockHeaderByHash:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.block.FindBlockHeaderByHash
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindBlockHeaderByHash>, ScaleWriter<FindBlockHeaderByHash> {
            public const val DISCRIMINANT: Int = 24

            public override fun read(reader: ScaleCodecReader): FindBlockHeaderByHash = try {
                FindBlockHeaderByHash(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.block.FindBlockHeaderByHash.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindBlockHeaderByHash) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.block.FindBlockHeaderByHash.write(
                    writer,
                    instance.findBlockHeaderByHash
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
        public val findAllTransactions:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.transaction.FindAllTransactions
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAllTransactions>, ScaleWriter<FindAllTransactions> {
            public const val DISCRIMINANT: Int = 25

            public override fun read(reader: ScaleCodecReader): FindAllTransactions = try {
                FindAllTransactions(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.transaction.FindAllTransactions.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAllTransactions) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.transaction.FindAllTransactions.write(
                    writer,
                    instance.findAllTransactions
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
            jp.co.soramitsu.iroha2.generated.datamodel.query.transaction.FindTransactionsByAccountId
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindTransactionsByAccountId>,
            ScaleWriter<FindTransactionsByAccountId> {
            public const val DISCRIMINANT: Int = 26

            public override fun read(reader: ScaleCodecReader): FindTransactionsByAccountId = try {
                FindTransactionsByAccountId(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.transaction.FindTransactionsByAccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindTransactionsByAccountId) =
                try {
                    jp.co.soramitsu.iroha2.generated.datamodel.query.transaction.FindTransactionsByAccountId.write(
                        writer,
                        instance.findTransactionsByAccountId
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
        public val findTransactionByHash:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.transaction.FindTransactionByHash
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindTransactionByHash>, ScaleWriter<FindTransactionByHash> {
            public const val DISCRIMINANT: Int = 27

            public override fun read(reader: ScaleCodecReader): FindTransactionByHash = try {
                FindTransactionByHash(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.transaction.FindTransactionByHash.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindTransactionByHash) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.transaction.FindTransactionByHash.write(
                    writer,
                    instance.findTransactionByHash
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
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
            public const val DISCRIMINANT: Int = 28

            public override fun read(reader: ScaleCodecReader): FindPermissionTokensByAccountId = try {
                FindPermissionTokensByAccountId(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.permissions.FindPermissionTokensByAccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindPermissionTokensByAccountId) =
                try {
                    jp.co.soramitsu.iroha2.generated.datamodel.query.permissions.FindPermissionTokensByAccountId.write(
                        writer,
                        instance.findPermissionTokensByAccountId
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindAllPermissionTokenDefinitions' variant
     */
    public data class FindAllPermissionTokenDefinitions(
        public val findAllPermissionTokenDefinitions:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.permissions.FindAllPermissionTokenDefinitions
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAllPermissionTokenDefinitions>,
            ScaleWriter<FindAllPermissionTokenDefinitions> {
            public const val DISCRIMINANT: Int = 29

            public override fun read(reader: ScaleCodecReader): FindAllPermissionTokenDefinitions = try {
                FindAllPermissionTokenDefinitions(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.permissions.FindAllPermissionTokenDefinitions.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(
                writer: ScaleCodecWriter,
                instance: FindAllPermissionTokenDefinitions
            ) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.permissions.FindAllPermissionTokenDefinitions.write(
                    writer,
                    instance.findAllPermissionTokenDefinitions
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
        public val findAllActiveTriggerIds:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.trigger.FindAllActiveTriggerIds
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindAllActiveTriggerIds>,
            ScaleWriter<FindAllActiveTriggerIds> {
            public const val DISCRIMINANT: Int = 30

            public override fun read(reader: ScaleCodecReader): FindAllActiveTriggerIds = try {
                FindAllActiveTriggerIds(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.trigger.FindAllActiveTriggerIds.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAllActiveTriggerIds) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.trigger.FindAllActiveTriggerIds.write(
                    writer,
                    instance.findAllActiveTriggerIds
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
        public val findTriggerById:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.trigger.FindTriggerById
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindTriggerById>, ScaleWriter<FindTriggerById> {
            public const val DISCRIMINANT: Int = 31

            public override fun read(reader: ScaleCodecReader): FindTriggerById = try {
                FindTriggerById(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.trigger.FindTriggerById.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindTriggerById) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.trigger.FindTriggerById.write(
                    writer,
                    instance.findTriggerById
                )
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
            jp.co.soramitsu.iroha2.generated.datamodel.query.trigger.FindTriggerKeyValueByIdAndKey
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindTriggerKeyValueByIdAndKey>,
            ScaleWriter<FindTriggerKeyValueByIdAndKey> {
            public const val DISCRIMINANT: Int = 32

            public override fun read(reader: ScaleCodecReader): FindTriggerKeyValueByIdAndKey = try {
                FindTriggerKeyValueByIdAndKey(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.trigger.FindTriggerKeyValueByIdAndKey.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindTriggerKeyValueByIdAndKey) =
                try {
                    jp.co.soramitsu.iroha2.generated.datamodel.query.trigger.FindTriggerKeyValueByIdAndKey.write(
                        writer,
                        instance.findTriggerKeyValueByIdAndKey
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindTriggersByDomainId' variant
     */
    public data class FindTriggersByDomainId(
        public val findTriggersByDomainId:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.trigger.FindTriggersByDomainId
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<FindTriggersByDomainId>,
            ScaleWriter<FindTriggersByDomainId> {
            public const val DISCRIMINANT: Int = 33

            public override fun read(reader: ScaleCodecReader): FindTriggersByDomainId = try {
                FindTriggersByDomainId(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.trigger.FindTriggersByDomainId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindTriggersByDomainId) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.trigger.FindTriggersByDomainId.write(
                    writer,
                    instance.findTriggersByDomainId
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
        public val findAllRoles: jp.co.soramitsu.iroha2.generated.datamodel.query.role.FindAllRoles
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAllRoles>, ScaleWriter<FindAllRoles> {
            public const val DISCRIMINANT: Int = 34

            public override fun read(reader: ScaleCodecReader): FindAllRoles = try {
                FindAllRoles(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.role.FindAllRoles.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAllRoles) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.role.FindAllRoles.write(
                    writer,
                    instance.findAllRoles
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAllRoleIds' variant
     */
    public data class FindAllRoleIds(
        public val findAllRoleIds: jp.co.soramitsu.iroha2.generated.datamodel.query.role.FindAllRoleIds
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindAllRoleIds>, ScaleWriter<FindAllRoleIds> {
            public const val DISCRIMINANT: Int = 35

            public override fun read(reader: ScaleCodecReader): FindAllRoleIds = try {
                FindAllRoleIds(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.role.FindAllRoleIds.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindAllRoleIds) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.role.FindAllRoleIds.write(
                    writer,
                    instance.findAllRoleIds
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindRoleByRoleId' variant
     */
    public data class FindRoleByRoleId(
        public val findRoleByRoleId:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.role.FindRoleByRoleId
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindRoleByRoleId>, ScaleWriter<FindRoleByRoleId> {
            public const val DISCRIMINANT: Int = 36

            public override fun read(reader: ScaleCodecReader): FindRoleByRoleId = try {
                FindRoleByRoleId(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.role.FindRoleByRoleId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindRoleByRoleId) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.role.FindRoleByRoleId.write(
                    writer,
                    instance.findRoleByRoleId
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
        public val findRolesByAccountId:  
            jp.co.soramitsu.iroha2.generated.datamodel.query.role.FindRolesByAccountId
    ) : QueryBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<FindRolesByAccountId>, ScaleWriter<FindRolesByAccountId> {
            public const val DISCRIMINANT: Int = 37

            public override fun read(reader: ScaleCodecReader): FindRolesByAccountId = try {
                FindRolesByAccountId(
                    jp.co.soramitsu.iroha2.generated.datamodel.query.role.FindRolesByAccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: FindRolesByAccountId) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.query.role.FindRolesByAccountId.write(
                    writer,
                    instance.findRolesByAccountId
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<QueryBox>, ScaleWriter<QueryBox> {
        public override fun read(reader: ScaleCodecReader): QueryBox = when (
            val discriminant =
                reader.readUByte().toInt()
        ) {
            0 -> FindAllAccounts.read(reader)
            1 -> FindAccountById.read(reader)
            2 -> FindAccountKeyValueByIdAndKey.read(reader)
            3 -> FindAccountsByName.read(reader)
            4 -> FindAccountsByDomainId.read(reader)
            5 -> FindAccountsWithAsset.read(reader)
            6 -> FindAllAssets.read(reader)
            7 -> FindAllAssetsDefinitions.read(reader)
            8 -> FindAssetById.read(reader)
            9 -> FindAssetDefinitionById.read(reader)
            10 -> FindAssetsByName.read(reader)
            11 -> FindAssetsByAccountId.read(reader)
            12 -> FindAssetsByAssetDefinitionId.read(reader)
            13 -> FindAssetsByDomainId.read(reader)
            14 -> FindAssetsByDomainIdAndAssetDefinitionId.read(reader)
            15 -> FindAssetQuantityById.read(reader)
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
            28 -> FindPermissionTokensByAccountId.read(reader)
            29 -> FindAllPermissionTokenDefinitions.read(reader)
            30 -> FindAllActiveTriggerIds.read(reader)
            31 -> FindTriggerById.read(reader)
            32 -> FindTriggerKeyValueByIdAndKey.read(reader)
            33 -> FindTriggersByDomainId.read(reader)
            34 -> FindAllRoles.read(reader)
            35 -> FindAllRoleIds.read(reader)
            36 -> FindRoleByRoleId.read(reader)
            37 -> FindRolesByAccountId.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        public override fun write(writer: ScaleCodecWriter, instance: QueryBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> FindAllAccounts.write(writer, instance as FindAllAccounts)
                1 -> FindAccountById.write(writer, instance as FindAccountById)
                2 -> FindAccountKeyValueByIdAndKey.write(writer, instance as FindAccountKeyValueByIdAndKey)
                3 -> FindAccountsByName.write(writer, instance as FindAccountsByName)
                4 -> FindAccountsByDomainId.write(writer, instance as FindAccountsByDomainId)
                5 -> FindAccountsWithAsset.write(writer, instance as FindAccountsWithAsset)
                6 -> FindAllAssets.write(writer, instance as FindAllAssets)
                7 -> FindAllAssetsDefinitions.write(writer, instance as FindAllAssetsDefinitions)
                8 -> FindAssetById.write(writer, instance as FindAssetById)
                9 -> FindAssetDefinitionById.write(writer, instance as FindAssetDefinitionById)
                10 -> FindAssetsByName.write(writer, instance as FindAssetsByName)
                11 -> FindAssetsByAccountId.write(writer, instance as FindAssetsByAccountId)
                12 -> FindAssetsByAssetDefinitionId.write(writer, instance as FindAssetsByAssetDefinitionId)
                13 -> FindAssetsByDomainId.write(writer, instance as FindAssetsByDomainId)
                14 -> FindAssetsByDomainIdAndAssetDefinitionId.write(
                    writer,
                    instance as
                        FindAssetsByDomainIdAndAssetDefinitionId
                )
                15 -> FindAssetQuantityById.write(writer, instance as FindAssetQuantityById)
                16 -> FindAssetKeyValueByIdAndKey.write(writer, instance as FindAssetKeyValueByIdAndKey)
                17 -> FindAssetDefinitionKeyValueByIdAndKey.write(
                    writer,
                    instance as
                        FindAssetDefinitionKeyValueByIdAndKey
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
                28 -> FindPermissionTokensByAccountId.write(
                    writer,
                    instance as
                        FindPermissionTokensByAccountId
                )
                29 -> FindAllPermissionTokenDefinitions.write(
                    writer,
                    instance as
                        FindAllPermissionTokenDefinitions
                )
                30 -> FindAllActiveTriggerIds.write(writer, instance as FindAllActiveTriggerIds)
                31 -> FindTriggerById.write(writer, instance as FindTriggerById)
                32 -> FindTriggerKeyValueByIdAndKey.write(writer, instance as FindTriggerKeyValueByIdAndKey)
                33 -> FindTriggersByDomainId.write(writer, instance as FindTriggersByDomainId)
                34 -> FindAllRoles.write(writer, instance as FindAllRoles)
                35 -> FindAllRoleIds.write(writer, instance as FindAllRoleIds)
                36 -> FindRoleByRoleId.write(writer, instance as FindRoleByRoleId)
                37 -> FindRolesByAccountId.write(writer, instance as FindRolesByAccountId)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
