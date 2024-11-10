lateinit var arr: Array<IntArray>
var white = 0
var blue = 0

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    arr = Array(n) { IntArray(n) }
    repeat(n) {
        arr[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    separate(0, 0, n)
    print("$white\n$blue")
}

fun separate(x: Int, y: Int, size: Int) {
    if (isSameColor(x, y, size)) {
        return
    }
    val next = size / 2
    separate(x, y, next)
    separate(x, y + next, next)
    separate(x + next, y, next)
    separate(x + next, y + next, next)
}

fun isSameColor(x: Int, y: Int, size: Int): Boolean {
    for (i in 0..<size) {
        for (j in 0..<size) {
            if (arr[x][y] != arr[x + i][y + j]) {
                return false
            }
        }
    }
    if (arr[x][y] == 0) white++ else blue++
    return true
}
