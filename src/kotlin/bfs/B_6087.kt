import java.util.*

lateinit var arr: Array<CharArray>
lateinit var visit: Array<Array<IntArray>>
val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
var N = 0
var M = 0
var answer = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    arr = Array(n) { readLine().toCharArray() }
    visit = Array(n) { Array(m) { IntArray(4) { Int.MAX_VALUE } } }
    var x1 = -1
    var y1 = -1
    var x2 = -1
    var y2 = -1
    repeat(n) { i ->
        repeat(m) { j ->
            if (arr[i][j] == 'C') {
                if (x1 == -1) {
                    x1 = i
                    y1 = j
                } else {
                    x2 = i
                    y2 = j
                }
            }
        }
    }
    bfs(x1, y1, x2, y2)
    print(answer)
}

fun bfs(startX: Int, startY: Int, endX: Int, endY: Int) {
    val q = LinkedList<Mirror>()
    repeat(4) {
        visit[startX][startY][it] = 0
        val x = startX + dx[it]
        val y = startY + dy[it]
        if (!check(x, y) || arr[x][y] == '*') {
            return@repeat
        }
        q.offer(Mirror(x, y, it, 0))
        visit[x][y][it] = 0
    }

    while (q.isNotEmpty()) {
        val now = q.poll()

        if (now.x == endX && now.y == endY) {
            if (now.count < answer) {
                answer = now.count
            }
            continue
        }
        repeat(4) {
            val nextX = now.x + dx[it]
            val nextY = now.y + dy[it]

            if (!check(nextX, nextY) || arr[nextX][nextY] == '*') {
                return@repeat
            }

            val nextCount = if (it == now.dir) now.count else now.count + 1
            if (visit[nextX][nextY][it] > nextCount) {
                visit[nextX][nextY][it] = nextCount
                q.offer(Mirror(nextX, nextY, it, nextCount))
            }
        }
    }
}

fun check(x: Int, y: Int) = x in 0..<N && y in 0..<M

class Mirror(val x: Int, val y: Int, val dir: Int, val count: Int)
