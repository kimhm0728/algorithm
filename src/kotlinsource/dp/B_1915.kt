import kotlin.math.max
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { readLine().map { it - '0' }.toIntArray() }
    val dp = Array(n) { IntArray(m) }
    var answer = 0
    (0..<n).forEach { i ->
        (0..<m).forEach { j ->
            if (i == 0 || j == 0) {
                dp[i][j] = arr[i][j]
            } else if (arr[i][j] == 1) {
                dp[i][j] = min(dp[i - 1][j], min(dp[i][j - 1], dp[i - 1][j - 1])) + 1
            }
            answer = max(answer, dp[i][j])
        }
    }
    println(answer * answer)
}
