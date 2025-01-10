package jp.co.soramitsu.iroha2.parse

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import jp.co.soramitsu.iroha2.COMMON_SCHEMA_GENERIC_REGEX
import jp.co.soramitsu.iroha2.DEFINITION_SCHEMA_GENERIC_REGEX
import kotlin.streams.toList

class SchemaReader {

    private val repeated = mutableMapOf<String, Int>()
    private val toReplace = mutableMapOf<String, String>()

    /**
     * Read Iroha2 schema from a given [file][fileName]
     */
    fun readSchema(fileName: String): Map<String, Any> {
        val resource = Thread.currentThread().contextClassLoader.getResourceAsStream(fileName)!!
        val sb = StringBuilder()
        val lines = resource.bufferedReader().lines().toList()

        lines.forEach { line -> line.countRepeatedWithGenerics() }
        repeated.entries.removeIf { (it.key != "Trigger" && it.key != "Action") && it.value < 2 }
        toReplace.putAll(lines.mapNotNull { it.getReplacePairOrNull() }.toMap())

        lines.forEach { line -> sb.appendLine(line.replace()) }

        return ObjectMapper().readValue(
            sb.toString(),
            object : TypeReference<MutableMap<String, Any>>() {},
        )
    }

    private fun String.countRepeatedWithGenerics() {
        DEFINITION_SCHEMA_GENERIC_REGEX.matchEntire(this)?.groupValues?.also { values ->
            val key = values[1]
            repeated[key] = repeated.getOrDefault(key, 0) + 1
        }
    }

    private fun String.replace(): String {
        var result = this
        toReplace.forEach { (old, new) -> result = result.replace(old, new) }
        return result
    }

    private fun String.getReplacePairOrNull(): Pair<String, String>? {
        COMMON_SCHEMA_GENERIC_REGEX.find(this)?.groupValues?.also { values ->
            val mutable = immutable.map { this.contains(it) }.all { !it }
            if (mutable && repeated[values[1]] != null) {
                val source = "${values[1]}<${values[2]}>"
                return source to source.replace("<", "Of")
                    .replace(", ", "And")
                    .replace(">", "")
            } else if (this.contains("Option<Option")) {
                val source = "${values[1]}<${values[2]}>"
                return source to values.last()
            }
        }
        return null
    }

    companion object {
        private val immutable = listOf(
            SortedMapResolver.NAME,
            ArrayResolver.NAME,
            VectorResolver.NAME,
            SortedVectorResolver.NAME,
            "Option",
            "SignatureOf",
            "HashOf",
        )
    }
}
