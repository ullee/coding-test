package util

class Node(
    var `val`: Int
) {
    var children: List<Node?> = listOf()
}

class ListNode(
    var `val`: Int = -1,
    var next: ListNode? = null
) {
    override fun toString(): String {
        return "$`val` -> ${next.toString()}"
    }

    companion object {
        fun from(nodes: List<Int>): ListNode {
            val node = ListNode()
            nodes.reversed().forEach {
                val t = ListNode(it)
                t.next = node.next
                node.next = t
            }
            return node.next!!
        }
    }
}


class TreeNode(
    var `val`: Int
) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}