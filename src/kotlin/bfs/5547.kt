import java.util.*

var N = 0
var M = 0
lateinit var arr: Array<IntArray>
lateinit var visit: Array<BooleanArray>

// x가 짝수일 때
val dx1 = intArrayOf(-1, -1, 0, 1, 1, 0)
val dy1 = intArrayOf(0, 1, 1, 1, 0, -1)

// x가 홀수일 때
val dx2 = intArrayOf(-1, -1, 0, 1, 1, 0)
val dy2 = intArrayOf(-1, 0, 1, 0, -1, -1)

var answer = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    arr = Array(n) { IntArray(m) }
    visit = Array(n) { BooleanArray(m) }

    repeat(n) {
        arr[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (i in 0..<m) {
        if (arr[0][i] == 0 && !visit[0][i]) {
            bfs1(0, i)
        }
        if (arr[n - 1][i] == 0 && !visit[n - 1][i]) {
            bfs1(n - 1, i)
        }
    }

    for (i in 1..<n - 1) {
        if (arr[i][0] == 0 && !visit[i][0]) {
            bfs1(i, 0)
        }
        if (arr[i][m - 1] == 0 && !visit[i][m - 1]) {
            bfs1(i, m - 1)
        }
    }

    repeat(n) { i ->
        repeat(m) { j ->
            if (arr[i][j] == 1 && !visit[i][j]) {
                bfs2(i, j)
            }
        }
    }

    print(answer)
}

fun bfs1(x: Int, y: Int) {
    val q = LinkedList<Light>()
    q.offer(Light(x, y))
    visit[x][y] = true

    while (q.isNotEmpty()) {
        val now = q.poll()

        repeat(6) {
            val nextX = now.x + if (now.x % 2 == 0) dx1[it] else dx2[it]
            val nextY = now.y + if (now.x % 2 == 0) dy1[it] else dy2[it]

            if (!check(nextX, nextY) || arr[nextX][nextY] == 1 || visit[nextX][nextY]) {
                return@repeat
            }
            visit[nextX][nextY] = true
            q.offer(Light(nextX, nextY))
        }
    }
}

fun bfs2(x: Int, y: Int) {
    val q = LinkedList<Light>()
    q.offer(Light(x, y))
    visit[x][y] = true

    while (q.isNotEmpty()) {
        val now = q.poll()

        repeat(6) {
            val nextX = now.x + if (now.x % 2 == 0) dx1[it] else dx2[it]
            val nextY = now.y + if (now.x % 2 == 0) dy1[it] else dy2[it]

            if (!check(nextX, nextY)) {
                answer++
                return@repeat
            }
            if (arr[nextX][nextY] == 0) {
                if (visit[nextX][nextY]) {
                    answer++
                }
                return@repeat
            }
            if (visit[nextX][nextY]) {
                return@repeat
            }
            visit[nextX][nextY] = true
            q.offer(Light(nextX, nextY))
        }
    }
}

fun check(x: Int, y: Int) = x in 0..<N && y in 0..<M

class Light(val x: Int, val y: Int)
