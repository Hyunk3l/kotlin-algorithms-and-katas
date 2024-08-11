package katas.americanbowling

private const val STRIKE = "X"

class AmericanBowling {
    fun calculate(score: String): Int {
        val points = score.split(" ")

        return points
            .map {
                if (it.isStrike()) {
                    25
                } else if (it == "9-") {
                    9
                } else 0
            }
            .sum()
    }

    private fun String.isStrike() = this == STRIKE
}
