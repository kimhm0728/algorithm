fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(m * 2) { IntArray(2) }
    repeat(m) {
        val (h1, h2) = readLine().split(" ").map { it.toInt() }
        arr[it * 2] = intArrayOf(h1, it + 1)
        arr[it * 2 + 1] = intArrayOf(h2, it + 1)
    }
    arr.sortWith { o1, o2 -> o1[0] - o2[0] }
    val idx = if (n % arr.size - 1 == -1) arr.size - 1 else n % arr.size - 1
    print(arr[idx][1])
}
