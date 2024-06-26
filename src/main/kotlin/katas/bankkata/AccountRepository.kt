package katas.bankkata

interface AccountRepository {
    fun book(amount: Int)

    fun findListOfTransactions(): List<Transaction>
}
