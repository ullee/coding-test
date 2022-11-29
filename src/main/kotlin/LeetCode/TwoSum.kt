package LeetCode

class FindMaxConsecutiveOnes {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        return nums.joinToString("")
            .split("0").toList()
            .max().length
    }
}

fun main() {
    println(FindMaxConsecutiveOnes().findMaxConsecutiveOnes(intArrayOf(1,1,0,1,1,1)))
}