package kotlinsource.dp

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, d) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(3) }
    val dp = IntArray(d + 1) { it }

    for (idx in 0 until n) {
        arr[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    arr.sortBy { it[0] }

    for (i in 0 until n) {
        val start = arr[i][0]
        val end = arr[i][1]
        val time = arr[i][2]

        if (end > d || end - start <= time ||
            dp[end] <= dp[start] + time) continue

        dp[end] = dp[start] + time
        for (j in end + 1..d) {
            dp[j] = min(dp[j], dp[start] + time + j - end)
        }
    }

    print(dp[d])
}