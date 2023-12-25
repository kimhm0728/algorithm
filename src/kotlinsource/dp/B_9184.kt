package kotlinsource.dp

data class Recursion(val a: Int, val b: Int, val c: Int) {
    fun isEnd() =
        a == -1 && b == -1 && c == -1

    override fun toString() =
        "w($a, $b, $c) = "
}

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val result = mutableMapOf<Recursion, Int>()

    while (true) {
        val recursion = readLine().toRecursion()
        if (recursion.isEnd()) break
        sb.append(recursion).append(solution(result, recursion)).append('\n')
    }

    print(sb)
}

private fun String.toRecursion() =
    split(" ").let {
        Recursion(it[0].toInt(), it[1].toInt(), it[2].toInt())
    }

private fun solution(result: MutableMap<Recursion, Int>, recursion: Recursion): Int {
    if (result.contains(recursion)) return result[recursion]!!

    val a = recursion.a
    val b = recursion.b
    val c = recursion.c

    if (a <= 0 || b <= 0 || c <= 0) {
        result[recursion] = 1
        return 1
    }

    if (a > 20 || b > 20 || c > 20) {
        result[recursion] = solution(result, Recursion(20, 20, 20))
        return result[recursion]!!
    }

    if (a < b && b < c) {
        result[recursion] = solution(result, Recursion(a, b, c - 1)) +
                solution(result, Recursion(a, b - 1, c - 1)) -
                solution(result, Recursion(a, b - 1, c))
        return result[recursion]!!
    }

    result[recursion] = solution(result, Recursion(a - 1, b, c)) +
            solution(result, Recursion(a - 1, b - 1, c)) +
            solution(result, Recursion(a - 1, b, c - 1)) -
            solution(result, Recursion(a - 1, b - 1, c - 1))
    return result[recursion]!!
}