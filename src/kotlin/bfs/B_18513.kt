import java.util.HashMap
import java.util.LinkedList

lateinit var set: HashSet<Int>
val dir = intArrayOf(-1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    set = readLine().split(" ").map { it.toInt() }.toHashSet()
    print(bfs(k))
}

fun bfs(k: Int): Long {
    val house = HashMap<Int, Int>()
    val q = LinkedList<House>()
    set.forEach {
        q.offer(House(it, 0))
    }

    while (house.size < k) {
        val now = q.poll()

        dir.forEach {
            val next = now.pos + it
            if (house.size >= k || set.contains(next) || house.containsKey(next)) {
                return@forEach
            }
            house[next] = now.happy + 1
            q.offer(House(next, now.happy + 1))
        }
    }

    return house.values.fold(0L) { acc, happy -> acc + happy }
}

class House(val pos: Int, val happy: Int)
