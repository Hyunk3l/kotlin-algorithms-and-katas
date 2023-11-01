package katas.tyrepressuresystem

import java.util.*

class Sensor {

    fun popNextPressurePsiValue(): Double {
        val pressureTelemetryValue: Double
        pressureTelemetryValue = samplePressure()

        return OFFSET + pressureTelemetryValue
    }

    companion object {
        val OFFSET = 16.0

        private fun samplePressure(): Double {
            // placeholder implementation that simulate a real sensor in a real tire
            val basicRandomNumbersGenerator = Random()
            return 6.0 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble()
        }
    }
}
