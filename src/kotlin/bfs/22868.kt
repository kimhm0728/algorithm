import java.util.*

var N = 0
lateinit var graph: Array<MutableList<Int>>
var answer = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    graph = Array(n) { mutableListOf() }

    repeat(m) {
        val (start, end) = readLine().split(" ").map { it.toInt() - 1 }
        graph[start].add(end)
        graph[end].add(start)
    }

    repeat(n) {
        graph[it].sort()
    }

    val (s, e) = readLine().split(" ").map { it.toInt() - 1 }
    bfs(e, s, bfs(s, e))
    print(answer)
}

fun bfs(start: Int, end: Int, sb: StringBuilder = StringBuilder()): StringBuilder {
    val q = LinkedList<Walk>()
    val visit = BooleanArray(N)
    val visited = sb.split(" ").filter { it.isNotBlank() }.map { it.toInt() }
    visited.forEach {
        if (it == start || it == end) return@forEach
        visit[it] = true
    }

    q.offer(Walk(start, 0, StringBuilder()))
    visit[start] = true

    while (q.isNotEmpty()) {
        val now = q.poll()

        if (now.node == end) {
            answer += now.count
            return now.path
        }

        graph[now.node].forEach { next ->
            if (visit[next]) {
                return@forEach
            }

            visit[next] = true
            q.offer(Walk(next, now.count + 1, StringBuilder(now.path).append("$next ")))
        }
    }

    return StringBuilder()
}

class Walk(val node: Int, val count: Int, val path: StringBuilder)
