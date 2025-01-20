fun main() = with(System.`in`.bufferedReader()) {
    val div = 1_000_000_007
    val n = readLine().toInt()
    val arr = readLine().toCharArray()
    val dp = Array(n) { LongArray(4) } // 0: W, 1: WH, 2: WHE, 3: WHEE...

    if (arr[0] == 'W') {
        dp[0][0] = 1
    }
    for (i in 1..<n) {
        when (arr[i]) {
            'W' -> {
                dp[i][0] = (dp[i - 1][0] + 1) % div
                dp[i][1] = dp[i - 1][1]
                dp[i][2] = dp[i - 1][2]
                dp[i][3] = dp[i - 1][3]
            }

            'H' -> {
                dp[i][0] = dp[i - 1][0]
                dp[i][1] = (dp[i - 1][1] + dp[i - 1][0]) % div
                dp[i][2] = dp[i - 1][2]
                dp[i][3] = dp[i - 1][3]
            }

            'E' -> {
                dp[i][0] = dp[i - 1][0]
                dp[i][1] = dp[i - 1][1]
                dp[i][2] = (dp[i - 1][2] + dp[i - 1][1]) % div
                dp[i][3] = (dp[i - 1][3] + dp[i - 1][2] + dp[i - 1][3]) % div
            }

            else -> {
                dp[i][0] = dp[i - 1][0]
                dp[i][1] = dp[i - 1][1]
                dp[i][2] = dp[i - 1][2]
                dp[i][3] = dp[i - 1][3]
            }
        }
    }
    print(dp[n - 1][3])
}
