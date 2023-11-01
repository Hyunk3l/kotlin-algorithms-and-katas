package katas.tyrepressuremonitoringsystem

class Application(
    private val alarm: Alarm
) {
    operator fun invoke(): String {
        val alarmResult = alarm.check()
        return "Monitoring system. Alarm status: $alarmResult"
    }
}
