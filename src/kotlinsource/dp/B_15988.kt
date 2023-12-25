package kotlinsource.dp

class B_15988 {
    private val div: Long = 1000000009
    private val dp = LongArray(1000001)

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        val t = readLine().toInt()
        val sb = StringBuilder()
        dp[0] = 1

        for (cnt in 1..t) {
            val n = readLine().toInt()
            sb.append(solution(n)).append('\n')
        }

        print(sb)
    }

    private fun solution(n: Int): Long {
        if (n < 0) return 0
        if (dp[n] != 0.toLong()) return dp[n]

        dp[n] = (solution(n - 1) + solution(n - 2) + solution(n - 3)) % div
        return dp[n] % div
    }
}

fun main() {
    B_15988()()
}