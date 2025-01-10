package jp.co.soramitsu.iroha2.parse

import jp.co.soramitsu.iroha2.ARRAY_REGEX
import jp.co.soramitsu.iroha2.IrohaSdkException
import jp.co.soramitsu.iroha2.type.ArrayType
import jp.co.soramitsu.iroha2.type.BooleanType
import jp.co.soramitsu.iroha2.type.CompactType
import jp.co.soramitsu.iroha2.type.EnumType
import jp.co.soramitsu.iroha2.type.FixedPointType
import jp.co.soramitsu.iroha2.type.I128Type
import jp.co.soramitsu.iroha2.type.I16Type
import jp.co.soramitsu.iroha2.type.I256Type
import jp.co.soramitsu.iroha2.type.I32Type
import jp.co.soramitsu.iroha2.type.I64Type
import jp.co.soramitsu.iroha2.type.I8Type
import jp.co.soramitsu.iroha2.type.IntType
import jp.co.soramitsu.iroha2.type.IterableType
import jp.co.soramitsu.iroha2.type.MapType
import jp.co.soramitsu.iroha2.type.NullType
import jp.co.soramitsu.iroha2.type.OptionType
import jp.co.soramitsu.iroha2.type.SetType
import jp.co.soramitsu.iroha2.type.StringType
import jp.co.soramitsu.iroha2.type.StructType
import jp.co.soramitsu.iroha2.type.TupleStructType
import jp.co.soramitsu.iroha2.type.Type
import jp.co.soramitsu.iroha2.type.U128Type
import jp.co.soramitsu.iroha2.type.U16Type
import jp.co.soramitsu.iroha2.type.U256Type
import jp.co.soramitsu.iroha2.type.U32Type
import jp.co.soramitsu.iroha2.type.U64Type
import jp.co.soramitsu.iroha2.type.U8Type
import jp.co.soramitsu.iroha2.type.UIntType
import jp.co.soramitsu.iroha2.type.VecType

/**
 * TypeResolver is used to resolve Iroha2 types using Iroha2 schema parser.
 */
class TypeResolver(private val schemaParser: SchemaParser) {

    private val resolvers = listOf<Resolver<*>>(
        BooleanResolver,
        SortedMapResolver,
        BitMapResolver,
        OptionResolver,
        VectorResolver,
        SortedVectorResolver,
        ArrayResolver,
        EnumResolver,
        TupleStructResolver,
        StructResolver,
        OneStringStructResolver,
        StringResolver,
        CompactResolver,
        UIntResolver,
        IntResolver,
        SetResolver,
        FixedPointResolver,
        QueryResolver,
    )

    /**
     * Resolve the type based on a given [name].
     *
     * @param name The name to resolve
     * @param typeValue The type to try and resolve the [name] to
     */
    fun resolve(name: String, typeValue: Any?): Type? {
        val candidates = resolvers
            .asSequence()
            .mapNotNull { it.resolve(name, typeValue, schemaParser) }
            .toSet()
        return candidates.firstOrNull()
    }
}

/**
 * Basic resolver for all kinds of types.
 *
 * @param name The name to resolve
 * @param typeValue The type to try and resolve the [name] to
 * @param schemaParser The schema parser to use
 */
interface Resolver<T : Type> {
    fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): T?
}

/**
 * Resolver for [BooleanType]
 */
object BooleanResolver : Resolver<BooleanType> {
    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): BooleanType? {
        return when (name) {
            "bool" -> BooleanType
            else -> null
        }
    }
}

/**
 * Resolver for [MapType]
 */
object BitMapResolver : Resolver<UIntType> {

    const val NAME = "Bitmap"

    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): UIntType? {
        when (typeValue) {
            is Map<*, *> -> if (typeValue.keys.first() != NAME) return null
            else -> return null
        }

        val type = (typeValue[NAME] as Map<String, *>)["repr"].toString()

        return UIntResolver.resolve(type, typeValue, schemaParser)
    }
}

/**
 * Resolver for [MapType]
 */
object SortedMapResolver : Resolver<MapType> {

    const val NAME = "SortedMap"

    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): MapType? {
        if (!name.startsWith("$NAME<")) return null

        val wildcards = name.removePrefix(NAME)
            .removeSurrounding("<", ">")
            .split(',')
            .map { it.trim() }
        if (wildcards.size != 2) return null

        return MapType(
            name,
            schemaParser.createAndGetNest(wildcards[0]),
            schemaParser.createAndGetNest(wildcards[1]),
            true,
        )
    }
}

/**
 * Basic resolver for wrapped types
 */
