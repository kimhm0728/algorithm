import java.util.*
import kotlin.math.min

var N = 0
lateinit var path: Array<MutableList<Path>>
var max = 100_000_000

fun main() = with(System.`in`.bufferedReader()) {
    val (n, e) = readLine().split(" ").map { it.toInt() }
    N = n
    path = Array(n) { mutableListOf<Path>() }
    repeat(e) {
        val (start, end, cost) = readLine().split(" ").map { it.toInt() }
        path[start - 1].add(Path(end - 1, cost))
        path[end - 1].add(Path(start - 1, cost))
    }
    val (u, v) = readLine().split(" ").map { it.toInt() - 1 }
    val min1 = dijkstra(0)
    val min2 = dijkstra(u)
    val min3 = dijkstra(v)
    var answer = min1[u] + min2[v] + min3[n - 1]
    answer = min(answer, min1[v] + min3[u] + min2[n - 1])
    if (u == 0) {
        answer = min(answer, min1[v] + min3[n - 1])
    }
    if (v == n - 1) {
        answer = min(answer, min1[u] + min2[n - 1])
    }
    if (u == 0 && v == n - 1) {
        answer = min(answer, min1[n - 1])
    }

    print(if (answer >= max) -1 else answer)
}

fun dijkstra(start: Int): IntArray {
    val pq = PriorityQueue<Path> { o1, o2 -> o1.cost - o2.cost }
    val min = IntArray(N) { max }
    min[start] = 0
    pq.offer(Path(start, 0))

    while (pq.isNotEmpty()) {
        val now = pq.poll()

        path[now.node].forEach { next ->
            if (min[next.node] > now.cost + next.cost) {
                min[next.node] = now.cost + next.cost
                pq.offer(Path(next.node, now.cost + next.cost))
            }
        }
    }
    return min
}

class Path(val node: Int, val cost: Int)
