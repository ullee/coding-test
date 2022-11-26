package level1

class MiddleSchool {
    fun solution(number: IntArray): Int {
        var answer: Int = 0

        for (i in number.indices) {
            for (j in i + 1 until number.size) {
                for (k in j + 1 until number.size) {
                    println("good : ${number[i]} + ${number[j]} + ${number[k]}")
                    if (number[i] + number[j] + number[k] == 0) {
                        answer += 1
                    }
                }
            }
        }

        return answer
    }
}

fun main() {
    val solution = MiddleSchool()
    val s = solution.solution(intArrayOf(-3, -2, -1, 0, 1, 2, 3))
    println("answer $s")
}