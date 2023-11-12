package katas.unicodeconverter

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class HtmlTextConverterTest {
    @Test
    fun `should able to get file name`() {
        val filename = "foo"

        val converter = HtmlTextConverter(filename)

        converter.filename shouldBe filename
    }

    @Test
    fun `should get content from file`() {
        val filename = "src/test/resources/to-convert-to-html.txt"
        val converter = HtmlTextConverter(filename)

        val result = converter.convertToHtml()

        result shouldBe """
            aaa<br />bbb<br />ccc<br />
        """.trimIndent()
    }
}
