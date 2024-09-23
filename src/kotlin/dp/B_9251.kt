package kotlin.dp

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val first = readLine()
    val second = readLine()
    val firstLen = first.length
    val secondLen = second.length

    val dp = Array(firstLen + 1) { IntArray(secondLen + 1) }
    var answer = 0

    for (i in 1..firstLen) {
        for (j in 1..secondLen) {
            if (first[i - 1] != second[j - 1]) {
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
                continue
            }
            dp[i][j] = max(dp[i - 1][j - 1] + 1, max(dp[i][j - 1], dp[i - 1][j]))
            answer = max(answer, dp[i][j])
        }
    }

    print(answer)
}