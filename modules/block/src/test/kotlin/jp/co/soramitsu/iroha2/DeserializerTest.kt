package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.RawGenesisTransaction
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class DeserializerTest {
    @Test
    fun `should deserialize genesis block`() {
        val json = File("../test-tools/src/main/resources/genesis.json")
        val node = JSON_SERDE.readTree(json)
        val transaction = JSON_SERDE.convertValue(node, RawGenesisTransaction::class.java)

        assert(transaction.instructions.isNotEmpty())

        val genesis = Genesis(transaction)
        val newJson = removeWhiteSpacesAndReplacePubKey(genesis.asJson())
        val initialJson = removeWhiteSpacesAndReplacePubKey(json.readText())
        assertEquals(initialJson.lowercase(), newJson.lowercase())
    }

    @Test
    fun `should deserialize genesis block2`() {
        val json = File("../test-tools/src/main/resources/genesis2.json")
        val node = JSON_SERDE.readTree(json)
        val transaction = JSON_SERDE.convertValue(node, RawGenesisTransaction::class.java)

        assert(transaction.instructions.isNotEmpty())

        val genesis = Genesis(transaction)
        val newJson = removeWhiteSpacesAndReplacePubKey(genesis.asJson())
        val initialJson = removeWhiteSpacesAndReplacePubKey(json.readText())
        assertEquals(initialJson.lowercase(), newJson.lowercase())
    }

    @Test
    fun `should deserialize genesis block3`() {
        val json = File("../test-tools/src/main/resources/genesis3.json")
        val node = JSON_SERDE.readTree(json)
        val transaction = JSON_SERDE.convertValue(node, RawGenesisTransaction::class.java)

        assert(transaction.instructions.isNotEmpty())

        val genesis = Genesis(transaction)
        val newJson = removeWhiteSpacesAndReplacePubKey(genesis.asJson())
        val initialJson = removeWhiteSpacesAndReplacePubKey(json.readText())
        assertEquals(initialJson.lowercase(), newJson.lowercase())
    }

    private fun removeWhiteSpacesAndReplacePubKey(json: String): String {
        val regex = "(\"ed01)+\\w+\"".toRegex()
        return json.replace(System.getProperty("line.separator"), "")
            .replace(" ", "")
            .replace(regex, "publicKey")
    }
}
