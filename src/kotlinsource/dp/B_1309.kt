package kotlinsource.dp

class B_1309 {
    private val div = 9901
    private lateinit var dp: Array<IntArray>

    operator fun invoke() {
        val n = System.`in`.bufferedReader().readLine().toInt()
        dp = Array(n) { IntArray(3) }
        dp[0].fill(1)

        for (idx in 1 until n) {
            dp[idx][0] = (dp[idx - 1][0] + dp[idx - 1][1] + dp[idx - 1][2]) % div
            dp[idx][1] = (dp[idx - 1][0] + dp[idx - 1][2]) % div
            dp[idx][2] = (dp[idx - 1][0] + dp[idx - 1][1]) % div
        }

        print((dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2]) % div)
    }
}

fun main() {
    B_1309()()
}