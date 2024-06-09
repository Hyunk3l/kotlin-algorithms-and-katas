package katas.wardrobe

class WardrobeConfigurator {
    fun getCombinations(wallSize: Int, modules: List<Int>): List<List<Int>> {
        val combinations = mutableMapOf<Int, MutableList<List<Int>>>()
        combinations[0] = mutableListOf(listOf())

        for (width in 1..wallSize) {
            val temporaryCombinations = mutableListOf<List<Int>>()
            for (module in modules) {
                if (width >= module && combinations.containsKey(width - module)) {
                    for (temporaryCombination in combinations[width - module]!!) {
                        temporaryCombinations.add(temporaryCombination + module)
                    }
                }
            }
            if (temporaryCombinations.isNotEmpty()) {
                combinations[width] = temporaryCombinations
            }
        }

        return combinations[wallSize]?.map {
            println(it)
            it.sorted()
        }?.toSet()?.toMutableList() ?: emptyList()
    }

    fun getCombinationsRecursive(
        wallSize: Int,
        modules: List<Int>,
        currentCombination: MutableList<Int>,
        result: MutableList<List<Int>> = mutableListOf()
    ): MutableList<List<Int>> {
        if (wallSize == 0) {
            result.add(currentCombination.toList())
            return result
        }

        if (wallSize < 0) return result

        for (module in modules) {
            currentCombination.add(module)
            getCombinationsRecursive(wallSize - module, modules, currentCombination, result)
            currentCombination.removeAt(currentCombination.size - 1)
        }
        return result
    }
}
