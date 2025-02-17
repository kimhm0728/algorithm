import java.util.*
import kotlin.math.abs

val arr = Array(200_001) { mutableListOf<Int>() }

fun main() = with(System.`in`.bufferedReader()) {
    val (n, t) = readLine().split(" ").map { it.toInt() }
    repeat(n) {
        val input = readLine().split(" ").map { it.toInt() }
        arr[input[1]].add(input[0])
    }
    print(bfs(t))
}

class Rock(val x: Int, val y: Int, val count: Int)

fun bfs(t: Int): Int {
    val q = LinkedList<Rock>()
    q.offer(Rock(0, 0, 0))

    while (q.isNotEmpty()) {
        val now = q.poll()
        if (now.y == t) {
            return now.count
        }

        for (nextY in now.y - 2..now.y + 2) {
            if (nextY !in 0..200000) {
                continue
            }
            var idx = 0
            while (idx < arr[nextY].size) {
                val nextX = arr[nextY][idx]
                if (abs(nextX - now.x) > 2) {
                    idx++
                    continue
                }
                q.offer(Rock(nextX, nextY, now.count + 1))
                arr[nextY].removeAt(idx)
            }
        }
    }
    return -1
}
