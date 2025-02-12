fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val path = Array(n) { BooleanArray(n) }
    repeat(m) {
        val (start, end) = readLine().split(" ").map { it.toInt() - 1 }
        path[start][end] = true
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
            }
        }
    }
    val s = readLine().toInt()
    val sb = StringBuilder()
    repeat(s) {
        val (start, end) = readLine().split(" ").map { it.toInt() - 1 }
        sb.append(
            if (path[start][end]) {
                -1
            } else if (path[end][start]) {
                1
            } else {
                0
            }
        ).append('\n')
    }
    print(sb)
}
