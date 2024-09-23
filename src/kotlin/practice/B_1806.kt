package kotlin.practice

fun main() = with(System.`in`.bufferedReader()) {
    val (n, s) = readLine().toIntList()
    val arr = readLine().toIntList().toIntArray()

    val max = 100001
    var answer = max

    for (idx in 0 until n) {
        if (arr[idx] >= s) answer = 1
        if (idx == 0) continue
        arr[idx] += arr[idx - 1]
    }

    for (i in 2 until n) {
        if (arr[i] < s) continue
        answer = if (answer > i + 1) i + 1 else answer

        for (j in i - 2 downTo 0) {
            if (arr[i] - arr[j] >= s) {
                answer = if (answer > i - j) i - j else answer
                break
            }
        }
    }

    print(if (answer == max) 0 else answer)
}

private fun String.toIntList() =
    this.split(" ").map { it.toInt() }