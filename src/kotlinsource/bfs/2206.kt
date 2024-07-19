import java.util.LinkedList

var N = 0
var M = 0
lateinit var arr: Array<BooleanArray> // 벽이면 true 아니면 false
lateinit var visit: Array<Array<BooleanArray>>
var answer = -1
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    arr = Array(n) { BooleanArray(m) }
    visit = Array(2) { Array(n) { BooleanArray(m) { false } } }
    repeat(n) {
        arr[it] = readLine().chars().toArray().map { it.toChar() == '1' }.toBooleanArray()
    }
    bfs(0, 0)
    println(answer)
}

fun bfs(startX: Int, startY: Int) {
    val q = LinkedList<Wall>()
    q.offer(Wall(startX, startY, false, 1))
    visit[0][startX][startY] = true

    while (!q.isEmpty()) {
        val now = q.poll()

        if (now.x == N - 1 && now.y == M - 1) {
            answer = now.path
            return
        }

        (0..<4).forEach {
            val nextX = now.x + dx[it]
            val nextY = now.y + dy[it]

            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                return@forEach
            }
            if (arr[nextX][nextY]) {
                if (now.isBroken || visit[1][nextX][nextY]) {
                    return@forEach
                }
                q.offer(Wall(nextX, nextY, true, now.path + 1))
                visit[1][nextX][nextY] = true
            } else {
                if (visit[if (now.isBroken) 1 else 0][nextX][nextY]) {
                    return@forEach
                }
                q.offer(Wall(nextX, nextY, now.isBroken, now.path + 1))
                visit[if (now.isBroken) 1 else 0][nextX][nextY] = true
            }
        }
    }
}

class Wall(val x: Int, val y: Int, val isBroken: Boolean, val path: Int)
