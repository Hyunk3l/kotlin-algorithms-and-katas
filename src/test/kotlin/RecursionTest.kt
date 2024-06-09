import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RecursionTest {
    @Test
    fun `should be able to power 5^5`() {
        val result = Recursion().power(5, 5)

        result shouldBe 3125
    }

    @Test
    fun `should be able to power 2^8`() {
        val result = Recursion().power(2, 8)

        result shouldBe 256
    }
}
