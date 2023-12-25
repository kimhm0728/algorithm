package kotlinsource.dp

import kotlin.math.max

class B_1535 {
    private lateinit var l: IntArray
    private lateinit var j: IntArray
    private lateinit var dp: Array<IntArray>

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        l = readLine().split(" ").map { it.toInt() }.toIntArray()
        j = readLine().split(" ").map { it.toInt() }.toIntArray()

        dp = Array(n) { IntArray(101) }
        print(solution(n - 1, 100))
    }

    private fun solution(n: Int, health: Int): Int {
        if (n < 0) return 0
        if (dp[n][health] != 0) return dp[n][health]

        if (health - l[n] <= 0) {
            dp[n][health] = solution(n - 1, health)
        } else {
            dp[n][health] = max(solution(n - 1, health), solution(n - 1, health - l[n]) + j[n])
        }
        return dp[n][health]
    }
}

fun main() {
    B_1535()()
}