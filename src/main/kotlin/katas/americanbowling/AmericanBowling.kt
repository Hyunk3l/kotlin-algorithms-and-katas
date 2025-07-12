package katas.americanbowling

private const val STRIKE = "X"
private const val MAX_POINTS = 300
private const val MAX_FRAMES_WITH_STRIKES = 12

class AmericanBowling {
    fun calculate(score: String): Int {
        val points = score.split(" ")

        if (points.isAllStrikes()) {
            return MAX_POINTS
        }

        return points
            .map {
                val shots = it.split("")

                if (shots[1].isStrike() || shots.isSpare()) {
                    10
                } else if (shots[1] == "9" && shots[2] == "-") {
                    9
                } else if (shots[2].isEmpty()) {
                    throw RuntimeException("Game not finished, player is still missing one shot")
                } else if (shots.isSummable()) {
                    shots[1].toInt() + shots[2].toInt()
                } else 0
            }
            .sum()
    }

    private fun String.isStrike() = this == STRIKE

    private fun List<String>.isSpare() = this[2] == "/"

    private fun List<String>.isSummable(): Boolean {
        return this[1].toCharArray()[0].isDigit()
                && this[2].toCharArray()[0].isDigit()
    }

    private fun List<String>.isAllStrikes(): Boolean {
        if (this.size != MAX_FRAMES_WITH_STRIKES) return false

        return this.none { it != "X" }
    }
}
