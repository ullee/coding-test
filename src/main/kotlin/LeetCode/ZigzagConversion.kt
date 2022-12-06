package LeetCode

class ZigzagConversion {
    fun convert(s: String, numRows: Int): String {
        var direction = 0
        var zigzagIdx = 0
        val zigzagTable = mutableMapOf<Int, String>()
        s.forEach { char ->
            if (zigzagIdx == 0) {
                direction = 1 // down(index plus)
            } else if (zigzagIdx == numRows - 1) {
                direction = -1 // up(index minus)
            }

            zigzagTable[zigzagIdx] = zigzagTable.getOrDefault(zigzagIdx, "") + char
            zigzagIdx += direction
        }
        return zigzagTable.values.joinToString("")
    }
}

fun main() {
    println(ZigzagConversion().convert("PAYPALISHIRING", 3))
}