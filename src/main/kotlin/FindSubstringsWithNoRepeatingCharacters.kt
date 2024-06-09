class FindSubstringsWithNoRepeatingCharacters {
    fun findFrom(initial: String): List<String> {
        val combinations = mutableListOf<String>()
        val characters = initial.toCharArray()
        for (element in characters) {
            var accumulated = element.toString()
            for (secondElement in characters) {
                if (
                    !combinations.contains(element.toString())
                    && accumulated.contains(secondElement)
                    && element != secondElement
                ) {
                    accumulated = "${accumulated}${secondElement}"
                }
            }
            combinations.add(accumulated)
        }
        return combinations
    }
}
