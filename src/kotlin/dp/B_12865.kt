// import kotlin.math.max

// class B_12865 {
//     private var N = 0
//     private lateinit var w: IntArray
//     private lateinit var v: IntArray
//     private lateinit var java.dp: Array<IntArray>

//     operator fun invoke() = with(System.`in`.bufferedReader()) {
//         val (n, k) = readLine().split(" ").map { it.toInt() }
//         N = n
//         w = IntArray(n)
//         v = IntArray(n)
//         java.dp = Array(n) { IntArray(k + 1) { -1 } }

//         for (idx in 0 until n) {
//             readLine().split(" ").run {
//                 w[idx] = this[0].toInt()
//                 v[idx] = this[1].toInt()
//             }
//         }

//         print(solution(0, k))
//     }

//     private fun solution(idx: Int, weight: Int): Int {
//         if (idx >= N) return 0
//         if (java.dp[idx][weight] != -1) return java.dp[idx][weight]

//         java.dp[idx][weight] = solution(idx + 1, weight)
//         if (weight - w[idx] >= 0) {
//             java.dp[idx][weight] = max(java.dp[idx][weight],
//                 solution(idx + 1, weight - w[idx]) + v[idx])
//         }

//         return java.dp[idx][weight]
//     }
// }

import kotlin.math.max

var N: Int = 0
var K: Int = 0
lateinit var w: IntArray
lateinit var v: IntArray
lateinit var dp: Array<IntArray>

fun main(): Unit = with(System.`in`.bufferedReader()) { // 12865
    val (n, k) = readLine().split(" ").map { it.toInt() }
    N = n
    K = k
    w = IntArray(n)
    v = IntArray(n)
    repeat(n) {
        val (weight, value) = readLine().split(" ").map { it.toInt() }
        w[it] = weight
        v[it] = value
    }
    dp = Array(n) { IntArray(k + 1) { -1 } }
    solution(0, 0)
    var answer = 0
    (0..<n).forEach { answer = max(answer, dp[it].max()) }
    println(answer)
}

fun solution(index: Int, weight: Int): Int {
    if (index >= N || weight > K) return 0
    if (index == N - 1) {
        dp[index][weight] = if (weight + w[index] > K) 0 else v[index]
    }
    if (dp[index][weight] != -1) return dp[index][weight]

    if (weight + w[index] <= K) {
        dp[index][weight] = solution(index + 1, weight + w[index]) + v[index]
    }
    dp[index][weight] = max(dp[index][weight], solution(index + 1, weight))
    return dp[index][weight]
}
