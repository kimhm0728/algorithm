import java.util.*
import kotlin.math.min

var n = 0
lateinit var arr: Array<IntArray>
lateinit var visit: Array<BooleanArray>
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
var answer = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = Array(n) { IntArray(n) { 0 } }
    visit = Array(n) { BooleanArray(n) { false } }

    val inputArr = Array(n) { IntArray(n) { 0 } }
    repeat(n) { i ->
        inputArr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    var islandNumber = 1
    repeat(n) { i ->
        repeat(n) { j ->
            if (inputArr[i][j] == 1 && !visit[i][j]) {
                checkIsland(islandNumber++, inputArr, i, j)
            }
        }
    }

    repeat(n) { i ->
        repeat(n) { j ->
            visit = Array(n) { BooleanArray(n) { false } }
            if (arr[i][j] != 0) {
                bfs(i, j)
            }
        }
    }

    println(answer)
}

fun checkIsland(islandNumber: Int, inputArr: Array<IntArray>, startX: Int, startY: Int) {
    val q = LinkedList<Island>()
    q.offer(Island(startX, startY))
    visit[startX][startY] = true
    arr[startX][startY] = islandNumber

    while (!q.isEmpty()) {
        val now = q.poll()

        repeat(4) {
            val nextX = now.x + dx[it]
            val nextY = now.y + dy[it]

            if (check(nextX, nextY) && !visit[nextX][nextY] && inputArr[nextX][nextY] == 1) {
                arr[nextX][nextY] = islandNumber
                visit[nextX][nextY] = true
                q.offer(Island(nextX, nextY))
            }
        }
    }
}

fun check(x: Int, y: Int) = x in 0..<n && y in 0..<n

class Island(val x: Int, val y: Int, val distance: Int = 0)

fun bfs(startX: Int, startY: Int) {
    val q = LinkedList<Island>()
    q.offer(Island(startX, startY))
    visit[startX][startY] = true
    val islandNumber = arr[startX][startY]

    while (!q.isEmpty()) {
        val now = q.poll()

        if (arr[now.x][now.y] != 0 && arr[now.x][now.y] != islandNumber) {
            answer = min(answer, now.distance - 1)
            return
        }

        repeat(4) {
            val nextX = now.x + dx[it]
            val nextY = now.y + dy[it]

            if (check(nextX, nextY) && !visit[nextX][nextY] && arr[nextX][nextY] != islandNumber) {
                visit[nextX][nextY] = true
                q.offer(Island(nextX, nextY, now.distance + 1))
            }
        }
    }
}
