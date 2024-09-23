package kotlin.dp

class B_15990 {
    private val div = 1_000_000_009
    private val dp = Array(100_001) { IntArray(4) }

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        val t = readLine().toInt()
        val sb = StringBuilder()
        dp[0].fill(1)

        for (cnt in 1..t) {
            val n = readLine().toInt()
            sb.append(solution(n, 0)).append('\n')
        }

        print(sb)
    }

    private fun solution(n: Int, pre: Int): Int {
        if (n < 0) return 0
        if (dp[n][pre] != 0) return dp[n][pre]

        if (pre != 1) dp[n][pre] = (dp[n][pre] + solution(n - 1, 1)) % div
        if (pre != 2) dp[n][pre] = (dp[n][pre] + solution(n - 2, 2)) % div
        if (pre != 3) dp[n][pre] = (dp[n][pre] + solution(n - 3, 3)) % div

        return dp[n][pre]
    }
}

fun main() {
    B_15990()()
}