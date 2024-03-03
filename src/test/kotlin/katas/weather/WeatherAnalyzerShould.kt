package katas.weather

import io.kotest.matchers.shouldBe
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WeatherAnalyzerShould {

    private val outputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        val printStream = PrintStream(outputStream)
        System.setOut(printStream)
    }

    @Test
    fun `print report with temperatures`() {
        val weatherAnalyzer = with(WeatherAnalyzer()) {
            addTemperature(23.0)
            addTemperature(21.0)
        }

        weatherAnalyzer.printReport()

        outputStream.toString() shouldBe """
            Average Temperature: 22.0
            Max Temperature: 23.0
            Min Temperature: 21.0
            Temperature Spread: 2.0
            
        """.trimIndent()
    }

    @Test
    fun `print report with no added temperatures`() {
        val weatherAnalyzer = WeatherAnalyzer()

        weatherAnalyzer.printReport()

        outputStream.toString() shouldBe """
            Average Temperature: NaN
            Max Temperature: ${Double.MIN_VALUE}
            Min Temperature: ${Double.MAX_VALUE}
            Temperature Spread: ${Double.MIN_VALUE - Double.MAX_VALUE}
            
        """.trimIndent()
    }
}
