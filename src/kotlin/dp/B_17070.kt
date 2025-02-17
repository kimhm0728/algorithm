var n = 0
lateinit var arr: Array<IntArray>
lateinit var dp: Array<Array<Array<IntArray>>>

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    dp = Array(n) { Array(n) { Array(n) { IntArray(n) { -1 } } } }
    if (arr[n - 1][n - 1] == 1) {
        print(0)
        return
    }
    print(solution(0, 0, 0, 1))
}

fun solution(x1: Int, y1: Int, x2: Int, y2: Int): Int {
    if (!check(x1, y1) || !check(x2, y2)) {
        return 0
    }
    if (dp[x1][y1][x2][y2] != -1) {
        return dp[x1][y1][x2][y2]
    }

    dp[x1][y1][x2][y2] = 0
    if (arr[x1][y1] == 1 || arr[x2][y2] == 1) {
        return dp[x1][y1][x2][y2]
    }

    if (isHorizontal(x1, y1, x2, y2)) {
        dp[x1][y1][x2][y2] += solution(x2, y2, x2 + 1, y2 + 1)
        dp[x1][y1][x2][y2] += solution(x2, y2, x2, y2 + 1)
    } else if (isVertical(x1, y1, x2, y2)) {
        dp[x1][y1][x2][y2] += solution(x2, y2, x2 + 1, y2 + 1)
        dp[x1][y1][x2][y2] += solution(x2, y2, x2 + 1, y2)
    } else {
        if (arr[x1][y1 + 1] == 1 || arr[x2][y2 - 1] == 1) {
            return dp[x1][y1][x2][y2]
        }
        dp[x1][y1][x2][y2] += solution(x2, y2, x2, y2 + 1)
        dp[x1][y1][x2][y2] += solution(x2, y2, x2 + 1, y2)
        dp[x1][y1][x2][y2] += solution(x2, y2, x2 + 1, y2 + 1)
    }
    if (x2 == n - 1 && y2 == n - 1) {
        dp[x1][y1][x2][y2] = 1
    }
    return dp[x1][y1][x2][y2]
}

fun isHorizontal(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    return x1 == x2 && y1 + 1 == y2
}

fun isVertical(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    return y1 == y2 && x1 + 1 == x2
}

fun check(x: Int, y: Int) = x in 0..<n && y in 0..<n
