package kotlinsource

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n: Int
    val m: Int

    readLine().split(" ").run {
        n = this[0].toInt()
        m = this[1].toInt()
    }

    val arr = Array(n) { IntArray(m) }
    val viruses = mutableListOf<IntArray>()

    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        for (j in 0 until m) {
            arr[i][j] = st.nextToken().toInt()
            if (arr[i][j] == 2) {
                viruses.add(intArrayOf(i, j))
            }
        }
    }

    var answer = 0

    fun check(x: Int, y: Int) = x < 0 || x >= n || y < 0 || y >= m

    fun calculateArea(visit: Array<BooleanArray>): Int {
        var area = 0

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (arr[i][j] == 0 && !visit[i][j]) area++
            }
        }

        return area
    }

    fun bfs() {
        val dx = intArrayOf(-1, 1, 0, 0)
        val dy = intArrayOf(0, 0, -1, 1)

        val visit = Array(n) { BooleanArray(m) }
        val q = LinkedList<IntArray>()

        q.addAll(viruses)

        while (!q.isEmpty()) {
            val now = q.poll()

            for (i in 0..3) {
                val nextX = now[0] + dx[i]
                val nextY = now[1] + dy[i]

                if (check(nextX, nextY) || arr[nextX][nextY] != 0 || visit[nextX][nextY]) {
                    continue
                }

                visit[nextX][nextY] = true
                q.offer(intArrayOf(nextX, nextY))
            }
        }

        val area = calculateArea(visit)
        answer = if (answer < area) area else answer
    }

    fun dfs(startIdx: Int, depth: Int, size: Int) {
        if (depth == size) {
            bfs()
            return
        }

        if (startIdx >= n * m) return

        for (idx in startIdx until n * m) {
            val i = idx / m
            val j = idx % m

            if (arr[i][j] != 0) continue

            arr[i][j] = 1
            dfs(idx + 1, depth + 1, size)
            arr[i][j] = 0
        }
    }

    dfs(0, 0, 3)
    print(answer)
}