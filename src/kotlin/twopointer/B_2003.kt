fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    var l = 0
    var r = 0
    var sum = 0
    var answer = 0
    while (l <= r) {
        if (sum < m) {
            if (r == n) break
            sum += arr[r++]
        } else if (sum == m) {
            answer++
            if (r == n) break
            sum += arr[r++]
        } else {
            sum -= arr[l++]
        }
    }
    print(answer)
}
