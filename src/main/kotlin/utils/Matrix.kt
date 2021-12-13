package utils

enum class Matrix(val value: List<List<Int>>) {
    H(
        listOf(
            listOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            listOf(1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            listOf(1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            listOf(1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            listOf(1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0),
            listOf(1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
            listOf(1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            listOf(1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0),
            listOf(1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
            listOf(1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
            listOf(1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0),
            listOf(1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
        )
    ),

    A(
        listOf(
            listOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
            listOf(1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0),
            listOf(1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1),
            listOf(1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1),
            listOf(1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0),
            listOf(1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1),
            listOf(1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1),
            listOf(1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1),
            listOf(1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0),
            listOf(1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0),
            listOf(1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0),
            listOf(1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1)
        )
    ),

    G(
        listOf(
            listOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
            listOf(0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0),
            listOf(0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1),
            listOf(0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1),
            listOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0),
            listOf(0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1),
            listOf(0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1),
            listOf(0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1),
            listOf(0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0),
            listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0),
            listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0),
            listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1)
        )
    );

    companion object {
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

        fun e(j: Int): List<Int> =
            MutableList(12) { 0 }.apply {
                if (j != 0) this[j - 1] = 1
            }
    }
}
