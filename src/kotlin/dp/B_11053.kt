import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp = IntArray(n) { 1 }
    for (i in 1..<n) {
        for (j in 0..<i) {
            if (arr[j] >= arr[i]) continue
            dp[i] = max(dp[i], dp[j] + 1)
        }
    }
    println(dp.max())
}

// package kotlin.dp

// import kotlin.math.max

// fun main() = with(System.`in`.bufferedReader()) {
//     val n = readLine().toInt()
//     val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
//     val dp = IntArray(n) { 1 }
//     var answer = 1

//     for (i in 1 until n) {
//         for (j in 0 until i) {
//             if (arr[i] <= arr[j]) continue
//             dp[i] = max(dp[i], dp[j] + 1)
//         }
//         answer = max(dp[i], answer)
//     }

//     print(answer)
// }
