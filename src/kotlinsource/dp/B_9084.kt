fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val n = readLine().toInt()
        val prices = readLine().split(" ").map { it.toInt() }
        val m = readLine().toInt()
        val dp = IntArray(m + 1)
        dp[0] = 1
        prices.forEach { price ->
            (price..m).forEach {
                dp[it] += dp[it - price]
            }
        }
        sb.append(dp[m]).append('\n')
    }
    println(sb)
}
