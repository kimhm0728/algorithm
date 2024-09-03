import java.util.LinkedList

var n: Int = 0
lateinit var arr: Array<IntArray>
lateinit var visit: Array<BooleanArray>
val answer = mutableListOf<Int>()

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = Array(n) { IntArray(n) }
    visit = Array(n) { BooleanArray(n) { false } }
    (0..<n).forEach { idx ->
        arr[idx] = readLine().toCharArray().map { it.code - '0'.code }.toIntArray()
    }

    (0..<n).forEach { i ->
        (0..<n).forEach { j ->
            if (!visit[i][j] && arr[i][j] == 1) {
                bfs(i, j)
            }
        }
    }

    val sb = StringBuilder()
    val sorted = answer.sorted()
    sb.append(sorted.size).append('\n')
    sorted.forEach { sb.append(it).append('\n') }
    println(sb)
}

fun bfs(startX: Int, startY: Int) {
    val q = LinkedList<House>()
    visit[startX][startY] = true
    q.offer(House(startX, startY))

    var count = 1
    while (!q.isEmpty()) {
        val now = q.poll()
        (0..3).forEach { i ->
            val nextX = now.x + dx[i]
            val nextY = now.y + dy[i]

            if (check(nextX, nextY) && arr[nextX][nextY] == 1 && !visit[nextX][nextY]) {
                visit[nextX][nextY] = true
                count++
                q.offer(House(nextX, nextY))
            }
        }
    }
    answer.add(count)
}

class House(val x: Int, val y: Int)

fun check(x: Int, y: Int): Boolean {
    return x in 0..<n && y in 0..<n
}
