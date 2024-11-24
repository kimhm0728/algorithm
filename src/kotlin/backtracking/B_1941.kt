import java.util.*

val arr = Array(5) { CharArray(5) }
val visit1 = Array(5) { BooleanArray(5) }

val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

var answer = 0

fun main() = with(System.`in`.bufferedReader()) {
    repeat(5) {
        arr[it] = readLine().toCharArray()
    }
    dfs(0, 0)
    print(answer)
}

fun dfs(idx: Int, depth: Int) {
    if (depth == 7) {
        if (bfs()) {
            answer++
        }
        return
    }

    for (i in idx..<25) {
        val x = i / 5
        val y = i % 5
        if (!check(x, y)) {
            continue
        }
        visit1[x][y] = true
        dfs(i + 1, depth + 1)
        visit1[x][y] = false
    }
}

fun check(x: Int, y: Int) = x in 0..<5 && y in 0..<5

fun bfs(): Boolean {
    val (startX, startY) = search()
    val visit2 = Array(5) { BooleanArray(5) }
    visit2[startX][startY] = true
    val q = LinkedList<Princess>()
    q.offer(Princess(startX, startY, arr[startX][startY]))

    var count = 0
    var s = 0
    var y = 0
    while (q.isNotEmpty()) {
        val now = q.poll()
        count++
        if (now.group == 'S') s++ else y++

        repeat(4) {
            val nextX = now.x + dx[it]
            val nextY = now.y + dy[it]

            if (!check(nextX, nextY) || !visit1[nextX][nextY] || visit2[nextX][nextY]) {
                return@repeat
            }

            visit2[nextX][nextY] = true
            q.offer(Princess(nextX, nextY, arr[nextX][nextY]))
        }
    }
    return count == 7 && s >= 4
}

class Princess(val x: Int, val y: Int, val group: Char)

fun search(): Pair<Int, Int> {
    for (i in 0..<5) {
        for (j in 0..<5) {
            if (visit1[i][j]) {
                return i to j
            }
        }
    }
    return 0 to 0
}
