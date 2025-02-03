import java.util.*

lateinit var arr: Array<IntArray>
lateinit var visit: Array<IntArray>

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
var N = 0
var M = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    M = m
    N = n
    arr = Array(n) { readLine().toCharArray().map { it - '0' }.toIntArray() }
    visit = Array(n) { IntArray(m) { 10_001 } }
    dijkstra(0, 0)
    print(visit[n - 1][m - 1])
}

fun dijkstra(x: Int, y: Int) {
    val pq = PriorityQueue<Pos> { o1, o2 -> o1.count - o2.count }
    pq.offer(Pos(x, y, 0))
    visit[x][y] = 0

    while (pq.isNotEmpty()) {
        val now = pq.poll()

        repeat(4) {
            val nextX = now.x + dx[it]
            val nextY = now.y + dy[it]

            if (!check(nextX, nextY)) {
                return@repeat
            }

            val nextCount = if (arr[nextX][nextY] == 1) now.count + 1 else now.count
            if (nextCount >= visit[nextX][nextY]) {
                return@repeat
            }
            visit[nextX][nextY] = nextCount
            pq.offer(Pos(nextX, nextY, nextCount))
        }
    }
}

class Pos(val x: Int, val y: Int, val count: Int)

fun check(x: Int, y: Int) = x in 0..<N && y in 0..<M
