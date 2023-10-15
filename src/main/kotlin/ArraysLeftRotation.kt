fun main(args: Array<String>) {

    println(rotateRight(1..5, 2) == listOf(3, 4, 5, 1, 2))
    println(rotateRight(1..5, 4) == listOf(5, 1, 2, 3, 4))

}

private fun rotateRight(array: IntRange, positionsToLeft: Int): List<Int> {
    val leftArray = mutableListOf<Int>()
    val rightArray = mutableListOf<Int>()

    for ((index: Int, value: Int) in array.withIndex()) {
        if (index >= positionsToLeft) {
            leftArray.add(value)
        } else if (index < positionsToLeft) {
            rightArray.add(value)
        }
    }
    return leftArray + rightArray
}
