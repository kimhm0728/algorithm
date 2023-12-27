package kotlinsource.dp

fun main() {
    val div = 10_007
    val n = System.`in`.bufferedReader().readLine().toInt()
    val dp = Array(n) { IntArray(10) }
    for (y in 0 until 10) {
        dp[0][y] = 10 - y
    }

    for (x in 1 until n) {
        dp[x][9] = dp[x - 1][9]
        for (y in 8 downTo 0) {
            dp[x][y] = (dp[x - 1][y] + dp[x][y + 1]) % div
        }
    }

    print(dp[n - 1][0])
}