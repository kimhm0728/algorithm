package kotlinsource.dp

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val max = 1_000_000
    val (c, n) = readLine().split(" ").map { it.toInt() }
    val dp = IntArray(c + 101) { max }
    dp[0] = 0

    for (idx in 0 until n) {
        val (cost, consumer) = readLine().split(" ").map { it.toInt() }.toIntArray()

        for (cnt in consumer..c + consumer) {
            dp[cnt] = min(dp[cnt], dp[cnt - consumer] + cost)
        }
    }

    var answer = max
    for (idx in c..c + 100) {
        answer = min(answer, dp[idx])
    }

    print(answer)
}