abstract class WrapperResolver<T : Type>(open val wrapperName: String) : Resolver<T> {
    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): T? {
        return when {
            name.startsWith("$wrapperName<") -> {
                val innerTypeName = name.removeSurrounding("$wrapperName<", ">")
                val innerType = schemaParser.createAndGetNest(innerTypeName)
                createWrapper(name, innerType)
            }
            name.startsWith("${wrapperName}Of") -> {
                val innerTypeName = name.replace("${wrapperName}Of", "")
                val innerType = schemaParser.createAndGetNest(innerTypeName)
                createWrapper(name, innerType)
            }
            else -> null
        }
    }

    /**
     * Create a wrapper type for [innerType]
     */
    abstract fun createWrapper(name: String, innerType: TypeNest, sorted: Boolean = false): T
}

/**
 * Basic resolver for iterable types
 */
abstract class SortedWrapperResolver<T : IterableType>(
    override val wrapperName: String,
) : WrapperResolver<T>(wrapperName) {

    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): T? {
        return super.resolve(name, typeValue, schemaParser)?.also {
            it.sorted = getSortedProperty(typeValue)
        }
    }

    fun getSortedProperty(typeValue: Any?): Boolean {
        return (typeValue as? Map<*, *>)?.get("Sorted$wrapperName") != null
    }
}

object SortedVectorResolver : SortedWrapperResolver<VecType>("SortedVec") {
    const val NAME = "SortedVec"

    override fun createWrapper(
        name: String,
        innerType: TypeNest,
        sorted: Boolean,
    ) = VecType(name, innerType, sorted)

    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): VecType? {
        return when (
            name.startsWith(wrapperName) || (typeValue as? Map<*, *>)?.get(wrapperName) != null
        ) {
            true -> createWrapper(name, extractGeneric(name, schemaParser).first(), true)
            false -> null
        }
    }
}

/**
 * Resolver for [VecType]
 */
object VectorResolver : SortedWrapperResolver<VecType>("Vec") {
    const val NAME = "Vec"

    override fun createWrapper(
        name: String,
        innerType: TypeNest,
        sorted: Boolean,
    ) = VecType(name, innerType, sorted)

    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): VecType? {
        return when (
            name.startsWith(wrapperName) || (typeValue as? Map<*, *>)?.get(wrapperName) != null
        ) {
            true -> createWrapper(name, extractGeneric(name, schemaParser).first(), false)
            false -> null
        }
    }
}

/**
 * Resolver for [SetType]
 */
object SetResolver : WrapperResolver<SetType>("BTreeSet") {
    override fun createWrapper(
        name: String,
        innerType: TypeNest,
        sorted: Boolean,
    ) = SetType(name, innerType, sorted)
}

/**
 * Resolver for [ArrayType]
 */
object ArrayResolver : Resolver<ArrayType> {

    const val NAME = "Array"

    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): ArrayType? {
        if (!name.startsWith(NAME)) return null
        val groups = ARRAY_REGEX.find(name)?.groupValues ?: return null
        return ArrayType(name, schemaParser.createAndGetNest(groups[1]), groups[2].toInt())
    }
}

/**
 * Resolver for [OptionType]
 */
object OptionResolver : WrapperResolver<OptionType>("Option") {
    override fun createWrapper(
        name: String,
        innerType: TypeNest,
        sorted: Boolean,
    ) = OptionType(name, innerType)
}

/**
 * Resolver for [CompactType]
 */
object CompactResolver : WrapperResolver<CompactType>("Compact") {
    override fun createWrapper(
        name: String,
        innerType: TypeNest,
        sorted: Boolean,
    ) = CompactType(name, innerType)
}

/**
 * Resolver for [EnumType]
 */
object EnumResolver : Resolver<EnumType> {
    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): EnumType? {
        return if (typeValue is Map<*, *> && typeValue["Enum"] != null) {
            val components = typeValue["Enum"] as List<Map<String, Any>>
            val generics = extractGeneric(name, schemaParser)
            val variants = components.map {
                val variantProperty = it["type"] as String?
                EnumType.Variant(
                    (it["tag"] ?: throw IrohaSdkException("Enum name not found")) as String,
                    (it["discriminant"] ?: throw IrohaSdkException("Enum discriminant not found")) as Int,
                    variantProperty?.let(schemaParser::createAndGetNest),
                )
            }
            EnumType(name, generics, variants)
        } else {
            null
        }
    }
}

/**
 * Resolver for [TupleStructType]
 */
