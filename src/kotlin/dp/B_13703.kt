lateinit var dp: Array<LongArray>

fun main() = with(System.`in`.bufferedReader()) {
    val (k, n) = readLine().split(" ").map { it.toInt() }
    dp = Array(200) { LongArray(n + 1) { -1 } } // 위치, 시간
    dp[0].fill(0)
    for (i in 1..<200) {
        dp[i][n] = 1
    }

    print(solution(k, 0))
}

fun solution(pos: Int, time: Int): Long {
    if (dp[pos][time] != -1L) {
        return dp[pos][time]
    }

    dp[pos][time] = solution(pos + 1, time + 1) + solution(pos - 1, time + 1)
    return dp[pos][time]
}
