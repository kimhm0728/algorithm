package kotlinsource.dp

fun main() = with(System.`in`.bufferedReader()) {
    fun String.toIntList() = split(" ").map { it.toInt() }

    val (n, m) = readLine().toIntList()
    val arr = Array(n + 1) { IntArray(n + 1) }

    for (x in 1 .. n) {
        readLine().split(" ").forEachIndexed { y, number ->
            arr[x][y + 1] = number.toInt() + arr[x - 1][y + 1] + arr[x][y] - arr[x - 1][y]
        }
    }

    val sb = StringBuilder()
    for (cnt in 1..m) {
        val (x1, y1, x2, y2) = readLine().toIntList()
        val answer = arr[x2][y2] - arr[x2][y1 - 1] - arr[x1 - 1][y2] + arr[x1 - 1][y1 - 1]
        sb.append(answer).append('\n')
    }

    print(sb)
}