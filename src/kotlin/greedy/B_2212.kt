fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val k = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    val diff = IntArray(n - 1)
    arr.sort()

    for (i in 1..<n) {
        diff[i - 1] = arr[i] - arr[i - 1]
    }
    diff.sort()
    var answer = 0
    for (i in 0..<n - k) {
        answer += diff[i]
    }

    print(answer)
}
