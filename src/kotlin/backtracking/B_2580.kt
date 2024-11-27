import kotlin.system.exitProcess

val arr = Array(9) { IntArray(9) }
val zero = mutableListOf<Int>()
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    repeat(9) { i ->
        val input = readLine().split(" ")
        repeat(9) { j ->
            arr[i][j] = input[j].toInt()
            if (arr[i][j] == 0) {
                zero.add(i * 9 + j)
            }
        }
    }
    n = zero.size
    dfs(0)
}

fun dfs(depth: Int) {
    if (depth == n) {
        val sb = StringBuilder()
        repeat(9) {
            sb.append(arr[it].joinToString(" ")).append('\n')
        }
        print(sb)
        exitProcess(0)
    }

    val x = zero[depth] / 9
    val y = zero[depth] % 9
    for (i in 1..9) {
        if (!check(x, y, i)) {
            continue
        }
        arr[x][y] = i
        dfs(depth + 1)
        arr[x][y] = 0
    }
}

fun check(x: Int, y: Int, num: Int): Boolean {
    val startX = if (x in 0..2) 0 else if (x in 3..5) 3 else 6
    val startY = if (y in 0..2) 0 else if (y in 3..5) 3 else 6

    for (i in startX..startX + 2) {
        for (j in startY..startY + 2) {
            if (x == i && y == j) continue
            if (arr[i][j] == num) return false
        }
    }

    for (i in 0..8) {
        if (y == i) continue
        if (arr[x][i] == num) return false
    }

    for (i in 0..8) {
        if (x == i) continue
        if (arr[i][y] == num) return false
    }
    return true
}

////////////

import kotlin.system.exitProcess

val arr = Array(9) { IntArray(9) }
val zero = mutableListOf<Int>()
var n = 0

val square = Array(9) { BooleanArray(9) }
val horizontal = Array(9) { BooleanArray(9) }
val vertical = Array(9) { BooleanArray(9) }

fun main() = with(System.`in`.bufferedReader()) {
    repeat(9) { i ->
        val input = readLine().split(" ")
        repeat(9) { j ->
            val num = input[j].toInt()
            if (num == 0) {
                zero.add(i * 9 + j)
            } else {
                checkVisit(i, j, num)
            }
        }
    }
    n = zero.size
    dfs(0)
}

fun dfs(depth: Int) {
    if (depth == n) {
        val sb = StringBuilder()
        repeat(9) {
            sb.append(arr[it].joinToString(" ")).append('\n')
        }
        print(sb)
        exitProcess(0)
    }

    val x = zero[depth] / 9
    val y = zero[depth] % 9
    for (i in 1..9) {
        if (!check(x, y, i)) {
            continue
        }
        checkVisit(x, y, i)
        dfs(depth + 1)
        uncheckVisit(x, y, i)
    }
}

fun check(x: Int, y: Int, num: Int): Boolean {
    return !square[(x / 3) * 3 + (y / 3)][num - 1] && !horizontal[x][num - 1] && !vertical[y][num - 1]
}

fun checkVisit(x: Int, y: Int, num: Int) {
    arr[x][y] = num
    square[(x / 3) * 3 + (y / 3)][num - 1] = true
    horizontal[x][num - 1] = true
    vertical[y][num - 1] = true
}

fun uncheckVisit(x: Int, y: Int, num: Int) {
    arr[x][y] = 0
    square[(x / 3) * 3 + (y / 3)][num - 1] = false
    horizontal[x][num - 1] = false
    vertical[y][num - 1] = false
}
