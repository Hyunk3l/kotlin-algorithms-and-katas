package katas.americanbowling

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class AmericanBowlingShould {
    @Test
    fun `calculate max score`() {
        val score = "X X X X X X X X X X X X"

        val result = AmericanBowling().calculate(score)

        result shouldBe 300
    }

    @Test
    fun `calculate 20 rolls, 10 pairs of 9 and miss`() {
        val score = "9- 9- 9- 9- 9- 9- 9- 9- 9- 9-"

        val result = AmericanBowling().calculate(score)

        result shouldBe 90
    }

    @Test
    fun `calculate 19 rolls, 1 strike, 9 pairs of 9 and miss`() {
        val score = "X 9- 9- 9- 9- 9- 9- 9- 9- 9-"

        val result = AmericanBowling().calculate(score)

        result shouldBe 91
    }
}
