package LeetCode

class MinimumLines {
    fun minimumLines(stockPrices: Array<IntArray>): Int {
        var lineCount = 1

        if (stockPrices.size == 1) {
            return 0
        }

        val s = stockPrices.sortedBy { it[0] }

        for (i in 2 until s.size) {
            val x1 = s[i][0]
            val x2 = s[i - 1][0]
            val x3 = s[i - 2][0]
            val y1 = s[i][1]
            val y2 = s[i - 1][1]
            val y3 = s[i - 2][1]
            // 여기 공식 잘 모르겠음..
            val n1 = (y3 - y2) * (x2 - x1)
            val n2 = (y2 - y1) * (x3 - x2)
            if (n1 != n2) {
                lineCount += 1
            }
        }

        return lineCount
    }
}

fun main() {
    val m = MinimumLines()
    println(
        m.minimumLines(
            arrayOf(
                intArrayOf(1, 7),
                intArrayOf(2, 6),
                intArrayOf(3, 5),
                intArrayOf(4, 4),
                intArrayOf(5, 4),
                intArrayOf(6, 3),
                intArrayOf(7, 2),
                intArrayOf(8, 1)
            )
        )
    )
    println(
        m.minimumLines(
            arrayOf(
                intArrayOf(3, 4),
                intArrayOf(1, 2),
                intArrayOf(7, 8),
                intArrayOf(2, 3)
            )
        )
    )
    println(
        m.minimumLines(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(2, 2),
                intArrayOf(3, 1),
                intArrayOf(4, 2),
                intArrayOf(5, 1),
                intArrayOf(6, 1),
                intArrayOf(12, 1),
            )
        )
    )
    val s = "[9,35],[12,47],[68,90],[64,71],[33,99],[90,25],[42,91],[41,5],[28,12],[66,30],[78,10],[92,23],[88,45],[89,32],[3,74],[93,3],[44,15],[43,11],[91,41]"
    val l = s.replace("[", "").replace("]", "").split(",")
    val a = l.chunked(2).toList()
    val arr = mutableListOf<IntArray>()
    a.forEach {
        arr.add(intArrayOf(it[0].toInt(), it[1].toInt()))
    }
    println(m.minimumLines(arr.toTypedArray()))
}