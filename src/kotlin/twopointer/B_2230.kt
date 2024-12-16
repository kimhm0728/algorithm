import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(n)
    repeat(n) {
        arr[it] = readLine().toInt()
    }
    arr.sort()
    var l = 0
    var r = 0
    var answer = Integer.MAX_VALUE
    while (r in l..<n) {
        if (arr[r] - arr[l] < m) {
            r++
        } else {
            answer = min(answer, arr[r] - arr[l])
            l++
        }
    }
    print(answer)
}
