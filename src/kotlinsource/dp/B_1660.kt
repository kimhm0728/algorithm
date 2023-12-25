package kotlinsource.dp

import kotlin.math.min

class B_1660 {
    private lateinit var dp: IntArray
    private lateinit var idx: IntArray
    private lateinit var arr: IntArray
    private var size = 0
    private val max = 100_000_000

    operator fun invoke() {
        val n = System.`in`.bufferedReader().readLine().toInt()
        dp = IntArray(n + 1) { max }
        idx = IntArray(n + 1) { -1 }
        arr = getTetrahedronArr(n)
        size = arr.size

        dp[0] = 0
        print(solution(n))
    }

    private fun getTetrahedronArr(max: Int): IntArray {
        val list = mutableListOf<Int>()
        var sum = 0
        var cnt = 1
        var value = 1

        while (true) {
            sum += value
            list.add(sum)
            value += ++cnt
            if (sum > max) break
        }

        return list.toIntArray()
    }

    private fun solution(n: Int): Int {
        if (n < 0) return max + 1
        if (dp[n] != max) return dp[n]

        val idx = getIdx(n)
        for (i in idx downTo 0) {
            dp[n] = min(dp[n], solution(n - arr[i]) + 1)
        }

        return dp[n]
    }

    private fun getIdx(n: Int): Int {
        if (idx[n] != -1) return idx[n]

        var lo = 0
        var hi = size

        while (lo < hi) {
            val mid = (lo + hi) / 2

            if (n < arr[mid]) hi = mid
            else lo = mid + 1
        }

        idx[n] = lo - 1
        return lo - 1
    }
}

fun main() {
    B_1660()()
}