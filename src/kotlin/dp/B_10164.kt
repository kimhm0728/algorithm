package kotlin.dp

class B_10164 {
    private lateinit var dp: Array<IntArray>
    private var destX = 0
    private var destY = 0

    operator fun invoke() {
        val (n, m, k) = System.`in`.bufferedReader().readLine()
            .split(" ").map { it.toInt() }
        dp = Array(n) { IntArray(m) }
        dp[n - 1][m - 1] = 1

        if (k == 0) {
            destX = n - 1
            destY = m - 1
            print(solution(0, 0))
            return
        }

        val (kx, ky) = (k - 1) / m to (k - 1) % m
        dp[kx][ky] = 1
        destX = kx
        destY = ky
        var answer = solution(0, 0)

        dp[kx][ky] = 0
        destX = n - 1
        destY = m - 1
        answer *= solution(kx, ky)

        print(answer)
    }

    private fun solution(x: Int, y: Int): Int {
        if (x > destX || y > destY) return 0
        if (dp[x][y] != 0) return dp[x][y]

        dp[x][y] = solution(x + 1, y) + solution(x, y + 1)
        return dp[x][y]
    }
}

fun main() {
    B_10164()()
}