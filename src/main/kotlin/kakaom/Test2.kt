package kakaom

class Test2 {
    fun solution(N: Int, A: IntArray, B: IntArray): Boolean {
        val m = mutableSetOf<Int>()
        A.forEach { a ->
            m.add(a)
            B.forEach { b->
                m.add(b)
            }
        }

        return m.size == N && m.first() == 1 && m.last() == N
    }
}

fun main() {
    val t = Test2()
    println(t.solution(
        4,
        intArrayOf(1, 2, 4, 4, 3),
        intArrayOf(2, 3, 1, 3, 1)
    ))
    println(t.solution(
        4,
        intArrayOf(1,2,1,3),
        intArrayOf(2,4,3,4)
    ))
    println(t.solution(
        6,
        intArrayOf(2,4,5,3),
        intArrayOf(3,5,6,4)
    ))
    println(t.solution(
        3,
        intArrayOf(1,3),
        intArrayOf(2,2)
    ))
}