package utils

import java.util.*

object StringUtils {
    fun stringToBinaryArray(input: String): List<Int> {
//        Remove any symbols that are not 0 or 1
        input.replace("[^01]".toRegex(), "")

//        Get integer array
        return input.map {
            Integer.valueOf(it.toString())
        }
    }

    fun binaryArrayToString(input: List<Int>): String {
        return input.joinToString("")
    }
}