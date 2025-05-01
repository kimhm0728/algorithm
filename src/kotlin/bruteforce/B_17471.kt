import java.util.*
import kotlin.math.abs

lateinit var count: IntArray
lateinit var path: Array<MutableList<Int>>
var n = 0
var max = 10_000
var answer = max

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    count = readLine().split(" ").map { it.toInt() }.toIntArray()
    path = Array(n) { mutableListOf() }
    repeat(n) { i ->
        val nodes = readLine().split(" ").map { it.toInt() - 1 }
        for (j in 1..<nodes.size) {
            path[i].add(nodes[j])
        }
    }
    dfs(0, 0, mutableListOf())
    print(if (answer == max) -1 else answer)
}

fun dfs(depth: Int, start: Int, list: MutableList<Int>) {
    if (depth == n) {
        return
    }
    if (depth > 0) {
        val result = getDiff(list)
        if (answer > result) {
            answer = result
        }
    }

    for (i in start..<n) {
        list.add(i)
        dfs(depth + 1, i + 1, list)
        list.removeLast()
    }
}

fun getDiff(a: MutableList<Int>): Int {
    val b = (0..<n).toList().filterNot { a.contains(it) }
    val countA = a.sumOf { count[it] }
    val countB = b.sumOf { count[it] }
    if (!isSame(a) || !isSame(b)) {
        return max
    }
    return abs(countA - countB)
}

fun isSame(list: List<Int>): Boolean {
    val q = LinkedList<Int>()
    val size = list.size
    val visit = BooleanArray(n)
    var count = 0
    q.offer(list[0])
    visit[list[0]] = true

    while (q.isNotEmpty()) {
        val now = q.poll()
        count++

        path[now].forEach {
            if (!list.contains(it) || visit[it]) {
                return@forEach
            }
            visit[it] = true
            q.offer(it)
        }
    }
    return count == size
}
