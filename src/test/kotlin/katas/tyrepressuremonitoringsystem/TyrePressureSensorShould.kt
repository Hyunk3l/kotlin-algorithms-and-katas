package katas.tyrepressuremonitoringsystem

import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.beInstanceOf
import io.mockk.every
import io.mockk.mockk
import java.util.Random
import org.junit.jupiter.api.Test

class TyrePressureSensorShould {

    @Test
    fun `get pressure value`() {
        val random = mockk<Random>()
        every { random.nextDouble() } returns 0.05
        val tyrePressureSensor = TyrePressureSensor(random)

        val result = tyrePressureSensor.popNextValue()

        result should beInstanceOf<Double>()
        result shouldBe 16.015
    }
}
