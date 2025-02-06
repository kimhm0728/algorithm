import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

var n = 0
lateinit var arr: LongArray
lateinit var visit: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = readLine().split(" ").map { it.toLong() }.toLongArray()
    print(lowerBound())
}

fun lowerBound(): Long {
    var l = 0L
    var r = 0 cal n - 1

    while (l < r) {
        visit = BooleanArray(n)
        val mid = (l + r) / 2
        if (isPossible(0, mid)) {
            r = mid
        } else {
            l = mid + 1
        }
    }
    return l
}

fun isPossible(idx: Int, k: Long): Boolean {
    if (idx == n - 1) {
        return true
    }
    visit[idx] = true
    for (next in idx + 1..<n) {
        if (!visit[next] && idx cal next <= k && isPossible(next, k)) {
            return true
        }
    }
    return false
}

infix fun Int.cal(x: Int) = (x - this) * (1 + abs(arr[x] - arr[this]))
