package katas.wardrobe

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class WardrobeConfiguratorTest {

    private val wardrobeConfigurator = WardrobeConfigurator()

    @Test
    fun `should be able to find one combination`() {
        val expected = listOf(
            listOf(50, 50, 50, 50, 50)
        )

        val result = wardrobeConfigurator
            .getCombinations(wallSize = 250, modules = listOf(50))

        result shouldBe expected
    }

    @Test
    fun `should be able to find two combinations`() {
        val expected = listOf(
            listOf(50, 50, 50, 50, 50),
            listOf(50, 50, 75, 75)
        )

        val result = wardrobeConfigurator
            .getCombinations(wallSize = 250, modules = listOf(50, 75))

        result shouldBe expected
    }

    @Test
    fun `should be able to find all the possible combinations`() {
        val expected = listOf(
            listOf(50, 50, 50, 50, 50),
            listOf(50, 50, 50, 100),
            listOf(50, 50, 75, 75),
            listOf(50, 100, 100),
            listOf(75, 75, 100),
        )

        val result = wardrobeConfigurator
            .getCombinations(wallSize = 250, modules = listOf(50, 75, 100, 120))

        result shouldBe expected
    }

    @Test
    fun `should be able to find all the possible combinations using recursion`() {
        val expected = listOf(
            listOf(50, 50, 50, 50, 50),
            listOf(50, 50, 50, 100),
            listOf(50, 50, 75, 75),
            listOf(50, 100, 100),
            listOf(75, 75, 100),
        )

        val result = wardrobeConfigurator
            .getCombinationsRecursive(
                wallSize = 250,
                modules = listOf(50, 75, 100, 120),
                currentCombination = mutableListOf(),
                result = mutableListOf()
            ).map { it.sorted() }.toSet()

        result shouldBe expected
    }
}
