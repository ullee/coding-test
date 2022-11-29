package LeetCode

import ListNode

class TwoNumbers {
    companion object {
        private fun from(nodes: List<Int>): ListNode {
            val node = ListNode()
            nodes.forEach {
                val t = ListNode(it)
                t.next = node.next
                node.next = t
            }
            return node.next!!
        }
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        fun get1(l: ListNode?) {
            l?.let {
                list1.add(it.`val`)
                get1(it.next)
            }
        }

        fun get2(l: ListNode?) {
            l?.let {
                list2.add(it.`val`)
                get2(it.next)
            }
        }

        l1?.let { get1(it) }
        l2?.let { get2(it) }

        val r1 = list1.reversed().joinToString("").toBigInteger()
        val r2 = list2.reversed().joinToString("").toBigInteger()

        val result = (r1 + r2).toString().map(Character::getNumericValue)

        return from(result)
    }
}

private fun listToNode(nodes: List<Int>): ListNode {
    val node = ListNode()
    nodes.forEach {
        val t = ListNode(it)
        t.next = node.next
        node.next = t
    }
    return node.next!!
}

fun main() {
    val l1 = listToNode(listOf(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1))
    val l2 = listToNode(listOf(9, 9, 9, 9))
    println(TwoNumbers().addTwoNumbers(l1, l2))
}