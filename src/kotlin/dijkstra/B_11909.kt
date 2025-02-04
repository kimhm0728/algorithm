import java.util.*

var N = 0
lateinit var arr: Array<IntArray>
lateinit var visit: Array<IntArray>

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    N = n
    arr = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    visit = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    dijkstra()
    print(visit[n - 1][n - 1])
}

fun dijkstra() {
    val pq = PriorityQueue<Pos> { o1, o2 -> o1.count - o2.count }
    pq.offer(Pos(0, 0, 0))
    visit[0][0] = 0

    while (pq.isNotEmpty()) {
        val now = pq.poll()

        if (now.x == N - 1 && now.y == N - 1) {
            continue
        }

        var nextX = 0
        var nextY = 0
        repeat(2) {
            when (it) {
                0 -> {
                    if (now.x == N - 1) {
                        return@repeat
                    }
                    nextX = now.x + 1
                    nextY = now.y
                }

                1 -> {
                    if (now.y == N - 1) {
                        return@repeat
                    }
                    nextX = now.x
                    nextY = now.y + 1
                }
            }
            if (nextX !in 0..<N || nextY !in 0..<N) {
                return@repeat
            }
            val nextCount =
                if (arr[nextX][nextY] < arr[now.x][now.y]) now.count else now.count + (arr[nextX][nextY] - arr[now.x][now.y] + 1)
            if (visit[nextX][nextY] > nextCount) {
                pq.offer(Pos(nextX, nextY, nextCount))
                visit[nextX][nextY] = nextCount
            }
        }
    }
}

class Pos(val x: Int, val y: Int, val count: Int)
