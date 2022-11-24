private fun solution(A: IntArray): Int {
    return A.toList()
        .groupingBy { it }
        .eachCount()
        .filter { (_, v) -> v == 1 }
        .map { (k, _) -> k }
        .takeIf { it.isNotEmpty() }?.first() ?: -1
}

fun main() {
    val s = solution(intArrayOf(4, 10, 5, 4, 2, 10))
    println("answer $s")
}