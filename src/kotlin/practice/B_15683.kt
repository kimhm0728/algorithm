package kotlin.practice

import java.util.*

private class Cctv(val r: Int, val c: Int, val list: List<IntArray>) {
    val n = list.size
}

private class B_15683 {
    private var n = 0
    private var m = 0
    private var cctvSize = 0
    private lateinit var arr: Array<IntArray>
    private lateinit var loc: IntArray
    private val list = mutableListOf<Cctv>()

    private val dx = intArrayOf(1, 0, -1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)
    private val cctvs = arrayOf(intArrayOf(1), intArrayOf(1, 3), intArrayOf(0, 1), intArrayOf(0, 1, 3), intArrayOf(0, 1, 2, 3))
    private val rotateCctv = mutableMapOf<Int, List<IntArray>>()
    private var max = 0

    init {
        for (idx in 0..4) {
            val list = mutableListOf(cctvs[idx].clone())

            if (idx == 4) {
                rotateCctv[idx + 1] = list
                continue
            }

            for (i in 0..2) {
                val size = cctvs[idx].size
                for (j in 0 until size) {
                    cctvs[idx][j] = if (cctvs[idx][j] == 3) 0 else cctvs[idx][j] + 1
                }
                list.add(cctvs[idx].clone())
            }

            rotateCctv[idx + 1] = list
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map { it.toInt() }.let {
            n = it[0]
            m = it[1]
        }
        arr = Array(n) { IntArray(m) }

        var empty = 0
        for (i in 0 until n) {
            val st = StringTokenizer(readLine())
            for (j in 0 until m) {
                arr[i][j] = st.nextToken().toInt()
                if (arr[i][j] == 0) empty++
                else if (arr[i][j] in 1..5) {
                    list.add(Cctv(i, j, rotateCctv[arr[i][j]]!!))
                }
            }
        }

        cctvSize = list.size
        loc = IntArray(cctvSize)
        dfs(0)
        print(empty - max)
    }

    private fun dfs(depth: Int) {
        if (depth == cctvSize) {
            calculate().run {
                max = if (max < this) this else max
            }
            return
        }

        val size = list[depth].n
        for (i in 0 until size) {
            loc[depth] = i
            dfs(depth + 1)
        }
    }

    private fun calculate(): Int {
        val visit = Array(n) { BooleanArray(m) }
        var cnt = 0

        for (idx in 0 until cctvSize) {
            val cctv = list[idx]
            val move = list[idx].list[loc[idx]]

            for (m in move) {
                var r = cctv.r
                var c = cctv.c
                while (true) {
                    r += dx[m]
                    c += dy[m]

                    if (check(r, c) || arr[r][c] == 6) break

                    if (arr[r][c] == 0 && !visit[r][c]) {
                        visit[r][c] = true
                        cnt++
                        continue
                    }
                }
            }
        }

        return cnt
    }

    private fun check(r: Int, c: Int) =
        r >= n || r < 0 || c >= m || c < 0
}

fun main() {
    B_15683().solution()
}