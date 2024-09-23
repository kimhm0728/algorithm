var N = 0
var M = 0
lateinit var arr: Array<BooleanArray>
var answer = 0

fun main() {
    val (n, m) = System.`in`.bufferedReader().readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    arr = Array(n) { BooleanArray(m) }

    dfs(0)
    print(answer)
}

fun dfs(depth: Int) {
    if (depth == N * M) {
        answer++
        return
    }

    dfs(depth + 1)
    val row = depth / M
    val col = depth % M
    if (check(row, col)) {
        arr[row][col] = true
        dfs(depth + 1)
        arr[row][col] = false
    }
}

fun check(row: Int, col: Int): Boolean {
    if (checkRange(row - 1, col - 1) || checkRange(row - 1, col) || checkRange(row, col - 1)) {
        return true
    }
    return !(arr[row - 1][col - 1] && arr[row - 1][col] && arr[row][col - 1])
}

fun checkRange(row: Int, col: Int) = row !in 0..<N || col !in 0..M
