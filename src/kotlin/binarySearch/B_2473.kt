import kotlin.math.abs

val max = 10_000_000_000

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toLong() }.sorted().toLongArray()

    var min = max
    var answer = longArrayOf()

    for (i in 0..<n) {
        for (j in i + 2..<n) {
            val result = binarySearch(arr, i + 1, j - 1, -(arr[i] + arr[j]))
            if (min > abs(arr[i] + arr[j] + result)) {
                min = abs(arr[i] + arr[j] + result)
                answer = longArrayOf(arr[i], result, arr[j])
            }
        }
    }

    print(answer.joinToString(" "))
}

fun binarySearch(arr: LongArray, start: Int, end: Int, x: Long): Long {
    var l = start
    var e = end
    var answer = max

    while (l <= e) {
        val mid = (l + e) / 2
        if (abs(answer - x) > abs(arr[mid] - x)) {
            answer = arr[mid]
        }
        if (arr[mid] > x) {
            e = mid - 1
        } else if (arr[mid] < x) {
            l = mid + 1
        } else {
            return arr[mid]
        }
    }
    return answer
}
