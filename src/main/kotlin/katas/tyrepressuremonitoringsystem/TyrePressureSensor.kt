package katas.tyrepressuremonitoringsystem

import java.util.Random

private const val OFFSET = 16.0

class TyrePressureSensor(private val random: Random) : Sensor {
    override fun popNextValue(): Double {
        val pressureTelemetryValue = samplePressure()

        return OFFSET + pressureTelemetryValue
    }

    private fun samplePressure(): Double {
        // placeholder implementation that simulate a real sensor in a real tire
        return 6.0 * random.nextDouble() * random.nextDouble()
    }
}
