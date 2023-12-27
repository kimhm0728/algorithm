package kotlinsource.dp

import kotlin.math.max

class B_9465 {
    private var n = 0
    private lateinit var arr: Array<IntArray>
    private lateinit var dp: Array<IntArray>

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        val t = readLine().toInt()
        val sb = StringBuilder()

        for (cnt in 1..t) {
            n = readLine().toInt()
            arr = Array(2) { IntArray(n) }
            dp = Array(2) { IntArray(n) { -1 } }

            for (idx in 0..1) {
                arr[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
            }

            sb.append(max(solution(0, 0), solution(1, 0))).append('\n')
        }

        print(sb)
    }

    private fun solution(x: Int, y: Int): Int {
        if (y >= n) return 0
        if (dp[x][y] != -1) return dp[x][y]

        val otherX = if (x == 0) 1 else 0
        dp[x][y] = arr[x][y] + max(solution(otherX, y + 1), solution(otherX, y + 2))

        return dp[x][y]
    }
}

fun main() {
    B_9465()()
}