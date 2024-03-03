package katas.weather

import WeatherAnalyzer
import io.kotest.matchers.shouldBe
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.Test

class WeatherAnalyzerShould {

    @Test
    fun `print report with temperatures`() {
        val outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)
        System.setOut(printStream)
        val weatherAnalyzer = WeatherAnalyzer()
        weatherAnalyzer.addTemperature(23.0)
        weatherAnalyzer.addTemperature(21.0)


        weatherAnalyzer.printReport()

        val capturedOutput = outputStream.toString()
        capturedOutput shouldBe """
            Average Temperature: 22.0
            Max Temperature: 23.0
            Min Temperature: 21.0
            Temperature Spread: 2.0
            
        """.trimIndent()
    }
}
