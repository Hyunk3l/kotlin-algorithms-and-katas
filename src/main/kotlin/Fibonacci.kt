class Fibonacci {
    /**
     * Iterative DP (Tabulation) - time complexity of O(n) and space complexity of O(n)
     */
    fun getFromUsingIterativeDynamicProgramming(number: Int): Int {
        if (number <= 1) {
            return number
        }
        val counter = mutableMapOf<Int, Int>()
        counter[0] = 0
        counter[1] = 1
        for (i in 2..number) {
            counter[i] = counter[i - 2]!! + counter[i - 1]!!
        }
        return counter[number]!!
    }

    /**
     * Not efficient - Brute force and recursive. Exponential time complexity.
     */
    fun getFromRecursive(number: Int): Int {
        if (number <= 1) return number
        return getFromRecursive(number - 1) + getFromRecursive(number - 2)
    }

    /**
     * Memoization (Recursive Dynamic Programming).
     */
    fun getFromMemoization(number: Int, memo: MutableMap<Int, Int>): Int {
        println("$number ${memo.values}")
        if (memo.containsKey(number)) return memo[number]!!
        if (number <= 1) return number

        memo[number] = getFromMemoization(number - 1, memo) + getFromMemoization(number - 2, memo)
        return memo[number]!!
    }
}
