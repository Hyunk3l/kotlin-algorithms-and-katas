# Bank Kata by Sandro Mancuso

## Description
This kata is the Bank Kata by Sandro Mancuso, but instead of Java, it's in Kotlin.
You can see the video by Sandro [here](https://www.youtube.com/watch?v=XHnuMjah6ps).

## Description of the Bank Kata
Create a simple Bank application with the following features:
- Deposit into Account
- Withdraw from an Account
- Print a bank statement to the console

### Acceptance criteria

Statement should have transactions in the following format:

DATE       | AMOUNT | BALANCE
10/04/2014 | 500.00  | 1400.00
02/04/2014 | -100.00 | 900.00
01/04/2014 | 1000.00 | 1000.00

### Starting point and constraints

Start with a class with the following structure
```
class Account {
    fun deposit(amount: Int) {
        TODO()
    }
    
    fun withdraw(amount: Int) {
        TODO()
    }
    
    fun printStatement() {
        TODO()
    }
}
```

- You are not allowed to add any other public method to this class.
- Use String and Integers for dates and amounts (Keep it simple).
- Don't worry about spacing in the statement printed on the console.
