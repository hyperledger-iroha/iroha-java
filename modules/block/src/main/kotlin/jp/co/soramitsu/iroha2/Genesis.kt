package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.ChainId
import jp.co.soramitsu.iroha2.generated.InstructionBox
import jp.co.soramitsu.iroha2.generated.Metadata
import jp.co.soramitsu.iroha2.generated.NewAccount
import jp.co.soramitsu.iroha2.generated.NewAssetDefinition
import jp.co.soramitsu.iroha2.generated.NewDomain
import jp.co.soramitsu.iroha2.generated.Parameter
import jp.co.soramitsu.iroha2.generated.RawGenesisTransaction
import jp.co.soramitsu.iroha2.generated.RegisterBox
import jp.co.soramitsu.iroha2.generated.RegisterOfAccount
import jp.co.soramitsu.iroha2.generated.RegisterOfAssetDefinition
import jp.co.soramitsu.iroha2.generated.RegisterOfDomain
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

/**
 * Genesis block is used to initialise a blockchain
 */
open class Genesis(open val transaction: RawGenesisTransaction) {
    /**
     * Write genesis to file
     */
    fun writeToFile(path: Path): Path = Files.write(
        path,
        asJson().toByteArray(Charsets.UTF_8),
        StandardOpenOption.TRUNCATE_EXISTING,
        StandardOpenOption.CREATE,
    )

    /**
     * Represent genesis as JSON
     */
    fun asJson(): String = JSON_SERDE.writeValueAsString(this.transaction)

    companion object {

        const val EXECUTOR_FILE_NAME = "executor.wasm"

        /**
         * List of genesis blocks to single block with unique instructions
         */
        fun List<Genesis>.toSingle(): Genesis {
            val uniqueIsi: MutableSet<InstructionBox> = mutableSetOf()
            val uniqueParams: MutableSet<Parameter> = mutableSetOf()

            this.forEach { genesis ->
                uniqueIsi.addAll(genesis.transaction.instructions)
                uniqueParams.addAll(genesis.transaction.parameters)
            }
            return Genesis(
                RawGenesisTransaction(
                    ChainId("00000000-0000-0000-0000-000000000000"),
                    EXECUTOR_FILE_NAME,
                    uniqueParams.toList(),
                    uniqueIsi.mergeMetadata().toList(),
                    emptyList(),
                ),
            )
        }

        private fun MutableSet<InstructionBox>.mergeMetadata(): List<InstructionBox> {
            // entity id to its metadata
            val metadataMap = mutableMapOf<Any, Metadata>()

            // only for InstructionBox.Register
            this.extractRegisterBoxes().forEach { idBox ->
                metadataMap.putMergedMetadata(idBox)
            }
            this.findIsiToReplace(metadataMap).forEach { (idToMetadata, toReplace) ->
                toReplace.forEach { isi -> this.remove(isi) }

                val idBox = toReplace.first().registerBox
                this.add(InstructionBox.Register(idBox.addMetadata(idToMetadata.second)))
            }

            return this.sorted()
        }

        private fun MutableSet<InstructionBox>.sorted() = this.sortedWith(
            compareByDescending { instruction ->
                when (instruction) {
                    is InstructionBox.Register -> when (instruction.cast<InstructionBox.Register>().registerBox) {
                        is RegisterBox.Domain -> 5
                        is RegisterBox.Account -> 4
                        is RegisterBox.AssetDefinition -> 3
                        is RegisterBox.Role -> 2
                        else -> 1
                    }

                    else -> -1
                }
            },
        )

        private fun RegisterBox.addMetadata(metadata: Metadata) = when (this) {
            is RegisterBox.Account -> RegisterBox.Account(
                RegisterOfAccount(
                    NewAccount(this.registerOfAccount.`object`.id, metadata),
                ),
            )

            is RegisterBox.Domain -> RegisterBox.Domain(
                RegisterOfDomain(
                    NewDomain(this.registerOfDomain.`object`.id, this.registerOfDomain.`object`.logo, metadata),
                ),
            )

            is RegisterBox.AssetDefinition -> RegisterBox.AssetDefinition(
                RegisterOfAssetDefinition(
                    NewAssetDefinition(
                        this.registerOfAssetDefinition.`object`.id,
                        this.registerOfAssetDefinition.`object`.type,
                        this.registerOfAssetDefinition.`object`.mintable,
                        metadata = metadata,
                    ),
                ),
            )

            else -> throw IrohaSdkException("Unexpected type ${this::class}")
        }

        private fun MutableMap<Any, Metadata>.putMergedMetadata(idBox: RegisterBox) {
            fun MutableMap<Any, Metadata>.putOrMerge(
                id: Any,
                metadata: Metadata,
            ) = when (val value = this[id]) {
                null -> this[id] = metadata
                else -> {
                    metadata.sortedMapOfName.forEach { (k, v) ->
                        if (value.sortedMapOfName.containsKey(k) && value.sortedMapOfName[k] != v) {
                            throw IrohaSdkException("Value for this key is already set in metadata")
                        }
                    }
                    this[id] = this[id]!!.merge(metadata)
                }
            }

            when (idBox) {
                is RegisterBox.Account -> this.putOrMerge(idBox.registerOfAccount.`object`.id, idBox.registerOfAccount.`object`.metadata)
                is RegisterBox.Domain -> this.putOrMerge(idBox.registerOfDomain.`object`.id, idBox.registerOfDomain.`object`.metadata)
                is RegisterBox.AssetDefinition -> this.putOrMerge(
                    idBox.registerOfAssetDefinition.`object`.id,
                    idBox.registerOfAssetDefinition.`object`.metadata,
                )

                else -> {}
            }
        }

        private fun MutableSet<InstructionBox>.findIsiToReplace(
            metadata: Map<Any, Metadata>,
        ): MutableMap<Pair<Any, Metadata>, MutableList<InstructionBox.Register>> {
            val isiToReplace =
                mutableMapOf<Pair<Any, Metadata>, MutableList<InstructionBox.Register>>()

            this.forEach { instruction ->
                runCatching {
                    instruction.cast<InstructionBox.Register>().registerBox
                }.onSuccess { idBox ->
                    when (idBox) {
                        is RegisterBox.Account -> idBox.registerOfAccount.`object`.id.let { id -> id to metadata[id]!! }
                        is RegisterBox.Domain -> idBox.registerOfDomain.`object`.id.let { id -> id to metadata[id]!! }
                        is RegisterBox.AssetDefinition -> idBox.registerOfAssetDefinition.`object`.id.let { id -> id to metadata[id]!! }
                        else -> null
                    }?.takeIf { it.second.sortedMapOfName.isNotEmpty() }?.let {
                        isiToReplace.merge(it, mutableListOf(instruction.cast())) { old, new ->
                            old.plus(new).toMutableList()
                        }
                    }
                }
            }
            return isiToReplace
        }
    }
}
