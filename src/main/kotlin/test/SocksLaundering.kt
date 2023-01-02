private fun solution(K: Int, C: IntArray, D: IntArray): Int {
    var k = K
    var answer = 0
    val clean = IntArray(51)
    val dirty = IntArray(51)

    // 깨끗한 양말 번호별로 count해 저장
    for (c in C) {
        clean[c] += 1
    }

    // 더러운 양말 번호별로 count해 저장
    for (d in D) {
        dirty[d] += 1
    }

    for (i in 1..50) {
        answer += clean[i] / 2 // 깨끗한 양말끼리 가능한 쌍 계산
        // 깨끗한 양말 + 더러운 양말 조합 계산
        if (clean[i] % 2 != 0 && k > 0 && dirty[i] > 0) {
            answer += 1
            k -= 1
            dirty[i] -= 1
        }
    }

    // 세탁 가능한 양말이 아직 남아있다면 더러운 양말 2개씩 묶어 처리
    for (i in 1..50) {
        if (k < 2) break // 세탁가능한 양말 개수가 2개 이상 남아있지 않다면 break
        // i번 더러운 양말이 2개 이상 남아있으면 세탁
        if (dirty[i] >= 2) {
            // i번 양말 쌍보다 세탁 가능한 양말 개수 K 중 더 작은 수 만큼만 세탁 가능
            val wash = dirty[i].coerceAtMost(k) / 2
            answer += wash
            k -= 2 * wash
        }
    }

    return answer
}

fun main() {
    val s = solution(2, intArrayOf(1, 2, 1, 1), intArrayOf(1, 4, 3, 2, 4))
    println("answer $s")
}