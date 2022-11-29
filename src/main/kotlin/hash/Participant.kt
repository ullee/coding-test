package hash

import java.util.*

class Participant {
    fun solution(participant: Array<String>, completion: Array<String>): String {
        val queue: Queue<String> = LinkedList()
        participant.map { queue.offer(it) }

        val c = completion.groupingBy { it }.eachCount().toMutableMap()

        val result = mutableListOf<String>()

        participant.forEach { q ->
            c[q]?.let {
                if (it > 0) {
                    queue.poll()
                    c[q] = it - 1
                } else {
                    result.add(q)
                }
            }
        }

        return result.first()
    }

    fun solution2(participant: Array<String>, completion: Array<String>): String {
        val hm = HashMap<String, Int>()
        participant.forEach { hm[it] = hm.getOrDefault(it, 0) + 1 }
        completion.forEach { hm[it] = hm[it]!! - 1 }
        println(hm)
        hm.forEach { if (it.value != 0) return it.key }
        return ""
    }
}

fun main() {
    val s = Participant().solution2(arrayOf("mislav", "stanko", "mislav", "ana"), arrayOf("stanko", "ana", "mislav"))
    println("answer $s")
}