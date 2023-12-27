package kotlinsource.dp

import kotlin.math.min
import kotlin.math.pow

class B_2302 {
    private var n = 0
    private val max = 10_000_000
    private lateinit var dp: IntArray
    private lateinit var road: String
    private var isPossible = false

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        n = readLine().toInt()
        dp = IntArray(n) { -1 }
        dp[n - 1] = 0

        road = readLine()
        val answer = solution('B', 0)
        print(if (isPossible) answer else -1)
    }

    private fun solution(now: Char, idx: Int): Int {
        if (idx == n - 1) isPossible = true
        if (dp[idx] != -1) return dp[idx]
        val next = getNext(now)

        var startIdx = idx
        dp[idx] = max
        while (true) {
            val nextIdx = road.indexOf(next, startIdx + 1)
            if (nextIdx == -1) break

            dp[idx] = min(dp[idx], (nextIdx - idx).toDouble().pow(2).toInt() + solution(next, nextIdx))
            startIdx = nextIdx
        }

        return dp[idx]
    }

    private fun getNext(now: Char) =
        if (now == 'B') 'O' else if (now == 'O') 'J' else 'B'
}

fun main() {
    B_2302()()
}