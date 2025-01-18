import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Int>()
    repeat(n) {
        pq.offer(readLine().toInt())
    }

    var answer = 0
    while (pq.size > 1) {
        val first = pq.poll()
        val second = pq.poll()
        answer += first + second
        pq.offer(first + second)
    }
    print(answer)
}
