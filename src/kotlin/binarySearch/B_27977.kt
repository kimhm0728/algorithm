import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (l, n, k) = readLine().split(" ").map { it.toInt() } // 학교까지 거리, 충전소 개수, 충전 횟수
    val list = readLine().split(" ").map { it.toInt() }

    var s = 1
    var e = l
    var answer = l
    while (s <= e) {
        val mid = (s + e) / 2
        if (canGoToSchool(list, l, k, mid)) {
            answer = min(answer, mid)
            e = mid - 1
        } else {
            s = mid + 1
        }
    }
    print(answer)
}

fun canGoToSchool(list: List<Int>, l: Int, k: Int, b: Int): Boolean {
    var count = 0 // 충전 횟수
    var now = 0
    while (true) {
        if (count > k) { // 최대 충전 횟수를 넘어선 경우
            return false
        }
        if (now + b >= l) { // 학교에 등교
            return true
        }
        val result = binarySearch(list, now + b)
        if (result == -1) { // 충전소를 만나기 전에 배터리 소진된 경우
            return false
        }
        if (now == list[result]) { // 같은 충전소를 또 방문한 경우
            return false
        }
        now = list[result]
        count++
    }
}

// 가장 가까운 충전소 반환
// 하한, x와 같으면 s 반환, 다르면 s-1 반환
fun binarySearch(list: List<Int>, x: Int): Int {
    var s = 0
    var e = list.size

    while (s < e) {
        val mid = (s + e) / 2
        if (list[mid] >= x) {
            e = mid
        } else {
            s = mid + 1
        }
    }
    return if (s == list.size || list[s] != x) s - 1 else s
}
