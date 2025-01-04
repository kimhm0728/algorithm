fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = IntArray(41)
    dp[0] = 1
    dp[1] = 1
    dp[2] = 2
    for (i in 3..40) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    val m = readLine().toInt()

    var pre = 0
    var answer = 1
    repeat(m) {
        val vip = readLine().toInt()
        answer *= dp[vip - pre - 1]
        pre = vip
    }
    answer *= dp[n - pre]
    print(answer)
}
