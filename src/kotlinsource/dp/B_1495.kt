package kotlinsource.dp

import kotlin.math.max

class B_1495 {
    private var N = 0
    private var M = 0
    private lateinit var arr: IntArray
    private lateinit var dp: Array<IntArray>

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        val (n, s, m) = readLine().toIntList()
        N = n
        M = m
        arr = readLine().toIntList().toIntArray()
        dp = Array(n) { IntArray(m + 1) { -10 } }

        print(solution(0, s))
    }

    private fun String.toIntList() = split(" ").map { it.toInt() }

    private fun solution(idx: Int, volume: Int): Int {
        if (idx >= N) return volume
        if (dp[idx][volume] != -10) return dp[idx][volume]

        var flag = false
        if (volume - arr[idx] >= 0) {
            flag = true
            dp[idx][volume] = max(dp[idx][volume], solution(idx + 1, volume - arr[idx]))
        }

        if (volume + arr[idx] <= M) {
            flag = true
            dp[idx][volume] = max(dp[idx][volume], solution(idx + 1, volume + arr[idx]))
        }

        if (!flag) dp[idx][volume] = -1
        return dp[idx][volume]
    }
}

fun main() {
    B_1495()()
}