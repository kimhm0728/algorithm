package kotlin.practice

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().toIntList()

    val fee = readLine().toIntList().toIntArray()
    val parent = IntArray(n) { it }

    for (i in 0 until m) {
        val (a, b) = readLine().toIntList()
        union(parent, a - 1, b - 1)
    }

    val group = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        val p = find(parent, i)
        group[p] = min(group.getOrDefault(p, 10001), fee[i])
    }

    var answer = 0
    group.forEach { (_, min) -> answer += min }

    if (answer > k) print("Oh no")
    else print(answer)
}

private fun String.toIntList() =
    this.split(" ").map { it.toInt() }

private fun union(parent: IntArray, a: Int, b: Int) {
    val x = find(parent, a)
    val y = find(parent, b)

    if (x == y) return
    if (x > y) parent[x] = y
    else parent[y] = x
}

private fun find(parent: IntArray, a: Int): Int {
    if (parent[a] == a) return a
    parent[a] = find(parent, parent[a])
    return parent[a]
}