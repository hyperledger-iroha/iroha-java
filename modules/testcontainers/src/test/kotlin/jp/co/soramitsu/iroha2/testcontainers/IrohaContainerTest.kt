package jp.co.soramitsu.iroha2.testcontainers

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class IrohaContainerTest {

    @Test
    fun check_container_can_start_and_stop() {
        val sut = IrohaContainer()

        assertFalse { sut.isCreated }
        assertFalse { sut.isRunning }

        sut.start()

        assertTrue { sut.isCreated }
        assertTrue { sut.isRunning }

        sut.stop()

        assertFalse { sut.isCreated }
        assertFalse { sut.isRunning }
    }
}
