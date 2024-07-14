// class B_5557 {
//     private lateinit var arr: IntArray
//     private lateinit var dp: Array<LongArray>

//     operator fun invoke() = with(System.`in`.bufferedReader()) {
//         val n = readLine().toInt()
//         arr = readLine()
//             .split(" ")
//             .map { it.toInt() }
//             .toIntArray()

//         dp = Array(n - 1) { LongArray(21) { -1 } }
//         dp[n - 2].fill(0)
//         dp[n - 2][arr[n - 1]] = 1

//         print(solution(0, arr[0]))
//     }

//     private fun solution(idx: Int, value: Int): Long {
//         if (value < 0 || value > 20) return 0
//         if (dp[idx][value] != (-1).toLong()) return dp[idx][value]

//         dp[idx][value] = solution(idx + 1, value + arr[idx + 1]) +
//                 solution(idx + 1, value - arr[idx + 1])
//         return dp[idx][value]
//     }
// }

lateinit var arr: IntArray
lateinit var dp: Array<LongArray>

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    dp = Array(n) { LongArray(21) { -1 } }
    (0..20).forEach { dp[n - 1][it] = 0 }
    dp[n - 1][arr[n - 1]] = 1
    println(solution(1, arr[0]))
}

fun solution(n: Int, k: Int): Long {
    if (k < 0 || k > 20) return 0
    if (dp[n][k] != (-1).toLong()) return dp[n][k]

    dp[n][k] = solution(n + 1, k - arr[n]) + solution(n + 1, k + arr[n])
    return dp[n][k]
}
