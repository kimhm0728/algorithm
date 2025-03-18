import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        sb.append("Case #${it + 1}: ")
        val (n, m) = readLine().split(" ", "\t").filterNot { it == "" }.map { it.toInt() }
        val arr = Array(m) { mutableListOf<Friend>() }
        repeat(n) {
            val (x, y, z) = readLine().split(" ", "\t").filterNot { it == "" }.map { it.toInt() }
            arr[x].add(Friend(y, z))
            arr[y].add(Friend(x, z))
        }
        sb.append(dijkstra(m, arr)).append('\n')
    }
    print(sb)
}

fun dijkstra(n: Int, arr: Array<MutableList<Friend>>): String {
    val pq = PriorityQueue<Find> { o1, o2 -> o1.total - o2.total }
    pq.offer(Find(0, 0, "0"))
    val min = IntArray(n) { 987654321 }
    min[0] = 0

    while (pq.isNotEmpty()) {
        val now = pq.poll()
        if (now.idx == n - 1) {
            return now.path
        }

        arr[now.idx].forEach { next ->
            if (min[next.idx] > now.total + next.degree) {
                min[next.idx] = now.total + next.degree
                pq.offer(Find(next.idx, min[next.idx], now.path + " ${next.idx}"))
            }
        }
    }
    return "-1"
}

class Friend(val idx: Int, val degree: Int)

class Find(val idx: Int, val total: Int, val path: String)
