package jp.co.soramitsu.iroha2.codegen.generator

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asClassName
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.codec.reader.CompactBigIntReader
import jp.co.soramitsu.iroha2.codec.writer.CompactULongWriter
import jp.co.soramitsu.iroha2.codegen.resolveKotlinType
import jp.co.soramitsu.iroha2.type.ArrayType
import jp.co.soramitsu.iroha2.type.BooleanType
import jp.co.soramitsu.iroha2.type.CompactType
import jp.co.soramitsu.iroha2.type.CompositeType
import jp.co.soramitsu.iroha2.type.FixedPointType
import jp.co.soramitsu.iroha2.type.I128Type
import jp.co.soramitsu.iroha2.type.I256Type
import jp.co.soramitsu.iroha2.type.I32Type
import jp.co.soramitsu.iroha2.type.I64Type
import jp.co.soramitsu.iroha2.type.MapType
import jp.co.soramitsu.iroha2.type.OptionType
import jp.co.soramitsu.iroha2.type.SetType
import jp.co.soramitsu.iroha2.type.StringType
import jp.co.soramitsu.iroha2.type.Type
import jp.co.soramitsu.iroha2.type.U128Type
import jp.co.soramitsu.iroha2.type.U16Type
import jp.co.soramitsu.iroha2.type.U256Type
import jp.co.soramitsu.iroha2.type.U32Type
import jp.co.soramitsu.iroha2.type.U64Type
import jp.co.soramitsu.iroha2.type.U8Type
import jp.co.soramitsu.iroha2.type.VecType

val SCALE_READER = ScaleReader::class.asClassName()
val SCALE_CODEC_READER = ScaleCodecReader::class.asClassName()
val SCALE_WRITER = ScaleWriter::class.asClassName()
val SCALE_CODEC_WRITER = ScaleCodecWriter::class.asClassName()
val COMPACT_ULONG_WRITER = CompactULongWriter::class.asClassName()
val COMPACT_BIG_INT_READER = CompactBigIntReader::class.asClassName()
val SCALE_CODEC_EX_WRAPPER = MemberName("jp.co.soramitsu.iroha2", "wrapException")
val TO_FIXED_POINT = MemberName("jp.co.soramitsu.iroha2", "toFixedPoint")
val FROM_FIXED_POINT = MemberName("jp.co.soramitsu.iroha2", "fromFixedPoint")

/**
 * Resolve Scale Reader for a given [type]
 */
fun resolveScaleReadImpl(type: Type): CodeBlock {
    return when (type) {
        is ArrayType -> type.scaleReadImpl()
        is VecType -> type.scaleReadImpl()
        is SetType -> CodeBlock.of(
            "reader.readSet(reader.readCompactInt()) {%L}",
            resolveScaleReadImpl(type.innerType.requireValue()),
        )
        is MapType -> CodeBlock.of(
            "reader.readMap(reader.readCompactInt(), {%1L}, {%2L})",
            resolveScaleReadImpl(type.key.requireValue()),
            resolveScaleReadImpl(type.value.requireValue()),
        )
        is U8Type -> CodeBlock.of("reader.readUByte().toShort()")
        is U16Type -> CodeBlock.of("reader.readUint16()")
        is U32Type -> CodeBlock.of("reader.readUint32()")
        is U64Type -> CodeBlock.of("reader.readUint64()")
        is U128Type -> CodeBlock.of("reader.readUint128()")
        is U256Type -> CodeBlock.of("reader.readUint256()")
        is I32Type -> CodeBlock.of("reader.readInt32()")
        is I64Type -> CodeBlock.of("reader.readInt64()")
        is I128Type -> CodeBlock.of("reader.readInt128()")
        is I256Type -> CodeBlock.of("reader.readInt256()")
        is StringType -> CodeBlock.of("reader.readString()")
        is BooleanType -> CodeBlock.of("reader.readBoolean()")
        is CompositeType -> type.scaleReadImpl()
        is OptionType -> type.scaleReadImpl()
        is FixedPointType -> type.scaleReadImpl()
        is CompactType -> type.scaleReadImpl()
        else -> throw RuntimeException("Unexpected type: $type")
    }
}

/**
 * Resolve Scale Writer for a given [type]
 */
