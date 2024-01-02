package kotlinsource.dp

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val dp = IntArray(k + 1)
    dp[0] = 1

    for (i in 1..n) {
        val value = readLine().toInt()

        for (cnt in value..k) {
            dp[cnt] += dp[cnt - value]
        }
    }

    print(dp[k])
}