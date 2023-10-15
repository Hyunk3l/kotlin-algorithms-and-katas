fun twoStrings(s1: String, s2: String): String {
    val result = s1.split("").intersect(s2.split("").toSet()).filter { it.isNotEmpty() }
    return if (result.isNotEmpty()) "YES" else "NO"
}

fun main() {
    val result = twoStrings("hi", "world")

    println(result)
}
