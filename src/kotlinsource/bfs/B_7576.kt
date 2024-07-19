import java.util.LinkedList
import kotlin.math.max

var N = 0
var M = 0

lateinit var arr: Array<IntArray>
lateinit var visit: Array<IntArray>
val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    M = m
    N = n
    arr = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    visit = Array(n) { IntArray(m) { -1 } }
    bfs()

    var answer = 0
    (0..<N).forEach { i ->
        (0..<M).forEach { j ->
            if (visit[i][j] == -1) {
                println(-1)
                return
            }
            answer = max(answer, visit[i][j])
        }
    }
    println(answer)
}

fun bfs() {
    val q = LinkedList<Triple<Int, Int, Int>>()
    (0..<N).forEach { i ->
        (0..<M).forEach { j ->
            if (arr[i][j] == 1) {
                q.offer(Triple(i, j, 0))
                visit[i][j] = 0
            } else if (arr[i][j] == -1) {
                visit[i][j] = 0
            }
        }
    }

    while (!q.isEmpty()) {
        val now = q.poll()
        (0..<4).forEach {
            val nextX = now.first + dx[it]
            val nextY = now.second + dy[it]
            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || visit[nextX][nextY] != -1 || arr[nextX][nextY] != 0) {
                return@forEach
            }

            visit[nextX][nextY] = now.third + 1
            q.offer(Triple(nextX, nextY, now.third + 1))
        }
    }
}
