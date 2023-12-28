package kotlinsource.dp

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n + 1) { IntArray(m + 1) }

    for (x in 1..n) {
        readLine().split(" ").forEachIndexed { y, number ->
            arr[x][y + 1] = number.toInt()
            arr[x][y + 1] += arr[x - 1][y + 1] + arr[x][y] - arr[x - 1][y]
        }
    }

    val sb = StringBuilder()
    val k = readLine().toInt()

    for (cnt in 1..k) {
        val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
        val answer = arr[x2][y2] - arr[x2][y1 - 1] - arr[x1 - 1][y2] + arr[x1 - 1][y1 - 1]
        sb.append(answer).append('\n')
    }

    print(sb)
}