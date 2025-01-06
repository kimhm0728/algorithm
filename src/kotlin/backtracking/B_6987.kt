val arr = Array(6) { IntArray(3) } // 0: 승, 1: 무, 2: 패
var flag = false

fun main() = with(System.`in`.bufferedReader()) {
    val answer = IntArray(4)

    repeat(4) {
        val input = readLine().split(" ").map { it.toInt() }
        if (input.sum() != 30) {
            return@repeat
        }
        input.forEachIndexed { idx, i ->
            arr[idx / 3][idx % 3] = i
        }
        dfs(0, 1)
        if (flag) {
            answer[it] = 1
        }
        flag = false
    }

    print(answer.joinToString(" "))
}

fun dfs(x: Int, y: Int) {
    if (flag) {
        return
    }
    if (x == 5) {
        flag = true
        return
    }

    val next = if (y == 5) x + 1 to x + 2 else x to y + 1
    if (arr[x][0] > 0 && arr[y][2] > 0) {
        arr[x][0]--
        arr[y][2]--
        dfs(next.first, next.second)
        arr[x][0]++
        arr[y][2]++
    }
    if (arr[x][1] > 0 && arr[y][1] > 0) {
        arr[x][1]--
        arr[y][1]--
        dfs(next.first, next.second)
        arr[x][1]++
        arr[y][1]++
    }
    if (arr[x][2] > 0 && arr[y][0] > 0) {
        arr[x][2]--
        arr[y][0]--
        dfs(next.first, next.second)
        arr[x][2]++
        arr[y][0]++
    }
}
