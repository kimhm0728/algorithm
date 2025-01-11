import java.util.*

lateinit var arr: Array<IntArray>
lateinit var visit: Array<Array<BooleanArray>>
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val (n, m, t) = List(3) { st.nextToken().toInt() }
    arr = Array(n) { IntArray(m) }
    visit = Array(2) { Array(n) { BooleanArray(m) } }
    repeat(n) {
        st = StringTokenizer(readLine())
        arr[it] = IntArray(m) { st.nextToken().toInt() }
    }
    print(bfs(t))
}

fun bfs(t: Int): String {
    val q = LinkedList<Pos>()
    visit[0][0][0] = true
    q.offer(Pos(0, 0, false, 0))

    while (q.isNotEmpty()) {
        val now = q.poll()
        if (now.x == arr.size - 1 && now.y == arr[0].size - 1) {
            return now.time.toString()
        }

        repeat(4) {
            val nextX = now.x + dx[it]
            val nextY = now.y + dy[it]

            if (!check(nextX, nextY)) {
                return@repeat
            }
            val hasKnife = now.hasKnife || arr[nextX][nextY] == 2
            val hasKnifeIdx = if (hasKnife) 1 else 0
            if (!hasKnife && arr[nextX][nextY] == 1) {
                return@repeat
            }
            if (now.time + 1 <= t && !visit[hasKnifeIdx][nextX][nextY]) {
                visit[hasKnifeIdx][nextX][nextY] = true
                q.offer(Pos(nextX, nextY, hasKnife, now.time + 1))
            }
        }
    }

    return "Fail"
}

fun check(x: Int, y: Int): Boolean {
    return x in arr.indices && y in arr[0].indices
}

class Pos(val x: Int, val y: Int, val hasKnife: Boolean, val time: Int)
