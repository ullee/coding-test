private fun solution(S: String): Int {
    if (S.isBlank()) {
        return -1
    }

    val size = S.length
    if (size == 1) {
        return 0
    }
    val centerIndex = size / 2
    val before = S.substring(0, centerIndex)
    val after = S.substring(centerIndex + 1, S.length).reversed()
    return if (before == after) centerIndex else -1
}

fun main() {
    val s = solution("x")
    println("answer $s")
}