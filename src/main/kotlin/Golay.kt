import utils.Matrix
import utils.Matrix.Companion.add
import utils.Matrix.Companion.append
import utils.Matrix.Companion.e
import utils.Matrix.Companion.multiply
import utils.Matrix.Companion.transpose
import utils.Matrix.Companion.weight

class Golay {
    companion object {
        fun encode(input: List<Int>): List<Int> {
            return append(input, multiply(input, Matrix.A.value))
        }

        fun decode(input: List<Int>, isRepeat: Boolean = false): List<Int> {
//    1.
            val s1 = multiply(input, transpose(Matrix.G.value))
            val s2 = multiply(input, transpose(Matrix.H.value))

            val w1 = weight(s1)
            val w2 = weight(s2)

//    Since both weights equal to 0, word has not been mutated
            if (w1 == 0 && w2 == 0)
                return input

// 2.
            if (w1 <= 3 && w2 >= 5)
                return add(input, append(s1, e(0)))

//    3.
            if (w2 <= 3 && w1 >= 5)
                return add(input, append(e(0), s2))

//    4.
            if (isRepeat)
                throw IllegalArgumentException("Data is too corrupted.")

            if (w1 >= 5 && w2 >= 5) {
                var countLessThan2 = 0
                var countMoreThan4 = 0
                var index = -1

                for (i in 1..12) {
                    val s1i = add(s1, multiply(e(i), Matrix.A.value))
                    val weight = weight(s1i)
                    if (weight <= 2) {
                        countLessThan2 += 1
                        index = i
                    } else if (weight >= 4) {
                        countMoreThan4 += 1
                    }
                }

                if (countLessThan2 == 1 && countMoreThan4 == 11) {
                    return decode(add(input, append(e(0), e(index))), true)
                }

                countLessThan2 = 0
                countMoreThan4 = 0
                index = -1

                for (i in 1..12) {
                    val s2i = add(s2, multiply(e(i), Matrix.A.value))
                    val weight = weight(s2i)
                    if (weight <= 2) {
                        countLessThan2 += 1
                        index = i
                    } else if (weight >= 4) {
                        countMoreThan4 += 1
                    }
                }

                if (countLessThan2 == 1 && countMoreThan4 == 11) {
                    return decode(add(input, append(e(index), e(0))))
                }
            }

            throw IllegalArgumentException("Data is too corrupted.")
        }
    }
}
