package katas.bankkata

import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class AccountShould {
    @Test
    fun `deposit amount in a bank account`() {
        val amount = 1000
        val printer = mockk<Printer>()
        val accountRepository = mockk<AccountRepository>()
        val account = Account(printer = printer, repository = accountRepository)
        justRun { accountRepository.book(amount) }

        account.deposit(amount)

        verify { accountRepository.book(amount) }
    }

    @Test
    fun `withdraw amount in a bank account`() {
        val amount = 500
        val printer = mockk<Printer>()
        val accountRepository = mockk<AccountRepository>()
        val account = Account(printer = printer, repository = accountRepository)
        justRun { accountRepository.book(-amount) }

        account.withdraw(amount)

        verify { accountRepository.book(-amount) }
    }
}
