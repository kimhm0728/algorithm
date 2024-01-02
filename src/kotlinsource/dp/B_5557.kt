package kotlinsource.dp

class B_5557 {
    private lateinit var arr: IntArray
    private lateinit var dp: Array<LongArray>

    operator fun invoke() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        arr = readLine()
            .split(" ")
            .map { it.toInt() }
            .toIntArray()

        dp = Array(n - 1) { LongArray(21) { -1 } }
        dp[n - 2].fill(0)
        dp[n - 2][arr[n - 1]] = 1

        print(solution(0, arr[0]))
    }

    private fun solution(idx: Int, value: Int): Long {
        if (value < 0 || value > 20) return 0
        if (dp[idx][value] != (-1).toLong()) return dp[idx][value]

        dp[idx][value] = solution(idx + 1, value + arr[idx + 1]) +
                solution(idx + 1, value - arr[idx + 1])
        return dp[idx][value]
    }
}

fun main() {
    B_5557()()
}