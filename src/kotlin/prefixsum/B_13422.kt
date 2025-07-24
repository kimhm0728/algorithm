fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val (n, m, k) = readLine().split(" ").map { it.toInt() }
        val list = readLine().split(" ").map { it.toInt() }

        val N = n * 2
        val arr = IntArray(N) { list[it % n] }
        val sum = IntArray(N + 1)
        sum[1] = arr[0]
        for (i in 2..N) {
            sum[i] = arr[i - 1] + sum[i - 1]
        }

        var count = 0
        if (m == n) {
            if (sum[n] < k) count++
        } else {
            repeat(n) { startIdx ->
                if (sum[startIdx + m] - sum[startIdx] < k) {
                    count++
                }
            }
        }
        sb.append(count).append('\n')
    }

    print(sb)
}
