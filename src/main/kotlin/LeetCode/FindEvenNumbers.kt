package LeetCode

import kotlin.math.abs

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val diffMap = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, int ->
            diffMap[int]?.let { return intArrayOf(it, index) }
            diffMap[target - int] = index
        }
        return intArrayOf()
    }
}

fun main() {
    println(TwoSum().twoSum(intArrayOf(2,7,11,15), 9).toList())
}