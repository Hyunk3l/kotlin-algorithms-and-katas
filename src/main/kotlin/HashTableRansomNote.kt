/*
 * Complete the 'checkMagazine' function below.
 *
 * The function accepts following parameters:
 *  1. STRING_ARRAY magazine
 *  2. STRING_ARRAY note
 */

fun checkMagazine(magazine: Array<String>, note: Array<String>, numberToFind: Int): Unit {
    val divisor = getDivisor(magazine.size)
    var found = false
    if (magazine.size > 1000 && divisor > 0) {
        val newArraySize = magazine.size / divisor
        var start = 0
        for (i in 1..divisor) {
            val end = ( newArraySize * i ) - 1
            val subset = magazine.sliceArray(start until end)
            found = run(subset, note, numberToFind)
            start = end

            if (found) break
        }
    } else {
        found = run(magazine, note, numberToFind)
    }

    if (found) println("Yes") else println("No")
}

private fun run(magazine: Array<String>, note: Array<String>, numberToFind: Int): Boolean {
    var counter = 0
    for (element: String in magazine) {
        if (note.contains(element)) {
            counter++
        } else if (counter >= numberToFind) {
            return true
        }
    }
    return false
}

private fun getDivisor(number: Int): Int {
    val divisor = (10 downTo 1).takeWhile { number % it == 0 }
    return if (divisor.isEmpty()) 0 else divisor.last()
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val m = first_multiple_input[0].toInt()

    val n = first_multiple_input[1].toInt()

    val magazine = readLine()!!.trimEnd().split(" ").toTypedArray()

    val note = readLine()!!.trimEnd().split(" ").toTypedArray()

    checkMagazine(magazine, note, n)
}
