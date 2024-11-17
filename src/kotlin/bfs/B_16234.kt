import kotlin.math.abs

var N = 0
lateinit var arr: Array<IntArray>
lateinit var visit: Array<BooleanArray>
lateinit var range: IntRange
val moves = mutableListOf<MutableList<Move>>()

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, l, r) = readLine().split(" ").map { it.toInt() }
    N = n
    arr = Array(n) { IntArray(n) }
    range = l..r
    repeat(n) {
        arr[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    var count = 0
    var canMove: Boolean
    while (true) {
        canMove = false
        visit = Array(n) { BooleanArray(n) }
        moves.clear()

        repeat(n) { i ->
            repeat(n) { j ->
                if (visit[i][j]) {
                    return@repeat
                }

                val result = bfs(i, j)
                if (result.isNotEmpty()) {
                    canMove = true
                    moves.add(result)
                }
            }
        }

        if (!canMove) {
            break
        }

        moves.forEach { list ->
            val avg = list.map { arr[it.x][it.y] }.average().toInt()
            list.forEach { move ->
                arr[move.x][move.y] = avg
            }
        }
        count++
    }

    print(count)
}

fun bfs(x: Int, y: Int): MutableList<Move> {
    val list = mutableListOf<Move>()
    visit[x][y] = true
    list.add(Move(x, y))

    var pointer = 0
    while (pointer < list.size) {
        val now = list[pointer++]

        repeat(4) {
            val nextX = now.x + dx[it]
            val nextY = now.y + dy[it]

            if (!check(nextX, nextY) || visit[nextX][nextY] || abs(arr[now.x][now.y] - arr[nextX][nextY]) !in range) {
                return@repeat
            }

            visit[nextX][nextY] = true
            list.add(Move(nextX, nextY))
        }
    }

    if (list.size == 1) {
        return mutableListOf()
    }

    return list
}

fun check(x: Int, y: Int) = x in 0..<N && y in 0..<N

class Move(val x: Int, val y: Int)
