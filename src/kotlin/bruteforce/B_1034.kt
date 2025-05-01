fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array<String>(n) { readLine() }
    val zeroCount = IntArray(n) { arr[it].count { it == '0' } }
    val k = readLine().toInt()
    var answer = 0

    val visit = HashSet<String>()
    repeat(n) { i ->
        var count = 1
        if (zeroCount[i] % 2 != k % 2 || zeroCount[i] > k) {
            return@repeat
        }
        if (visit.contains(arr[i])) {
            return@repeat
        }
        for (j in i + 1..<n) {
            if (arr[i] == arr[j]) {
                count++
            }
        }
        if (answer < count) {
            answer = count
        }
    }
    print(answer)
}
