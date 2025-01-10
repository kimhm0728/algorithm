import java.util.PriorityQueue

val max = 100_000_001
lateinit var path: Array<MutableList<Bus>>
lateinit var min: IntArray
lateinit var visit: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    path = Array(n) { mutableListOf() }
    min = IntArray(n) { max }
    visit = BooleanArray(n)
    repeat(m) {
        val (start, end, cost) = readLine().split(" ").map { it.toInt() }
        path[start - 1].add(Bus(end - 1, cost))
    }
    val (origin, dest) = readLine().split(" ").map { it.toInt() - 1 }
    min[origin] = 0
    print(dijkstra(origin, dest))
}

fun dijkstra(origin: Int, dest: Int): Int {
    val pq = PriorityQueue<Bus> { o1, o2 -> o1.cost.compareTo(o2.cost) }
    pq.offer(Bus(origin, 0))

    while (pq.isNotEmpty()) {
        val now = pq.poll()
        if (now.pos == dest) {
            return now.cost
        }
        if (visit[now.pos]) {
            continue
        }

        visit[now.pos] = true
        path[now.pos].forEach { next ->
            if (min[next.pos] <= now.cost + next.cost) {
                return@forEach
            }
            min[next.pos] = now.cost + next.cost
            pq.offer(Bus(next.pos, now.cost + next.cost))
        }
    }

    return 0
}

class Bus(val pos: Int, val cost: Int)
