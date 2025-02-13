import java.util.*

val visit = HashSet<Stone>()

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    if ((a + b + c) % 3 != 0) {
        print(0)
        return
    }

    print(bfs(a, b, c))
}

fun bfs(a: Int, b: Int, c: Int): Int {
    val q = LinkedList<Stone>()
    val s = Stone(a, b, c)
    q.offer(s)
    visit.add(s)

    while (q.isNotEmpty()) {
        val now = q.poll()

        if (now.a == now.b && now.b == now.c) {
            return 1
        }

        if (now.a != now.b) {
            val stone = Stone(now.a + now.a, now.b - now.a, now.c)
            if (!visit.contains(stone)) {
                q.offer(stone)
                visit.add(stone)
            }
        }
        if (now.b != now.c) {
            val stone = Stone(now.b + now.b, now.c - now.b, now.a)
            if (!visit.contains(stone)) {
                q.offer(stone)
                visit.add(stone)
            }
        }
        if (now.a != now.c) {
            val stone = Stone(now.a + now.a, now.c - now.a, now.b)
            if (!visit.contains(stone)) {
                q.offer(stone)
                visit.add(stone)
            }
        }
    }

    return 0
}

data class Stone(var a: Int, var b: Int, var c: Int) {
    init {
        val arr = intArrayOf(a, b, c).sorted()
        a = arr[0]
        b = arr[1]
        c = arr[2]
    }
}
