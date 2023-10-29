package katas.gildedrose

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class GildedRoseShould {
    @Test
    fun `update quality of a single item`() {
        val items = listOf(
            Item(
                name = "Mozzarella",
                sellIn = 5,
                quality = 50
            )
        )
        val gilded = GildedRose(items = items)

        gilded.updateQuality()

        items[0].quality shouldBe 49
        items[0].name shouldBe "Mozzarella"
    }

    @Test
    fun `degrade quality twice faster if sell in date has passed`() {
        val items = listOf(
            Item(
                name = "Mozzarella",
                sellIn = 0,
                quality = 50
            )
        )
        val gilded = GildedRose(items = items)

        gilded.updateQuality()

        items[0].quality shouldBe 48
        items[0].name shouldBe "Mozzarella"
    }

    @Test
    fun `not update in case quality is 0`() {
        val items = listOf(
            Item(
                name = "Mozzarella",
                sellIn = 1,
                quality = 0
            )
        )
        val gilded = GildedRose(items = items)

        gilded.updateQuality()

        items[0].quality shouldBe 0
        items[0].name shouldBe "Mozzarella"
        items[0].sellIn shouldBe 0
    }

    @Test
    fun `increase quality of the Aged Brie`() {
        val items = listOf(
            Item(
                name = "Aged Brie",
                sellIn = 10,
                quality = 10
            )
        )
        val gilded = GildedRose(items = items)

        gilded.updateQuality()

        items[0].quality shouldBe 11
        items[0].name shouldBe "Aged Brie"
        items[0].sellIn shouldBe 9
    }

    @Test
    fun `not update quality by more than 50`() {
        val items = listOf(
            Item(
                name = "Aged Brie",
                sellIn = 10,
                quality = 50
            )
        )
        val gilded = GildedRose(items = items)

        gilded.updateQuality()

        items[0].quality shouldBe 50
        items[0].name shouldBe "Aged Brie"
        items[0].sellIn shouldBe 9
    }

    @Test
    fun `increase quality by 3 if 5 or less days left`() {
        val items = listOf(
            Item(
                name = "Backstage passes to a TAFKAL80ETC concert",
                sellIn = 5,
                quality = 10
            )
        )
        val gilded = GildedRose(items = items)

        gilded.updateQuality()

        items[0].quality shouldBe 13
        items[0].name shouldBe "Backstage passes to a TAFKAL80ETC concert"
        items[0].sellIn shouldBe 4
    }

    @Test
    fun `increase quality by 2 if 10 or less days left`() {
        val items = listOf(
            Item(
                name = "Backstage passes to a TAFKAL80ETC concert",
                sellIn = 10,
                quality = 10
            )
        )
        val gilded = GildedRose(items = items)

        gilded.updateQuality()

        items[0].quality shouldBe 12
        items[0].name shouldBe "Backstage passes to a TAFKAL80ETC concert"
        items[0].sellIn shouldBe 9
    }

    @Test
    fun `not increase quality of Sulfuras, must be always 80`() {
        val items = listOf(
            Item(
                name = "Sulfuras, Hand of Ragnaros",
                sellIn = 10,
                quality = 80
            )
        )
        val gilded = GildedRose(items = items)

        gilded.updateQuality()

        items[0].name shouldBe "Sulfuras, Hand of Ragnaros"
        items[0].sellIn shouldBe 10
        items[0].quality shouldBe 80
    }

    @Test
    fun `decrease quality to 0 if less than 0 sell in days for Backstage passes to a TAFKAL80ETC concert`() {
        val items = listOf(
            Item(
                name = "Backstage passes to a TAFKAL80ETC concert",
                sellIn = -1,
                quality = 5
            )
        )
        val gilded = GildedRose(items = items)

        gilded.updateQuality()

        items[0].name shouldBe "Backstage passes to a TAFKAL80ETC concert"
        items[0].sellIn shouldBe -2
        items[0].quality shouldBe 0
    }

    @Test
    fun `increase quality if Aged Brie sell in is less than 0`() {
        val items = listOf(
            Item(
                name = "Aged Brie",
                sellIn = -1,
                quality = 5
            )
        )
        val gilded = GildedRose(items = items)

        gilded.updateQuality()

        items[0].name shouldBe "Aged Brie"
        items[0].sellIn shouldBe -2
        items[0].quality shouldBe 7
    }
}
