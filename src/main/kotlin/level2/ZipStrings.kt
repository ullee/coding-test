package level2

/**
 * 가장 큰 수 조합 찾기
 */
class ZipStrings {
    fun solution(s: String): Int {
        if (s.length == 1) {
            return 1
        }

        val result = (1..s.length / 2 + 1).map { i ->
            val chunk = s.chunked(i)
            // 앞자리랑 비교하기 위해서 한칸씩 뒤로 당긴 배열
            val diffChunk = chunk.subList(1, chunk.size) + ""
            var count = 1

            val r = diffChunk.mapIndexedNotNull { index, str ->
                if (chunk[index] == str) {
                    count += 1
                    null
                } else {
                    val value = if (count == 1) "" else count.toString()
                    count = 1
                    value + chunk[index]
                }
            }
            r.joinToString("")
        }

        return result.minOf { it.length }
    }
}

fun main() {
    val solution = ZipStrings()
    val s = solution.solution("ababcdcdababcdcd")
    println("answer $s")
}