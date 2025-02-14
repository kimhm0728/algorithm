import java.util.*

val arr = Array(4) { Array(5) { Array(5) { IntArray(5) } } }
val order = Array(5) { Order(0, 0) }
val visit = BooleanArray(5)
var answer = Int.MAX_VALUE

class Order(val idx: Int, val rotate: Int)

val dx = intArrayOf(-1, 1, 0, 0, 0, 0)
val dy = intArrayOf(0, 0, -1, 1, 0, 0)
val dz = intArrayOf(0, 0, 0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    repeat(5) { i ->
        repeat(5) { j ->
            arr[0][i][j] = readLine().split(" ").map { it.toInt() }.toIntArray()
        }
    }
    repeat(3) { i -> // 회전 횟수
        repeat(5) { j ->// 판
            arr[i + 1][j] = rotate(arr[i][j])
        }
    }
    dfs(0)
    print(if (answer == Int.MAX_VALUE) -1 else answer)
}

fun rotate(arr: Array<IntArray>): Array<IntArray> {
    val new = Array(5) { IntArray(5) }
    repeat(5) { i ->
        repeat(5) { j ->
            new[j][4 - i] = arr[i][j]
        }
    }
    return new
}

fun dfs(depth: Int) {
    if (depth == 5) {
        val result = bfs()
        if (result < answer) {
            answer = result
        }
    }

    repeat(5) { i ->
        if (visit[i]) {
            return@repeat
        }
        repeat(4) { j ->
            visit[i] = true
            order[depth] = Order(i, j)
            dfs(depth + 1)
            visit[i] = false
        }
    }
}

fun bfs(): Int {
    val a = Array(5) { Array(5) { IntArray(5) } }
    repeat(5) {
        a[it] = arr[order[it].rotate][order[it].idx]
    }
    if (a[0][0][0] == 0 || a[4][4][4] == 0) {
        return Int.MAX_VALUE
    }
    val visit = Array(5) { Array(5) { BooleanArray(5) } }
    visit[0][0][0] = true
    val q = LinkedList<Maze>()
    q.offer(Maze(0, 0, 0, 0))

    while (q.isNotEmpty()) {
        val now = q.poll()

        if (now.x == 4 && now.y == 4 && now.z == 4) {
            return now.count
        }

        repeat(6) {
            val nextX = now.x + dx[it]
            val nextY = now.y + dy[it]
            val nextZ = now.z + dz[it]

            if (!check(nextX, nextY, nextZ) || visit[nextX][nextY][nextZ] || a[nextX][nextY][nextZ] == 0) {
                return@repeat
            }
            visit[nextX][nextY][nextZ] = true
            q.offer(Maze(nextX, nextY, nextZ, now.count + 1))
        }
    }

    return Int.MAX_VALUE
}

class Maze(val x: Int, val y: Int, val z: Int, val count: Int)

fun check(x: Int, y: Int, z: Int) = x in 0..4 && y in 0..4 && z in 0..4
