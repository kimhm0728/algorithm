package kotlinsource.dp

import kotlin.math.max

class B_12865 {
    private var N = 0
    private lateinit var w: IntArray
    private lateinit var v: IntArray
    private lateinit var dp: Array<IntArray>

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        val (n, k) = readLine().split(" ").map { it.toInt() }
        N = n
        w = IntArray(n)
        v = IntArray(n)
        dp = Array(n) { IntArray(k + 1) { -1 } }

        for (idx in 0 until n) {
            readLine().split(" ").run {
                w[idx] = this[0].toInt()
                v[idx] = this[1].toInt()
            }
        }

        print(solution(0, k))
    }

    private fun solution(idx: Int, weight: Int): Int {
        if (idx >= N) return 0
        if (dp[idx][weight] != -1) return dp[idx][weight]

        dp[idx][weight] = solution(idx + 1, weight)
        if (weight - w[idx] >= 0) {
            dp[idx][weight] = max(dp[idx][weight],
                solution(idx + 1, weight - w[idx]) + v[idx])
        }

        return dp[idx][weight]
    }
}

fun main() {
    B_12865()()
}