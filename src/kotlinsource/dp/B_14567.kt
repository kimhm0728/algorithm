package kotlinsource.dp

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { Prerequisite(0, mutableListOf()) }

    for (cnt in 1..m) {
        val (pre, post) = readLine().split(" ").map { it.toInt() - 1 }
        arr[post].inorder++
        arr[pre].posts.add(post)
    }

    val answer = IntArray(n)
    val decreaseInorder = mutableListOf<Int>()
    var semester = 1
    var cnt = 0

    while (cnt < n) {
        decreaseInorder.clear()
        for (idx in 0 until n) {
            if (arr[idx].inorder != 0) continue

            arr[idx].inorder = -1
            answer[idx] = semester
            decreaseInorder.addAll(arr[idx].posts)
            cnt++
        }
        semester++
        for (post in decreaseInorder) {
            arr[post].inorder--
        }
    }

    print(answer.joinToString(" "))
}

private class Prerequisite(
    var inorder: Int,
    val posts: MutableList<Int>
) : Comparable<Prerequisite> {

    override fun compareTo(other: Prerequisite) =
        this.inorder - other.inorder
}