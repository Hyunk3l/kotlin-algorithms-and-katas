package katas.gildedrose

private const val MAX_QUALITY = 50
private const val AGED_BRIE = "Aged Brie"
private const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
private const val SULFURAS = "Sulfuras, Hand of Ragnaros"

class GildedRose(var items: List<BaseItem>) {

    fun updateQuality() {
        items.forEach { it.update() }
    }
}
