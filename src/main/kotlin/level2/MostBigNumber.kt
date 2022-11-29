package level2

/**
 * 가장 큰 수 조합 찾기
 */
class MostBigNumber {
    fun solution(numbers: IntArray): String {
        // 리스트 요소의 앞뒤만 비교 하면 됨
        return numbers.sortedWith { n1, n2 ->
            "$n2$n1".compareTo("$n1$n2")
        }.joinToString("").run {
            if (this[0] == '0')  "0" else this
        }
    }
}

fun main() {
    val solution = MostBigNumber()
    val s = solution.solution(intArrayOf(1,2,3,4))
    println("answer $s")
}