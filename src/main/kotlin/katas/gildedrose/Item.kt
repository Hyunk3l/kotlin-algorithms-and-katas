package katas.gildedrose

private const val MAX_QUALITY = 50
private const val AGED_BRIE = "Aged Brie"
private const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
private const val SULFURAS = "Sulfuras, Hand of Ragnaros"

sealed class BaseItem(open var name: String, open var sellIn: Int, open var quality: Int) {

    data class Item(override var name: String, override var sellIn: Int, override var quality: Int) :
        BaseItem(name, sellIn, quality)

    data class AgedBrie(override var name: String = AGED_BRIE, override var sellIn: Int, override var quality: Int) :
        BaseItem(name, sellIn, quality)

    data class Backstage(override var name: String = BACKSTAGE, override var sellIn: Int, override var quality: Int) :
        BaseItem(name, sellIn, quality)

    data class Sulfuras(override var name: String = SULFURAS, override var sellIn: Int, override var quality: Int) :
        BaseItem(name, sellIn, quality)

    fun isSpecialItem(): Boolean = this.name == AGED_BRIE
            || this.name == BACKSTAGE
            || this.name == SULFURAS

    fun decreaseQualityByOne() {
        if (this.quality > 0) {
            this.quality--
        }
    }

    fun increaseQualityByOne() {
        if (this.quality < MAX_QUALITY) {
            this.quality++
        }
    }

    fun isItemExpired(): Boolean = this.sellIn < 0
}
