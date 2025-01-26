fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { readLine() }
    val len = arr.sumOf { it.length }
    val short = "_".repeat((m - len) / (n - 1))
    val long = short + "_"
    var cnt = (m - len) % (n - 1)

    val pos = HashSet<Int>()
    if (cnt > 0) {
        for (i in 1..<n) {
            if (arr[i][0].isLowerCase()) {
                pos.add(i - 1)
                cnt--
                if (cnt == 0) {
                    break
                }
            }
        }
    }
    if (cnt > 0) {
        for (i in n - 1 downTo 0) {
            if (arr[i][0].isUpperCase()) {
                pos.add(i - 1)
                cnt--
                if (cnt == 0) {
                    break
                }
            }
        }
    }

    val sb = StringBuilder(arr[0])
    for (i in 0..n - 2) {
        if (pos.contains(i)) {
            sb.append(long)
        } else {
            sb.append(short)
        }
        sb.append(arr[i + 1])
    }
    print(sb)
}
