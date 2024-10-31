fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val dababas = HashSet<Dababa>()
    val count = HashSet<Dababa>()

    val dx = intArrayOf(0, 0, -2, 2)
    val dy = intArrayOf(-2, 2, 0, 0)

    repeat(k) {
        val (x, y) = readLine().split(" ").map { it.toInt() - 1 }
        dababas.add(Dababa(x, y))
    }

    dababas.forEach { dababa ->
        repeat(4) { j ->
            val nextX = dababa.x + dx[j]
            val nextY = dababa.y + dy[j]
            val nextDababa = Dababa(nextX, nextY)

            if (nextX in 0..<n && nextY in 0..<n && !dababas.contains(nextDababa)) {
                count.add(Dababa(nextX, nextY))
            }
        }
    }

    print(count.size)
}

data class Dababa(val x: Int, val y: Int)
