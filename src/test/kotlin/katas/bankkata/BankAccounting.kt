package katas.bankkata

import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import java.time.Clock
import org.junit.jupiter.api.Test

class BankAccounting {
    @Test
    fun `should print a valid statement`() {
        val clock = mockk<Clock>()
        every {
            clock.toString()
        } returnsMany listOf("01/04/2014", "02/04/2014", "10/04/2014")
        val printer = spyk<Printer>()
        val accountRepository = InMemoryAccountRepository(clock)
        val account = Account(printer, accountRepository)
        account.deposit(1000)
        account.withdraw(100)
        account.deposit(500)

        account.printStatement()

        verify {
            printer.print("DATE       | AMOUNT | BALANCE")
            printer.print("10/04/2014 | 500.00 | 1400.00")
            printer.print("02/04/2014 | -100.00 | 900.00")
            printer.print("01/04/2014 | 1000.00 | 1000.00")
        }
    }
}
