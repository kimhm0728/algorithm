import kotlin.math.ceil

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray().sorted()
    var answer = 0
    for (i in ceil(n / 2.0).toInt()..<n) {
        answer += 2 * arr[i]
    }
    if (n % 2 == 1) {
        answer += arr[n / 2]
    }
    print(answer)
}
