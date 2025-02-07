import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = LongArray(n + 1)
    dp[1] = 1
    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1
        if (i < 7) {
            continue
        }
        for (j in 3..<i - 3) {
            dp[i] = max(dp[i], dp[j] * (i - j - 1))
        }
    }
    print(dp[n])
}
