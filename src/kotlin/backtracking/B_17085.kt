var answer = 0
var n = 0
var m = 0
lateinit var arr: Array<CharArray>
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (temp1, temp2) = readLine().split(" ").map { it.toInt() }
    n = temp1
    m = temp2
    arr = Array(n) { CharArray(m) }
    repeat(n) {
        arr[it] = readLine().toCharArray()
    }
    dfs(0, 0, 1)
    print(answer)
}

fun dfs(depth: Int, idx: Int, dimen: Int) {
    if (depth == 2) {
        if (answer < dimen) {
            answer = dimen
        }
        return
    }

    for (i in idx..<n * m) {
        val r = i / m
        val c = i % m
        if (arr[r][c] != '#') {
            continue
        }

        var size = 0
        while (canPlace(r, c, size)) {
            place(r, c, size)
            dfs(depth + 1, i + 1, dimen * (size * 4 + 1))
            place(r, c, size)
            size++
        }
    }
}

fun canPlace(r: Int, c: Int, size: Int): Boolean {
    repeat(size) { i ->
        repeat(4) { j ->
            val nextR = r + dx[j] * (i + 1)
            val nextC = c + dy[j] * (i + 1)
            if (nextR !in 0..<n || nextC !in 0..<m || arr[nextR][nextC] != '#') {
                return false
            }
        }
    }
    return true
}

fun place(r: Int, c: Int, size: Int) {
    val state = if (arr[r][c] == '#') '*' else '#'
    arr[r][c] = state
    repeat(size) { i ->
        repeat(4) { j ->
            val nextR = r + dx[j] * (i + 1)
            val nextC = c + dy[j] * (i + 1)
            arr[nextR][nextC] = state
        }
    }
}
