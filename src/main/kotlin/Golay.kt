import utils.Matrix

fun encode(input: List<Int>): List<Int> {
    return append(input, multiply(input, Matrix.A.value))
}

fun multiply(matrixA: List<Int>, matrixB: List<List<Int>>): List<Int> {
    val output = MutableList(matrixB[0].size) { 0 }

    matrixB[0].forEachIndexed { i, _ ->
        output[i] = 0
        matrixA.forEachIndexed { j, _ ->
            output[i] += matrixA[j] * matrixB[j][i]
        }

        output[i] %= 2
    }

    return output
}

fun append(arrayA: List<Int>, arrayB: List<Int>): List<Int> {
    return arrayA + arrayB
}

fun transpose(matrix: List<List<Int>>): List<List<Int>> {
    val transposed = MutableList(matrix[0].size) { MutableList(matrix.size) { 0 } }

    for (i in matrix.indices) {
        for (j in 0 until matrix[0].size) {
            transposed[j][i] = matrix[i][j]
        }
    }

    return transposed
}

fun weight(array: List<Int>): Int {
    return array.sum()
}

fun add(arrayA: List<Int>, arrayB: List<Int>): List<Int> {
    val output = MutableList(arrayA.size) { 0 }
    arrayA.forEachIndexed { i, _ ->
        output[i] = (arrayA[i] + arrayB[i]) % 2
    }

    return output
}


fun decode(input: List<Int>, isRepeat: Boolean = false): List<Int> {
//    1.
//    Find syndromes (vectors)
    val s1 = multiply(input, transpose(Matrix.G.value))
    val s2 = multiply(input, transpose(Matrix.H.value))

//    Calculate weight
    val w1 = weight(s1)
    val w2 = weight(s2)

//    Since both weights equal to 0, word has not been mutated
    if (w1 == 0 && w2 == 0) {
        return input
    }

// 2.
    if (w1 <= 3 && w2 >= 5) {
//        000101000111011010100101
//   s1 = 000010000000
//s1 + e0 = 000010000000000000000000
//        000101000111011010100101 +
//        000010000000000000000000 =
//        000111000111011010100101
        return add(input, append(s1, e(0)))
    }

//    3.
    if (w2 <= 3 && w1 >= 5) {
        return add(input, append(e(0), s2))
    }

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

fun e(j: Int): List<Int> =
    MutableList(12) { 0 }.apply {
        if (j != 0) this[j - 1] = 1
    }
