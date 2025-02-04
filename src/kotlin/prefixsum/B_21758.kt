import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    val sum = IntArray(n)
    sum[0] = arr[0]
    for (i in 1..<n) {
        sum[i] = arr[i] + sum[i - 1]
    }

    // 벌통이 가장 왼쪽인 경우
    var answer = 0
    for (i in 1..<n - 1) {
        answer = max(answer, sum[n - 2] + sum[i - 1] - arr[i])
    }

    // 벌통이 가장 오른쪽인 경우
    for (i in 1..<n - 1) {
        answer = max(answer, sum[n - 1] - arr[0] + sum[n - 1] - sum[i] - arr[i])
    }

    // 벌통이 중간에 오는 경우
    for (i in 1..<n - 1) {
        answer = max(answer, sum[n - 1] - arr[0] - arr[n - 1] + arr[i])
    }

    print(answer)
}
