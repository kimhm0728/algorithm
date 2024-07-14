/* 위상 정렬 풀이 */
// fun main() = with(System.`in`.bufferedReader()) {
//     val (n, m) = readLine().split(" ").map { it.toInt() }
//     val arr = Array(n) { Prerequisite(0, mutableListOf()) }

//     for (cnt in 1..m) {
//         val (pre, post) = readLine().split(" ").map { it.toInt() - 1 }
//         arr[post].inorder++
//         arr[pre].posts.add(post)
//     }

//     val answer = IntArray(n)
//     val decreaseInorder = mutableListOf<Int>()
//     var semester = 1
//     var cnt = 0

//     while (cnt < n) {
//         decreaseInorder.clear()
//         for (idx in 0 until n) {
//             if (arr[idx].inorder != 0) continue

//             arr[idx].inorder = -1
//             answer[idx] = semester
//             decreaseInorder.addAll(arr[idx].posts)
//             cnt++
//         }
//         semester++
//         for (post in decreaseInorder) {
//             arr[post].inorder--
//         }
//     }

//     print(answer.joinToString(" "))
// }

// private class Prerequisite(
//     var inorder: Int,
//     val posts: MutableList<Int>
// ) : Comparable<Prerequisite> {

//     override fun compareTo(other: Prerequisite) =
//         this.inorder - other.inorder
// }

/* 다이나믹 프로그래밍 풀이 */
import kotlin.math.max

lateinit var arr: Array<MutableList<Int>>
lateinit var dp: IntArray
const val INIT_VALUE = Int.MIN_VALUE

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    arr = Array(n) { mutableListOf() }
    dp = IntArray(n) { INIT_VALUE }

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() - 1 }
        arr[b].add(a)
    }

    val sb = StringBuilder()
    (0..<n).forEach { sb.append(solution(it)).append(" ") }
    println(sb)
}

fun solution(n: Int): Int {
    if (dp[n] != INIT_VALUE) return dp[n]
    arr[n].forEach {
        dp[n] = max(dp[n], solution(it) + 1)
    }
    if (dp[n] == INIT_VALUE) dp[n] = 1
    return dp[n]
}
