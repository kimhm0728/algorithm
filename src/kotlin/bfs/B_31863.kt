import java.util.*

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    n = N
    m = M
    val arr = Array(n) { readLine().toCharArray().map { Type(it) } }
    var startX = -1
    var startY = -1
    var count = 0
    for (i in 0..<n) {
        for (j in 0..<m) {
            if (arr[i][j].t == '@') {
                startX = i
                startY = j
            } else if (arr[i][j].t == '*' || arr[i][j].t == '#') {
                count++
            }
        }
    }
    val broken = bfs(arr, startX, startY)
    println("$broken ${count - broken}")
}

fun bfs(arr: Array<List<Type>>, startX: Int, startY: Int): Int {
    var count = 0
    val q = LinkedList<Quake>()
    repeat(4) { i ->
        repeat(2) { j ->
            val nextX = startX + dx[i] * if (j == 1) 2 else 1
            val nextY = startY + dy[i] * if (j == 1) 2 else 1

            if (!check(nextX, nextY)) {
                return@repeat
            }
            if (j == 1 && arr[startX + dx[i]][startY + dy[i]].t == '|') {
                return@repeat
            }
            if (arr[nextX][nextY].t == '*') {
                arr[nextX][nextY].isBroken = true
                q.offer(Quake(nextX, nextY, '*'))
                count++
            } else if (arr[nextX][nextY].t == '#') {
                arr[nextX][nextY].isAttacked = true
            }
        }
    }

    while (q.isNotEmpty()) {
        val now = q.poll()

        repeat(4) {
            val nextX = now.x + dx[it]
            val nextY = now.y + dy[it]

            if (!check(nextX, nextY)) {
                return@repeat
            }
            val next = arr[nextX][nextY]
            if (next.isBroken) {
                return@repeat
            }
            if (next.t == '*') {
                next.isBroken = true
                q.offer(Quake(nextX, nextY, '*'))
                count++
            } else if (next.t == '#') {
                if (next.isAttacked) {
                    next.isBroken = true
                    q.offer(Quake(nextX, nextY, '*'))
                    count++
                } else {
                    arr[nextX][nextY].isAttacked = true
                }
            }
        }
    }
    return count
}

fun check(x: Int, y: Int) = x in 0..<n && y in 0..<m

class Type(val t: Char, var isBroken: Boolean = false, var isAttacked: Boolean = false)

class Quake(val x: Int, val y: Int, val type: Char, val isAttacked: Boolean = false)
