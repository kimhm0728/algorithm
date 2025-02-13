import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var sum = 0
    val arr = Array(n) { IntArray(2) }
    repeat(n) {
        val st = StringTokenizer(readLine())
        arr[it][0] = st.nextToken().toInt()
        arr[it][1] = st.nextToken().toInt()
    }
    arr.sortBy { it[0] }

    var start = arr[0][0]
    var end = arr[0][1]
    for (i in 1..<n) {
        val (x, y) = arr[i]
        if (end >= y) {
            continue
        }
        if (end >= x && end < y) {
            end = y
            continue
        }
        sum += end - start
        start = x
        end = y
    }
    sum += end - start
    print(sum)
}
