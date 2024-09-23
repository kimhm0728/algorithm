package kotlin.practice

var max = 0
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
val visit = BooleanArray(26)

fun main() = with(System.`in`.bufferedReader()) {
    val n: Int
    val m: Int
    readLine().split(" ").run {
        n = this[0].toInt()
        m = this[1].toInt()
    }

    val board = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val temp = readLine()
        for (j in 0 until m) {
            board[i][j] = temp[j] - 'A'
        }
    }

    dfs(board, n, m, 0, 0, 1)
    print(max)
}

fun dfs(board: Array<IntArray>, n: Int, m: Int, x: Int, y: Int, depth: Int) {
    max = if (depth > max) depth else max
    visit[board[x][y]] = true

    for (i in 0..3) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]

        if (check(n, m, nextX, nextY) || visit[board[nextX][nextY]]) {
            continue
        }

        dfs(board, n, m, nextX, nextY, depth + 1)
    }

    visit[board[x][y]] = false
}

private fun check(n: Int, m: Int, x: Int, y: Int) =
    x >= n || x < 0 || y >= m || y < 0