import java.util.*
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = IntArray(n + 1)
    var max = 0

    repeat(n) { idx ->
        val st = StringTokenizer(readLine())
        val t = st.nextToken().toInt()
        val p = st.nextToken().toInt()
        max = max(max, dp[idx])
        if (idx + t > n) return@repeat
        dp[idx + t] = max(dp[idx + t], max + p)
    }
    println(dp.max())
}
