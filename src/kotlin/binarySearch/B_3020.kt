fun main() = with(System.`in`.bufferedReader()) {
    val (n, h) = readLine().split(" ").map { it.toInt() }
    val down = IntArray(n / 2)
    val up = IntArray(n / 2)
    repeat(n) {
        if (it % 2 == 0) {
            down[it / 2] = readLine().toInt()
        } else {
            up[it / 2] = readLine().toInt()
        }
    }
    down.sort()
    up.sort()
    var min = 200_001
    var count = 0
    for (i in 1..h) {
        val result = binarySearch(down, i) + binarySearch(up, h - i + 1)
        if (min > result) {
            min = result
            count = 1
        } else if (min == result) {
            count++
        }
    }
    print("$min $count")
}

fun binarySearch(arr: IntArray, x: Int): Int { // 장애물을 부시는 개수 반환 -> x보다 처음으로 크거나 같은 원소의 인덱스 구하기
    var l = 0
    var e = arr.size

    while (l < e) {
        val mid = (l + e) / 2
        if (arr[mid] >= x) {
            e = mid
        } else {
            l = mid + 1
        }
    }
    return arr.size - l
}
