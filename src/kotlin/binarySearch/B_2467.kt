import java.util.*
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.min

val max = 5_000_000_000
lateinit var arr: LongArray
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    val st = StringTokenizer(readLine())
    arr = LongArray(n) { st.nextToken().toLong() }

    var min = max
    var answer1 = 0L
    var answer2 = 0L
    for (i in 0..<n) {
        val x = binarySearch(-arr[i], i + 1)
        if (min > abs(x + arr[i])) {
            min = abs(x + arr[i])
            answer1 = min(x, arr[i])
            answer2 = max(x, arr[i])
            if (min == 0L) {
                break
            }
        }
    }
    print("$answer1 $answer2")
}

fun binarySearch(x: Long, startIdx: Int): Long {
    var answer = max
    var l = startIdx
    var e = n - 1
    while (l <= e) {
        val mid = (l + e) / 2
        if (arr[mid] == x) {
            return x
        }
        if (abs(x - answer) > abs(x - arr[mid])) {
            answer = arr[mid]
        }
        if (arr[mid] < x) {
            l = mid + 1
        } else {
            e = mid - 1
        }
    }
    return answer
}
