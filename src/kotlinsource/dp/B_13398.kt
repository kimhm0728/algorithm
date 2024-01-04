package kotlinsource.dp

import kotlin.math.max

class B_13398 {
    private val INF = -10_000_001
    private var n = 0
    private lateinit var arr: IntArray
    private lateinit var dp: Array<IntArray>

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        n = readLine().toInt()
        arr = readLine().split(" ").map { it.toInt() }.toIntArray()
        dp = Array(n) { IntArray(2) { INF } }

        solution(0, 0)
        var answer = INF
        for (idx in 0 until n) {
            answer = max(answer, dp[idx].max())
        }
        print(answer)
    }

    private fun solution(idx: Int, delete: Int): Int {
        if (idx >= n) return INF
        if (dp[idx][delete] != INF) return dp[idx][delete]

        dp[idx][delete] = max(arr[idx], arr[idx] + solution(idx + 1, delete))
        if (delete == 0) {
            dp[idx][delete] = max(dp[idx][delete], solution(idx + 1, 1))
        }

        return dp[idx][delete]
    }
}

fun main() {
    B_13398()()
}