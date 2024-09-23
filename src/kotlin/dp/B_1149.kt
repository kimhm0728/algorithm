package kotlin.dp

import kotlin.math.min

class B_1149 {
    private lateinit var arr: Array<IntArray>
    private lateinit var dp: Array<IntArray>

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        arr = Array(n) { IntArray(3) }
        dp = Array(n) { IntArray(3) }

        for (idx in 0 until n) {
            arr[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
        }

        val answer = min(min(solution(n - 1, 0), solution(n - 1, 1)), solution(n - 1, 2))
        print(answer)
    }

    private fun solution(n: Int, color: Int): Int {
        if (n < 0) return 0
        if (dp[n][color] != 0) return dp[n][color]

        if (color == 0) {
            dp[n][color] = arr[n][color] + min(solution(n - 1, 1), solution(n - 1, 2))
            return dp[n][color]
        }

        if (color == 1) {
            dp[n][color] = arr[n][color] + min(solution(n - 1, 0), solution(n - 1, 2))
            return dp[n][color]
        }

        dp[n][color] = arr[n][color] + min(solution(n - 1, 0), solution(n - 1, 1))
        return dp[n][color]
    }
}

fun main() {
    B_1149()()
}