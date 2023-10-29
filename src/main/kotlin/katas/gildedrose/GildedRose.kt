package katas.gildedrose

class GildedRose(var items: List<BaseItem>) {
    fun updateQuality() { items.forEach { it.update() } }
}
