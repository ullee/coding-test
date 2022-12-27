package LeetCode

class MaximumBags {
    fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
        var additionalRocks = additionalRocks
        val fill = mutableListOf<Int>()

        capacity.indices.forEach { i ->
            val empty = capacity[i] - rocks[i]
            if (empty > 0) {
                fill.add(empty)
            } else {
                fill.add(0)
            }
        }

        val sortedFill = fill.sorted().toMutableList()

        // 최대한 많은 가방을 채우기 위해 작은 수 순으로 정렬
        sortedFill.indices.forEach { i ->
            val n = additionalRocks - sortedFill[i]
            if (n >= 0) {
                additionalRocks = n
                sortedFill[i] = 0
            }
        }

        // println(sortedFill)

        return sortedFill.count { it == 0 }
    }
}

fun main() {
    val m = MaximumBags()
    println(m.maximumBags(intArrayOf(54,18,91,49,51,45,58,54,47,91,90,20,85,20,90,49,10,84,59,29,40,9,100,1,64,71,30,46,91), intArrayOf(14,13,16,44,8,20,51,15,46,76,51,20,77,13,14,35,6,34,34,13,3,8,1,1,61,5,2,15,18), 77))
}