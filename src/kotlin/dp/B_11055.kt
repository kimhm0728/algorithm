import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp = IntArray(n) { arr[it] }
    for (i in 1..<n) {
        for (j in 0..<i) {
            if (arr[j] >= arr[i]) continue
            dp[i] = max(dp[i], arr[i] + dp[j])
        }
    }
    println(dp.max())
}

// package kotlin.dp

// import kotlin.math.max

// fun main() = with(System.`in`.bufferedReader()) {
//     val n = readLine().toInt()
//     val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
//     val dp = IntArray(n) { arr[it] }
//     var answer = arr[0]

//     for (i in 1 until n) {
//         var temp = 0
//         for (j in i - 1 downTo 0) {
//             if (arr[i] <= arr[j]) continue
//             temp = max(temp, dp[j])
//         }
//         dp[i] += temp
//         answer = max(answer, dp[i])
//     }

//     print(answer)
// }
