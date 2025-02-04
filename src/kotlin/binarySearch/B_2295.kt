import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n) { readLine().toInt() }.sorted()
    val two = mutableListOf<Int>()

    for (i in 0..<n - 1) {
        for (j in i..<n - 1) {
            two.add(arr[i] + arr[j])
        }
    }
    val sortedTwo = two.sorted().toIntArray()

    var answer = -1
    for (i in n - 1 downTo 1) {
        for (j in i - 1 downTo 0) {
            if (binarySearch(sortedTwo, arr[i] - arr[j])) {
                answer = max(answer, arr[i])
            }
        }
    }
    print(answer)
}

fun binarySearch(arr: IntArray, x: Int): Boolean {
    var l = 0
    var r = arr.size - 1

    while (l <= r) {
        val mid = (l + r) / 2

        if (x < arr[mid]) {
            r = mid - 1
        } else if (x > arr[mid]) {
            l = mid + 1
        } else {
            return true
        }
    }
    return false
}
