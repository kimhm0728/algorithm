fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) }
    repeat(n) {
        arr[it] = readLine().toCharArray().map { it - '0' }.toIntArray()
    }
    val answer = Array(n) { IntArray(m) }
    repeat(n) {
        answer[it] = readLine().toCharArray().map { it - '0' }.toIntArray()
    }
    var count = 0
    loop@ while (!equals(n, m, arr, answer)) {
        for (i in 0..n - 3) {
            for (j in 0..m - 3) {
                if (arr[i][j] != answer[i][j]) {
                    count++
                    reverse(arr, i, j)
                    continue@loop
                }
            }
        }
        count = -1
        break
    }
    print(count)
}

fun equals(n: Int, m: Int, arr: Array<IntArray>, answer: Array<IntArray>): Boolean {
    for (i in 0..<n) {
        for (j in 0..<m) {
            if (arr[i][j] != answer[i][j]) {
                return false
            }
        }
    }
    return true
}

fun reverse(arr: Array<IntArray>, x: Int, y: Int) {
    repeat(3) { i ->
        repeat(3) { j ->
            arr[x + i][y + j] = if (arr[x + i][y + j] == 1) 0 else 1
        }
    }
}
