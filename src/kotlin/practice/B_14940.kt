package kotlin.practice

import java.util.LinkedList
import java.util.StringTokenizer

class Distance(val x: Int, val y: Int, val dis: Int)

class B_14940 {
    private var N = 0
    private var M = 0
    private lateinit var arr: Array<IntArray>
    private var startX = 0
    private var startY = 0

    fun solution() {
        init()
        val result = bfs()
        result.processResult()

        val sb = StringBuilder()
        for (i in 0 until N) {
            for (j in 0 until M) {
                sb.append(result[i][j]).append(' ')
            }
            sb.append('\n')
        }

        println(sb)
    }

    private fun init() = with(System.`in`.bufferedReader()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        N = n
        M = m
        arr = Array(n) { IntArray(m) }

        var st: StringTokenizer
        for (i in 0 until N) {
            st = StringTokenizer(readLine())
            for (j in 0 until M) {
                arr[i][j] = st.nextToken().toInt()
                if (arr[i][j] == 2) {
                    startX = i
                    startY = j
                }
            }
        }
    }

    private fun bfs(): Array<IntArray> {
        val dx = intArrayOf(1, -1, 0, 0)
        val dy = intArrayOf(0, 0, -1, 1)

        val visit = Array(N) { BooleanArray(M) }
        val result = Array(N) { IntArray(M) }
        val q = LinkedList<Distance>()

        q.offer(Distance(startX, startY, 0))
        visit[startX][startY] = true

        while (q.isNotEmpty()) {
            val now = q.poll()

            for (i in 0 until 4) {
                val nextX = now.x + dx[i]
                val nextY = now.y + dy[i]

                if (check(nextX, nextY) || visit[nextX][nextY] || arr[nextX][nextY] == 0) {
                    continue
                }

                result[nextX][nextY] = now.dis + 1
                visit[nextX][nextY] = true
                q.offer(Distance(nextX, nextY, now.dis + 1))
            }
        }

        return result
    }

    private fun check(x: Int, y: Int) =
        x >= N || x < 0 || y >= M || y < 0

    private fun Array<IntArray>.processResult() {
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (this[i][j] != 0) continue

                if (arr[i][j] == 1) {
                    this[i][j] = -1
                }
            }
        }
    }
}

fun main() {
    B_14940().solution()
}