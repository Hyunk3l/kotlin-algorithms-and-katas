package katas.gildedrose

private const val MAX_QUALITY = 50
private const val AGED_BRIE = "Aged Brie"
private const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
private const val SULFURAS = "Sulfuras, Hand of Ragnaros"

sealed class BaseItem(open var name: String, open var sellIn: Int, open var quality: Int) {

    abstract fun update()

    abstract fun computeQuality()

    protected fun decreaseQualityBy(number: Int) {
        if (this.quality > 0) this.quality -= number
    }

    protected fun decreaseDaysByOne() {
        this.sellIn--
    }

    protected fun increaseQualityBy(number: Int) {
        if (this.quality < MAX_QUALITY) this.quality += number
    }

    protected fun isExpired(): Boolean = this.sellIn < 0

    data class Item(override var name: String, override var sellIn: Int, override var quality: Int) :
        BaseItem(name, sellIn, quality) {

        override fun update() {
            this.decreaseDaysByOne()
            this.computeQuality()
        }

        override fun computeQuality() {
            if (this.isExpired()) {
                this.decreaseQualityBy(2)
            } else {
                this.decreaseQualityBy(1)
            }
        }
    }

    data class AgedBrie(override var sellIn: Int, override var quality: Int) :
        BaseItem(AGED_BRIE, sellIn, quality) {

        override fun update() {
            this.decreaseDaysByOne()
            this.computeQuality()
        }

        override fun computeQuality() {
            this.increaseQualityBy(1)
            if (this.isExpired()) this.increaseQualityBy(1)
        }
    }

    data class Backstage(override var sellIn: Int, override var quality: Int) :
        BaseItem(BACKSTAGE, sellIn, quality) {
        override fun update() {
            this.decreaseDaysByOne()
            this.computeQuality()
        }

        override fun computeQuality() {
            if (this.sellIn < 6) {
                this.increaseQualityBy(3)
            } else if (this.sellIn < 11) {
                this.increaseQualityBy(2)
            } else {
                this.increaseQualityBy(1)
            }

            if (this.isExpired()) this.quality = 0
        }
    }

    data class Sulfuras(override var sellIn: Int, override var quality: Int) :
        BaseItem(SULFURAS, sellIn, quality) {
        override fun update() {
            this.computeQuality()
        }

        override fun computeQuality() {
            this.increaseQualityBy(1)
        }
    }
}
