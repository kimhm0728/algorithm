package kotlinsource

import kotlin.math.abs
import kotlin.math.min

class B_14889 {
    private var n = 0
    private lateinit var arr: Array<IntArray>
    private lateinit var isStart: BooleanArray
    private var answer = 200000

    fun solution() = with(System.`in`.bufferedReader()) {
        n = readLine().toInt()
        arr = Array(n) { IntArray(n) }
        isStart = BooleanArray(n)

        for (idx in 0 until n) {
            arr[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
        }

        dfs(0, 0, n / 2)
        print(answer)
    }

    private fun dfs(depth: Int, startIdx: Int, size: Int) {
        if (depth == size) {
            answer = min(answer, calculate())
            return
        }

        for (idx in startIdx until n) {
            isStart[idx] = true
            dfs(depth + 1, idx + 1, size)
            isStart[idx] = false
        }
    }

    private fun calculate(): Int {
        var start = 0
        var link = 0

        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (isStart[i] && isStart[j]) {
                    start += arr[i][j] + arr[j][i]
                    continue
                }

                if (!isStart[i] && !isStart[j]) {
                    link += arr[i][j] + arr[j][i]
                    continue
                }
            }
        }

        return abs(start - link)
    }
}

fun main() {
    B_14889().solution()
}

