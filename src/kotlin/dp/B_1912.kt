package kotlin.dp

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    val dp = IntArray(n) { Int.MIN_VALUE }
    dp[0] = arr[0]
    var answer = arr[0]

    for (idx in 1 until n) {
        dp[idx] = max(arr[idx], dp[idx - 1] + arr[idx])
        answer = max(answer, dp[idx])
    }

    print(answer)
}