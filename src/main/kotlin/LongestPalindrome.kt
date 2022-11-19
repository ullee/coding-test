class Solution : ListNode() {
    fun ListNode.toList(): List<Int> {
        val result = mutableListOf<Int>()
        var isFirstIndex = true
        fun recursion(node: ListNode?): List<Int> {
            if (isFirstIndex) {
                isFirstIndex = false
                node?.`val`?.also {
                    result.add(it)
                    recursion(node)
                }
            } else {
                node?.next?.also {
                    result.add(it.`val`)
                    recursion(it)
                } ?: return result
            }
            return result
        }
        return recursion(this)
    }

    fun from(nodes: List<Int>): ListNode {
        val node = ListNode()
        nodes.reversed().forEach {
            val temp = ListNode(it)
            temp.next = node.next
            node.next = temp
        }
        return node.next!!
    }

    fun detectCycle(head: ListNode?): ListNode? {
        val set = mutableSetOf<ListNode>()
        var h = head

        while (h != null) {
            if (!set.add(h)) {
                println(h)
                return h
            }
            h = h.next
        }
        return null
    }

    fun maxProfit(prices: IntArray): Int {
        var minprice = Int.MAX_VALUE
        var maxprofit = 0
        for (i in prices.indices) {
            if (prices[i] < minprice) {
                minprice = prices[i]
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice
            }
        }
        return maxprofit
    }

    fun longestPalindrome(s: String): Int {
        if (s.length == 1) {
            return 1
        }

        val map = mutableMapOf<Char, Int>()
        s.forEach { char ->
            if (map[char] == null) {
                map[char] = 1
            } else {
                map[char] = map[char]!! + 1
            }
        }

        if (map.size == 1) {
            return map.values.first()
        }

        val sortedMap = map.toList().sortedBy { (_, value) -> value }.toMap()
        println(sortedMap)

        val first = mutableListOf<Char>()
        val second = mutableListOf<Char>()
        val minOddNumberSize = if (sortedMap.values.min()!! > 1) 0 else 1
        var maxOddNumberSize = 0
        sortedMap.filter { it.value % 2 != 0 }.forEach {
            maxOddNumberSize = it.value.coerceAtMost(maxOddNumberSize)
        }

        sortedMap.filter { it.value > 1 }.forEach { (char, size) ->
            if (size % 2 == 0) {
                repeat(size / 2) {
                    first.add(char)
                    second.add(char)
                }
            } else {
                repeat((size - 1) / 2) {
                    first.add(char)
                    second.add(char)
                }
            }
        }

        val reversed = second.reversed()

        val result = first + reversed
        println(result)
        println(minOddNumberSize)

        return result.size + minOddNumberSize
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    // solution.detectCycle(ListNode.from(listOf(3, 2, 0, -4)))
    // println(solution.maxProfit(listOf(7, 1, 5, 3, 6, 4).toIntArray()))
    var s =
        "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"
    // s = "abccccdd"
    s = "ababababa"
    println(solution.longestPalindrome(s))
}