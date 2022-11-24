class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        levelOrderTraversal(result, 0, root)
        return result
    }

    private fun levelOrderTraversal(result: MutableList<MutableList<Int>>, level: Int, node: TreeNode?) {
        node?.also { n ->
            if (result.size <= level) {
                val row = mutableListOf<Int>()
                row.add(n.`val`)
                result.add(row)
            } else {
                val row = result[level]
                row.add(n.`val`)
            }
            levelOrderTraversal(result, level + 1, n.left)
            levelOrderTraversal(result, level + 1, n.right)
        } ?: return
    }
}

fun main() {
    val solution = BinaryTreeLevelOrderTraversal()
    val nodes = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }
        right = TreeNode(3).apply {
            right = TreeNode(5)
        }
    }
    println(solution.levelOrder(nodes))
}