package katas.gildedrose

private const val MAX_QUALITY = 50
private const val AGED_BRIE = "Aged Brie"
private const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
private const val SULFURAS = "Sulfuras, Hand of Ragnaros"

class GildedRose(var items: List<Item>) {

    fun updateQuality() {

        items.forEach {
            if (!it.isSpecialItem()) {
                it.decreaseQualityByOne()
            } else {
                if (it.quality < MAX_QUALITY) {
                    it.increaseQualityByOne()

                    if (it.name == BACKSTAGE) {
                        if (it.sellIn < 11) {
                            if (it.quality < MAX_QUALITY) {
                                it.quality += 1
                            }
                        }

                        if (it.sellIn < 6) {
                            if (it.quality < MAX_QUALITY) {
                                it.quality += 1
                            }
                        }
                    }
                }
            }

            if (it.name != SULFURAS) {
                it.sellIn -= 1
            }

            if (it.isItemExpired()) {
                if (it.name != AGED_BRIE) {
                    if (it.name != BACKSTAGE) {
                        if (it.quality > 0) {
                            if (it.name != SULFURAS) {
                                it.quality -= 1
                            }
                        }
                    } else {
                        it.quality = 0
                    }
                } else {
                    if (it.quality < MAX_QUALITY) {
                        it.quality += 1
                    }
                }
            }
        }
    }
}
