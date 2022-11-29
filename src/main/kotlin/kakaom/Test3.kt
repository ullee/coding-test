package kakaom

class Test3 {
    fun solution(N: Int, S: String): Int {
        val reserved = S.split(" ").toSet()
        val seats = mutableListOf("A", "B", "C", "D", "E", "F", "G", "H", "J", "K")

        var count = 0

        fun isNotReserved(s: String) = !reserved.contains(s)
        fun isReserved(s: String) = reserved.contains(s)
        fun isNotAllReserved(line: Int, s: List<String>): Boolean {
            s.forEach {
                if (reserved.contains("$line$it")) {
                    return false
                }
            }
            return true
        }

        fun isNotAllReserved(lineStart: Int, lineEnd: Int, s: List<String>): Boolean {
            for (i in lineStart..lineEnd) {
                if (reserved.contains("$i${s[i]}")) {
                    return false
                }
            }
            return true
        }

        for (line in 1..N) {
            count += when {
                isNotAllReserved(line, seats)
                -> 2

                (isReserved("$line${seats[0]}") || isReserved("$line${seats[9]}")) && isNotAllReserved(1, 8, seats)
                -> 2

                isNotReserved("$line${seats[1]}") && isNotAllReserved(2, 4, seats)
                -> 1

                (isReserved("$line${seats[1]}") || isReserved("$line${seats[2]}")) && isNotAllReserved(3, 6, seats)
                -> 1

                (isReserved("$line${seats[3]}") || isReserved("$line${seats[4]}")) && isNotAllReserved(5, 8, seats)
                -> 1

                else -> 0
            }
        }
        return count
    }
}

fun main() {
    val t = Test3()
    println(t.solution(2, "1A 2F 1C"))
    // println(t.solution(22, "1A 3C 2B 20G 5A"))
}