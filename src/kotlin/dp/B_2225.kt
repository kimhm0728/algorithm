// package kotlinsource.java.dp

// class B_2225 {
//     private val div = 1_000_000_000
//     private lateinit var java.dp: Array<IntArray>

//     operator fun invoke() {
//         val (n, k) = System.`in`.bufferedReader().readLine()
//             .split(" ")
//             .map { it.toInt() }

//         java.dp = Array(n + 1) { IntArray(k + 1) }
//         for (idx in 0..n) {
//             java.dp[idx][1] = 1
//         }

//         print(solution(n, k))
//     }

//     private fun solution(n: Int, k: Int): Int {
//         if (java.dp[n][k] != 0) return java.dp[n][k]

//         for (i in 0..n) {
//             java.dp[n][k] = (java.dp[n][k] + solution(n - i, k - 1)) % div
//         }

//         return java.dp[n][k]
//     }
// }

// fun main() {
//     B_2225()()
// }

val div = 1_000_000_000
lateinit var dp: Array<IntArray>

fun main() {
    val (n, k) = System.`in`.bufferedReader().readLine().split(" ").map { it.toInt() }
    dp = Array(n + 1) { IntArray(k + 1) { 0 } }
    (0..n).forEach { dp[it][1] = 1 }
    println(solution(n, k))
}

fun solution(n: Int, k: Int): Int {
    if (k == 0) return 0
    if (dp[n][k] != 0) return dp[n][k]
    var temp = 0
    (0..n).forEach {
        temp = (temp + solution(n - it, k - 1)) % div
    }
    dp[n][k] = temp
    return dp[n][k]
}
