package test

class LinkedIsland {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        var root = IntArray(n, { i -> i })

        fun find(x: Int): Int {
            if (root[x] == x) {
                return x
            } else {
                return find(root[x])
            }
        }

        fun union(x: Int, y: Int) {
            var a = find(x)
            var b = find(y)
            root[b] = a
        }

        fun getCost(s: IntArray): Int {
            return s[2]
        }

        costs.sortBy { getCost(it) }
        for (item in costs) {
            if (find(item[0]) == find(item[1])) {
                continue
            } else {
                union(item[0], item[1])
                answer += item[2]
            }

        }
        return answer
    }
}

fun main() {
    val solution = LinkedIsland()
    val s = solution.solution(
        2,
        arrayOf(
            intArrayOf(0, 1, 1),
        )
    )
    println("answer $s")
}