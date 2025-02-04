package jp.co.soramitsu.iroha2.codegen.generator

import com.squareup.kotlinpoet.FileSpec
import jp.co.soramitsu.iroha2.codegen.blueprint.EnumBlueprint
import jp.co.soramitsu.iroha2.codegen.blueprint.StructBlueprint
import jp.co.soramitsu.iroha2.codegen.blueprint.TupleStructBlueprint
import jp.co.soramitsu.iroha2.type.EnumType
import jp.co.soramitsu.iroha2.type.IterableType
import jp.co.soramitsu.iroha2.type.MapType
import jp.co.soramitsu.iroha2.type.StructType
import jp.co.soramitsu.iroha2.type.TupleStructType
import jp.co.soramitsu.iroha2.type.Type
import java.nio.file.Path

/**
 * Generator for the entry point
 */
object GeneratorEntryPoint {
    @OptIn(ExperimentalUnsignedTypes::class)
    fun generate(
        types: Map<String, Type>,
        outputPath: Path,
    ) {
        types.values
            .mapNotNull { type ->
                when (type) {
                    is StructType -> StructBlueprint(type)
                    is EnumType -> EnumBlueprint(type)
                    is TupleStructType -> TupleStructBlueprint(type)
                    else -> null
                }
            }.forEach { type ->
                val typeSpec =
                    when (type) {
                        is StructBlueprint -> StructGenerator.generate(type)
                        is EnumBlueprint -> EnumGenerator.generate(type)
                        is TupleStructBlueprint -> TupleStructGenerator.generate(type)
                        else -> throw RuntimeException("Unexpected blueprint type: ${type::class}")
                    }
                val builder =
                    FileSpec
                        .builder(type.packageName, type.className)
                        .addType(typeSpec)
                        .addFileComment("\nAuto-generated file. DO NOT EDIT!\n")

                val isSortedMap =
                    type.properties
                        .map { it.original as? MapType }
                        .any { it?.sortedByKey == true }
                val isSortedVec =
                    type.properties
                        .map { it.original as? IterableType }
                        .any { it?.sorted == true }
                if (isSortedMap || isSortedVec) {
                    builder.addImport("jp.co.soramitsu.iroha2", "comparator")
                }
                builder.build().writeTo(outputPath)
            }
    }
}
