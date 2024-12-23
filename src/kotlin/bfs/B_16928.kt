import java.util.*

val map = HashMap<Int, Int>()

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    repeat(n + m) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        map[x] = y
    }
    print(bfs())
}

fun bfs(): Int {
    val visit = IntArray(101) { Integer.MAX_VALUE }
    val q = LinkedList<Int>()
    visit[1] = 0
    q.offer(1)

    while (q.isNotEmpty()) {
        val now = q.poll()
        if (now == 100) {
            return visit[now]
        }

        for (i in 1..6) {
            var next = now + i
            if (next > 100) {
                break
            }
            next = map.getOrDefault(next, next) // 사다리, 뱀인 경우
            if (visit[next] <= visit[now] + 1) {
                continue
            }
            visit[next] = visit[now] + 1
            q.offer(next)
        }
    }
    return 0
}
