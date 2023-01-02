package test

class BestAlbum {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        return plays.indices.groupBy { genres[it] }
            .toList()
            .sortedByDescending { it.second.sumOf { s -> plays[s] } }
            .map { it.second.sortedByDescending { s -> plays[s] }.take(2) }
            .flatten()
            .toIntArray()
    }
}

fun main() {
    val solution = BestAlbum()
    val s = solution.solution(
        arrayOf("classic", "pop", "classic", "classic", "pop"),
        intArrayOf(500, 600, 150, 800, 2500)
    )
    println("answer ${s.toList()}")
}