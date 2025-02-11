import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp = Array(n) { HashSet<Int>() }
    val m = readLine().toInt()
    val beads = readLine().split(" ").map { it.toInt() }.toIntArray()

    dp[0] = HashSet<Int>().apply {
        add(0)
        add(arr[0])
    }

    for (i in 1..<n) {
        val pre = dp[i - 1]
        val set = HashSet<Int>()
        pre.forEach {
            set.add(it)
            set.add(it + arr[i])
            set.add(abs(arr[i] - it))
        }
        dp[i] = set
    }

    val sb = StringBuilder()
    beads.forEach {
        sb.append(if (dp[n - 1].contains(it)) 'Y' else 'N').append(' ')
    }
    print(sb)
}
