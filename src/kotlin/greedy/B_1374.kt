import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { IntArray(2) }
    repeat(n) {
        val input = readLine().split(" ").map { it.toInt() }
        arr[it][0] = input[1]
        arr[it][1] = input[2]
    }
    arr.sortWith { o1, o2 -> if (o1[0] == o2[0]) o1[1] - o2[1] else o1[0] - o2[0] }
    val pq = PriorityQueue<Int>()
    pq.offer(arr[0][1])
    for (i in 1..<n) {
        if (arr[i][0] >= pq.peek()) {
            pq.poll()
        }
        pq.offer(arr[i][1])
    }
    print(pq.size)
}
