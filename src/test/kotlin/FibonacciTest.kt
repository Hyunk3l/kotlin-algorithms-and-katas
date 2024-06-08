import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class FibonacciTest {
    @Test
    fun `should solve simple fibonacci of 1 using brute force`() {
        val result = Fibonacci().getFromUsingBruteForce(1)

        result shouldBe 1
    }
    @Test
    fun `should solve fibonacci of 10 using brute force`() {
        val result = Fibonacci().getFromUsingBruteForce(10)

        result shouldBe 55
    }
}
