fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val path = Array(n) { BooleanArray(n) }
    val reversePath = Array(n) { BooleanArray(n) }
    repeat(m) {
        val (start, end) = readLine().split(" ").map { it.toInt() - 1 }
        path[start][end] = true
        reversePath[end][start] = true
    }

    for (k in 0..<n) {
        for (i in 0..<n) {
            for (j in 0..<n) {
                if (k == i || i == j || k == j) {
                    continue
                }
                if (path[i][k] && path[k][j]) {
                    path[i][j] = true
                }
                if (reversePath[i][k] && reversePath[k][j]) {
                    reversePath[i][j] = true
                }
            }
        }
    }
    var answer = 0
    for (i in 0..<n) {
        var count = 0
        for (j in 0..<n) {
            if (i == j) {
                continue
            }
            if (path[i][j] || reversePath[i][j]) {
                count++
            }
        }
        if (count == n - 1) {
            answer++
        }
    }
    print(answer)
}
