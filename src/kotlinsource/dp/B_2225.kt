package kotlinsource.dp

class B_2225 {
    private val div = 1_000_000_000
    private lateinit var dp: Array<IntArray>

    operator fun invoke() {
        val (n, k) = System.`in`.bufferedReader().readLine()
            .split(" ")
            .map { it.toInt() }

        dp = Array(n + 1) { IntArray(k + 1) }
        for (idx in 0..n) {
            dp[idx][1] = 1
        }

        print(solution(n, k))
    }

    private fun solution(n: Int, k: Int): Int {
        if (dp[n][k] != 0) return dp[n][k]

        for (i in 0..n) {
            dp[n][k] = (dp[n][k] + solution(n - i, k - 1)) % div
        }

        return dp[n][k]
    }
}

fun main() {
    B_2225()()
}