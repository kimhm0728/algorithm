package kotlin.dp

import kotlin.math.max

class B_10835 {
    private var n = 0
    private lateinit var left: IntArray
    private lateinit var right: IntArray
    private lateinit var dp: Array<IntArray>

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        n = readLine().toInt()
        left = readLine().toIntArray()
        right = readLine().toIntArray()
        dp = Array(n) { IntArray(n) { -1 } }

        print(solution(0, 0))
    }

    private fun String.toIntArray() =
        split(" ").map { it.toInt() }.toIntArray()

    private fun solution(leftIdx: Int, rightIdx: Int): Int {
        if (leftIdx >= n || rightIdx >= n) return 0
        if (dp[leftIdx][rightIdx] != -1) return dp[leftIdx][rightIdx]

        if (left[leftIdx] > right[rightIdx]) {
            dp[leftIdx][rightIdx] = right[rightIdx] + solution(leftIdx, rightIdx + 1)
            return dp[leftIdx][rightIdx]
        }

        dp[leftIdx][rightIdx] = max(
            solution(leftIdx + 1, rightIdx),
            solution(leftIdx + 1, rightIdx + 1)
        )
        return dp[leftIdx][rightIdx]
    }
}

fun main() {
    B_10835()()
}