import kotlin.math.max

lateinit var arr: Array<IntArray>
lateinit var dp: Array<Array<IntArray>>
val next = intArrayOf(1, 2, 0)
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = Array(n) { IntArray(n) }
    dp = Array(n) { Array(n) { IntArray(3) { -1 } } }
    repeat(n) {
        arr[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    print(solution(0, 0, 0))
}

fun solution(x: Int, y: Int, idx: Int): Int {
    if (x !in 0..<n || y !in 0..<n) {
        return 0
    }
    if (dp[x][y][idx] != -1) {
        return dp[x][y][idx]
    }

    if (arr[x][y] == idx) {
        dp[x][y][idx] = 1 + max(solution(x + 1, y, next[idx]), solution(x, y + 1, next[idx]))
    }
    dp[x][y][idx] = max(dp[x][y][idx], max(solution(x + 1, y, idx), solution(x, y + 1, idx)))
    return dp[x][y][idx]
}
