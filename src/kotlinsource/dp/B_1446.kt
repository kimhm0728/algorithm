package kotlinsource.dp

import java.util.PriorityQueue
import java.util.StringTokenizer


fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val d = st.nextToken().toInt()

    class Distance(val start: Int, val end: Int, val dis: Int) : Comparable<Distance> {
        override fun compareTo(other: Distance): Int {
            if (this.start == other.start) {
                return this.dis - other.dis
            }

            return this.start - other.start
        }
    }

    val pq = PriorityQueue<Distance>()
    val distance = IntArray(d + 1) { it }

    for (cnt in 1..n) {
        st = StringTokenizer(readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        val dis = st.nextToken().toInt()

        if (end > d || end - start <= dis) continue
        pq.offer(Distance(start, end, dis))
    }

    while (pq.isNotEmpty()) {
        val now = pq.poll()

        if (distance[now.end] > distance[now.start] + now.dis) {
            distance[now.end] = distance[now.start] + now.dis
        }

        for (idx in distance[now.end] + 1..d) {
            distance[idx] = distance[now.end] + idx - now.end
        }
    }

    print(distance[d])
}