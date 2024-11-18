import kotlin.math.min

var N = 0
var M = 0
lateinit var arr: Array<IntArray>
lateinit var dp: Array<Array<IntArray>>
val max = 10_000

val dy = intArrayOf(-1, 0, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    arr = Array(n) { IntArray(m) }
    dp = Array(n) { Array(m) { IntArray(3) { max } } }

    repeat(n) {
        arr[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    repeat(m) { i ->
        repeat(3) { j ->
            dp[0][i][j] = arr[0][i]
        }
    }
    repeat(m) { i ->
        repeat(3) { j ->
            solution(n - 1, i, j)
        }
    }

    var answer = max
    repeat(m) { i ->
        repeat(3) { j ->
            answer = min(answer, dp[n - 1][i][j])
        }
    }
    print(answer)
}

fun solution(x: Int, y: Int, dir: Int): Int {
    if (y !in 0..<M) {
        return max
    }

    if (dp[x][y][dir] != max) {
        return dp[x][y][dir]
    }

    repeat(3) {
        if (dir == it) {
            return@repeat
        }
        val preX = x - 1
        val preY = y + dy[it]
        dp[x][y][dir] = min(dp[x][y][dir], arr[x][y] + solution(preX, preY, it))
    }
    return dp[x][y][dir]
}
