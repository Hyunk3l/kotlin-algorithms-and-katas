

class Fibonacci {
    fun getFromUsingBruteForce(number: Int): Int {
        if (number <= 1) { return number }
        val counter = mutableMapOf<Int, Int>()
        counter[0] = 0
        counter[1] = 1
        for (i in 2..number) {
            counter[i] = counter[i-2]!! + counter[i-1]!!
        }
        return counter[number]!!
    }
}
