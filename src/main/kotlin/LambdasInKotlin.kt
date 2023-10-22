
private fun operation(first: Int, second: Int, predicate: (Int, Int) -> Int) {
    println("Operation $first $second: ${predicate(first, second)}")
}

private fun <T> genericOperation(first: T, second: T, predicate: (T, T) -> T) {
    println("Generic operation $first $second: ${predicate(first, second)}")
}

fun main() {
    operation(2, 2) { a, b -> a + b }
    operation(2, 3) { a, b -> a * b }
    operation(6, 2) { a, b -> a - b }
    operation(6, 2) { a, b -> a / b }

    println("--------------------------------------")

    genericOperation(2, 2) { a, b -> a + b }
    genericOperation("Hello", "World") { a, b -> "$a $b" }
    genericOperation("Hello", 2) { a, b -> "$a + $b" }
}
