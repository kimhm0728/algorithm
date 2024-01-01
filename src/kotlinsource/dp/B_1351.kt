package kotlinsource.dp

fun main() {
    val (n, p, q) = System.`in`.bufferedReader().readLine()
        .split(" ")
        .map { it.toLong() }

    val dp = mutableMapOf<Long, Long>()
    dp[0] = 1
    print(solution(n, p, q, dp))
}

private fun solution(n: Long, p: Long, q: Long, dp: MutableMap<Long, Long>): Long {
    if (dp.contains(n)) return dp[n]!!

    dp[n] = solution(n / p, p, q, dp) + solution(n / q, p, q, dp)
    return dp[n]!!
}