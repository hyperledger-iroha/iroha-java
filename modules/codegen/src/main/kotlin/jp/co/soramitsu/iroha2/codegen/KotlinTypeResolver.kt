package jp.co.soramitsu.iroha2.codegen

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName
import jp.co.soramitsu.iroha2.type.ArrayType
import jp.co.soramitsu.iroha2.type.BooleanType
import jp.co.soramitsu.iroha2.type.CompactType
import jp.co.soramitsu.iroha2.type.CompositeType
import jp.co.soramitsu.iroha2.type.I128Type
import jp.co.soramitsu.iroha2.type.I16Type
import jp.co.soramitsu.iroha2.type.I256Type
import jp.co.soramitsu.iroha2.type.I32Type
import jp.co.soramitsu.iroha2.type.I64Type
import jp.co.soramitsu.iroha2.type.I8Type
import jp.co.soramitsu.iroha2.type.MapType
import jp.co.soramitsu.iroha2.type.OptionType
import jp.co.soramitsu.iroha2.type.StringType
import jp.co.soramitsu.iroha2.type.Type
import jp.co.soramitsu.iroha2.type.U128Type
import jp.co.soramitsu.iroha2.type.U16Type
import jp.co.soramitsu.iroha2.type.U256Type
import jp.co.soramitsu.iroha2.type.U32Type
import jp.co.soramitsu.iroha2.type.U64Type
import jp.co.soramitsu.iroha2.type.U8Type
import jp.co.soramitsu.iroha2.type.VecType
import jp.co.soramitsu.iroha2.type.WrapperType
import java.math.BigInteger
import kotlin.reflect.KClass

/**
 * Resolve Kotlin [types][type]
 */
fun resolveKotlinType(type: Type): TypeName {
    return when (type) {
        is CompositeType -> {
            val propClassName = defineClassName(type.name)
            val propPackageName = definePackageName(propClassName, type)
            val clazz = ClassName(propPackageName, propClassName)
            if (type.generics.isEmpty()) {
                clazz
            } else {
                clazz.parameterizedBy(
                    type.generics.map {
                        resolveKotlinType(
                            it.requireValue(),
                        )
                    },
                )
            }
        }
        // must be before 'WrapperType'
        is OptionType -> resolveKotlinType(type.innerType.requireValue()).copy(nullable = true)
        // must be before 'WrapperType'
        is ArrayType -> {
            when (type.innerType.requireValue()) {
                is U8Type -> ByteArray::class.asTypeName()
                else -> {
                    val wrapperType = lookUpInBuiltInTypes(type)
                    (wrapperType as ClassName).parameterizedBy(resolveKotlinType(type.innerType.requireValue()))
                }
            }
        }
        is CompactType -> resolveKotlinType((type as WrapperType).innerType.requireValue())
        is WrapperType -> {
            // special case for vector of bytes
            if (type is VecType && type.innerType.requireValue() is U8Type) {
                return ByteArray::class.asTypeName()
            }
            val wrapperType = lookUpInBuiltInTypes(type)
            (wrapperType as ClassName).parameterizedBy(resolveKotlinType(type.innerType.requireValue()))
        }
        is MapType -> {
            val wrapperType = lookUpInBuiltInTypes(type)
            (wrapperType as ClassName).parameterizedBy(
                resolveKotlinType(type.key.requireValue()),
                resolveKotlinType(type.value.requireValue()),
            )
        }
        // only "primitive" types left
        else -> lookUpInBuiltInTypes(type)
    }
}

/**
 * Check if the given [type] is one of the [built-in Kotlin types][builtinKotlinTypes]
 */
fun lookUpInBuiltInTypes(type: Type): TypeName = builtinKotlinTypes[type::class]
    ?: throw RuntimeException("unexpected type: $type")

/**
 * Define the package name for the given [class][className] and [type]
 */
fun definePackageName(className: String, type: Type): String {
    return "jp.co.soramitsu.iroha2.generated." + type.name.substringBeforeLast(className)
        .removeSuffix("::")
        .removePrefix("iroha")
        .replace("::", ".")
        .replace("_", "")
}

/**
 * Define the class name for the given [type][typeName]
 */
fun defineClassName(typeName: String) = typeName.substringBefore('<')
    .substringAfterLast("::")

val builtinKotlinTypes = mapOf<KClass<*>, TypeName>(
    StringType::class to String::class.asTypeName(),
    BooleanType::class to Boolean::class.asTypeName(),
    U8Type::class to Short::class.asTypeName(),
    U16Type::class to Int::class.asTypeName(),
    U32Type::class to Long::class.asTypeName(),
    U64Type::class to BigInteger::class.asTypeName(),
    U128Type::class to BigInteger::class.asTypeName(),
    U256Type::class to BigInteger::class.asTypeName(),
    I8Type::class to Byte::class.asTypeName(),
    I16Type::class to Short::class.asTypeName(),
    I32Type::class to Int::class.asTypeName(),
    I64Type::class to Long::class.asTypeName(),
    I128Type::class to BigInteger::class.asTypeName(),
    I256Type::class to BigInteger::class.asTypeName(),
    VecType::class to List::class.asTypeName(),
    MapType::class to Map::class.asTypeName(),
    ArrayType::class to Array::class.asTypeName(),
)
