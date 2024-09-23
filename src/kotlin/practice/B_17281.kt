package kotlin.practice

import kotlin.math.max

private class B_17281 {
    private var n = 0
    private lateinit var arr: Array<IntArray>
    private val order = IntArray(9)
    private val visit = BooleanArray(9)
    private var answer = 0

    fun solution() = with(System.`in`.bufferedReader()) {
        n = readLine().toInt()
        arr = Array(n) { IntArray(9) }

        for (i in 0 until n) {
            arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
        }

        visit[0] = true
        order[3] = 0
        dfs(0)
        print(answer)
    }

    private fun dfs(depth: Int) {
        if (depth == 9) {
            answer = max(answer, calculate())
            return
        }

        for (i in 1 until 9) {
            if (visit[i]) continue

            visit[i] = true
            order[depth] = i

            if (depth == 2) dfs(depth + 2)
            else dfs(depth + 1)
            visit[i] = false
        }
    }

    private fun calculate(): Int {
        var score = 0
        var idx = 0


        for (i in 0 until n) {
            val base = BooleanArray(4)
            var out = 0

            while (true) {
                val type = arr[i][order[(idx++ % 9)]]
                if (type == 0) {
                    if (++out == 3) break
                    continue
                }
                score += progressBase(base, type)
            }
        }

        if (score == 47) return score
        return score
    }

    private fun progressBase(base: BooleanArray, type: Int): Int {
        var result = 0
        base[0] = true

        for (idx in 3 downTo (4 - type)) {
            if (base[idx]) {
                result++
                base[idx] = false
            }
        }

        for (idx in (4 - type - 1) downTo 0) {
            if (base[idx]) {
                base[idx + type] = true
                base[idx] = false
            }
        }

        return result
    }
}

fun main() {
    B_17281().solution()
}
