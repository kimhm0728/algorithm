fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { "" }
    var len = 0
    repeat(n) {
        arr[it] = readLine()
        len += arr[it].length
    }
    val lines = "_".repeat((m - len) / (n - 1))
    val additionalLines = lines + "_"
    var additionalCount = (m - len) % (n - 1)

    val additionalPosition = HashSet<Int>()
    if (additionalCount > 0) {
        for (i in 1..<n) {
            if (arr[i][0].isLowerCase()) {
                additionalPosition.add(i - 1)
                additionalCount--
                if (additionalCount == 0) {
                    break
                }
            }
        }
    }
    if (additionalCount > 0) {
        for (i in n - 1 downTo 0) {
            if (arr[i][0].isUpperCase()) {
                additionalPosition.add(i - 1)
                additionalCount--
            }
            if (additionalCount == 0) {
                break
            }
        }
    }

    val sb = StringBuilder(arr[0])
    for (i in 0..n - 2) {
        if (additionalPosition.contains(i)) {
            sb.append(additionalLines)
        } else {
            sb.append(lines)
        }
        sb.append(arr[i + 1])
    }
    print(sb)
}
