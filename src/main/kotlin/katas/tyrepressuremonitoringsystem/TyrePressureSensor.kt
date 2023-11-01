package katas.tyrepressuremonitoringsystem

import java.util.*

interface Sensor {
    fun popNextValue(): Double
}

class TyrePressureSensor : Sensor {
    override fun popNextValue(): Double {
        val pressureTelemetryValue = samplePressure()

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
