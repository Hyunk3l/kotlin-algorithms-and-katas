package katas.unicodeconverter

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

private const val RESOURCES_DIR = "src/test/resources/text-pages-to-html"

class HtmlPagesConverterTest {

    @Test
    fun `should convert a simple plain text file into html`() {
        val converter = HtmlPagesConverter(filename = "$RESOURCES_DIR/simple-text.txt")

        val result = converter.getHtmlPage(0)

        result shouldBe """
            just<br /><br />a<br /><br />simple<br /><br /><br />text<br /><br /><br />to<br /><br />convert<br />
        """.trimIndent()
    }

    @Test
    fun `should fail in case is not able to retrieve a non existing page`() {
        val converter = HtmlPagesConverter(filename = "$RESOURCES_DIR/simple-text.txt")

        shouldThrow<PageNotFoundError> {
            converter.getHtmlPage(1)
        }
    }

    @Test
    fun `should convert a 3 pages plain text file into html`() {
        val converter = HtmlPagesConverter(filename = "$RESOURCES_DIR/simple-text-3-pages.txt")

        val result = converter.getHtmlPage(2)

        result shouldBe """
            third page content<br />
        """.trimIndent()
    }

    @Test
    fun `should be empty in case of empty file`() {
        val converter = HtmlPagesConverter(filename = "$RESOURCES_DIR/empty-file.txt")

        shouldThrow<PageNotFoundError> {
            converter.getHtmlPage(0)
        }
    }

    @Test
    fun `should fail in case of non-existing file`() {
        shouldThrow<ReadingError> {
            HtmlPagesConverter(filename = "$RESOURCES_DIR/not-existing-file.txt")
        }
    }

    @Test
    fun `should not convert if it contains a page break`() {
        val converter = HtmlPagesConverter(filename = "$RESOURCES_DIR/content-break.txt")

        val result = converter.getHtmlPage(1)

        result shouldBe ""
    }
}
