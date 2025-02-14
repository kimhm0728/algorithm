import java.util.*

var n = 0
var answer = 0
val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    val arr = Array(n) { IntArray(n) }
    repeat(n) { i ->
        val st = StringTokenizer(readLine())
        repeat(n) { j ->
            arr[i][j] = st.nextToken().toInt()
        }
    }
    dfs(0, arr)
    print(answer)
}

fun dfs(depth: Int, arr: Array<IntArray>) {
    var max = 0
    repeat(n) { i ->
        repeat(n) { j ->
            if (arr[i][j] > max) {
                max = arr[i][j]
            }
        }
    }
    if (answer < max) {
        answer = max
    }
    if (depth == 10) {
        return
    }

    repeat(4) {
        val new = move(it, arr)
        if (equals(arr, new)) {
            return@repeat
        }
        dfs(depth + 1, move(it, arr))
    }
}

fun move(dir: Int, arr: Array<IntArray>): Array<IntArray> {
    val new = Array(n) { IntArray(n) }
    val startX = if (dir == 1) n - 1 else 0
    val startY = if (dir == 3) n - 1 else 0
    if (dir == 0 || dir == 1) { // 상, 하
        for (y in 0..<n) {
            var x = startX
            var idx = startX
            var last = -1
            while (x in 0..<n) {
                if (arr[x][y] == 0) {
                    x += dx[dir]
                    continue
                }
                if (last == arr[x][y]) {
                    new[idx - dx[dir]][y] = last * 2
                    last = -1
                } else {
                    new[idx][y] = arr[x][y]
                    idx += dx[dir]
                    last = arr[x][y]
                }
                x += dx[dir]
            }
        }
    } else { // 좌, 우
        for (x in 0..<n) {
            var y = startY
            var idx = startY
            var last = -1
            while (y in 0..<n) {
                if (arr[x][y] == 0) {
                    y += dy[dir]
                    continue
                }
                if (last == arr[x][y]) {
                    new[x][idx - dy[dir]] = last * 2
                    last = -1
                } else {
                    new[x][idx] = arr[x][y]
                    idx += dy[dir]
                    last = arr[x][y]
                }
                y += dy[dir]
            }
        }
    }
    return new
}

fun equals(arr1: Array<IntArray>, arr2: Array<IntArray>): Boolean {
    repeat(n) { i ->
        repeat(n) { j ->
            if (arr1[i][j] != arr2[i][j]) {
                return false
            }
        }
    }
    return true
}
