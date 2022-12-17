package LeetCode

import java.util.*


class EvalRPN {
    fun evalRPN(tokens: Array<String>): Int {
        val numbers = LinkedList<Int>()

        val isOperator = { s: String ->
            s == "*" || s == "/" || s == "-" || s == "+"
        }

        val eval = {num1: Int, num2: Int, operator: String ->
            when (operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> num1 / num2
                else -> 0
            }
        }

        tokens.indices.forEach { i ->
            if (isOperator(tokens[i])) {
                val num2 = numbers.pollLast()
                val num1 = numbers.pollLast()
                numbers.add(eval(num1, num2, tokens[i]))
            } else {
                val number = tokens[i].toInt()
                numbers.add(number)
            }
        }
        return numbers[0]
    }
}

fun main() {
    val res = EvalRPN().evalRPN(arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+"))
    println(res)
}