import kotlin.math.min

var N = 0
lateinit var arr: Array<IntArray>
lateinit var dp: Array<IntArray>

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    N = n
    arr = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    dp = Array(n) { IntArray(n) { -1 } }
    dp[0][0] = 0
    print(solution(n - 1, n - 1))
}

fun solution(x: Int, y: Int): Int {
    if (dp[x][y] != -1) {
        return dp[x][y]
    }

    dp[x][y] = Int.MAX_VALUE
    if (x != 0) {
        val count = if (arr[x - 1][y] > arr[x][y]) 0 else arr[x][y] - arr[x - 1][y] + 1
        dp[x][y] = min(dp[x][y], count + solution(x - 1, y))
    }
    if (y != 0) {
        val count = if (arr[x][y - 1] > arr[x][y]) 0 else arr[x][y] - arr[x][y - 1] + 1
        dp[x][y] = min(dp[x][y], count + solution(x, y - 1))
    }
    return dp[x][y]
}
