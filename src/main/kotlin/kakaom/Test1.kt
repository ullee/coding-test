package kakaom

class Test1 {
    fun solution(N_arg: Int) {
        var N: Int = N_arg
        var enable_print: Int

        enable_print = N % 10
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1
            }
            else if (enable_print == 1) {
                print(N % 10)
            }
            N = N / 10
        }
    }

    // 4:53
    fun solution2(N_arg: Int) {
        print(N_arg.toString().reversed().toInt())
    }
}

fun main() {
    val t = Test1()
    val s = t.solution2(54321)
    println("answer : $s")
}