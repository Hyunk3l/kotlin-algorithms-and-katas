package katas.unicodeconverter

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

private const val PAGE_BREAK = "PAGE_BREAK"

class HtmlPagesConverter(fileReader: PersonalFileReader<String>) {
    private val content = HashMap<Int, List<String>>()

    init {
        var currentPage = 0
        fileReader.read().forEach { line ->
            if (line == PAGE_BREAK) {
                currentPage++
            } else {
                content[currentPage] = content.getOrElse(currentPage) { emptyList() } + line
            }
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

class FileReaderFromResources(val filename: String) : PersonalFileReader<String> {
    override fun read(): List<String> {
        try {
            BufferedReader(FileReader(filename)).use { reader ->
                return reader.readLines()
            }
        } catch (exception: IOException) {
            throw ReadingError(exception.message)
        }
    }
}

interface PersonalFileReader<T> {
    fun read(): List<T>
}
