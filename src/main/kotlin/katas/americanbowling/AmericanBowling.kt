package katas.americanbowling

class AmericanBowling {
    fun calculate(score: String): Int {
        val points = score.split(" ")

        return points.map { if (it == "X") 25 else 0 }.sum()
    }
}
