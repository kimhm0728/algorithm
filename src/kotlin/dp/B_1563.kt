fun main() {
    val n = System.`in`.bufferedReader().readLine().toInt()
    val dp = Array(n) { Array(2) { IntArray(3) } }
    val div = 1_000_000

    dp[0][0][0] = 1
    dp[0][0][1] = 1
    dp[0][1][0] = 1
    for (i in 1..<n) {
        dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % div // O
        dp[i][0][1] = dp[i - 1][0][0] // A
        dp[i][0][2] = dp[i - 1][0][1] // A
        dp[i][1][0] =
            (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2] + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % div // O, L
        dp[i][1][1] = dp[i - 1][1][0] // A
        dp[i][1][2] = dp[i - 1][1][1] // A
    }
    var answer = 0L
    dp[n - 1].forEach {
        it.forEach {
            answer = (answer + it) % div
        }
    }
    print(answer % div)
}
