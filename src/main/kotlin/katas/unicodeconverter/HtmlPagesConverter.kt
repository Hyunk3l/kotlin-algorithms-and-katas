package katas.unicodeconverter

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

private const val PAGE_BREAK = "PAGE_BREAK"

class HtmlPagesConverter(filename: String) {
    private val content = HashMap<Int, List<String>>()

    init {
        try {
            BufferedReader(FileReader(filename)).use { reader ->
                var currentPage = 0
                val lines = reader.readLines()
                lines.forEach { line ->
                    if (line == PAGE_BREAK) {
                        currentPage++
                    } else {
                        content[currentPage] = content.getOrElse(currentPage) { emptyList() } + line
                    }
                }
            }
        } catch (exception: IOException) {
            throw ReadingError(exception.message)
        }
    }

    fun getHtmlPage(page: Int): String {
        val pageContent = content[page] ?: throw PageNotFoundError("Page $page not found")

        val htmlPage = StringBuffer()

        pageContent.forEach { singleLine ->
            if (!singleLine.contains(PAGE_BREAK)) {
                htmlPage.append(StringEscapeUtils.escapeHtml(singleLine))
                htmlPage.append("<br />")
            }
        }

        return htmlPage.toString()
    }
}
