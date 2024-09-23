package kotlin.dp

class B_2688 {
    private val dp = Array(65) { LongArray(10) }

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        val t = readLine().toInt()

        for (idx in 0..9) {
            dp[1][idx] = (10 - idx).toLong()
        }

        val sb = StringBuilder()
        for (cnt in 1..t) {
            sb.append(solution(readLine().toInt(), 0)).append('\n')
        }

        print(sb)
    }

    private fun solution(n: Int, idx: Int): Long {
        if (dp[n][idx] != 0.toLong()) return dp[n][idx]

        if (idx == 9) {
            dp[n][idx] = solution(n - 1, idx)
            return dp[n][idx]
        }

        dp[n][idx] = solution(n - 1, idx) + solution(n, idx + 1)
        return dp[n][idx]
    }
}

fun main() {
    B_2688()()
}