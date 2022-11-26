package level1

class TwoNumberSum {
    fun solution(s: String, n: Int): String {
        return s.toList().joinToString("") { char ->
            when (char) {
                in 'A'..'Z' -> ('A'.code + (char.code - 'A'.code + n) % ('Z' - 'A' + 1)).toChar()
                in 'a'..'z' -> ('a'.code + (char.code - 'a'.code + n) % ('z' - 'a' + 1)).toChar()
                else -> char
            }.toString()
        }
    }
}

fun main() {
    val solution = TwoNumberSum()
    val s = solution.solution("AB", 1)
    println("answer $s")
}