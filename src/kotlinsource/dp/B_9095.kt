package kotlinsource.dp

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()
    val dp = IntArray(11)
    dp[0] = 1

    for (cnt in 1..t) {
        sb.append(solution(dp, readLine().toInt())).append('\n')
    }

    print(sb)
}

private fun solution(dp: IntArray, n: Int): Int {
    if (n < 0) return 0
    if (dp[n] != 0) return dp[n]

    dp[n] += solution(dp, n - 1) + solution(dp, n - 2) + solution(dp, n - 3)
    return dp[n]
}