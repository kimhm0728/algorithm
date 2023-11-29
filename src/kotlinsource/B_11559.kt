package kotlinsource

private class Main {
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val field = Array(12) { CharArray(6) }
    val visit = Array(12) { BooleanArray(6) }

    fun solution() = with(System.`in`.bufferedReader()) {
        for (i in 0 until 12) {
            field[i] = readLine().toCharArray()
        }

        var count = 0
        while (true) {
            var flag = false
            for (i in 0 until 12) {
                for (j in 0 until 6) {
                    if (field[i][j] != '.' && !visit[i][j] && bfs(i, j)) {
                        flag = true
                    }
                }
            }

            if (flag) {
                count++
                down()
            } else break
            visit.clear()
        }

        print(count)
    }

    private fun Array<BooleanArray>.clear() {
        for (i in 0 until 12) this[i].fill(false)
    }

    private fun bfs(startX: Int, startY: Int): Boolean {
        val c = field[startX][startY]
        val list = mutableListOf<IntArray>()

        visit[startX][startY] = true
        list.add(intArrayOf(startX, startY))

        var max = 1
        var idx = 0
        while (idx < list.size) {
            val now = list[idx++]

            for (i in 0..3) {
                val nextX = now[0] + dx[i]
                val nextY = now[1] + dy[i]

                if (check(nextX, nextY) || visit[nextX][nextY] || c != field[nextX][nextY]) {
                    continue
                }

                visit[nextX][nextY] = true
                list.add(intArrayOf(nextX, nextY))
                max++
            }
        }

        if (max >= 4) {
            list.forEach {
                field[it[0]][it[1]] = '.'
            }
            return true
        }

        return false
    }

    private fun check(x: Int, y: Int) =
        x >= 12 || x < 0 || y >= 6 || y < 0

    private fun down() {
        for (i in 0 until 6) {
            val stack = mutableListOf<Char>()
            for (j in 0 until 12) {
                if (field[j][i] != '.') {
                    stack.add(field[j][i])
                }
                field[j][i] = '.'
            }

            var idx = 11
            while (stack.isNotEmpty()) {
                field[idx--][i] = stack.removeLast()
            }
        }
    }
}

fun main() {
    Main().solution()
}