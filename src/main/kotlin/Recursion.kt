
class Recursion {
    fun power(number: Int, exponent: Int, memory: MutableMap<Int, Int> = emptyMap<Int, Int>().toMutableMap()): Int {
        if (memory.isEmpty()) {
            memory[exponent] = number
        } else {
            memory[exponent] = number * memory[exponent+1]!!
        }

        if (exponent <= 0) return memory[1]!!

        return power(number, exponent-1, memory)
    }
}