fun resolveScaleWriteImpl(type: Type, propName: CodeBlock): CodeBlock {
    return when (type) {
        is ArrayType -> type.scaleWriteImpl(propName)
        is VecType -> type.scaleWriteImpl(propName)
        is SetType -> type.scaleWriteImpl(propName)
        is MapType -> type.scaleWriteImpl(propName)
        is U8Type -> CodeBlock.of("writer.writeUByte(%L)", propName)
        is U16Type -> CodeBlock.of("writer.writeUint16(%L)", propName)
        is U32Type -> CodeBlock.of("writer.writeUint32(%L)", propName)
        is U64Type -> CodeBlock.of("writer.writeUint64(%L)", propName)
        is U128Type -> CodeBlock.of("writer.writeUint128(%L)", propName)
        is U256Type -> CodeBlock.of("writer.writeUint256(%L)", propName)
        is I32Type -> CodeBlock.of("writer.writeInt32(%L)", propName)
        is I64Type -> CodeBlock.of("writer.writeInt64(%L)", propName)
        is I128Type -> CodeBlock.of("writer.writeInt128(%L)", propName)
        is I256Type -> CodeBlock.of("writer.writeInt256(%L)", propName)
        is StringType -> CodeBlock.of("writer.writeAsList(%L.toByteArray(Charsets.UTF_8))", propName)
        is BooleanType -> CodeBlock.of("if (%L) { writer.directWrite(1) } else { writer.directWrite(0) }", propName)
        is CompositeType -> CodeBlock.of("%T.write(writer, %L)", withoutGenerics(resolveKotlinType(type)), propName)
        is OptionType -> type.scaleWriteImpl(propName)
        is FixedPointType -> type.scaleWriteImpl(propName)
        is CompactType -> CodeBlock.of("writer.write(%T(), %L.toLong())", COMPACT_ULONG_WRITER, propName)
        else -> throw RuntimeException("Unexpected type: $type")
    }
}

/**
 * @return the class name for a given [type][typeName]
 */
fun withoutGenerics(typeName: TypeName): ClassName {
    return when (typeName) {
        is ClassName -> typeName.topLevelClassName()
        is ParameterizedTypeName -> typeName.rawType.topLevelClassName()
        else -> throw RuntimeException("Unexpected type name: $typeName")
    }
}

private fun ArrayType.scaleReadImpl(): CodeBlock {
    return when (this.innerType.requireValue()) {
        is U8Type -> CodeBlock.of("reader.readByteArray(%L)", this.size)
        else -> CodeBlock.of(
            "reader.readArray(%L) {%L}",
            this.size,
            resolveScaleReadImpl(this.innerType.requireValue()),
        )
    }
}

private fun VecType.scaleReadImpl(): CodeBlock {
    return when (this.innerType.requireValue()) {
        is U8Type -> CodeBlock.of("reader.readByteArray()")
        else -> CodeBlock.of(
            "reader.readVec(reader.readCompactInt()) {%L}",
            resolveScaleReadImpl(this.innerType.requireValue()),
        )
    }
}

private fun CompositeType.scaleReadImpl(): CodeBlock {
    val typeName = resolveKotlinType(this)
    val typeNameWithoutGenerics = withoutGenerics(typeName)
    return if (this.generics.isEmpty()) {
        CodeBlock.of("%1T.read(reader)", typeNameWithoutGenerics)
    } else {
        CodeBlock.of("%1T.read(reader) as %2T", typeNameWithoutGenerics, typeName)
    }
}

private fun OptionType.scaleReadImpl(): CodeBlock {
    return when (this.innerType.requireValue()) {
        is U64Type, U32Type, U16Type, StringType -> CodeBlock.of("reader.readNullable()")
        else -> resolveKotlinType(this).let { type ->
            CodeBlock.of(
                "reader.readNullable(%1T) as %2T",
                withoutGenerics(type),
                type,
            )
        }
    }
}

private fun FixedPointType.scaleReadImpl(): CodeBlock {
    return when (this.innerType.requireValue()) {
        is I64Type -> CodeBlock.builder()
            .add(resolveScaleReadImpl(this.innerType.requireValue()))
            .add(".toBigInteger().%M()", FROM_FIXED_POINT)
            .build()
        else -> throw RuntimeException("Fixed point with base type $this not implemented")
    }
}

