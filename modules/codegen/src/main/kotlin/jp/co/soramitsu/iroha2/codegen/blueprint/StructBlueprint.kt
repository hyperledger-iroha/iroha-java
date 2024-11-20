package jp.co.soramitsu.iroha2.codegen.blueprint

import jp.co.soramitsu.iroha2.codegen.resolveKotlinType
import jp.co.soramitsu.iroha2.type.StructType
import java.util.StringTokenizer

/**
 * Blueprint for [StructType]
 */
class StructBlueprint(type: StructType) : TypeBasedBlueprint<StructType>(type) {
    override fun resolveProperties(type: StructType): List<Property> = type.mapping.map { (name, ty) ->
        Property(
            convertToCamelCase(name),
            resolveKotlinType(ty.requireValue()),
            ty.requireValue(),
        )
    }

    /**
     * Create property name by converting from snake case to camel case
     */
    private fun convertToCamelCase(name: String): String {
        val tokenizer = StringTokenizer(name, "_")
        return if (tokenizer.hasMoreTokens()) {
            val resultBuilder = StringBuilder(tokenizer.nextToken())
            for (token in tokenizer) {
                resultBuilder.append((token as String).replaceFirstChar(Char::uppercase))
            }
            resultBuilder.toString()
        } else {
            name
        }
    }
}
