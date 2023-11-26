package katas.unicodeconverter

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

class HtmlPagesConverter @Throws(IOException::class)
constructor(filename: String) {
    private val content = HashMap<Int, List<String>>()

    init {
        val reader = try {
            BufferedReader(FileReader(filename))
        } catch (exception: IOException) {
            throw ReadingError(exception.message)
        }

        var currentPage = 0
        var line: String? = reader.readLine()
        while (line != null) {
            if (line == "PAGE_BREAK") {
                currentPage++
            } else {
                content[currentPage] = content.getOrDefault(currentPage, emptyList()) + line
            }
            line = reader.readLine()
        }
        reader.close()
    }

    @Throws(IOException::class)
    fun getHtmlPage(page: Int): String {
        val pageContent = content[page] ?: throw PageNotFoundError("Page $page not found")

        val htmlPage = StringBuffer()

        pageContent.forEach { singleLine ->
            if (!singleLine.contains("PAGE_BREAK")) {
                htmlPage.append(StringEscapeUtils.escapeHtml(singleLine))
                htmlPage.append("<br />")
            }
        }

        return htmlPage.toString()
    }
}
