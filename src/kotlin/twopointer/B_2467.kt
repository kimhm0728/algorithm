import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = LongArray(n) { st.nextToken().toLong() }
    var l = 0
    var r = n - 1
    var min = 5_000_000_000
    var idx1 = 0
    var idx2 = 0
    while (l < r) {
        val sum = arr[l] + arr[r]
        if (min > abs(sum)) {
            idx1 = l
            idx2 = r
            min = abs(sum)
        }
        if (sum > 0) {
            r--
        } else {
            l++
        }
    }
    print("${arr[idx1]} ${arr[idx2]}")
}
