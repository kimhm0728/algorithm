package kotlinsource

private class B_14890 {
    private var n = 0
    private var l = 0
    lateinit var arr: Array<IntArray>

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().toIntList().let {
            n = it[0]
            l = it[1]
        }

        arr = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            arr[i] = readLine().toIntList().toIntArray()
        }

        var answer = 0
        for (i in 0 until n) {
            if (check(0, i, 1, 0)) answer++
            if (check(i, 0, 0, 1)) answer++
        }

        print(answer)
    }

    private fun check(startR: Int, startC: Int, addR: Int, addC: Int): Boolean {
        var value = arr[startR][startC]
        var r = startR
        var c = startC
        var cntValue = 1
        var cntMin = 0

        for (i in 0 until n - 1) {
            r += addR
            c += addC

            if (arr[r][c] == value && cntMin == 0) {
                cntValue++
                continue
            }

            if (arr[r][c] + 1 == value) {
                if (++cntMin < l) continue

                value = arr[r][c]
                cntValue = 0
                cntMin = 0
                continue
            }

            if (arr[r][c] == value + 1) {
                if (cntValue < l) return false

                value = arr[r][c]
                cntValue = 1
                continue
            }

            return false
        }

        return (cntMin == 0)
    }

    private fun String.toIntList() = this.split(" ").map { it.toInt() }
}

fun main() {
    B_14890().solution()
}