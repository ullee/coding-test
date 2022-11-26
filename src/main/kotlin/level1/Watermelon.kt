package level1

class Watermelon {
    fun solution(n: Int): String {
        var answer = ""
        val su = "수"
        val bak = "박"

        repeat(n) {
            answer += if (it % 2 == 0) {
                su
            } else {
                bak
            }
        }

        return answer
    }
}

fun main() {
    val solution = Watermelon()
    val s = solution.solution(4)
    println("answer $s")
}