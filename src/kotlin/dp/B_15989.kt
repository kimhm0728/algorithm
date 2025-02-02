val dp = Array(10_001) { IntArray(4) { -1 } }

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()

    dp[0][1] = 0
    dp[0][2] = 0
    dp[0][3] = 0

    dp[1][1] = 1
    dp[1][2] = 0
    dp[1][3] = 0

    dp[2][1] = 1
    dp[2][2] = 1
    dp[2][3] = 0

    dp[3][1] = 1
    dp[3][2] = 1
    dp[3][3] = 1

    repeat(t) {
        val n = readLine().toInt()
        sb.append(solution(n, 1) + solution(n, 2) + solution(n, 3)).append('\n')
    }

    print(sb)
}

fun solution(n: Int, idx: Int): Int {
    if (dp[n][idx] != -1) {
        return dp[n][idx]
    }

    dp[n][idx] = when (idx) {
        1 -> solution(n - 1, 1)
        2 -> solution(n - 2, 1) + solution(n - 2, 2)
        else -> solution(n - 3, 1) + solution(n - 3, 2) + solution(n - 3, 3)
    }

    return dp[n][idx]
}
