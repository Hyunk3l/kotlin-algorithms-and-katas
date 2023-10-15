import java.io.BufferedReader
import java.io.StringReader
import jdk.jshell.execution.Util

fun readFileFromResources(fileName: String): Content {
    val file = Util::class::class.java.getResource(fileName)?.readText()

    val reader = BufferedReader(StringReader(file!!))
    var line: String?
    var result = emptyArray<Array<Long>>()
    while (reader.readLine().also { line = it } != null) {
        result += line!!.trimEnd().split(" ").map{ it.toLong() }.toTypedArray()
    }
    reader.close()

    return Content(
        count = result[0][0],
        commonRation = result[0][1],
        expectedOutput = result[0][2],
        numbers = result[1]
    )
}

data class Content(val count: Long, val commonRation: Long, val expectedOutput: Long, val numbers: Array<Long>)
