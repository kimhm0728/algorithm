lateinit var path: Array<MutableList<Int>>
lateinit var dp: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, r, q) = readLine().split(" ").map { it.toInt() }
    val root = r - 1
    path = Array(n) { mutableListOf() }
    dp = IntArray(n) { -1 }

    repeat(n - 1) {
        val (start, end) = readLine().split(" ").map { it.toInt() - 1 }
        path[start].add(end)
        path[end].add(start)
    }
    sortPath(root)

    val sb = StringBuilder(n)
    repeat(q) {
        sb.append(subtree(readLine().toInt() - 1)).append('\n')
    }
    print(sb)
}

fun sortPath(parent: Int) {
    path[parent].forEach { child ->
        path[child].remove(parent)
        sortPath(child)
    }
}

fun subtree(root: Int): Int {
    if (dp[root] != -1) {
        return dp[root]
    }
    var sum = 1
    path[root].forEach { child ->
        sum += subtree(child)
    }
    dp[root] = sum
    return dp[root]
}
