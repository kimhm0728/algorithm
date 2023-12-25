package kotlinsource.dp

import kotlin.math.max

class B_11048 {
    private lateinit var arr: Array<IntArray>
    private lateinit var dp: Array<IntArray>

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        fun String.toIntList() = split(" ").map { it.toInt() }
        val (n, m) = readLine().toIntList()

        arr = Array(n) { IntArray(m) }
        dp = Array(n) { IntArray(m) { -1 } }

        for (idx in 0 until n) {
            arr[idx] = readLine().toIntList().toIntArray()
        }

        print(solution(n - 1, m - 1))
    }

    private fun solution(x: Int, y: Int): Int {
        if (x < 0 || y < 0) return 0
        if (dp[x][y] != -1) return dp[x][y]

        dp[x][y] = max(max(solution(x - 1, y), solution(x, y - 1)),
            solution(x - 1, y - 1)) + arr[x][y]
        return dp[x][y]
    }
}

fun main() {
    B_11048()()
}