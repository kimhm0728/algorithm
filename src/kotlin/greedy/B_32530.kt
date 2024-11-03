fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n)
    repeat(n) {
        val input = readLine().split(":").map { it.toInt() }
        arr[it] = input[0] * 60 + input[1]
    }
    arr.sort()
    var isStart = true
    var time = 0
    var count = 0
    var idx = 0
    while(idx < n) {
        if (isStart) {
            isStart = false
            count++
            time = arr[idx] + 10
            idx++
        } else {
            if (time >= arr[idx] - 10) {
                idx++
            } else {
                isStart = true
                continue
            }
        }
    }
    print(count)
}
