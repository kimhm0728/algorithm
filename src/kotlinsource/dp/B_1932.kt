package kotlinsource.dp

import kotlin.math.max

class B_1932 {
    private var N = 0
    private lateinit var arr: Array<IntArray>
    private lateinit var dp: Array<IntArray>

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        arr = Array(N) { IntArray(N) }
        dp = Array(N) { IntArray(N) }

        for (idx in 0 until N) {
            arr[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
        }

        print(solution(0, 0))
    }

    private fun solution(x: Int, y: Int): Int {
        if (x == N) return 0
        if (dp[x][y] != 0) return dp[x][y]

        dp[x][y] = max(solution(x + 1, y), solution(x + 1, y + 1)) + arr[x][y]
        return dp[x][y]
    }
}

fun main() {
    B_1932()()
}
