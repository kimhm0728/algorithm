fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n) { readLine().toInt() }.sorted()
    val visit = BooleanArray(n)

    var answer = 0
    for (i in 0..<n - 1 step (2)) {
        if (arr[i] <= 0 && arr[i + 1] <= 0) {
            answer += arr[i] * arr[i + 1]
            visit[i] = true
            visit[i + 1] = true
            continue
        }
        break
    }

    for (i in n - 1 downTo 1 step (2)) {
        if (arr[i] > 1 && arr[i - 1] > 1) {
            answer += arr[i] * arr[i - 1]
            visit[i] = true
            visit[i - 1] = true
            continue
        }
        break
    }

    for (i in 0..<n) {
        if (!visit[i]) {
            answer += arr[i]
        }
    }
    print(answer)
}
