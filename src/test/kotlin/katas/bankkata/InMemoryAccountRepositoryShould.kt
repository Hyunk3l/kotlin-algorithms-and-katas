package katas.bankkata

import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.time.Clock
import org.junit.jupiter.api.Test

private val clock = mockk<Clock>()
private val inMemoryAccountRepository = InMemoryAccountRepository(clock)

class InMemoryAccountRepositoryShould {
    @Test
    fun `book a transaction`() {
        every { clock.toString() } returns "01/04/2014"

        inMemoryAccountRepository.book(100)

        verify { clock.toString() }
    }

    @Test
    fun `book a transaction with negative amount`() {
        every { clock.toString() } returns "01/04/2014"

        inMemoryAccountRepository.book(-100)

        verify { clock.toString() }
    }

    @Test
    fun `find a list of transactions`() {
        every { clock.toString() } returnsMany listOf("01/04/2014", "02/04/2014")
        val inMemoryAccountRepository = InMemoryAccountRepository(clock)
        inMemoryAccountRepository.book(100)
        inMemoryAccountRepository.book(-100)

        val result = inMemoryAccountRepository.findListOfTransactions()

        result shouldBe listOf(
            Transaction(date = "01/04/2014", amount = 100),
            Transaction(date = "02/04/2014", amount = -100),
        )
        verify { clock.toString() }
    }
}
