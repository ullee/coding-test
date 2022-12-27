package algorithm

class BubbleSort {
    private fun swap(arr: MutableList<Int>, source: Int, target: Int) {
        val tmp = arr[source]
        arr[source] = arr[target]
        arr[target] = tmp
    }

    private tailrec fun recursive(mNums: MutableList<Int>, lastIndex: Int): MutableList<Int> {
        return if (lastIndex > 0) {
            for (i in 1..lastIndex) {
                if (mNums[i - 1] > mNums[i]) {
                    swap(mNums, i - 1, i)
                }
            }
            recursive(mNums, lastIndex - 1)
        } else mNums
    }

    fun bubbleSort(nums: List<Int>): List<Int> {

        val mNums = nums.toMutableList()

        return recursive(mNums, mNums.size - 1)
    }
}

fun main() {
    val bubbleSort = BubbleSort().bubbleSort(listOf(5,3,1,2,4))
    println(bubbleSort)
}