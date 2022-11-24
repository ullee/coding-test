class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        return binarySearch(nums, target, i = 0, j = nums.size)
    }

    private fun binarySearch(nums: IntArray, target: Int, i: Int, j: Int): Int {
        if (target > nums[j - 1]) {
            return -1
        }

        if (target < nums[i]) {
            return -1
        }

        val mid = (i + j) / 2
        if (i == j) {
            if (nums[i] != target) {
                return -1
            }
        }

        val c = target.compareTo(nums[mid])
        return when {
            c == 0 -> {
                // eq
                mid
            }
            c > 0 -> {
                // gt
                binarySearch(nums, target, i = (mid + 1), j = j)
            }
            else -> {
                // lt
                binarySearch(nums, target, i = i, j = mid)
            }
        }
    }
}

fun main() {
    val solution = BinarySearch()
    val nums = intArrayOf(-1,0,3,5,9,12)
    val target = 9
    println(solution.search(nums, target))
}