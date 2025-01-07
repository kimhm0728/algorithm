fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { IntArray(2) }
    repeat(n) {
        arr[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    arr.sortWith { o1, o2 -> o2[1] - o1[1] }

    var pre = arr[0][1]
    for (idx in 0..<n) {
        val end = if (pre < arr[idx][1]) pre else arr[idx][1]
        pre = end - arr[idx][0]
        if (pre < 0) {
            print(-1)
            return
        }
    }
    print(pre)
}
