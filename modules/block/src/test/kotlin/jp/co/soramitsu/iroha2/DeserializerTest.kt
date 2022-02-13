package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.core.genesis.RawGenesisBlock
import org.junit.jupiter.api.Test
import java.io.File

class DeserializerTest {
    @Test
    fun `should deserialize genesis block`() {
        val json = File("../testcontainers/src/main/resources/genesis.json")
        val node = JSON_SERDE.readTree(json)
        val block = JSON_SERDE.convertValue(node, RawGenesisBlock::class.java)

        assert(block.transactions.isNotEmpty())
        assert(block.transactions.first().isi.size == 4)
    }
}
