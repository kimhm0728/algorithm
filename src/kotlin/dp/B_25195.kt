lateinit var dp: IntArray
lateinit var path: Array<MutableList<Int>>
lateinit var isFan: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    dp = IntArray(n)
    path = Array(n) { mutableListOf() }
    isFan = BooleanArray(n)

    repeat(m) {
        val (start, end) = readLine().split(" ").map { it.toInt() - 1 }
        path[start].add(end)
    }
    readLine().toInt()
    val input = readLine().split(" ")
    input.forEach {
        isFan[it.toInt() - 1] = true
    }
    print(if (solution(0) == 1) "yes" else "Yes")
}

// 0: 아직 방문 X, 1: 이동 O, 2: 이동 X
fun solution(idx: Int): Int {
    if (dp[idx] != 0) {
        return dp[idx]
    }
    if (isFan[idx]) {
        dp[idx] = 2
        return dp[idx]
    }
    if (path[idx].size == 0) {
        dp[idx] = 1
        return dp[idx]
    }
    dp[idx] = 2
    for (i in path[idx].indices) {
        val result = solution(path[idx][i])
        if (result == 1) {
            dp[idx] = 1
            break
        }
    }
    return dp[idx]
}
