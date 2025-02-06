import kotlin.math.*

val max = 3_000_000_001

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
    var min = max

    var answer1 = 0
    var answer2 = 0
    for (i in 0..<n) {
        val result = binarySearch(arr, -arr[i])
        if (abs(arr[i] + result) < min && result != arr[i]) {
            min = abs(arr[i] + result).toLong()
            answer1 = min(arr[i], result)
            answer2 = max(arr[i], result)
        }
    }
    print("$answer1 $answer2")
}

fun binarySearch(arr: IntArray, x: Int): Int {
    var l = 0
    var r = arr.size - 1
    var answer = max

    while (l <= r) {
        val mid = (l + r) / 2
        if (abs(x - answer) > abs(x - arr[mid])) {
            answer = arr[mid].toLong()
        }

        if (x < arr[mid]) {
            r = mid - 1
        } else if (x > arr[mid]) {
            l = mid + 1
        } else {
            return answer.toInt()
        }
    }
    return answer.toInt()
}
