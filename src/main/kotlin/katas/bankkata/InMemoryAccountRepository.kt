package katas.bankkata

import java.time.Clock

class InMemoryAccountRepository(
    private val clock: Clock,
    private val transactions: MutableList<Transaction> = mutableListOf()
) : AccountRepository {
    override fun book(amount: Int) {
        Transaction(
            date = clock.toString(),
            amount = amount,
        ).let {
            transactions.add(it)
        }
    }

    override fun findListOfTransactions(): List<Transaction> = transactions.toList()
}
