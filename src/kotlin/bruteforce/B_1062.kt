import kotlin.math.max

var N = 0
var K = 0
var answer = 0
val visit = BooleanArray(26) { false }
val words = mutableListOf<String>()

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    N = n
    K = k - 5

    if (K == 26) {
        println(N)
        return
    }
    if (K < 0) {
        println(0)
        return
    }

    repeat(N) { words.add(readLine()) }
    listOf('a', 'n', 't', 'i', 'c').forEach { visit[it.code - 'a'.code] = true }
    dfs(0, 0)
    println(answer)
}

fun dfs(depth: Int, start: Int) {
    if (depth == K) {
        answer = max(answer, words.count { word -> word.all { visit[it.code - 'a'.code] } })
        return
    }

    (start..<visit.size).forEach {
        if (!visit[it]) {
            visit[it] = true
            dfs(depth = depth + 1, start = it)
            visit[it] = false
        }
    }
}
