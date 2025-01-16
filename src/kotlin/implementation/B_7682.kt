val set = HashSet<String>()
val arr = CharArray(9) { '.' }
val idx = arrayOf(
    intArrayOf(0, 1, 2),
    intArrayOf(3, 4, 5),
    intArrayOf(6, 7, 8),
    intArrayOf(0, 3, 6),
    intArrayOf(1, 4, 7),
    intArrayOf(2, 5, 8),
    intArrayOf(0, 4, 8),
    intArrayOf(2, 4, 6),
)

fun main() = with(System.`in`.bufferedReader()) {
    dfs(0)

    val sb = StringBuilder()
    while (true) {
        val input = readLine()
        if (input == "end") {
            break
        }
        sb.append(if (set.contains(input)) "valid" else "invalid").append('\n')
    }
    print(sb)
}

fun dfs(depth: Int) {
    if ((depth >= 3 && check()) || depth == 9) {
        set.add(arr.joinToString(""))
        return
    }

    val order = if (depth % 2 == 0) 'X' else 'O'
    repeat(9) {
        if (arr[it] != '.') {
            return@repeat
        }
        arr[it] = order
        dfs(depth + 1)
        arr[it] = '.'
    }
}

fun check(): Boolean {
    idx.forEach {
        if (arr[it[0]] == '.') {
            return@forEach
        }
        if (arr[it[0]] == arr[it[1]] && arr[it[1]] == arr[it[2]]) {
            return true
        }
    }
    return false
}
