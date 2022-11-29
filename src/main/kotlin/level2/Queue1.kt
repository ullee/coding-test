package level2

import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

class Queue1 {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = 0

        val q1: Queue<Int> = LinkedList()
        val q2: Queue<Int> = LinkedList()

        queue1.forEach { q1.offer(it) }
        queue2.forEach { q2.offer(it) }

        val resultCounts = mutableListOf<Int>()

        if (q1.sum() == q2.sum()) {
            return 1
        }

        val r = abs(q1.sum() - q2.sum())

        println(r)

        var count1 = 0
        println("solution 1")
        for (i in 1 until queue1.size) {
            q2.offer(q1.poll())
            println("$q1 -> $q2")
            count1 += 1
            if (queue1.sum() == queue2.sum()) {
                resultCounts.add(count1)
                break
            }
        }

        var count2 = 0
        println("solution 2")
        for (i in 1 until queue2.size) {
            q1.offer(q2.poll())
            println("$q2 -> $q1")
            count2 += 1
            if (queue1.sum() == queue2.sum()) {
                resultCounts.add(count2)
                break
            }
        }

        var count3 = 0
        println("solution 3")
        for (i in 1 until queue1.size + queue2.size) {
            q1.offer(q2.poll())
            println("$q2 -> $q1")
            count3 += 1
            if (queue1.sum() == queue2.sum()) {
                resultCounts.add(count3)
                break
            }
            q2.offer(q1.poll())
            println("$q2 -> $q1")
            count3 += 1
            if (queue1.sum() == queue2.sum()) {
                resultCounts.add(count3)
                break
            }
        }

        var count = 0
        while (queue1.sum() != queue2.sum()) {
            q1.offer(q2.poll())
            count += 1
            q2.offer(q1.poll())
            count += 1
        }

        return if (count == 0) -1 else count
    }
}

fun main() {
    val solution = Queue1()
    val s = solution.solution(intArrayOf(1, 2, 1, 2), intArrayOf(1, 10, 1, 2))
    println("answer $s")
}