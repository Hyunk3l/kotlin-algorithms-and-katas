package katas.bankkata

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

class Account(private val printer: Printer, private val repository: AccountRepository) {
    fun deposit(amount: Int) {
        repository.book(amount)
    }

    fun withdraw(amount: Int) {
        repository.book(-amount)
    }

    fun printStatement() {
        printer.print("DATE       | AMOUNT | BALANCE")

        repository.findListOfTransactions()
            .calculateBalance()
            .sortByDateDescending()
            .printStatementLine()
    }

    private fun List<Transaction>.calculateBalance(): List<Triple<String, Int, Double>> {
        var balance = 0.00
        return this.map {
            balance += it.amount
            Triple(it.date, it.amount, balance)
        }
    }

    private fun List<Triple<String, Int, Double>>.sortByDateDescending() =
        this.sortedByDescending { it.first }

    private fun List<Triple<String, Int, Double>>.printStatementLine() {
        val decimalFormat = DecimalFormat("#0.00", DecimalFormatSymbols(Locale.US))

        this.forEach {
            printer.print(
                "${it.first} | ${decimalFormat.format(it.second)} | ${decimalFormat.format(it.third)}"
            )
        }
    }
}
