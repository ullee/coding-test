package LeetCode

class HalvesAreAlike {
    fun halvesAreAlike(s: String): Boolean {
        val halfLength = s.length / 2
        var leftCount = 0
        var rightCount = 0

        val valid = { char: Char ->
            when (char) {
                'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> 1
                else -> 0
            }
        }

        s.indices.forEach { i ->
            if (i < halfLength) {
                leftCount += valid(s[i])
            } else {
                rightCount += valid(s[i])
            }
        }

        return leftCount == rightCount
    }
}

fun main() {
    println(HalvesAreAlike().halvesAreAlike("tkPAdxpMfJiltOerItiv"))
}