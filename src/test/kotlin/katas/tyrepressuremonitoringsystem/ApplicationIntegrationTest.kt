package katas.tyrepressuremonitoringsystem

import io.kotest.matchers.string.shouldContain
import java.util.Random
import org.junit.jupiter.api.Test

class ApplicationIntegrationTest {
    @Test
    fun `tyre pressure application should return alarm status`() {
        val application = Application(alarm = Alarm(sensor = TyrePressureSensor(Random())))

        val result = application()

        result shouldContain "Monitoring system. Alarm status: (true|false)".toRegex()
    }
}
