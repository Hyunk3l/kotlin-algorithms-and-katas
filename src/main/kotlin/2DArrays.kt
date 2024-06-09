/*
 * Complete the 'hourglassSum' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */

fun hourglassSum(arr: Array<Array<Int>>): Int {
    var counter: Int
    var previousCounter = 0
    for (row: Int in 0..3) {
        for (column: Int in 0..3) {
            counter = sumHoursFrom(row, column, arr)
            if (previousCounter < counter || previousCounter == 0) previousCounter = counter
        }
    }
    return previousCounter
}

private fun sumHoursFrom(
    startingRow: Int,
    startingColumn: Int,
    arr: Array<Array<Int>>
): Int {
    var counter = 0
    var countToSkip = 1
    for (firstIndex: Int in startingRow..startingRow + 2) {
        for (secondIndex: Int in startingColumn..startingColumn + 2) {
            if (countToSkip !in arrayOf(4, 6)) {
                counter += arr[firstIndex][secondIndex]
            }
            countToSkip++
        }
    }
    return counter
}

fun main() {

    val arr = Array(6) { Array(6, { 0 }) }

    for (i in 0 until 6) {
        arr[i] = readln().trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
    println(result == 19)
}
