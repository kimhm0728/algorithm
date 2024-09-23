package kotlin.dp

fun main() {
    val div = 1_000_000_000
    val n = System.`in`.bufferedReader().readLine().toInt()
    val dp = Array(n) { IntArray(10) }

    for (idx in 0..9) {
        dp[0][idx] = 1
    }

    for (x in 1 until n) {
        for (y in 0..9) {
            when (y) {
                0 -> dp[x][y] = dp[x - 1][1]
                9 -> dp[x][y] = dp[x - 1][8]
                else -> dp[x][y] = (dp[x - 1][y - 1] + dp[x - 1][y + 1]) % div
            }
        }
    }

    var answer = 0
    for (y in 1..9) {
        answer = (answer + dp[n - 1][y]) % div
    }

    print(answer)
}