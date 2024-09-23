package kotlin.practice

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }.toMutableList()
    val nge = mutableListOf<Int>()

    val answer = IntArray(n)

    for (idx in n - 1 downTo 0) {
        answer[idx] = findNGE(list[idx], nge)
    }

    print(answer.joinToString(" "))
}

private fun findNGE(element: Int, nge: MutableList<Int>): Int {
    while (nge.isNotEmpty()) {
        val last = nge.last()
        if (element < last) {
            nge.add(element)
            return last
        }

        nge.removeLast()
    }

    nge.add(element)
    return -1
}