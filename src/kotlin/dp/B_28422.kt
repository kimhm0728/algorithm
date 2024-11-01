import kotlin.math.max

var N = 0
lateinit var cards: IntArray
lateinit var dp: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    dp = IntArray(N) { -1 }
    cards = readLine().split(" ").map { it.toInt() }.toIntArray()
    println(max(solution(0), 0))
}

fun solution(idx: Int): Int {
    if (idx == N) {
        return 0
    }
    if (idx + 1 == N) {
        return Integer.MIN_VALUE
    }
    if (dp[idx] != -1) return dp[idx]

    if (idx + 3 <= N) {
        val score = getScore3(cards[idx], cards[idx + 1], cards[idx + 2])
        dp[idx] = max(dp[idx], solution(idx + 3) + score)
    }
    val score = getScore2(cards[idx], cards[idx + 1])
    dp[idx] = max(dp[idx], solution(idx + 2) + score)
    return dp[idx]
}

fun getScore2(a: Int, b: Int): Int {
    var str1 = a.toString(2)
    var str2 = b.toString(2)

    val maxLen = max(str1.length, str2.length)
    str1 = "0".repeat(maxLen - str1.length) + str1
    str2 = "0".repeat(maxLen - str2.length) + str2

    var score = 0
    for (i in str1.indices) {
        if (str1[i] != str2[i]) {
            score++
        }
    }
    return score
}

fun getScore3(a: Int, b: Int, c: Int): Int {
    var str1 = a.toString(2)
    var str2 = b.toString(2)
    var str3 = c.toString(2)

    val maxLen = max(str1.length, max(str2.length, str3.length))
    str1 = "0".repeat(maxLen - str1.length) + str1
    str2 = "0".repeat(maxLen - str2.length) + str2
    str3 = "0".repeat(maxLen - str3.length) + str3

    var score = 0
    for (i in 0..<maxLen) {
        var count = 0
        if (str1[i] == '1') count++
        if (str2[i] == '1') count++
        if (str3[i] == '1') count++
        if (count % 2 == 1) {
            score++
        }
    }
    return score
}
