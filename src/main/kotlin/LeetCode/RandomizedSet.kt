package LeetCode

import java.util.*

class RandomizedSet {
    private val random = Random()
    private val nums = arrayListOf<Int>()
    private val positions = hashMapOf<Int, Int>()

    fun insert(`val`: Int): Boolean {
        if (`val` in positions) {
            return false
        }
        positions[`val`] = nums.size
        nums += `val`
        return true
    }

    fun remove(`val`: Int): Boolean {
        val pos = positions.remove(`val`)
            ?: return false

        val removedLast = nums.removeAt(nums.size - 1)
        if (removedLast != `val`) {
            nums[pos] = removedLast
            positions[removedLast] = pos
        }

        return true
    }

    fun getRandom(): Int {
        return nums[random.nextInt(nums.size)]
    }
}

fun main() {
    val obj = RandomizedSet()
    var param1 = obj.insert(1)
    var param2 = obj.remove(1)
    var param3 = obj.getRandom()
}
