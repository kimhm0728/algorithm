package kotlinsource.dp

import kotlin.math.max

class B_2240 {
    private var T = 0
    private lateinit var arr: IntArray
    private lateinit var dp: Array<IntArray>

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        val (t, w) = readLine().split(" ").map { it.toInt() }
        T = t
        arr = IntArray(t)
        dp = Array(t) { IntArray(w + 1) { -1 } }

        for (idx in 0 until t) {
            arr[idx] = readLine().toInt()
        }

        print(max(solution(1, 0, w), solution(2, 0, w - 1)))
    }

    private fun solution(pos: Int, t: Int, w: Int): Int {
        if (t >= T) return 0
        if (dp[t][w] != -1) return dp[t][w]

        val move = if (pos == 1) 2 else 1

        if (pos == arr[t]) {
            dp[t][w] = solution(pos, t + 1, w) + 1
            if (w >= 1) dp[t][w] = max(dp[t][w], solution(move, t + 1, w - 1))
            return dp[t][w]
        }

        dp[t][w] = solution(pos, t + 1, w)
        if (w >= 1) dp[t][w] = max(dp[t][w], solution(move, t + 1, w - 1) + 1)

        return dp[t][w]
    }
}

fun main() {
    B_2240()()
}