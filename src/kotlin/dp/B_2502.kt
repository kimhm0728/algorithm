package kotlin.dp

fun main() {
    val (d, k) = System.`in`.bufferedReader().readLine()
        .split(" ")
        .map { it.toInt() }

    val dp = Array(d + 1) { StringBuilder() }
    dp[1].append('A')
    dp[2].append('B')
    val result = solution(dp, d)
    val aCount = result.count { it == 'A' }
    val bCount = result.length - aCount

    loop@for (a in 1..100_000) {
        for (b in a..100_000) {
            val sum = a * aCount + b * bCount
            if (sum > k) break
            if (sum == k) {
                println(a)
                println(b)
                break@loop
            }
        }
    }
}

private fun solution(dp: Array<StringBuilder>, d: Int): StringBuilder {
    if (dp[d].isNotEmpty()) return dp[d]

    dp[d].append(solution(dp, d - 1)).append(solution(dp, d - 2))
    return dp[d]
}