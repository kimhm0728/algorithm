import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val target = StringBuilder()
        repeat(3) {
            target.append(readLine())
        }
        sb.append(bfs(target.toString())).append('\n')
    }
    print(sb)
}

fun bfs(target: String): Int {
    val q = LinkedList<Reverse>()
    val visit = HashSet<String>()
    val initial = "........."
    q.offer(Reverse(initial, 0))
    visit.add(initial)

    while (q.isNotEmpty()) {
        val now = q.poll()

        if (now.board == target) {
            return now.count
        }

        repeat(9) { idx ->
            val board = StringBuilder(now.board)
            board.update(idx)
            board.update(idx - 3)
            board.update(idx + 3)
            if (idx % 3 != 0) {
                board.update(idx - 1)
            }
            if (idx % 3 != 2) {
                board.update(idx + 1)
            }
            val boardString = board.toString()
            if (visit.contains(boardString)) {
                return@repeat
            }
            q.offer(Reverse(boardString, now.count + 1))
            visit.add(boardString)
        }
    }
    return -1
}

fun StringBuilder.update(idx: Int) {
    if (idx !in 0..8) {
        return
    }
    if (this[idx] == '*') {
        replace(idx, idx + 1, ".")
    } else {
        replace(idx, idx + 1, "*")
    }
}

class Reverse(val board: String, val count: Int)
