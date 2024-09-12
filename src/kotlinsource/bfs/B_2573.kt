import java.util.LinkedList
import kotlin.math.max

var N = 0
var M = 0
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
lateinit var arr: Array<IntArray>
lateinit var tempArr: Array<IntArray>

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    arr = Array(n) { IntArray(m) }
    repeat(n) { i ->
        arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    var years = 0
    do {
        tempArr = Array(n) { IntArray(m) }
        ++years
        for (i in 0..<n) {
            for (j in 0..<m) {
                if (arr[i][j] != 0) {
                    var count = 0
                    repeat(4) { idx ->
                        val nextX = i + dx[idx]
                        val nextY = j + dy[idx]

                        if (check(nextX, nextY) && arr[nextX][nextY] == 0) {
                            count++
                        }
                    }
                    tempArr[i][j] = max(arr[i][j] - count, 0)
                }
            }
        }
        for (i in 0..<n) {
            arr[i] = tempArr[i].clone()
        }
        if (isNoIce()) {
            println(0)
            return
        }
    } while (!isSeparateIce())
    println(years)
}

class Ice(val x: Int, val y: Int)

fun check(x: Int, y: Int): Boolean = x in 0..<N && y in 0..<M

fun isNoIce(): Boolean {
    for (i in 0..<N) {
        for (j in 0..<M) {
            if (arr[i][j] != 0) {
                return false
            }
        }
    }
    return true
}

fun isSeparateIce(): Boolean {
    var startX = 0
    var startY = 0
    loop@ for (i in 0..<N) {
        for (j in 0..<M) {
            if (arr[i][j] != 0) {
                startX = i
                startY = j
                break@loop
            }
        }
    }

    val visit = Array(N) { BooleanArray(M) { false } }
    bfs(visit, startX, startY)
    for (i in 0..<N) {
        for (j in 0..<M) {
            if (arr[i][j] != 0 && !visit[i][j]) {
                return true
            }
        }
    }
    return false
}

fun bfs(visit: Array<BooleanArray>, startX: Int, startY: Int) {
    val q = LinkedList<Ice>()
    q.offer(Ice(startX, startY))
    visit[startX][startY] = true

    while (!q.isEmpty()) {
        val now = q.poll()

        repeat(4) { i ->
            val nextX = now.x + dx[i]
            val nextY = now.y + dy[i]

            if (check(nextX, nextY) && !visit[nextX][nextY] && arr[nextX][nextY] != 0) {
                visit[nextX][nextY] = true
                q.offer(Ice(nextX, nextY))
            }
        }
    }
}
