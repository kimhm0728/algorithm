fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val v = IntArray(n) { readLine().toInt() }
    val dp = IntArray(k + 1) { 0 }
    dp[0] = 1

    v.forEach { value ->
        (value..k).forEach {
            dp[it] += dp[it - value]
        }
    }

    println(dp[k])
}
