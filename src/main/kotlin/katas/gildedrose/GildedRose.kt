package katas.gildedrose

class GildedRose(var items: List<Item>) {
    fun updateQuality() { items.forEach { it.update() } }
}
