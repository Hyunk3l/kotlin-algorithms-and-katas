package katas.unicodeconverter

import kotlin.test.Test
import org.junit.jupiter.api.Assertions.assertEquals

class HtmlTextConverterTest {
    @Test
    fun foo() {
        val converter = HtmlTextConverter("foo")
        assertEquals("fixme", converter.filename)
    }
}
