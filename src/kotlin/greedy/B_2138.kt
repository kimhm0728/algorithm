import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val a = readLine().toCharArray().map { it - '0' }
    val b = readLine().toCharArray().map { it - '0' }.toIntArray()

    var answer = Int.MAX_VALUE
    var arr = a.toIntArray()
    var count = switch(arr, b, n)
    if (arr.contentEquals(b)) {
        answer = min(answer, count)
    }

    arr = a.toIntArray()
    arr[0] = arr[0].reserve()
    arr[1] = arr[1].reserve()
    count = switch(arr, b, n) + 1
    if (arr.contentEquals(b)) {
        answer = min(answer, count)
    }

    print(if (answer == Int.MAX_VALUE) -1 else answer)
}

fun Int.reserve() = if (this == 0) 1 else 0

fun switch(arr: IntArray, b: IntArray, n: Int): Int {
    var count = 0
    for (i in 1..<n) {
        if (arr[i - 1] == b[i - 1]) {
            continue
        }
        arr[i - 1] = if (arr[i - 1] == 0) 1 else 0
        arr[i] = if (arr[i] == 0) 1 else 0
        if (i != n - 1) {
            arr[i + 1] = if (arr[i + 1] == 0) 1 else 0
        }
        count++
    }
    return count
}
