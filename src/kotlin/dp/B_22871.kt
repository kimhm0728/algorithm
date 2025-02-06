import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

lateinit var arr: LongArray
lateinit var dp: LongArray
val max = Long.MAX_VALUE
var n = 0
fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = readLine().split(" ").map { it.toLong() }.toLongArray()
    dp = LongArray(n) { max }
    dp[n - 1] = 0
    print(solution(0))
}

fun solution(idx: Int): Long {
    if (dp[idx] != max) {
        return dp[idx]
    }

    for (i in idx + 1..<n) {
        val value = (i - idx) * (1 + abs(arr[idx] - arr[i]))
        dp[idx] = min(dp[idx], max(solution(i), value))
    }
    return dp[idx]
}
