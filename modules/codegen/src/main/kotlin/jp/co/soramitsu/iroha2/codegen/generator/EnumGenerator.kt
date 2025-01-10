package jp.co.soramitsu.iroha2.codegen.generator

import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeSpec
import jp.co.soramitsu.iroha2.ModelEnum
import jp.co.soramitsu.iroha2.codegen.blueprint.EnumBlueprint

/**
 * Generator for [EnumBlueprint]
 */
object EnumGenerator : AbstractGenerator<EnumBlueprint>() {

    override fun implKDoc(blueprint: EnumBlueprint, clazz: TypeSpec.Builder) {
        super.implKDoc(blueprint, clazz)
        clazz.addKdoc("\n\nGenerated from '${blueprint.source.name}' enum")
    }

    override fun implClassModifiers(blueprint: EnumBlueprint, clazz: TypeSpec.Builder) {
        clazz.addModifiers(KModifier.SEALED)
    }

    // class generated from Rust Enums no need to have constructor due they are not intended
    // to be instantiated
    override fun implConstructor(blueprint: EnumBlueprint, clazz: TypeSpec.Builder) = Unit

    override fun implFunctions(blueprint: EnumBlueprint, clazz: TypeSpec.Builder) {
        clazz.addFunction(
            FunSpec.builder("discriminant")
                .addModifiers(KModifier.ABSTRACT)
                .returns(Int::class, CodeBlock.of("Discriminator of variant in enum"))
                .build(),
        )
        if (true in blueprint.variants.map { it.properties.isEmpty() }) {
            clazz.addFunction(equalsFun(blueprint)).addFunction(hashCodeFun(blueprint))
        }
    }

    override fun implInnerClasses(blueprint: EnumBlueprint, clazz: TypeSpec.Builder) {
        for (variant in blueprint.variants) {
            clazz.addType(EnumVariantGenerator.generate(variant))
        }
    }

    override fun scaleReaderCode(blueprint: EnumBlueprint): CodeBlock {
        val codeBlock = CodeBlock.builder().add("return when(val discriminant = reader.readUByte()) {\n")
        val whenFlow = blueprint.variants.joinToString("\n") {
            CodeBlock.of("\t${it.discriminant} -> ${it.className}.read(reader)").toString()
        }
        codeBlock.add(whenFlow)
        codeBlock.add("\n\telse -> throw RuntimeException(\"Unresolved discriminant of the enum variant: \$discriminant\")")
        return codeBlock.add("}").build()
    }

    override fun scaleWriterCode(blueprint: EnumBlueprint): CodeBlock {
        val codeBlock = CodeBlock.builder().add("writer.directWrite(instance.discriminant())\n")
        codeBlock.add("when(val discriminant = instance.discriminant()) {\n")
        val whenFlow = blueprint.variants.joinToString("\n") {
            CodeBlock.of("\t${it.discriminant} -> ${it.className}.write(writer, instance as ${it.className})")
                .toString()
        }
        codeBlock.add(whenFlow)
        codeBlock.add("\n\telse -> throw RuntimeException(\"Unresolved discriminant of the enum variant: \$discriminant\")")
        return codeBlock.add("}").build()
    }

    override fun implSuperClasses(blueprint: EnumBlueprint, clazz: TypeSpec.Builder) {
        super.implSuperClasses(blueprint, clazz)
        clazz.addSuperinterface(ModelEnum::class)
    }

    private fun hashCodeFun(blueprint: EnumBlueprint): FunSpec {
        return FunSpec.builder("hashCode")
            .addCode(hashcodeCode(blueprint))
            .addModifiers(KModifier.OVERRIDE)
            .returns(Int::class.java)
            .build()
    }

    private fun equalsFun(blueprint: EnumBlueprint): FunSpec {
        return FunSpec.builder("equals")
            .addParameter(ParameterSpec.builder("other", ANY_TYPE.copy(nullable = true)).build())
            .addCode(equalsCode(blueprint))
            .addModifiers(KModifier.OVERRIDE)
            .returns(Boolean::class.java)
            .build()
    }

    private fun equalsCode(blueprint: EnumBlueprint): CodeBlock {
        val codeBlock = CodeBlock.builder().add("return when(this) {\n")

        blueprint.variants.filter {
            it.properties.isEmpty()
        }.joinToString("\n") {
            CodeBlock.of("\tis ${it.className} -> ${it.className}.equals(this, other)").toString()
        }.also { whenFlow ->
            codeBlock.add(whenFlow)
        }
        codeBlock.add("\n\telse -> super.equals(other)")
        return codeBlock.add("}").build()
    }

    private fun hashcodeCode(blueprint: EnumBlueprint): CodeBlock {
        val codeBlock = CodeBlock.builder().add("return when(this) {\n")

        blueprint.variants.filter {
            it.properties.isEmpty()
        }.joinToString("\n") {
            CodeBlock.of("\tis ${it.className} -> ${it.className}.hashCode()").toString()
        }.also { whenFlow ->
            codeBlock.add(whenFlow)
        }
        codeBlock.add("\n\telse -> super.hashCode()")
        return codeBlock.add("}").build()
    }
}
