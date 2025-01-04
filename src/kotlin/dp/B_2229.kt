import kotlin.math.max
import kotlin.math.min

lateinit var arr: IntArray
lateinit var dp: IntArray
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    dp = IntArray(n) { -1 }
    print(solution(0))
}

fun solution(idx: Int): Int {
    if (idx >= n) {
        return 0
    }
    if (dp[idx] != -1) {
        return dp[idx]
    }

    var temp = -1
    var min = 10_001
    var max = -1
    for (i in 1..n - idx) {
        min = min(min, arr[idx + i - 1])
        max = max(max, arr[idx + i - 1])
        val score = max - min
        temp = max(temp, score + solution(idx + i))
    }
    dp[idx] = temp
    return dp[idx]
}