private fun CompactType.scaleReadImpl(): CodeBlock {
    return when (val innerType = this.innerType.requireValue()) {
        is U8Type -> CodeBlock.of("reader.readCompactInt().toShort()")
        is U16Type -> CodeBlock.of("reader.readCompactInt().toInt()")
        is U32Type -> CodeBlock.of("reader.readCompactInt().toLong()")
        is U64Type -> CodeBlock.of("reader.read(%T()).toBigInteger()", COMPACT_BIG_INT_READER)
        is U128Type, is U256Type -> CodeBlock.of("reader.read(%T())", COMPACT_BIG_INT_READER)
        else -> throw RuntimeException("Compact type implementation unresolved: $innerType")
    }
}

private fun MapType.scaleWriteImpl(propName: CodeBlock): CodeBlock {
    val key = (resolveKotlinType(this.key.requireValue()) as ClassName)
    val keyName = key.simpleName
    val sorted = when {
        this.sortedByKey -> CodeBlock.of(".toSortedMap(\n%1L.comparator()\n)", CodeBlock.of(keyName))
        else -> CodeBlock.of("")
    }
    return CodeBlock.of(
        "writer.writeCompact(%1L.size)\n" +
            "%1L%4L.forEach { (key, value) ->\n\t%2L\n\t%3L\n}",
        propName,
        resolveScaleWriteImpl(this.key.requireValue(), CodeBlock.of("key")),
        resolveScaleWriteImpl(this.value.requireValue(), CodeBlock.of("value")),
        sorted,
    )
}

private fun FixedPointType.scaleWriteImpl(propName: CodeBlock): CodeBlock {
    return when (this.innerType.requireValue()) {
        is I64Type -> CodeBlock.of("writer.writeInt64(%1L.%2M().toLong())", propName, TO_FIXED_POINT)
        else -> throw RuntimeException("Fixed point with base type $this not implemented")
    }
}

private fun OptionType.scaleWriteImpl(propName: CodeBlock): CodeBlock {
    return when (this.innerType.requireValue()) {
        is U64Type, U32Type, U16Type, StringType -> CodeBlock.of(
            "writer.writeNullable(%L)",
            propName,
        )
        else -> CodeBlock.of(
            "writer.writeNullable(%1T, %2L)",
            withoutGenerics(resolveKotlinType(this)),
            propName,
        )
    }
}

private fun ArrayType.scaleWriteImpl(propName: CodeBlock): CodeBlock {
    return when (this.innerType.requireValue()) {
        is U8Type -> CodeBlock.of("writer.writeByteArray(%L)", propName)
        else -> {
            val value = resolveScaleWriteImpl(this.innerType.requireValue(), CodeBlock.of("value"))
            CodeBlock.of(
                "%1L.forEach { value ->\n%2L\n}",
                propName,
                value,
            )
        }
    }
}

private fun VecType.scaleWriteImpl(propName: CodeBlock): CodeBlock {
    return when (this.innerType.requireValue()) {
        is U8Type -> CodeBlock.of("writer.writeAsList(%L)", propName)
        else -> {
            val sorted = when (this.sorted) {
                true -> {
                    val innerType = resolveKotlinType(this.innerType.requireValue())
                    val innerTypeName = innerType.rawTypeName()
                    CodeBlock.of(".sortedWith(\n%1L.comparator()\n)", innerTypeName)
                }
                false -> CodeBlock.of("")
            }
            val value = resolveScaleWriteImpl(this.innerType.requireValue(), CodeBlock.of("value"))

            CodeBlock.of(
                "writer.writeCompact(%1L.size)\n%1L%3L.forEach { value ->\n%2L\n}",
                propName,
                value,
                sorted,
            )
        }
    }
}

private fun SetType.scaleWriteImpl(propName: CodeBlock): CodeBlock {
    return CodeBlock.of(
        "writer.writeCompact(%1L.size)\n%1L.forEach { value -> %2L }",
        propName,
        resolveScaleWriteImpl(this.innerType.requireValue(), CodeBlock.of("value")),
    )
}

private fun TypeName.rawTypeName() = ((this as? ParameterizedTypeName)?.rawType ?: (this as ClassName)).simpleName
