import java.util.*
import kotlin.math.max

lateinit var arr: Array<CharArray>
lateinit var visit: Array<BooleanArray>
var N = 0
var M = 0
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    arr = Array(n) { readLine().toCharArray() }
    var answer = 0
    for (i in 0..<n) {
        for (j in 0..<m) {
            if (arr[i][j] == 'W') {
                continue
            }
            visit = Array(n) { BooleanArray(m) }
            answer = max(answer, bfs(i, j))
        }
    }
    print(answer)
}

fun bfs(x: Int, y: Int): Int {
    val q = LinkedList<Pos>()
    q.offer(Pos(x, y, 0))
    var max = 0
    visit[x][y] = true

    while (q.isNotEmpty()) {
        val now = q.poll()
        max = max(max, now.count)

        repeat(4) {
            val nextX = now.x + dx[it]
            val nextY = now.y + dy[it]

            if (nextX !in 0..<N || nextY !in 0..<M || visit[nextX][nextY] || arr[nextX][nextY] == 'W') {
                return@repeat
            }
            visit[nextX][nextY] = true
            q.offer(Pos(nextX, nextY, now.count + 1))
        }
    }
    return max
}

class Pos(val x: Int, val y: Int, val count: Int)
