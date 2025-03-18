lateinit var dp: IntArray
lateinit var path: Array<MutableList<Int>>
lateinit var h: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    dp = IntArray(n)
    path = Array(n) { mutableListOf() }
    h = readLine().split(" ").map { it.toInt() }.toIntArray()

    repeat(m) {
        val (start, end) = readLine().split(" ").map { it.toInt() - 1 }
        path[start].add(end)
        path[end].add(start)
    }

    val sb = StringBuilder()
    repeat(n) {
        sb.append(solution(it)).append('\n')
    }
    print(sb)
}

fun solution(idx: Int): Int {
    if (dp[idx] != 0) {
        return dp[idx]
    }

    path[idx].forEach {
        if (h[idx] >= h[it]) {
            return@forEach
        }
        val next = solution(it)
        if (dp[idx] < next) {
            dp[idx] = next
        }
    }
    dp[idx]++
    return dp[idx]
}
