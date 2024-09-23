package kotlin.practice

import java.util.*

class Edge(val e1: Int, val e2: Int, val w: Int): Comparable<Edge> {
    override fun compareTo(other: Edge) = this.w - other.w
}

fun main() = with(System.`in`.bufferedReader()) {
    val (v, e) = readLine().split(" ").map { it.toInt() }

    val parent = IntArray(v)
    for (i in 0 until v) parent[i] = i

    val pq = PriorityQueue<Edge>()

    for (i in 0 until e) {
        val (e1, e2, w) = readLine().split(" ").map { it.toInt() }
        pq.offer(Edge(e1 - 1, e2 - 1, w))
    }

    var cnt = 0
    var weight = 0

    while (cnt < v - 1) {
        val edge = pq.poll()

        if (union(parent, edge.e1, edge.e2)) {
            cnt++
            weight += edge.w
        }
    }

    print(weight)
}

private fun union(parent: IntArray, e1: Int, e2: Int): Boolean {
    val p1 = find(parent, e1)
    val p2 = find(parent, e2)

    if (p1 == p2) return false

    if (p1 > p2) parent[p2] = p1
    else parent[p1] = p2
    return true
}

private fun find(parent: IntArray, e: Int): Int {
    if (parent[e] == e) return e
    parent[e] = find(parent, parent[e])
    return parent[e]
}