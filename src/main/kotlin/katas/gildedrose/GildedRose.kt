package katas.gildedrose

private const val MAX_QUALITY = 50
private const val AGED_BRIE = "Aged Brie"
private const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
private const val SULFURAS = "Sulfuras, Hand of Ragnaros"

class GildedRose(var items: List<BaseItem>) {

    fun updateQuality() {

        items.forEach {

            it.update()

            if (it.isItemExpired()) {
                if (it.name == AGED_BRIE && it.quality < MAX_QUALITY) {
                    it.quality++
                } else if (it.name != BACKSTAGE) {
                    if (it.quality > 0) {
                        if (it.name != SULFURAS) {
                            it.quality--
                        }
                    }
                } else {
                    it.quality = 0
                }
            }
        }
    }
}
