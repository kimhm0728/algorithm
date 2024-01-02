package kotlinsource.dp

fun main() {
    val n = System.`in`.bufferedReader().readLine().toInt()
    val dp = IntArray(n + 1)
    dp[0] = 1

    var power = 1
    while (true) {
        if (power > n) break

        for (cnt in power..n) {
            dp[cnt] = (dp[cnt] + dp[cnt - power]) % 1_000_000_000
        }

        power *= 2
    }

    print(dp[n])
}