object TupleStructResolver : Resolver<TupleStructType> {
    override fun resolve(
        name: String,
        typeValue: Any?,
        schemaParser: SchemaParser,
    ): TupleStructType? {
        return if (typeValue is Map<*, *> && typeValue["Tuple"] != null) {
            val components = typeValue["Tuple"] as List<String>
            val children = components.map(schemaParser::createAndGetNest)
            val generics = extractGeneric(name, schemaParser)
            TupleStructType(name, generics, children)
        } else {
            null
        }
    }
}

/**
 * Resolver for [StructType]
 */
object StructResolver : Resolver<StructType> {
    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): StructType? {
        return if ((typeValue is Map<*, *> && typeValue["Struct"] != null)) {
            val components = typeValue["Struct"] as List<Map<String, String>>
            val properties = LinkedHashMap<String, TypeNest>()
            for (singleMapping in components) {
                val fieldName = singleMapping["name"] ?: throw IrohaSdkException("Component 'name' not found")
                val fieldType = singleMapping["type"] ?: throw IrohaSdkException("Component 'type' not found")
                properties[fieldName] = schemaParser.createAndGetNest(fieldType)
            }
            val generics = extractGeneric(name, schemaParser)
            StructType(name, generics, properties)
        } else {
            null
        }
    }
}

/**
 * Resolver for [StructType]
 */
object OneStringStructResolver : Resolver<StructType> {
    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): StructType? {
        return if (typeValue is String) {
            val fieldName = typeValue.toFieldName()
            val properties = LinkedHashMap<String, TypeNest>().also { map ->
                map[fieldName] = schemaParser.createAndGetNest(typeValue)
            }
            val generics = extractGeneric(name, schemaParser)
            StructType(name, generics, properties)
        } else {
            null
        }
    }

    private fun String.toFieldName() = this.replaceFirstChar { it.lowercase() }.let { name ->
        val parts = name.split("<")
        val firstPart = parts.first()
        val lastPart = parts.last().split(",")
            .first().replaceFirstChar { it.uppercase() }
            .replace(">", "")

        when (firstPart.lowercase() == lastPart.lowercase()) {
            true -> firstPart
            false -> "${firstPart}Of$lastPart"
        }
    }
}

/**
 * Resolver for [StructType]
 */
object QueryResolver : Resolver<StructType> {
    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): StructType? {
        return if (name.startsWith("Find") && typeValue == null) {
            val generics = extractGeneric(name, schemaParser)
            StructType(name, generics, emptyMap())
        } else {
            null
        }
    }
}

/**
 * Resolver for [StringType]
 */
object StringResolver : Resolver<StringType> {
    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): StringType? {
        return when {
            name.endsWith("String") -> StringType
            else -> null
        }
    }
}

/**
 * Resolver for [UIntType]
 */
object UIntResolver : Resolver<UIntType> {
    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): UIntType? {
        return when (name) {
            "AtomicU32Wrapper" -> U32Type
            "NonZeroU8" -> U8Type
            "u8" -> U8Type
            "u16" -> U16Type
            "u32" -> U32Type
            "u64" -> U64Type
            "u128" -> U128Type
            "u256" -> U256Type
            else -> null
        }
    }
}

/**
 * Resolver for [IntType]
 */
object IntResolver : Resolver<IntType> {
    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): IntType? {
        return when (name) {
            "i8" -> I8Type
            "i16" -> I16Type
            "i32" -> I32Type
            "i64" -> I64Type
            "i128" -> I128Type
            "i256" -> I256Type
            else -> null
        }
    }
}

/**
 * Resolver for [FixedPointType]
 */
object FixedPointResolver : Resolver<FixedPointType> {
    override fun resolve(name: String, typeValue: Any?, schemaParser: SchemaParser): FixedPointType? {
        return if (name.startsWith("FixedPoint<") && typeValue is Map<*, *>) {
            val members = (typeValue["FixedPoint"] as? Map<String, Any>)!!
            val base = schemaParser.createAndGetNest(members["base"]!! as String)
            val decimalPlaces = members["decimal_places"]!! as Int
            FixedPointType(name, base, decimalPlaces)
        } else {
            null
        }
    }
}

/**
 * `TypeNest` contains [the name of the type][name] and [the type it resolves to][value]
 */
data class TypeNest(val name: String, var value: Type?) {

    private var resolutionInProgress: Boolean = false

    fun requireValue() = value ?: NullType

    fun notResolvedTypes(): Set<String> {
        if (resolutionInProgress) {
            return setOf()
        }
        resolutionInProgress = true
        val resolutionResult = value?.notResolvedTypes() ?: setOf()
        resolutionInProgress = false
        return resolutionResult
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TypeNest) return false

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
