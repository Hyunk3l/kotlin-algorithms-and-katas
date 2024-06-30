package katas.numbertolcd

class NumberToLCD {

    private val lcdNumbers = mapOf(
        1 to listOf("   ", "  |", "  |"),
        2 to listOf("  _", " _|", "|_ "),
        3 to listOf("  _", " _|", " _|"),
        4 to listOf("   ", "|_|", "  |"),
        5 to listOf("  _", "|_ ", " _|"),
        6 to listOf("  _", "|_ ", "|_|"),
        7 to listOf("  _", "  |", "  |"),
        8 to listOf("  _", "|_|", "|_|"),
        9 to listOf("  _", "|_|", " _|"),
    )

    operator fun invoke(number: Int): String {
        val availableLcdNumbers = mutableListOf<List<String>>()
        number.toString().forEach {
            if (it.digitToInt() in lcdNumbers) {
                availableLcdNumbers.add(lcdNumbers[it.digitToInt()]!!)
            }
        }

        val result = StringBuilder()
        (0..2).forEach {
            availableLcdNumbers.forEach { available ->
                result.append(available[it])
            }
            result.append("\n")
        }
        return result.toString().trimIndent()
    }
}
