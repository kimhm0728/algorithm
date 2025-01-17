import java.util.*
import kotlin.math.ceil

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { LongArray(2) }
    var sum = 0L
    repeat(n) {
        val st = StringTokenizer(readLine())
        arr[it][0] = st.nextToken().toLong()
        arr[it][1] = st.nextToken().toLong()
        sum += arr[it][1]
    }
    arr.sortWith { o1, o2 -> o1[0].compareTo(o2[0]) }
    val mid = ceil(sum / 2.0)
    var temp = 0L
    repeat(n) {
        temp += arr[it][1]
        if (temp >= mid) {
            print(arr[it][0])
            return
        }
    }
}
