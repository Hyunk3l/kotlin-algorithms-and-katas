package katas.numbertolcd

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class NumberToLCDShould {
    @Test
    fun `display correctly the number one`() {
        val result = NumberToLCD().invoke(1)

        result shouldBe """
            |
            |""".trimIndent()
    }

    @Test
    fun `display correctly two numbers`() {
        val result = NumberToLCD().invoke(12)

         result.trimIndent() shouldBe """
               _
            | _|
            ||_ """.trimIndent()
    }

    @Test
    fun `display correctly numbers from 1 to 9`() {
        val result = NumberToLCD().invoke(123456789)

         result.trimIndent() shouldBe """
                _  _     _  _  _  _  _
             | _| _||_||_ |_   ||_||_|
             ||_  _|  | _||_|  ||_| _|""".trimIndent()
    }
}
