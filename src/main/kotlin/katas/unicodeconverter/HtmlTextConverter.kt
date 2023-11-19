package katas.unicodeconverter

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

class HtmlTextConverter(val filename: String) {

    fun convertToHtml(): String {

        val reader = try {
            BufferedReader(FileReader(filename))
        } catch (exception: IOException) {
            throw ReadingError(exception.message)
        }

        var line: String? = reader.readLine()
        var html = ""
        while (line != null) {
            html = buildHtml(html, line)
            line = reader.readLine()
        }
        return html
    }

    private fun buildHtml(html: String, line: String?) =
        html + StringEscapeUtils.escapeHtml(line!!) + "<br />"
}

class ReadingError(message: String?) : RuntimeException(message)
