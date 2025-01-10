package jp.co.soramitsu.iroha2.codegen.generator

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.WildcardTypeName
import jp.co.soramitsu.iroha2.codegen.blueprint.Blueprint
import jp.co.soramitsu.iroha2.type.CompositeType

/**
 * Basic generator for all kinds of [blueprints][Blueprint]
 */
abstract class AbstractGenerator<T : Blueprint<*>> {

    companion object {
        val ANY_TYPE = ClassName("kotlin", "Any")
    }

    fun generate(blueprint: T): TypeSpec = pipelineClass(blueprint)

    open fun pipelineClass(blueprint: T): TypeSpec {
        val clazz = TypeSpec.classBuilder(ClassName(blueprint.packageName, blueprint.className))
        implGenerics(blueprint, clazz)
        implSuperClasses(blueprint, clazz)
        implClassModifiers(blueprint, clazz)
        implKDoc(blueprint, clazz)
        implConstructor(blueprint, clazz)
        implClassBody(blueprint, clazz)

        return clazz.build()
    }

    open fun implGenerics(blueprint: T, clazz: TypeSpec.Builder) {
        if (blueprint.source is CompositeType) {
            val generics = blueprint.source.generics
            for (i in generics.indices) {
                clazz.addTypeVariable(TypeVariableName.Companion.invoke("T$i"))
            }
        }
    }

    open fun implClassBody(blueprint: T, clazz: TypeSpec.Builder) {
        implFunctions(blueprint, clazz)
        implInnerClasses(blueprint, clazz)
        clazz.addType(implCompanions(blueprint, clazz).build())
    }

    open fun implCompanions(blueprint: T, clazz: TypeSpec.Builder): TypeSpec.Builder {
        val thisType = ClassName(
            blueprint.packageName,
            blueprint.className,
        ).let { className ->
            when (blueprint.source is CompositeType && blueprint.source.generics.isNotEmpty()) {
                true -> className.parameterizedBy(
                    blueprint.source.generics.map { WildcardTypeName.producerOf(ANY_TYPE) },
                )
                false -> className
            }
        }
        val companionBuilder = TypeSpec.companionObjectBuilder()
            .addSuperinterface(SCALE_READER.parameterizedBy(thisType))
            .addSuperinterface(SCALE_WRITER.parameterizedBy(thisType))
            .addFunction(readFun(thisType, blueprint))
            .addFunction(writeFun(thisType, blueprint))

        return when {
            blueprint.properties.isEmpty() && KModifier.SEALED !in clazz.modifiers -> {
                companionBuilder.addFunction(variantEqualsFun(blueprint)).addFunction(variantHashcodeFun(blueprint))
            }
            else -> companionBuilder
        }
    }

    open fun scaleReaderCode(blueprint: T): CodeBlock {
        var result = CodeBlock.builder()
            .add("return try {\n")
            .indent()
        result.add("${blueprint.className}(\n").indent()
        val codeBlocks = blueprint.properties.map { resolveScaleReadImpl(it.original) }.toList()
        for (cb in codeBlocks) {
            result = result.add(cb).add(",\n")
        }
        return result
            .unindent()
            .add(")\n")
            .unindent()
            .add("} catch (ex: Exception) {\n").indent()
            .add("throw %M(ex)\n", SCALE_CODEC_EX_WRAPPER).unindent()
            .add("}")
            .build()
    }

    open fun scaleWriterCode(blueprint: T): CodeBlock {
        var result = CodeBlock.builder()
            .add("return try {\n")
            .indent()
        val codeBlocks = blueprint.properties.map {
            resolveScaleWriteImpl(
                it.original,
                CodeBlock.of("instance.%N", it.name),
            )
        }
        for (cb in codeBlocks) {
            result = result.add(cb).add("\n")
        }
        return result
            .unindent()
            .add("} catch (ex: Exception) {\n").indent()
            .add("throw %M(ex)\n", SCALE_CODEC_EX_WRAPPER).unindent()
            .add("}")
            .build()
    }

    open fun implFunctions(blueprint: T, clazz: TypeSpec.Builder) = Unit

    open fun implInnerClasses(blueprint: T, clazz: TypeSpec.Builder) = Unit

    open fun implClassModifiers(blueprint: T, clazz: TypeSpec.Builder) {
        if (blueprint.properties.isNotEmpty()) {
            clazz.addModifiers(KModifier.DATA)
        }
    }

    open fun implSuperClasses(blueprint: T, clazz: TypeSpec.Builder) = Unit

    open fun implConstructor(blueprint: T, clazz: TypeSpec.Builder) {
        if (blueprint.properties.isEmpty()) {
            return
        }
        val constructorBuilder = FunSpec.constructorBuilder()
        for ((name, type) in blueprint.properties) {
            constructorBuilder.addParameter(
                ParameterSpec.builder(name, type)
                    .let { it.takeIf { type.isNullable }?.defaultValue("null") ?: it }
                    .build(),
            )
            clazz.addProperty(
                PropertySpec.builder(name, type)
                    .initializer(name)
                    .build(),
            )
        }
        clazz.primaryConstructor(constructorBuilder.build())
    }

    open fun implKDoc(blueprint: T, clazz: TypeSpec.Builder) {
        clazz.addKdoc(blueprint.className)
    }

    private fun writeFun(type: TypeName, blueprint: T) =
        FunSpec.builder("write")
            .addParameter(ParameterSpec.builder("writer", SCALE_CODEC_WRITER).build())
            .addParameter(ParameterSpec.builder("instance", type).build())
            .addCode(scaleWriterCode(blueprint))
            .addModifiers(KModifier.OVERRIDE)
            .build()

    private fun readFun(type: TypeName, blueprint: T) =
        FunSpec.builder("read")
            .addParameter(ParameterSpec.builder("reader", SCALE_CODEC_READER).build())
            .addCode(scaleReaderCode(blueprint))
            .addModifiers(KModifier.OVERRIDE)
            .returns(type)
            .build()

    private fun variantEqualsFun(blueprint: T): FunSpec {
        val variantType = ClassName(blueprint.packageName, blueprint.className)
        val code = """return when (o2) {
            null -> false
            else -> o2::class == o1::class
        }
        """.trimIndent()

        return FunSpec.builder("equals")
            .addParameter(ParameterSpec.builder("o1", variantType).build())
            .addParameter(ParameterSpec.builder("o2", ANY_TYPE.copy(nullable = true)).build())
            .addCode(code)
            .returns(Boolean::class)
            .build()
    }

    private fun variantHashcodeFun(blueprint: T): FunSpec {
        val code = "return \"${blueprint.packageName}.${blueprint.className}\".hashCode()"
            .replace("jp.co.soramitsu.iroha2.generated.", "")
        return FunSpec.builder("hashCode")
            .addCode(code)
            .addModifiers(KModifier.OVERRIDE)
            .returns(Int::class)
            .build()
    }

    protected fun TypeName.extractName() = when (this) {
        is ParameterizedTypeName -> this.rawType.canonicalName
        is ClassName -> this.canonicalName
        else -> throw RuntimeException("Unexpected type: $this")
    }
}
