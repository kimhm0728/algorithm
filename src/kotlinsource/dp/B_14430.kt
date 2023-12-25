package kotlinsource.dp

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    fun String.toIntList() = split(" ").map { it.toInt() }

    val (n, m) = readLine().toIntList()
    val arr = Array(n) { IntArray(m) }
    val dp = Array(n) { IntArray(m) { -1 } }

    for (idx in 0 until n) {
        arr[idx] = readLine().toIntList().toIntArray()
    }

    print(solution(arr, dp, n - 1, m - 1))
}

private fun solution(arr: Array<IntArray>, dp: Array<IntArray>, x: Int, y: Int): Int {
    if (x < 0 || y < 0) return 0
    if (dp[x][y] != -1) return dp[x][y]

    dp[x][y] = arr[x][y] + max(solution(arr, dp, x - 1, y), solution(arr, dp, x, y - 1))
    return dp[x][y]
}