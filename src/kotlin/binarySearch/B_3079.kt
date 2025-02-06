import kotlin.math.floor

var N = 0
var M = 0
lateinit var arr: LongArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    arr = LongArray(n) { readLine().toLong() }

    var l = 0L
    var r = Long.MAX_VALUE

    while (l < r) {
        val mid = (l + r) / 2

        if (isPossible(mid)) {
            r = mid
        } else {
            l = mid + 1
        }
    }
    print(l)
}

fun isPossible(t: Long): Boolean {
    var count = 0L
    arr.forEach {
        count += t / it
        if (count >= M) {
            return true
        }
    }
    return false
}
