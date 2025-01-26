fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) }
    repeat(n) {
        arr[it] = readLine().toCharArray().map { it - '0' }.toIntArray()
    }

    var answer = 0
    while (!check(n, m, arr)) {
        for (i in n - 1 downTo 0) {
            for (j in m - 1 downTo 0) {
                if (arr[i][j] == 1) {
                    reserve(i, j, arr)
                    answer++
                }
            }
        }
    }
    print(answer)
}

fun check(n: Int, m: Int, arr: Array<IntArray>): Boolean {
    for (i in 0..<n) {
        for (j in 0..<m) {
            if (arr[i][j] == 1) {
                return false
            }
        }
    }
    return true
}

fun reserve(x: Int, y: Int, arr: Array<IntArray>) {
    for (i in 0..x) {
        for (j in 0..y) {
            arr[i][j] = if (arr[i][j] == 0) 1 else 0
        }
    }
}
