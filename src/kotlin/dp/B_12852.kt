package kotlin.dp

class B_12852 {
    private val max = 1_000_001
    private lateinit var dp: IntArray
    private lateinit var next: IntArray

    operator fun invoke() {
        val n = System.`in`.bufferedReader().readLine().toInt()
        dp = IntArray(n + 1) { max }
        dp[1] = 0
        next = IntArray(n + 1)

        println(solution(n))

        val sb = StringBuilder("$n ")
        var nextValue = next[n]
        while (nextValue != 0) {
            sb.append("$nextValue ")
            nextValue = next[nextValue]
        }

        print(sb)
    }

    private fun solution(n: Int): Int {
        if (dp[n] != max) return dp[n]

        if (n % 3 == 0) update(n, n / 3, solution(n / 3))
        if (n % 2 == 0) update(n, n / 2, solution(n / 2))
        update(n, n - 1, solution(n - 1))

        return dp[n]
    }

    private fun update(n: Int, nextN: Int, result: Int) {
        if (result + 1 >= dp[n]) return

        dp[n] = result + 1
        next[n] = nextN
    }
}

fun main() {
    B_12852()()
}
