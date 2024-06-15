package katas.bankkata

class Account(private val printer: Printer, private val repository: AccountRepository) {
    fun deposit(amount: Int) {
        repository.book(amount)
    }

    fun withdraw(amount: Int) {
        repository.book(-amount)
    }

    fun printStatement() {
        TODO()
    }
}
