package kotlinsource.dp

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val max = 10001
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val dp = IntArray(k + 1) { max }
    dp[0] = 0

    for (i in 1..n) {
        val value = readLine().toInt()

        for (cnt in value..k) {
            dp[cnt] = min(dp[cnt], dp[cnt - value] + 1)
        }
    }

    print(if (dp[k] == max) -1 else dp[k])
}