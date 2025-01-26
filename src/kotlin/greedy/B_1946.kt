import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val n = readLine().toInt()
        val arr = Array(n) {
            val st = StringTokenizer(readLine())
            IntArray(2) { st.nextToken().toInt() }
        }
        arr.sortWith { o1, o2 -> o1[0] - o2[0] }
        var min = arr[0][1]
        var answer = 1
        for (i in 1..<n) {
            if (min > arr[i][1]) {
                min = arr[i][1]
                answer++
            }
        }
        sb.append(answer).append('\n')
    }
    print(sb)
}
