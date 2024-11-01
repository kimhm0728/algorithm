import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
    val lens = readLine().split(" ").map { it.toInt() }.sorted().toIntArray()

    var answer = -1.0
    for (i in 0..<n) {
        for (j in i + 1..<n) {
            var left = 0
            var right = m - 1
            while (left <= right) {
                val mid = (left + right) / 2
                val area = (lens[mid] * (arr[j] - arr[i])) / 2.0
                if (area > r) {
                    right = mid - 1
                } else {
                    answer = max(answer, area)
                    left = mid + 1
                }
            }
        }
    }

    if (answer == -1.0) {
        print("-1")
        return
    }
    print(String.format("%.1f", answer))
}
