package test

import java.util.LinkedList

private class NumberMate {
    fun solution(X: String, Y: String): String {
        var answer: String = ""

        val y = Y.toList().groupingBy { it }.eachCount().toMutableMap()

        val z = LinkedList<Char>()

        X.forEach { char ->
            y[char]?.also {
                if (it >= 1) {
                    z.add(char)
                    y[char] = it - 1
                }
            }
        }

        if (z.isEmpty()) {
            return "-1"
        }

        if (z.none { it != '0' }) {
            return "0"
        }

        answer = z.sortedDescending().joinToString("")

        return answer
    }
}

fun main() {
    val solution = NumberMate()
    val s = solution.solution("100", "123450")
    println("answer $s")
}