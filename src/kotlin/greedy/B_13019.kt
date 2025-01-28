fun main() = with(System.`in`.bufferedReader()) {
    val a = readLine()
    val b = readLine()

    val countA = IntArray(26)
    val countB = IntArray(26)
    repeat(a.length) {
        countA[a[it] - 'A']++
        countB[b[it] - 'A']++
    }
    repeat(26) {
        if (countA[it] != countB[it]) {
            print(-1)
            return
        }
    }

    var idxA = a.length - 1
    var idxB = a.length - 1
    var count = 0
    while (idxA >= 0) {
        if (a[idxA] == b[idxB]) {
            idxA--
            idxB--
        } else {
            idxA--
            count++
        }
    }
    print(count)
}
