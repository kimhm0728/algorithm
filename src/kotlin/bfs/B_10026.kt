import java.util.*

var n = 0
lateinit var visit: Array<BooleanArray>
lateinit var arr: Array<CharArray>
var answer1 = 0
var answer2 = 0
val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = Array(n) { CharArray(n) }
    visit = Array(n) { BooleanArray(n) }
    repeat(n) { idx ->
        arr[idx] = readLine().toCharArray()
    }
    repeat(n) { i ->
        repeat(n) { j ->
            if (!visit[i][j]) {
                answer1++
                bfs(i, j, true) // 적록색약이 아닌 사람
            }
        }
    }

    visit = Array(n) { BooleanArray(n) }
    repeat(n) { i ->
        repeat(n) { j ->
            if (!visit[i][j]) {
                answer2++
                bfs(i, j, false) // 적록색약인 사람
            }
        }
    }
    println("$answer1 $answer2")
}

fun bfs(startX: Int, startY: Int, type: Boolean) {
    val q = LinkedList<Color>()
    q.offer(Color(startX, startY, arr[startX][startY]))
    visit[startX][startY] = true

    while (!q.isEmpty()) {
        val now = q.poll()

        repeat(4) {
            val nextX = now.x + dx[it]
            val nextY = now.y + dy[it]

            if (check(nextX, nextY) && !visit[nextX][nextY] && equalsColor(now.color, arr[nextX][nextY], type)) {
                visit[nextX][nextY] = true
                q.offer(Color(nextX, nextY, arr[nextX][nextY]))
            }
        }
    }
}

fun equalsColor(color1: Char, color2: Char, type: Boolean): Boolean {
    if (type) return color1 == color2
    return color1 == color2 || ((color1 == 'R' && color2 == 'G') || (color1 == 'G' && color2 == 'R'))
}

fun check(x: Int, y: Int): Boolean = x in 0..<n && y in 0..<n

class Color(val x: Int, val y: Int, val color: Char)
