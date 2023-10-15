import kotlin.math.roundToLong

fun main() {
    println(repeatedString("gfcaaaecbg", 547602) == 164280L)
    println()
    println(repeatedString("aba", 10) == 7L)
    println()
    println(repeatedString("epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq", 549382313570))
    println(repeatedString("epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq", 549382313570) == 16481469408L)
}

fun repeatedString(s: String, n: Long): Long {
    val charToFind = 'a'

    if (s.isEmpty() || s.replace("a", "").isEmpty()) return n

    val occurrences = s.count { it == charToFind }

    println("Ocurrences of a: $occurrences, Longit. ${n.toDouble()}, length: ${s.length}, modulo: ${n % s.length}")

    return (occurrences * (n / s.length) + (n % s.length))
}
