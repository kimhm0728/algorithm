package kotlin.practice

import java.util.PriorityQueue

private class B_1922 {
    private var n = 0
    private var pq = PriorityQueue<Node>()
    private lateinit var parent: IntArray
    private var answer = 0

    fun solution() {
        init()

        var cnt = 0
        while(cnt < n - 1) {
            val now = pq.poll()

            if (union(now.e1, now.e2)) {
                answer += now.w
                cnt++
            }
        }

        print(answer)
    }

    private fun init() = with(System.`in`.bufferedReader()) {
        n = readLine().toInt()
        val m = readLine().toInt()

        for (i in 0 until m) {
            readLine().split(" ").map { it.toInt() }.let {
                pq.offer(Node(it[0] - 1, it[1] - 1, it[2]))
            }
        }

        parent = IntArray(n) { it }
    }

    private fun union(a: Int, b: Int): Boolean {
        val x = find(a)
        val y = find(b)

        if (x == y) return false

        if (x > y) parent[y] = x
        else parent[x] = y
        return true
    }

    private fun find(a: Int): Int {
        if (parent[a] == a) return a
        parent[a] = find(parent[a])
        return parent[a]
    }

    private class Node(val e1: Int, val e2: Int, val w: Int): Comparable<Node> {
        override fun compareTo(other: Node) = this.w - other.w
    }
}

fun main() {
    B_1922().solution()
}