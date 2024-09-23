import java.util.LinkedList
import kotlin.math.min

var K = 0
var N = 0
var M = 0
lateinit var arr: Array<IntArray>
lateinit var visit: Array<Array<IntArray>>
const val max = Int.MAX_VALUE
var answer = max
val horseX = intArrayOf(-1, -2, -2, -1, 1, 2, 2, 1)
val horseY = intArrayOf(-2, -1, 1, 2, -2, -1, 1, 2)
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    K = readLine().toInt()
    val (m, n) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    arr = Array(N) { IntArray(M) }
    visit = Array(N) { Array(M) { IntArray(K + 1) { max } } }

    repeat(N) {
        arr[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    bfs(0, 0)
    println(if (answer == max) -1 else answer)
}

fun bfs(startX: Int, startY: Int) {
    val q = LinkedList<Monkey>()
    q.offer(Monkey(startX, startY, 0, K))
    visit[startX][startY][K] = 0

    while (!q.isEmpty()) {
        val now = q.poll()

        if (now.x == N - 1 && now.y == M - 1) {
            answer = min(answer, now.distance)
            break
        }

        if (now.k > 0) {
            repeat(8) {
                val nextX = now.x + horseX[it]
                val nextY = now.y + horseY[it]

                if (!check(nextX, nextY)) return@repeat
                if (arr[nextX][nextY] == 1) return@repeat
                if (visit[nextX][nextY][now.k - 1] <= now.distance + 1) return@repeat
                visit[nextX][nextY][now.k - 1] = now.distance + 1
                q.offer(Monkey(nextX, nextY, now.distance + 1, now.k - 1))
            }
        }
        repeat(4) {
            val nextX = now.x + dx[it]
            val nextY = now.y + dy[it]

            if (!check(nextX, nextY)) return@repeat
            if (arr[nextX][nextY] == 1) return@repeat
            if (visit[nextX][nextY][now.k] <= now.distance + 1) return@repeat
            visit[nextX][nextY][now.k] = now.distance + 1
            q.offer(Monkey(nextX, nextY, now.distance + 1, now.k))
        }
    }
}

class Monkey(val x: Int, val y: Int, val distance: Int, val k: Int)

fun check(x: Int, y: Int) = x in 0..<N && y in 0..<M
