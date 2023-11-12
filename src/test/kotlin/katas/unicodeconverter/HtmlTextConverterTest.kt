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
    fun `should convert text to html`() {
        val filename = "src/test/resources/to-convert-to-html.txt"
        val converter = HtmlTextConverter(filename)

        val result = converter.convertToHtml()

        result shouldBe """
            aaa<br />bbb<br />ccc<br />
        """.trimIndent()
    }

    @Test
    fun `should convert text with special chars to html`() {
        val filename = "src/test/resources/to-convert-to-html-special-chars.txt"
        val converter = HtmlTextConverter(filename)

        val result = converter.convertToHtml()

        result shouldBe """
            aaà<br />ñññ<br />
        """.trimIndent()
    }

    @Test
    fun `should convert text with html to html`() {
        val filename = "src/test/resources/to-convert-to-html-with-html.txt"
        val converter = HtmlTextConverter(filename)

        val result = converter.convertToHtml()

        result shouldBe """
            &lt;p&gt;aaa&lt;/p&gt;<br />bbb<br />
        """.trimIndent()
    }

    @Test
    fun `should convert empty text to html`() {
        val filename = "src/test/resources/empty.txt"
        val converter = HtmlTextConverter(filename)

        val result = converter.convertToHtml()

        result shouldBe ""
    }
}
