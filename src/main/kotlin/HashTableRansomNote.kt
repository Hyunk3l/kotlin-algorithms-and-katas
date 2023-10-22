/*
 * Complete the 'checkMagazine' function below.
 *
 * The function accepts following parameters:
 *  1. STRING_ARRAY magazine
 *  2. STRING_ARRAY note
 */

fun checkMagazine(magazine: Array<String>, note: Array<String>, numberToFind: Int): Boolean {
    val map = HashMap<String, Int>()

    for (element in magazine) {
        map[element] = map.getOrDefault(element, 0) + 1
    }

    val commonElements = mutableListOf<String>()

    for (element in note) {
        if (map.containsKey(element) && map[element]!! > 0) {
            commonElements.add(element)
            map[element] = map[element]!! - 1
        }
    }

    return (commonElements.size >= numberToFind)
}

fun main(args: Array<String>) {
    val n = 4
    val magazine = "give me one grand today night".trimEnd().split(" ").toTypedArray()
    val note = "give one grand today".trimEnd().split(" ").toTypedArray()

    assert(checkMagazine(magazine, note, n))
    assert(checkMagazine(magazine, note, n))
}
