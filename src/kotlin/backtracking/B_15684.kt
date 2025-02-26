lateinit var arr: Array<BooleanArray>
var answer = 10
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (M, c, N) = readLine().split(" ").map { it.toInt() }
    n = N
    m = M
    arr = Array(n) { BooleanArray(m) }
    repeat(c) {
        val (x, y) = readLine().split(" ").map { it.toInt() - 1 }
        arr[x][y] = true
    }
    dfs(0, 0)
    print(if (answer == 10) -1 else answer)
}

fun dfs(depth: Int, idx: Int) {
    if (check() && answer > depth) {
        answer = depth
    }
    if (depth == 3) {
        return
    }

    for (i in idx..<n * m) {
        val x = i / m
        val y = i % m
        if (y == m - 1 || arr[x][y] || (y - 1 > 0 && arr[x][y - 1])) {
            continue
        }
        arr[x][y] = true
        dfs(depth + 1, idx + 1)
        arr[x][y] = false
    }
}

fun check(): Boolean {
    for (i in 0..<m) {
        var x = 0
        var y = i
        while (x < n) {
            if (y - 1 >= 0 && arr[x][y - 1]) {
                y--
            } else if (arr[x][y]) {
                y++
            }
            x++
        }
        if (y != i) {
            return false
        }
    }
    return true
}
