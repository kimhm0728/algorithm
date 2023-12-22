package kotlinsource

fun main() {
    val div = 9901
    val n = System.`in`.bufferedReader().readLine().toInt()
    val arr = Array(n) { IntArray(3) }
    arr[0][0] = 1
    arr[0][1] = 1
    arr[0][2] = 1

    for (idx in 1 until n) {
        arr[idx][0] = (arr[idx - 1][0] + arr[idx - 1][1] + arr[idx - 1][2]) % div
        arr[idx][1] = (arr[idx - 1][0] + arr[idx - 1][2]) % div
        arr[idx][2] = (arr[idx - 1][0] + arr[idx - 1][1]) % div
    }

    println((arr[n - 1][0] + arr[n - 1][1] + arr[n - 1][2]) % 9901)
}