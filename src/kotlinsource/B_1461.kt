package kotlinsource

import java.util.*

private class B_1461 {
    private val pos = mutableListOf<Int>()
    private val neg = mutableListOf<Int>()
    private var book = 0
    private var answer = 0

    fun solution() {
        input()
        pos.sortDescending()
        neg.sortDescending()

        if (pos.isEmpty() || neg.isNotEmpty() && pos[0] < neg[0]) {
            answer += neg[0]
            bringBook(neg)
        } else if (neg.isEmpty() || pos[0] >= neg[0]) {
            answer += pos[0]
            bringBook(pos)
        }

        while (pos.isNotEmpty()) {
            answer += pos[0] * 2
            bringBook(pos)
        }

        while (neg.isNotEmpty()) {
            answer += neg[0] * 2
            bringBook(neg)
        }

        print(answer)
    }

    private fun input() = with(System.`in`.bufferedReader()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        book = m

        val st = StringTokenizer(readLine())
        for (i in 0 until n) {
            val loc = st.nextToken().toInt()
            if (loc > 0) pos.add(loc)
            else neg.add(-loc)
        }
    }

    private fun bringBook(list: MutableList<Int>) {
        for (i in 0 until book) {
            if (list.isEmpty()) return
            list.removeFirst()
        }
    }
}

fun main() {
    B_1461().solution()
}