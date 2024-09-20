import java.util.Collections
import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val n = readLine().toInt()
        val map = HashMap<Int, Int>()
        val pq1 = PriorityQueue<Int>(Collections.reverseOrder())
        val pq2 = PriorityQueue<Int>()
        repeat(n) {
            val (oper, tmp) = readLine().split(" ")
            val num = tmp.toInt()
            if (oper == "I") {
                map[num] = map.getOrDefault(num, 0) + 1
                pq1.offer(num)
                pq2.offer(num)
            } else {
                if (map.isNotEmpty()) {
                    map.removePQ(if (num == 1) pq1 else pq2)
                }
            }
        }
        if (map.isEmpty()) {
            sb.append("EMPTY").append('\n')
        } else {
            val max = map.removePQ(pq1)
            val min = if (map.isEmpty()) max else map.removePQ(pq2)
            sb.append("$max $min").append('\n')
        }
    }
    println(sb)
}

fun HashMap<Int, Int>.removePQ(pq: PriorityQueue<Int>): Int {
    while (true) {
        val num = pq.poll()
        val value = this[num]
        if (value != null) {
            if (value == 1) {
                this.remove(num)
            } else {
                this[num] = value - 1
            }
            return num
        }
    }
}
