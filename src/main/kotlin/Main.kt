import Golay.Companion.decode
import Golay.Companion.encode
import utils.StringUtils

fun main() {
    println("Enter a string you wish to encode:")
//    val bits = readLine()
    val bits = "000111000111"

    var encoded = encode(StringUtils.stringToBinaryArray(bits))
    println(StringUtils.binaryArrayToString(encoded))

    encoded = invert(encoded, listOf(1, 2, 4))
    val decoded = decode(encoded)
    println(StringUtils.binaryArrayToString(decoded))
}

fun invert(text: List<Int>, positions: List<Int>): List<Int> {
    val copy = text.toMutableList()
    positions.forEach {
        copy[it] = (copy[it] + 1) % 2
    }
    return copy
}