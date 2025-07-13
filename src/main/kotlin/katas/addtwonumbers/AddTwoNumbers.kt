package katas.addtwonumbers

class AddTwoNumbers {
    fun addTwoNumbers(l1: List<Int>, l2: List<Int>): List<Int> {
        val biggerList = if (l1.count() >= l2.count()) l1 else l2
        var previousFirstDigit = 0

        val final = biggerList.mapIndexed { index, number ->
            val currentSecondNumber = if (l2.getOrNull(index) != null) l2[index] else 0
            val sum = number + currentSecondNumber + previousFirstDigit

            if (sum <= 9) {
                previousFirstDigit = 0
                sum
            } else {
                val split = sum.toString().split("")

                previousFirstDigit = split[1].toInt()

                split[2].toInt()
            }
        }
        return if (previousFirstDigit > 0) final + previousFirstDigit else final
    }
}
