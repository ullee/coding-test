package LeetCode

class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        if (s.length == 1) {
            return s
        }

        var answer = ""
        s.indices.forEach { i ->
            for (j in i..s.length) {
                val sub = s.substring(i, j)
                if (isPalindrome(sub)) {
                    if (answer.length < sub.length) {
                        answer = sub
                    }
                }
            }
        }
        return answer
    }

    private fun isPalindrome(s: String): Boolean {
        if (s.isEmpty()) {
            return true
        }

        // 문자열 처음부터 그리고 마지막부터 양쪽으로 단어 하나씩 검사 후 하나라도 틀리면 false
        for (i in 0..s.lastIndex / 2) {
            if (s[i] != s[s.lastIndex - i]) {
                return false
            }
        }

        return true
    }

    @Deprecated("performance fail")
    private fun ok(s: String): String? {
        val r = s.reversed()
        return if (s.first() == s.last() && s == r) {
            s
        } else {
            null
        }
    }

    @Deprecated("performance fail")
    fun longestPalindrome2(s: String): String {
        var result = ""

        ok(s)?.also {
            return s
        }

        s.indices.forEach { i ->
            for (j in i + 1 .. s.length) {
                val temp = s.substring(i, j)
                println(temp)
                ok(temp)?.let {
                    if (result.length < it.length) {
                        result = it
                    }
                }
            }
        }

        if (result.isBlank()) {
            return s.first().toString()
        }

        return result
    }
}

fun main() {
    val e = LongestPalindromicSubstring().longestPalindrome(
        "dtgrtoxuybwyfskikukcqlvprfipgaygawcqnfhpxoifwgpnzjfdnhpgmsoqzlpsaxmeswlhzdxoxobxysgmpkhcylvqlzenzhzhnakctrliyyngrquiuvhpcrnccapuuwrrdufwwungaevzkvwbkcietiqsxpvaaowrteqgkvovcoqumgrlsxvouaqzwaylehybqchsgpzbkfugujrostopwhtgrnrggocprnxwsecmvofawkkpjvcchtxixjtrnngrzqpiwywmnbdnjwqpmnifdiwzpmabosrmzhgdwgcgidmubywsnshcgcrawjvfiuxzyzxsbpfhzpfkjqcpfyynlpshzqectcnltfimkukopjzzmlfkwlgbzftsddnxrjootpdhjehaafudkkffmcnimnfzzjjlggzvqozcumjyazchjkspdlmifvsciqzgcbehqvrwjkusapzzxyiwxlcwpzvdsyqcfnguoidiiekwcjdvbxjvgwgcjcmjwbizhhcgirebhsplioytrgjqwrpwdciaeizxssedsylptffwhnedriqozvfcnsmxmdxdtflwjvrvmyausnzlrgcchmyrgvazjqmvttabnhffoe"
    )
    println(e)
}