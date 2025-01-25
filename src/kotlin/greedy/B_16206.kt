import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    var (n, m) = List(2) { st.nextToken().toInt() }
    val q = PriorityQueue<Int> { o1, o2 ->
        if (o1 % 10 == o2 % 10) {
            o1 - o2
        } else {
            o1 % 10 - o2 % 10
        }
    }
    st = StringTokenizer(readLine())
    var answer = 0
    repeat(n) {
        val len = st.nextToken().toInt()
        if (len == 10) {
            answer++
            return@repeat
        }
        if (len < 10) {
            return@repeat
        }
        q.offer(len)
    }
    while (q.isNotEmpty() && m > 0) {
        val now = q.poll()
        answer++
        m--
        if (now - 10 == 10) {
            answer++
            continue
        }
        if (now - 10 > 10) {
            q.offer(now - 10)
            continue
        }
    }
    print(answer)
}
