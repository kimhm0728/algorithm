import kotlin.math.max
import kotlin.math.min

lateinit var arr: IntArray
lateinit var dp: Array<IntArray>
lateinit var sum: IntArray
val init = -100_000_000
val min = -300_000_000
var N = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    arr = IntArray(n + 1)
    dp = Array(n + 1) { IntArray(m + 1) { init } }
    sum = IntArray(n + 1)
    for (i in 1..n) {
        arr[i] = readLine().toInt()
        sum[i] = sum[i - 1] + arr[i]
    }

    print(solution(n, m))
}

fun solution(idx: Int, k: Int): Int {
    if (k == 0) {
        return 0
    }
    if (idx < 1) {
        return min
    }
    if (dp[idx][k] != init) {
        return dp[idx][k]
    }

    dp[idx][k] = solution(idx - 1, k) // idx를 건너뛰는 경우
    for (i in idx downTo 1) { // idx를 포함시키는 경우 중 최대값
        dp[idx][k] = max(dp[idx][k], solution(i - 2, k - 1) + sum[idx] - sum[i - 1])
    }
    return dp[idx][k]
}
