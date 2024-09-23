package kotlin.dp

import kotlin.math.min
import kotlin.math.sqrt

fun main() {
    val n = System.`in`.bufferedReader().readLine().toInt()
    val dp = IntArray(n + 1)
    print(solution(dp, n))
}

private fun solution(dp: IntArray, n: Int): Int {
    if (n == 0) return 0
    if (dp[n] != 0) return dp[n]

    val sqrt = sqrt(n.toDouble()).toInt()
    dp[n] = 100001
    for (number in sqrt downTo 1) {
        dp[n] = min(dp[n], solution(dp, n - number * number) + 1)
    }
    return dp[n]
}