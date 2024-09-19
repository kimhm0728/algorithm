fun main() {
    val n = System.`in`.bufferedReader().readLine().toInt()
    val dp = Array(n + 1) { LongArray(2) { 0 } }
    dp[1][0] = 0
    dp[1][1] = 1
    (2..n).forEach { i ->
        dp[i][0] = dp[i - 1][0] + dp[i - 1][1]
        dp[i][1] = dp[i - 1][0]
    }
    print(dp[n][0] + dp[n][1])
}
