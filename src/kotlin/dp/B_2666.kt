import kotlin.math.abs
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val (a, b) = readLine().split(" ").map { it.toInt() - 1 }
    val m = readLine().toInt()
    val used = IntArray(m) { readLine().toInt() - 1 }

    print(solution(a, b, used, 0))
}

fun solution(a: Int, b: Int, used: IntArray, depth: Int): Int {
    if (depth == used.size) {
        return 0
    }
    val idx = used[depth]
    val diffA = abs(a - idx)
    val diffB = abs(b - idx)
    return min(solution(idx, b, used, depth + 1) + diffA, solution(a, idx, used, depth + 1) + diffB)
}
