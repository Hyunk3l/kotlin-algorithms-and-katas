package katas.americanbowling

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
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

    @Test
    fun `calculate 19 rolls, 1 strike, 1 spare, 8 pairs of 9 and miss`() {
        val score = "X 5/ 9- 9- 9- 9- 9- 9- 9- 9-"

        val result = AmericanBowling().calculate(score)

        result shouldBe 92
    }

    @Test
    fun `calculate 19 rolls, 1 strike, 1 spare, 1 frame of 4, 7 pairs of 9 and miss`() {
        val score = "X 5/ 9- 9- 9- 9- 9- 9- 9- 31"

        val result = AmericanBowling().calculate(score)

        result shouldBe 87
    }

    @Test
    fun `calculate 9 strikes and one missed frame`() {
        val score = "X X X X X X X X X --"

        val result = AmericanBowling().calculate(score)

        result shouldBe 240
    }

    @Test
    fun `throw an error in case game is not finished`() {
        val score = "X 9- 9- 9- 9- 9- 9- 9- 9- 9"

        val exception = shouldThrow<RuntimeException> {
            AmericanBowling().calculate(score)
        }
        exception.message should startWith("Game not finished, player is still missing one shot")
    }
}
