import java.util.*
import kotlin.math.max

var n = 0
lateinit var graph: Array<MutableList<Path>>
lateinit var visit: BooleanArray
var answer = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    val isParent = BooleanArray(n)
    graph = Array(n) { mutableListOf() }
    visit = BooleanArray(n)

    repeat(n - 1) {
        val (start, end, w) = readLine().split(" ").map { it.toInt() - 1 }
        isParent[start] = true

        graph[start].add(Path(end, w + 1))
        graph[end].add(Path(start, w + 1))
    }

    repeat(n) {
        if (!isParent[it]) {
            visit[it] = true
            dfs(it, 0)
            visit[it] = false
        }
    }
    print(answer)
}

fun dfs(idx: Int, w: Int) {
    answer = max(answer, w)

    graph[idx].forEach { next ->
        if (visit[next.node]) {
            return@forEach
        }

        visit[next.node] = true
        dfs(next.node, w + next.w)
        visit[next.node] = false
    }
}

class Path(val node: Int, val w: Int)
