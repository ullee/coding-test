package test

import java.lang.Integer.min

private class RowsAndColumns {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val answer = IntArray(queries.size)
        var minimalsIdx = 0

        val square = Array(rows) { IntArray(columns) }

        var value = 1
        (0 until columns).forEach { col ->
            (0 until rows).forEach { row ->
                square[col][row] = value
                value += 1
            }
        }

        queries.forEach { query ->
            val x1 = query[0] - 1
            val y1 = query[1] - 1
            val x2 = query[2] - 1
            val y2 = query[3] - 1
            val firstNum = square[x1][y2]
            var min = firstNum

            // 숫자를 우로 이동 (상단)
            for (i in y2 - 1 downTo y1) {
                min = min(min, square[x1][i])
                square[x1][i + 1] = square[x1][i]
            }

            // 숫자를 위로 이동 (좌측)
            for (i in x1 + 1..x2) {
                min = min(min, square[i][y1])
                square[i - 1][y1] = square[i][y1]
            }

            // 숫자를 좌로 이동 (하단)
            for (i in y1 + 1..y2) {
                min = min(min, square[x2][i])
                square[x2][i - 1] = square[x2][i]
            }

            // 숫자를 아래로 이동 (우측)
            for (i in x2 - 1 downTo x1) {
                min = min(min, square[i][y2])
                square[i + 1][y2] = square[i][y2]
            }

            square[x1+1][y2] = firstNum
            answer[minimalsIdx] = min
            minimalsIdx++
        }

        return answer
    }
}

fun main() {
    val solution = RowsAndColumns()
    val s = solution.solution(
        6,
        6,
        arrayOf(
            intArrayOf(2, 2, 5, 4),
            intArrayOf(3, 3, 6, 6),
            intArrayOf(5, 1, 6, 3),
        )
    )
    println("answer ${s.toList()}")
}