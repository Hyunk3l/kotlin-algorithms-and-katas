fun main(args: Array<String>) {

    minimumBribes(arrayOf(1, 2, 5, 3, 7, 8, 6, 4))
}


fun minimumBribes(q: Array<Int>): Unit {
    // 2 1 5 3 4 -> 3
    // 2 5 1 3 4 -> Too chaotic
    // 1 2 5 3 7 8 6 4 -> 2 + 2 + 2 + 1 = 7

    var numberOfBribes = 0
    for ((index: Int, current: Int) in q.withIndex()) {
        var currentNumberCount = 0
        for (internalIndex: Int in index+1 until q.count()) {
            if (q[internalIndex] < current) {
                currentNumberCount++
            }
        }
        if (currentNumberCount > 2) {
            println("Too chaotic")
            return
        } else {
            numberOfBribes += currentNumberCount
        }
    }
    if (numberOfBribes > 0) println(numberOfBribes)
}
