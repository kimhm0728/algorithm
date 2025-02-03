lateinit var dp: Array<LongArray>
var N = 0
var M = 0

val set = HashSet<Path>()

data class Path(val startX: Int, val startY: Int, val endX: Int, val endY: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() + 1 }
    N = n
    M = m
    dp = Array(n) { LongArray(m) { -1 } }

    val k = readLine().toInt()
    repeat(k) {
        val (a, b, c, d) = readLine().split(" ").map { it.toInt() }
        set.add(Path(n - b - 1, a, n - d - 1, c))
        set.add(Path(n - d - 1, c, n - b - 1, a))
    }
    dp[n - 1][0] = 1
    print(solution(0, m - 1))
}

fun solution(x: Int, y: Int): Long {
    if (dp[x][y] != -1L) {
        return dp[x][y]
    }
    dp[x][y] = 0
    if (check(x + 1, y) && !set.contains(Path(x, y, x + 1, y))) {
        dp[x][y] += solution(x + 1, y)
    }
    if (check(x, y - 1) && !set.contains(Path(x, y, x, y - 1))) {
        dp[x][y] += solution(x, y - 1)
    }
    return dp[x][y]
}

fun check(x: Int, y: Int) = x in 0..<N && y in 0..<M
