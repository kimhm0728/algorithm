const val INF = 50_000_000

fun main() = with(System.`in`.bufferedReader()) {
    val (v, e) = readLine().split(" ").map { it.toInt() }
    val arr = Array(v) { IntArray(v) { INF } }
    repeat(e) {
        val (start, end, cost) = readLine().split(" ").map { it.toInt() }
        arr[start - 1][end - 1] = cost
    }

    for (i in 0..<v) {
        for (j in 0..<v) {
            for (k in 0..<v) {
                if (arr[i][j] + arr[j][k] < arr[i][k]) {
                    arr[i][k] = arr[i][j] + arr[j][k]
                }
            }
        }
    }

    var answer = INF
    for (i in 0..<v) {
        for (j in 0..<v) {
            if (answer > arr[i][j] + arr[j][i]) {
                answer = arr[i][j] + arr[j][i]
            }
        }
    }
    print(if (answer == INF) -1 else answer)
}
