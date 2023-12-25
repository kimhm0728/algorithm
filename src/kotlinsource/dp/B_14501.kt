package kotlinsource.dp

import java.util.*
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = IntArray(n + 1)
    var max = 0

    for (idx in 0 until n) {
        val st = StringTokenizer(readLine())
        val t = st.nextToken().toInt()
        val p = st.nextToken().toInt()

        max = max(max, dp[idx])
        if (idx + t > n) continue
        dp[idx + t] = max(dp[idx + t], max + p)
    }

    print(max(max, dp[n]))
}