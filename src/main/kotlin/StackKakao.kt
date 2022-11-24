import java.util.*

private class StackKakao {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val stack = Stack<Int>()

        moves.forEach { move ->
            for (i in board.indices) {
                val take = board[i][move - 1]
                if (take != 0) {
                    if (stack.isNotEmpty() && stack.peek() == take) {
                        stack.pop()
                        answer += 2
                    } else {
                        stack.push(take)
                    }
                    board[i][move - 1] = 0
                    break
                }
            }
        }

        return answer
    }
}

fun main() {
    val solution = StackKakao()
    val s = solution.solution(
        arrayOf(
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 0, 3),
            intArrayOf(0, 2, 5, 0, 1),
            intArrayOf(4, 2, 4, 4, 2),
            intArrayOf(3, 5, 1, 3, 1)
        ),
        intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
    )
    println("answer $s")
}