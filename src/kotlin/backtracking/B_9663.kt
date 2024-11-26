var n = 0
lateinit var arr: IntArray
lateinit var visit: BooleanArray
var answer = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = IntArray(n)
    visit = BooleanArray(n)
    dfs(0)
    print(answer)
}

fun dfs(depth: Int) {
    if (depth == n) {
        answer++
        return
    }

    for (i in 0..<n) {
        if (visit[i] || !check(depth, i)) {
            continue
        }
        arr[depth] = i
        visit[i] = true
        dfs(depth + 1)
        visit[i] = false
    }
}

fun check(x: Int, y: Int): Boolean {
    for (i in 0..<x) {
        if (arr[i] == y) return false
        val diff = x - i
        if (y - diff in 0..<n && arr[i] == y - diff) return false
        if (y + diff in 0..<n && arr[i] == y + diff) return false
    }
    return true
}
