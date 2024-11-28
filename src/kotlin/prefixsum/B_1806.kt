import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, s) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    var l = 0
    var r = 0
    var sum = 0L
    var answer = 100_001
    while (true) {
        if (sum < s) {
            if (r >= n) break
            sum += arr[r++]
        } else {
            answer = min(answer, r - l)
            sum -= arr[l++]
        }
    }
    print(if (answer == 100_001) 0 else answer)
}
