import kotlin.math.abs
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val broken = BooleanArray(10)
    if (m > 0) {
        val arr = readLine().split(" ")
        arr.forEach {
            broken[it.toInt()] = true
        }
    }
    var answer = abs(100 - n)
    for (i in 0..1_000_000) {
        val str = i.toString()
        if (str.toCharArray().map { it - '0' }.any { broken[it] }) {
            continue
        }
        val count = str.length + abs(i - n)
        answer = min(count, answer)
    }
    print(answer)
}
