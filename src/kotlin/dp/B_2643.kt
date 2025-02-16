fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) {
        val input = readLine().split(" ").map { it.toInt() }
        if (input[0] > input[1]) {
            intArrayOf(input[0], input[1])
        } else {
            intArrayOf(input[1], input[0])
        }
    }
    arr.sortWith { o1, o2 -> if (o2[0] == o1[0]) o2[1] - o1[1] else o2[0] - o1[0] }
    val dp = IntArray(n) { 1 }

    for (i in 1..<n) {
        for (j in i - 1 downTo 0) {
            if ((arr[i][0] > arr[j][0] || arr[i][1] > arr[j][1]) && (arr[i][0] > arr[j][1] || arr[i][1] > arr[j][0])) {
                continue
            }
            if (dp[i] < dp[j] + 1) {
                dp[i] = dp[j] + 1
            }
        }
    }
    print(dp.max())
}
