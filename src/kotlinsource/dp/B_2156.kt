package kotlinsource.dp

import kotlin.math.max

class B_2156 {
    private var n = 0
    private lateinit var arr: IntArray
    private lateinit var dp: Array<IntArray>

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        n = readLine().toInt()
        arr = IntArray(n)
        dp = Array(n) { IntArray(2) { -1 } }

        for (idx in 0 until n) {
            arr[idx] = readLine().toInt()
        }

        print(max(solution(0, 0), solution(1, 0)))
    }

    private fun solution(idx: Int, isContinue: Int): Int {
        if (idx >= n) return 0
        if (dp[idx][isContinue] != -1) return dp[idx][isContinue]

        var temp = max(solution(idx + 2, 0), solution(idx + 3, 0))
        if (isContinue == 0) {
            temp = max(temp, solution(idx + 1, 1))
        }

        dp[idx][isContinue] = temp + arr[idx]
        return dp[idx][isContinue]
    }
}

fun main() {
    B_2156()()
}