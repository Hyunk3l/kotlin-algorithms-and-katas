

fun main() {

    println(countTriplets(arrayOf(1, 2, 2, 4), 2) == 2L)

    println(countTriplets(arrayOf(1, 3, 9, 9, 27, 81), 3) == 6L)

    println(countTriplets(arrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), 1) == 161700L)
}

fun countTriplets(arr: Array<Long>, r: Long): Long {
    val start = System.currentTimeMillis()
    var counter = 0
    var first = 0
    var second = 1
    var third = 2
    do {
        if (checkCombination(third, second, first, arr, r)) counter++

        if (second == arr.size-2) {
            first++
            second = first+1
            third = second+1
        } else if (third == arr.size-1) {
            second++
            third = second+1
        } else third++
    } while ((third + second + first) < (arr.size-1 + arr.size-2 + arr.size-3 +1))

    println("Elapsed do/while: ${System.currentTimeMillis() - start} & counter: $counter")

    return counter.toLong()
}

fun checkCombination(thirdValue: Int, secondValue: Int, firstValue: Int, arr: Array<Long>, r: Long): Boolean {
    return (arr[thirdValue] / arr[secondValue]) == r && (arr[secondValue] / arr[firstValue]) == r
}
