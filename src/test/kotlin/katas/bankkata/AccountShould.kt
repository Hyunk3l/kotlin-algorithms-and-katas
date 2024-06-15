package katas.bankkata

import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

private val printer = mockk<Printer>(relaxed = true)
private val accountRepository = mockk<AccountRepository>()
private val account = Account(printer = printer, repository = accountRepository)

class AccountShould {
    @Test
    fun `deposit amount in a bank account`() {
        val amount = 1000
        justRun { accountRepository.book(amount) }

        account.deposit(amount)

        verify { accountRepository.book(amount) }
    }

    @Test
    fun `withdraw amount in a bank account`() {
        val amount = 500
        justRun { accountRepository.book(-amount) }

        account.withdraw(amount)

        verify { accountRepository.book(-amount) }
    }

    @Test
    fun `print the entire bank statement`() {
        every { accountRepository.findListOfTransactions() } returns listOf(
            Transaction(date = "01/04/2014", amount = 100),
            Transaction(date = "02/04/2014", amount = -100),
        )

        account.printStatement()

        verify {
            printer.print("DATE       | AMOUNT | BALANCE")
            printer.print("02/04/2014 | -100.00 | 0.00")
            printer.print("01/04/2014 | 100.00 | 100.00")
        }
    }
}
