import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n + 1) { IntArray(m + 1) }

    repeat(n) { i ->
        val input = readLine().split(" ").map { it.toInt() }
        repeat(m) { j ->
            arr[i + 1][j + 1] = input[j]
        }
    }
    for (i in 1..n) {
        for (j in 1..m) {
            arr[i][j] += arr[i][j - 1]
        }
    }
    for (i in 1..n) {
        for (j in 1..m) {
            arr[i][j] += arr[i - 1][j]
        }
    }

    var answer = Int.MIN_VALUE
    for (i in 1..n) {
        for (j in 1..m) {
            for (k in i..n) {
                for (y in j..m) {
                    answer = max(answer, arr[k][y] - arr[k][j - 1] - arr[i - 1][y] + arr[i - 1][j - 1])
                }
            }
        }
    }
    print(answer)
}
