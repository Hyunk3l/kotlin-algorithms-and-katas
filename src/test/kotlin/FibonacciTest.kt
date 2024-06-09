import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class FibonacciTest {
    @Test
    fun `should solve simple fibonacci of 1 using iterative DP (tabulation)`() {
        val result = Fibonacci().getFromUsingIterativeDynamicProgramming(1)

        result shouldBe 1
    }
    @Test
    fun `should solve fibonacci of 10 using iterative DP (tabulation)`() {
        val result = Fibonacci().getFromUsingIterativeDynamicProgramming(10)

        result shouldBe 55
    }

    @Test
    fun `should solve fibonacci of 10 using recursive (brute force simple rec)`() {
        val result = Fibonacci().getFromRecursive(10)

        result shouldBe 55
    }

    @Test
    fun `should solve fibonacci of 10 using memoization (recursive DP)`() {
        val result = Fibonacci().getFromMemoization(10, mutableMapOf())

        result shouldBe 55
    }
}
