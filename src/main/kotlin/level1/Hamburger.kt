package level1

import java.util.*


class Hamburger {
    fun solution(ingredient: IntArray): Int {
        var answer = 0
        val burger = listOf(1, 2, 3, 1)
        val source = Stack<Int>()

        for (index in ingredient.indices) {
            source.add(ingredient[index])
            println(source)
            if (source.size >= 4) {
                val temp = listOf(
                    source[source.size - 4],
                    source[source.size - 3],
                    source[source.size - 2],
                    source[source.size - 1]
                )
                // println("$temp -> $burger")
                if (temp == burger) {
                    answer++
                    repeat(4) {
                        source.pop()
                    }
                }
            }
        }
        return answer
    }
}

fun main() {
    val solution = Hamburger()
    val s = solution.solution(intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1))
    println("answer $s")
}