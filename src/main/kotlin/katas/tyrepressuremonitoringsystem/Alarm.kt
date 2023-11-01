package katas.tyrepressuremonitoringsystem

private const val LOW_PRESSURE_THRESHOLD = 17.0
private const val HIGH_PRESSURE_THRESHOLD = 21.0

class Alarm(private val sensor: Sensor) {

    fun check(): Boolean {
        val psiPressureValue = sensor.popNextValue()

        return psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue
    }
}
