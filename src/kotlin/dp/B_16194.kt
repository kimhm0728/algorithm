package kotlin.dp

import kotlin.math.min

class B_16194 {
    private var n = 0
    private val max = 10_000_001
    private lateinit var arr: IntArray
    private lateinit var dp: IntArray

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        n = readLine().toInt()
        arr = IntArray(n + 1)
        readLine().split(" ").forEachIndexed { idx, number ->
            arr[idx + 1] = number.toInt()
        }

        dp = IntArray(n + 1) { max }
        dp[0] = 0

        print(solution(n))
    }

    private fun solution(cnt: Int): Int {
        if (dp[cnt] != max) return dp[cnt]

        for (purchaseCnt in 1..cnt) {
            dp[cnt] = min(dp[cnt], arr[purchaseCnt] + solution(cnt - purchaseCnt))
        }

        return dp[cnt]
    }
}

fun main() {
    B_16194()()
}