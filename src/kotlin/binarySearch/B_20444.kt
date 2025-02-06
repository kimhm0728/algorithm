fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ")
    val n = input[0].toInt()
    val k = input[1].toLong()
    print(if (binarySearch(n, k)) "YES" else "NO")
}

fun binarySearch(n: Int, k: Long): Boolean {
    var l = 0
    var r = n / 2

    while (l <= r) {
        val mid = (l + r) / 2
        val result = calculate(mid, n - mid)
        if (result > k) {
            r = mid - 1
        } else if (result < k) {
            l = mid + 1
        } else {
            return true
        }
    }

    return false
}

fun calculate(h: Int, v: Int): Long = (1 + v.toLong()) * (h.toLong() + 1)
