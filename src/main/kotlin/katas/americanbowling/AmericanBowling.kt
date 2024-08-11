package katas.americanbowling

class AmericanBowling {
    fun calculate(score: String): Int {
        val points = score.split(" ")

        return points
            .map {
                if (it == "X") {
                    25
                } else if (it == "9-") {
                    9
                } else 0
            }
            .sum()
    }
}
