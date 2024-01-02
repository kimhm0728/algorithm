package kotlinsource.dp

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val k = readLine().toInt()

    val dp = IntArray(t + 1)
    dp[0] = 1

    for (idx in 0 until k) {
        val (p, n) = readLine().split(" ").map { it.toInt() }

        for (amount in t downTo p) {
            for (cnt in 1..n) {
                if (amount - p * cnt < 0) break

                dp[amount] += dp[amount - p * cnt]
            }
        }
    }

    print(dp[t])
}