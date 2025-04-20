fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray().sorted()
    val x = readLine().toInt()
    var count = 0
    var l = 0
    var r = n - 1
    while (l < r) {
        if (arr[l] + arr[r] == x) {
            count++
            l++
            r--
        } else if (arr[l] + arr[r] > x) {
            r--
        } else {
            l++
        }
    }
    print(count)
}
