package level1

import java.lang.Integer.max
import java.lang.Integer.min

class TwoNumberSum2 {
    fun solution(a: Int, b: Int): Long {
        return (min(a, b)..max(a, b)).sumOf { it.toLong() }
    }
}

fun main() {
    val solution = TwoNumberSum2()
    val s = solution.solution(1, 1)
    println("answer $s")
}