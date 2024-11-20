package jp.co.soramitsu.iroha2.util

import jp.co.soramitsu.iroha2.DEFAULT_SCALE
import jp.co.soramitsu.iroha2.FixedPointConversionException
import jp.co.soramitsu.iroha2.fromFixedPoint
import jp.co.soramitsu.iroha2.toFixedPoint
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.RoundingMode.DOWN
import java.security.SecureRandom
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class FixnumTest {

    @Test
    fun `check there and back works for floating point numbers with fractional parts only`() {
        val random = SecureRandom()
        test {
            BigDecimal(random.nextDouble())
                .setScale(random.nextInt(DEFAULT_SCALE), DOWN)
        }
    }

    @Test
    fun `check there and back works for floating point numbers with only integral part`() {
        val random = SecureRandom()
        test { BigDecimal(random.nextInt()) }
    }

    @Test
    fun `check there and back works for floating point numbers with both integral and fractional part`() {
        val random = SecureRandom()
        test {
            BigDecimal(random.nextDouble() + random.nextInt())
                .setScale(random.nextInt(DEFAULT_SCALE), DOWN)
        }
    }

    @Test
    fun `check there and back works for zero`() {
        test(1) { BigDecimal.ZERO }
    }

    @Test
    fun `check if floating point is bigger than scale, then exception is thrown`() {
        assertFailsWith(FixedPointConversionException::class) { test(1) { BigDecimal(SecureRandom().nextDouble()) } }
    }

    @Test
    fun `check if floating point has irrelevant zeros in fractional part then they are ignored`() {
        test(1, 3) { BigDecimal.ONE.setScale(15) }
    }

    private fun test(
        probes: Int = 20_000,
        scale: Int = DEFAULT_SCALE,
        generator: () -> BigDecimal,
    ) {
        generateSequence { generator() }
            .take(probes)
            .forEachIndexed { iteration, expected ->
                val actual = expected.toFixedPoint(scale).fromFixedPoint(scale)
                assertTrue("Iteration $iteration failed: expected value `$expected`, but was `$actual`") {
                    expected.compareTo(actual) == 0
                }
            }
    }
}
