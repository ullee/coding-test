package LeetCode


class Reverse {
    fun reverse(x: Int): Int {
        return try {
            x.takeIf { it > 0 }
                ?.toString()?.reversed()
                ?.toInt()
                ?: ((-1 * x).toString().reversed().toInt() * -1)
        } catch (ex: NumberFormatException) {
            0
        }
    }
}

fun main() {
    val res = Reverse().reverse(-2147483648)
    println(res)
}