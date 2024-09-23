package kotlin.practice

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    fun String.toIntList() = this.split(" ").map { it.toInt() }
    val max = 150000

    val (n, m, r) = readLine().toIntList()
    val items = readLine().toIntList().toIntArray()
    val arr = Array(n) { IntArray(n) { max } }

    for (i in 0 until n) arr[i][i] = 0

    for (i in 0 until r) {
        val st = StringTokenizer(readLine())
        val start = st.nextToken().toInt() - 1
        val end = st.nextToken().toInt() - 1
        val weight = st.nextToken().toInt()

        arr[start][end] = weight
        arr[end][start] = weight
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (arr[i][j] > arr[i][k] + arr[k][j]) {
                    arr[i][j] = arr[i][k] + arr[k][j]
                }
            }
        }
    }

    var answer = 0
    for (i in 0 until n) {
        var cnt = 0
        for (j in 0 until n) {
            if (arr[i][j] > m) continue
            cnt += items[j]
        }
        answer = if (answer < cnt) cnt else answer
    }

    print(answer)
}