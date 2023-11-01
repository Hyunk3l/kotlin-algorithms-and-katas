package katas.tyrepressuresystem

import kotlin.test.Test
import org.junit.jupiter.api.Assertions.assertEquals

class AlarmShould {

    @Test
    fun foo() {
        val alarm = Alarm()
        assertEquals(false, alarm.isAlarmOn)
    }
}
