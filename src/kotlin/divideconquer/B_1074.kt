import kotlin.math.pow

var answer = 0
var R = 0
var C = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (n, r, c) = readLine().split(" ").map { it.toInt() }
    R = r
    C = c
    val size = 2.0.pow(n).toInt()
    solution(0, 0, 0, size)
    print(answer)
}

fun solution(x: Int, y: Int, count: Int, size: Int) {
    if (x == R && y == C) {
        answer = count
        return
    }

    val nextSize = size / 2
    val nextCount = nextSize * nextSize
    if (R in x..<x + nextSize && C in y..<y + nextSize) {
        solution(x, y, count, nextSize)
        return
    }
    if (R in x..<x + nextSize && C in y + nextSize..<y + 2 * nextSize) {
        solution(x, y + nextSize, count + nextCount, nextSize)
        return
    }
    if (R in x + nextSize..<x + 2 * nextSize && C in y..<y + nextSize) {
        solution(x + nextSize, y, count + 2 * nextCount, nextSize)
        return
    }
    if (R in x + nextSize..<x + 2 * nextSize && C in y + nextSize..<y + 2 * nextSize) {
        solution(x + nextSize, y + nextSize, count + 3 * nextCount, nextSize)
        return
    }
}
