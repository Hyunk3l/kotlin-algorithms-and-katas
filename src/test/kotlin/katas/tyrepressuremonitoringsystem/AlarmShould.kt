package katas.tyrepressuremonitoringsystem

import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlin.test.Test

private val sensor = mockk<Sensor>()

class AlarmShould {

    @Test
    fun `be deactivated by default`() {
        val alarm = Alarm(sensor = sensor)

        alarm.isAlarmOn shouldBe false
    }

    @Test
    fun `be active if pressure is above threshold`() {
        every { sensor.popNextValue() } returns 22.0
        val alarm = Alarm(sensor)

        alarm.check()

        alarm.isAlarmOn shouldBe true
    }

    @Test
    fun `be active if pressure is below threshold`() {
        every { sensor.popNextValue() } returns 16.0
        val alarm = Alarm(sensor)

        alarm.check()

        alarm.isAlarmOn shouldBe true
    }
}
