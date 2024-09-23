lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    parent = IntArray(n + 1) { it }

    val sb = StringBuilder()
    repeat(m) {
        val (t, a, b) = readLine().split(" ").map { it.toInt() }
        if (t == 0) {
            union(a, b)
            return@repeat
        }
        val parentX = find(a)
        val parentY = find(b)

        sb.append(if (parentX == parentY) "YES" else "NO").append('\n')
    }
    println(sb)
}

fun union(x: Int, y: Int) {
    val parentX = find(x)
    val parentY = find(y)

    if (parentX == parentY) return
    if (parentX < parentY) {
        parent[parentX] = parentY
        return
    }
    parent[parentY] = parent[parentX]
}

fun find(x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent[x])
    return parent[x]
}
