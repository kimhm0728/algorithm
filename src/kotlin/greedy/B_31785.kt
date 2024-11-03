import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(500_001)
    var front = 0
    var back = 0
    val sb = StringBuilder()
    repeat(n) {
        val q = readLine().split(" ").map { it.toInt() }
        if (q.first() == 1) {
            val number = q.last()
            back++
            arr[back] = arr[back - 1] + number
        } else {
            val mid = (front + back) / 2
            val preSum = arr[mid] - arr[front]
            val postSum = arr[back] - arr[mid]

            if (preSum <= postSum) {
                sb.append(preSum).append('\n')
                front = mid
            } else {
                sb.append(postSum).append('\n')
                back = mid
            }
        }
    }
    for (idx in front + 1..back) {
        sb.append(arr[idx] - arr[idx - 1]).append(' ')
    }
    print(sb)
}
