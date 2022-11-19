open class Node(
    var `val`: Int
) {
    var children: List<Node?> = listOf()
}

open class ListNode(
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
                val temp = ListNode(it)
                temp.next = node.next
                node.next = temp
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