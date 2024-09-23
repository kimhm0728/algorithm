package kotlin.dp

class B_4811 {
    private lateinit var dp: Array<LongArray>

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()

        while (true) {
            val n = readLine().toInt()
            if (n == 0) break

            dp = Array(n + 1) { LongArray(2 * n + 1) }
            dp[0][0] = 1

            sb.append(solution(n, 0)).append('\n')
        }

        print(sb)
    }

    private fun solution(w: Int, h: Int): Long {
        if (w < 0 || h < 0) return 0
        if (dp[w][h] != 0.toLong()) return dp[w][h]

        dp[w][h] = solution(w - 1, h + 1) + solution(w, h - 1)
        return dp[w][h]
    }
}

fun main() {
    B_4811()()
}