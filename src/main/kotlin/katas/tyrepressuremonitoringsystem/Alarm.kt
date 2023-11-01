package katas.tyrepressuremonitoringsystem

private const val LOW_PRESSURE_THRESHOLD = 17.0
private const val HIGH_PRESSURE_THRESHOLD = 21.0

class Alarm(private val sensor: Sensor) {

    var isAlarmOn = false
        internal set

    fun check() {
        val psiPressureValue = sensor.popNextValue()

        if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue) {
            isAlarmOn = true
        }
    }
}
