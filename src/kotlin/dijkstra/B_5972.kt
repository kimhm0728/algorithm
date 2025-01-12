import java.util.*

lateinit var path: Array<MutableList<Cow>>
lateinit var dist: IntArray
lateinit var visit: BooleanArray

class Cow(val pos: Int, val cost: Int)

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val (n, m) = List(2) { st.nextToken().toInt() }
    path = Array(n) { mutableListOf() }
    dist = IntArray(n) { Int.MAX_VALUE }
    visit = BooleanArray(n)
    repeat(m) {
        st = StringTokenizer(readLine())
        val (start, end, cost) = List(3) { st.nextToken().toInt() }
        path[start - 1].add(Cow(end - 1, cost))
        path[end - 1].add(Cow(start - 1, cost))
    }
    print(dijkstra())
}

fun dijkstra(): Int {
    val pq = PriorityQueue<Cow> { o1, o2 -> o1.cost - o2.cost }
    dist[0] = 0
    pq.offer(Cow(0, 0))

    while (pq.isNotEmpty()) {
        val now = pq.poll()
        if (now.pos == dist.size - 1) {
            return now.cost
        }

        visit[now.pos] = true
        path[now.pos].forEach { next ->
            if (visit[next.pos]) {
                return@forEach
            }
            if (dist[next.pos] > now.cost + next.cost) {
                dist[next.pos] = now.cost + next.cost
                pq.offer(Cow(next.pos, now.cost + next.cost))
            }
        }
    }
    return 0
}
