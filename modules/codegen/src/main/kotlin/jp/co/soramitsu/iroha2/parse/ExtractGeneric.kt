package jp.co.soramitsu.iroha2.parse

import jp.co.soramitsu.iroha2.GENERIC_REGEX

private const val TYPE_GROUP_INDEX = 2 // first one will be the entire typeDef, the second one will be raw type

/**
 * Extract generics from [name] using [parser]
 */
fun extractGeneric(
    name: String,
    parser: SchemaParser,
): List<TypeNest> {
    val groups = GENERIC_REGEX.find(name)?.groupValues ?: return listOf()
    val rawType = groups.getOrNull(TYPE_GROUP_INDEX) ?: return listOf()
    return rawType.split(", ").map { parser.createAndGetNest(it) }
}
