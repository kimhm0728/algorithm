var N = 0
var M = 0
lateinit var arr: Array<IntArray>

// 위, 오른쪽, 아래, 왼쪽
val dx = intArrayOf(-1, 0, 1, 0)
val dy = intArrayOf(0, 1, 0, -1)

val back = intArrayOf(2, 3, 0, 1)
val rotate = intArrayOf(3, 0, 1, 2)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    arr = Array(n) { IntArray(m) }
    var (x, y, d) = readLine().split(" ").map { it.toInt() }
    repeat(n) {
        arr[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    var answer = 0
    while (true) {
        if (arr[x][y] == 0) {
            arr[x][y] = 2
            answer++
        }
        if (checkNear(x, y)) {
            for (i in 0..3) {
                d = rotate[d]
                val nextX = x + dx[d]
                val nextY = y + dy[d]
                if (check(nextX, nextY) && arr[nextX][nextY] == 0) {
                    x = nextX
                    y = nextY
                    break
                }
            }
        } else {
            val nextX = x + dx[back[d]]
            val nextY = y + dy[back[d]]
            if (!check(nextX, nextY) || arr[nextX][nextY] == 1) {
                break
            } else {
                x = nextX
                y = nextY
            }
        }
    }
    print(answer)
}

fun checkNear(x: Int, y: Int): Boolean {
    repeat(4) {
        val nextX = x + dx[it]
        val nextY = y + dy[it]

        if (!check(nextX, nextY)) {
            return@repeat
        }
        if (arr[nextX][nextY] == 0) {
            return true
        }
    }
    return false
}

fun check(x: Int, y: Int) = x in 0..<N && y in 0..<M
