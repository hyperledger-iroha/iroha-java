package jp.co.soramitsu.iroha2.codegen.generator

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asTypeName
import jp.co.soramitsu.iroha2.codegen.blueprint.StructBlueprint

/**
 * Generator for [StructBlueprint]
 */
object StructGenerator : AbstractGenerator<StructBlueprint>() {

    override fun implKDoc(blueprint: StructBlueprint, clazz: TypeSpec.Builder) {
        super.implKDoc(blueprint, clazz)
        clazz.addKdoc("\n\nGenerated from '${blueprint.source.name}' regular structure")
    }

    override fun implFunctions(blueprint: StructBlueprint, clazz: TypeSpec.Builder) {
        super.implFunctions(blueprint, clazz)

        if (blueprint.properties.any { it.typeName.extractName() == ByteArray::class.qualifiedName }) {
            clazz.addFunction(equalsFun(blueprint)).addFunction(hashCodeFun(blueprint))
        }
    }

    private fun hashCodeFun(blueprint: StructBlueprint): FunSpec {
        return FunSpec.builder("hashCode")
            .addModifiers(KModifier.OVERRIDE)
            .returns(Int::class)
            .apply {
                when (blueprint.properties.isEmpty()) {
                    true -> addStatement("return 0")
                    false -> {
                        val firstProperty = blueprint.properties[0]
                        when (blueprint.properties[0].typeName) {
                            ByteArray::class.asTypeName() -> addCode("return %L.%L()", firstProperty.name, "contentHashCode")
                            else -> addCode("return %L.%L()", firstProperty.name, "hashCode")
                        }
                        for ((property, type) in blueprint.properties.drop(1)) {
                            addCode(" * 31")
                            when (type) {
                                ByteArray::class.asTypeName() -> addCode(" + %L.contentHashCode()", property)
                                else -> addCode(" + %L.hashCode()", property)
                            }
                        }
                        addCode("\n")
                    }
                }
            }.build()
    }

    private fun equalsFun(blueprint: StructBlueprint): FunSpec {
        return FunSpec.builder("equals")
            .addModifiers(KModifier.OVERRIDE)
            .addParameter(ParameterSpec.builder("other", ANY_TYPE.copy(nullable = true)).build())
            .returns(Boolean::class)
            .addStatement("if (this === other) return true")
            .addStatement("if (other !is %L) return false", blueprint.className)
            .apply {
                for ((property, type) in blueprint.properties) {
                    when (type) {
                        ByteArray::class.asTypeName() -> addStatement("if (!%L.contentEquals(other.%L)) return false", property, property)
                        else -> addStatement("if (%L != other.%L) return false", property, property)
                    }
                }
                addStatement("return true")
            }.build()
    }
}
