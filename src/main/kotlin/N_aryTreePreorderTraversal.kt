import util.Node

class N_aryTreePreorderTraversal {
    fun preorder(root: Node?): List<Int> {
        val result = mutableListOf<Int>()
        root?.also {
            result.add(it.`val`)
            it.children.forEach { child ->
                result.addAll(preorder(child))
            }
        }
        return result
    }
}

fun main() {
    val solution = N_aryTreePreorderTraversal()
    val nodes = Node(1).apply {
        children = listOf(
            Node(3).apply {
                children = listOf(
                    Node(5),
                    Node(6),
                )
            },
            Node(2),
            Node(4),
        )
    }
    solution.preorder(nodes)
}