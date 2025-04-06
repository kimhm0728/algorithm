import kotlin.math.max
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, c) = readLine().split(" ").map { it.toInt() } // 집 개수, 공유기 개수
    val arr = IntArray(n) { readLine().toInt() }
    arr.sort()
    if (c == 0) {
        print(arr.last() - arr.first())
        return
    }

    var l = 0
    var r = 1_000_000_000
    var answer = 0
    while (l < r) {
        val mid = (l + r + 1) / 2
        val result = solution(mid, arr, c)
        if (result == -1) {
            r = mid - 1
        } else {
            answer = max(answer, result)
            l = mid
        }
    }
    print(answer)
}

// 거리, 집 좌표, 공유기 개수
fun solution(dis: Int, arr: IntArray, c: Int): Int { // 공유기 거리 최솟값 반환
    var count = c - 1
    var min = 1_000_000_001
    var now = arr.first()

    while (count != 0) {
        val result = binarySearch(arr, now + dis)
        if (result == arr.size) {
            return -1
        }
        min = min(min, arr[result] - now)
        now = arr[result]
        count--
    }
    return min
}

fun binarySearch(arr: IntArray, x: Int): Int {
    var l = 0
    var r = arr.size

    while (l < r) {
        val mid = (l + r) / 2

        if (arr[mid] >= x) {
            r = mid
        } else {
            l = mid + 1
        }
    }
    return l
}
