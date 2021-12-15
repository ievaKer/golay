import Golay.Companion.decode
import Golay.Companion.encode
import utils.StringUtils
import java.lang.Exception

fun main() {
    println("Hello!")
    println()
    println("What would you like to do?")
    println("0 - exit")
    println("1 - encode")
    println("2 - decode")
    println("3 - invert bits")
    println()

    var entered: String? = ""

    while (entered != "0") {
        entered = readLine()

        if (entered == "1") {
            println("Enter bytes to encode:")

            entered = readLine()
            if (entered?.length != 12)  {
                println("Wrong string length. Please enter 12 bits.")
            } else if (("[^01]".toRegex()).find(entered) != null) {
                println("Please enter only 0 or 1.")
            } else {
                val encoded = encode(StringUtils.stringToBinaryArray(entered))
                println("Encoded bits:")
                println(StringUtils.binaryArrayToString(encoded))
            }
            continue
        }

        if (entered == "2") {
            println("Enter bytes to decode:")

            entered = readLine()
            if (entered?.length != 24)  {
                println("Wrong string length. Please enter 12 bits.")
            } else if (("[^01]".toRegex()).find(entered) != null) {
                println("Please enter only 0 or 1.")
            } else {
                try {
                    val decoded = decode(StringUtils.stringToBinaryArray(entered))
                    println("Code word:")
                    println(StringUtils.binaryArrayToString(decoded))
                } catch (e: Exception) {
                    println(e.message)
                }
            }
            continue
        }

        if (entered == "3") {
            println("Enter bits:")
            val bits = readLine()
            if (bits == null || bits.length < 0 || ("[^01]".toRegex()).find(bits) != null) {
                println("This is not a valid bit list!")
                continue
            }

            val positions = mutableListOf<Int>()
            println("Which positions to invert?")
            entered = readLine()

            while (entered != "") {
                try {
                    positions.add(Integer.valueOf(entered))
                } catch (e: Exception) {
                    println("Not a valid number!")
                }
                entered = readLine()
            }

            val inverted = invert(StringUtils.stringToBinaryArray(bits), positions)
            println("Inverted bits:")
            println(StringUtils.binaryArrayToString(inverted))
            continue
        }

        if (entered != "0") {
            println("$entered is not a valid option!")
        }
    }

    println("Bye!")
}

fun invert(text: List<Int>, positions: List<Int>): List<Int> {
    val copy = text.toMutableList()
    positions.forEach {
        if (it >= 0 || it < copy.size) copy[it] = (copy[it] + 1) % 2
    }
    return copy
}