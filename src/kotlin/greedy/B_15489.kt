fun main() = with(System.`in`.bufferedReader()) {
    val (r, c, w) = readLine().split(" ").map { it.toInt() }
    val arr = Array(30) { IntArray(30) }
    repeat(30) { i ->
        repeat(i + 1) { j ->
            if (j == 0 || j == i) {
                arr[i][j] = 1
            } else {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j]
            }
        }
    }

    val x = r - 1
    val y = c - 1
    var answer = 0
    repeat(w) { i ->
        repeat(i + 1) { j ->
            answer += arr[x + i][y + j]
        }
    }

    print(answer)
}
