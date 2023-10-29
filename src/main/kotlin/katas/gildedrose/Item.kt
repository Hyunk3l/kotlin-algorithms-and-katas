package katas.gildedrose

private const val AGED_BRIE = "Aged Brie"
private const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
private const val SULFURAS = "Sulfuras, Hand of Ragnaros"

open class Item(var name: String, var sellIn: Int, var quality: Int) {

    fun isSpecialItem(): Boolean = this.name == AGED_BRIE
            || this.name == BACKSTAGE
            || this.name == SULFURAS

    fun decreaseQualityByOne() {
        if (this.quality > 0) {
            this.quality--
        }
    }
}
