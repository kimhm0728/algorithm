import kotlin.math.max
/*
class B_9465 {
    private var n = 0
    private lateinit var arr: Array<IntArray>
    private lateinit var java.dp: Array<IntArray>

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        val t = readLine().toInt()
        val sb = StringBuilder()

        for (cnt in 1..t) {
            n = readLine().toInt()
            arr = Array(2) { IntArray(n) }
            java.dp = Array(2) { IntArray(n) { -1 } }

            for (idx in 0..1) {
                arr[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
            }

            sb.append(max(solution(0, 0), solution(1, 0))).append('\n')
        }

        print(sb)
    }

    private fun solution(x: Int, y: Int): Int {
        if (y >= n) return 0
        if (java.dp[x][y] != -1) return java.dp[x][y]

        val otherX = if (x == 0) 1 else 0
        java.dp[x][y] = arr[x][y] + max(solution(otherX, y + 1), solution(otherX, y + 2))

        return java.dp[x][y]
    }
}

fun main() {
    B_9465()()
}
*/

lateinit var arr: Array<IntArray>
lateinit var dp: Array<IntArray>

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val n = readLine().toInt()
        arr = Array(2) { IntArray(n) { 0 } }
        dp = Array(2) { IntArray(n) { -1 } }
        arr[0] = readLine().split(" ").map { it.toInt() }.toIntArray()
        arr[1] = readLine().split(" ").map { it.toInt() }.toIntArray()

        if (n == 1) {
            sb.append(max(arr[0][0], arr[1][0])).append('\n')
            return@repeat
        }

        dp[0][0] = arr[0][0]
        dp[1][0] = arr[1][0]
        dp[0][1] = arr[0][1] + arr[1][0]
        dp[1][1] = arr[1][1] + arr[0][0]
        sb.append(max(solution(0, n - 1), solution(1, n - 1))).append('\n')
    }
    println(sb)
}

fun solution(x: Int, y: Int): Int {
    if (x < 0) return 0
    if (dp[x][y] != -1) return dp[x][y]
    val reverseX = if (x == 0) 1 else 0
    dp[x][y] = max(solution(reverseX, y - 1), solution(reverseX, y - 2)) + arr[x][y]
    return dp[x][y]
}
