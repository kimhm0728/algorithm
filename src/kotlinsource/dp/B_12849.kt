package kotlinsource.dp

class B_12849 {
    private val div = 1_000_000_007
    private lateinit var dp: Array<IntArray>
    private val path = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(0, 2, 3),
        intArrayOf(0, 1, 3, 5),
        intArrayOf(1, 2, 4, 5),
        intArrayOf(3, 5, 6),
        intArrayOf(2, 3, 4, 7),
        intArrayOf(4, 7),
        intArrayOf(5, 6)
    )
    private val n = path.size

    operator fun invoke() {
        val d = System.`in`.bufferedReader().readLine().toInt()
        dp = Array(n) { IntArray(d + 1) { -1 } }

        for (idx in 1 until n) {
            dp[idx][0] = 0
        }
        dp[0][0] = 1

        print(solution(0, d))
    }

    private fun solution(pos: Int, time: Int): Int {
        if (dp[pos][time] != -1) return dp[pos][time]

        dp[pos][time] = 0
        for (next in path[pos]) {
            dp[pos][time] = (dp[pos][time] + solution(next, time - 1)) % div
        }

        return dp[pos][time]
    }
}

fun main() {
    B_12849()()
}