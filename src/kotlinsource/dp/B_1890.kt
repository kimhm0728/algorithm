package kotlinsource.dp

class B_1890 {
    private var N = 0
    private lateinit var arr: Array<IntArray>
    private lateinit var dp: Array<LongArray>

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        N = n

        arr = Array(n) { IntArray(n) }
        dp = Array(n) { LongArray(n) { -1 } }
        dp[n - 1][n - 1] = 1

        for (idx in 0 until n) {
            arr[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
        }

        print(solution(0, 0))
    }

    private fun solution(x: Int, y: Int): Long {
        if (x >= N || y >= N) return 0
        if (dp[x][y] != (-1).toLong()) return dp[x][y]

        if (arr[x][y] == 0) {
            dp[x][y] = 0
            return dp[x][y]
        }

        dp[x][y] = solution(x + arr[x][y], y) + solution(x, y + arr[x][y])
        return dp[x][y]
    }
}

fun main() {
    B_1890()()
}