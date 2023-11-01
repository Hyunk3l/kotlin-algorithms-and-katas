package katas.tyrepressuremonitoringsystem

import java.util.Random

private const val OFFSET = 16.0
private const val MULTIPLIER = 6.0

class TyrePressureSensor(private val random: Random) : Sensor<Double> {
    override fun popNextValue(): Double = OFFSET + samplePressure()

    private fun samplePressure() = MULTIPLIER * random.nextDouble() * random.nextDouble()
}
