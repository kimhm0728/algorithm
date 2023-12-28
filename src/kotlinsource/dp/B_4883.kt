package kotlinsource.dp

import kotlin.math.min

class B_4883 {
    private var n = 0
    private val max = 100_000_001
    private lateinit var arr: Array<IntArray>
    private lateinit var dp: Array<IntArray>
    private val dx = intArrayOf(0, 1, 1, 1)
    private val dy = intArrayOf(1, -1, 0, 1)

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        var cnt = 1

        while (true) {
            n = readLine().toInt()
            if (n == 0) break

            arr = Array(n) { IntArray(3) }
            for (idx in 0 until n) {
                arr[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
            }

            dp = Array(n) { IntArray(3) { max } }
            dp[n - 1][1] = arr[n - 1][1]

            sb.append("${cnt++}. ${solution(0, 1)}").append('\n')
        }

        print(sb)
    }

    private fun solution(x: Int, y: Int): Int {
        if (dp[x][y] != max) return dp[x][y]

        for (idx in 0..3) {
            val nextX = x + dx[idx]
            val nextY = y + dy[idx]

            if (check(nextX, nextY)) continue
            dp[x][y] = min(dp[x][y], arr[x][y] + solution(nextX, nextY))
        }

        return dp[x][y]
    }

    private fun check(x: Int, y: Int) =
        x < 0 || x >= n || y < 0 || y >= 3
}

fun main() {
    B_4883()()
}