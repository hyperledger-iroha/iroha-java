package jp.co.soramitsu.iroha2.util

import jp.co.soramitsu.iroha2.bytes
import jp.co.soramitsu.iroha2.fromHex
import jp.co.soramitsu.iroha2.generateKeyPair
import jp.co.soramitsu.iroha2.hash
import jp.co.soramitsu.iroha2.keyPairFromHex
import jp.co.soramitsu.iroha2.signAs
import jp.co.soramitsu.iroha2.toHex
import jp.co.soramitsu.iroha2.verify
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.bouncycastle.util.encoders.Hex
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CryptoTest {

    @Test
    fun `generating key pairs is thread safe`() {
        val iterations = 1000
        val futureResults = generateSequence {
            CoroutineScope(Dispatchers.Default)
                .async { generateKeyPair() }
        }.take(iterations).toSet()

        class ByteArrayWrapper(private val byteArray: ByteArray) {
            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other !is ByteArrayWrapper) return false
                if (!byteArray.contentEquals(other.byteArray)) return false
                return true
            }

            override fun hashCode() = byteArray.contentHashCode()
        }

        runBlocking {
            assertEquals(
                iterations,
                futureResults.map { it.await().private.bytes() }
                    .map { ByteArrayWrapper(it) }
                    .toSet().size,
            )
        }
    }

    @Test
    fun `signature created and verified`() {
        val keyPair = generateKeyPair()
        val message = "Test message to sign.".toByteArray()
        val signature = keyPair.private.signAs(message)

        assertTrue { keyPair.public.verify(signature, message) }
    }

    @Test
    fun `hash function returns expected result`() {
        val expected = "ba67336efd6a3df3a70eeb757860763036785c182ff4cf587541a0068d09f5b3"
        val input = "6920616d2064617461"
        assertEquals(expected, Hex.toHexString(input.fromHex().hash()))
    }

    @Test
    fun `keypair serialized to hex and deserialized back`() {
        val keyPair = generateKeyPair()
        val pubKey = keyPair.public.bytes().toHex()
        val privKey = keyPair.private.bytes().toHex()

        val message = "foo".toByteArray()
        val signature = keyPair.private.signAs(message)

        val restoredKeyPair = keyPairFromHex(pubKey, privKey)
        assertEquals(keyPair.private, restoredKeyPair.private)
        assertEquals(keyPair.public, restoredKeyPair.public)

        assertDoesNotThrow {
            assertTrue { restoredKeyPair.public.verify(signature, message) }
        }
    }
}
