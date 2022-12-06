package LeetCode

import util.ListNode


class OddEvenList {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head?.next == null) { // head == null && head.next == null
            return head // base case
        }
        var odd = head // the first node is odd node
        var even = head.next // the second node is even node
        val evenHead = even // store the head of even node for later

        // use even as condition because even is always after odd
        while (even?.next != null) { // event != null && even.next != null
            odd?.next = even.next // can also use odd.next.next
            odd = odd?.next // link odd nodes together
            even.next = odd?.next // can also use even.next.next
            even = even.next // link even nodes together
        }
        // After loop, odd is at the tail of odd nodes list,
        // link odd with the head of even nodes list
        odd?.next = evenHead
        return head
    }
}

fun main() {
    val res = OddEvenList().oddEvenList(
        ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    )
    println(res)
}