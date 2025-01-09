import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val t = readLine()
    val q = LinkedList<String>()
    q.offer(t)
    while (q.isNotEmpty()) {
        val now = q.poll()
        if (now == s) {
            print(1)
            return
        }
        if (now[now.length - 1] == 'A' && now.length > s.length) {
            q.offer(now.substring(0, now.length - 1))
        }
        if (now[now.length - 1] == 'B' && now.length > s.length) {
            q.offer(StringBuilder(now.substring(0, now.length - 1)).reverse().toString())
        }
    }
    print(0)
}
