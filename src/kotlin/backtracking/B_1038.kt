val arr = List(10) { mutableListOf<String>() }

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    repeat(10) {
        arr[0].add(it.toString())
    }
    dfs(1)
    val sortedArr = arr.flatten().map { it.toLong() }.sorted()
    if (sortedArr.size <= n) {
        print(-1)
        return
    }
    print(sortedArr[n])
}

fun dfs(depth: Int) {
    if (depth == 10) {
        return
    }
    arr[depth - 1].forEach {
        val first = it[0].code - '0'.code
        for (next in first + 1..9) {
            arr[depth].add(next.toString() + it)
        }
    }
    dfs(depth + 1)
}
