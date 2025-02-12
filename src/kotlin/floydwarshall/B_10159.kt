fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val path1 = Array(n) { BooleanArray(n) }
    val path2 = Array(n) { BooleanArray(n) }
    repeat(m) {
        val (start, end) = readLine().split(" ").map { it.toInt() - 1 }
        path1[start][end] = true
        path2[end][start] = true
    }
    for (k in 0..<n) {
        for (i in 0..<n) {
            for (j in 0..<n) {
                if (k == i || i == j || k == j) {
                    continue
                }
                if (path1[i][k] && path1[k][j]) {
                    path1[i][j] = true
                }
                if (path2[i][k] && path2[k][j]) {
                    path2[i][j] = true
                }
            }
        }
    }
    val sb = StringBuilder()
    for (i in 0..<n) {
        var count = 0
        for (j in 0..<n) {
            if (i == j) {
                continue
            }
            if (!path1[i][j] && !path2[i][j]) {
                count++
            }
        }
        sb.append(count).append('\n')
    }
    print(sb)
}
