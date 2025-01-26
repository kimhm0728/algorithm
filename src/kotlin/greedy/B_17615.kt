import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().toCharArray()
    val end = arr[n - 1]

    var flag = false
    var r = 0
    var b = 0
    for (i in n - 2 downTo 0) {
        if (!flag && arr[i] != end) {
            flag = true
        }
        if (flag) {
            if (arr[i] == 'R') {
                r++
            } else {
                b++
            }
        }
    }
    val answer = min(r, b)

    val start = arr[0]
    flag = false
    r = 0
    b = 0
    for (i in 1..<n) {
        if (!flag && arr[i] != start) {
            flag = true
        }
        if (flag) {
            if (arr[i] == 'R') {
                r++
            } else {
                b++
            }
        }
    }
    print(min(answer, min(r, b)))
}
