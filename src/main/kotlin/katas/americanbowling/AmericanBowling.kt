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
                if (it.isStrike()) {
                    10
                } else if (it == "9-") {
                    9
                } else 0
            }
            .sum()
    }

    private fun String.isStrike() = this == STRIKE

    private fun List<String>.isAllStrikes(): Boolean {
        if (this.size != MAX_FRAMES_WITH_STRIKES) return false

        return this.none { it != "X" }
    }
}
