fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val function = readLine()
        val n = readLine().toInt()
        val tmp = readLine()
        val deque = ArrayDeque<Int>().also { q ->
            if (tmp != "[]") {
                val tmp1 = tmp
                    .replace("[", "")
                    .replace("]", "")
                    .split(",")
                    .map { it.toInt() }
                tmp1.forEach { q.add(it) }
            }
        }
        var isFirst = true
        function.forEach {
            if (it == 'R') {
                isFirst = !isFirst
            } else {
                if (deque.isEmpty()) {
                    sb.append("error").append('\n')
                    return@repeat
                }
                if (isFirst) deque.removeFirst() else deque.removeLast()
            }
        }
        val result = if (isFirst) deque.toIntArray() else deque.toIntArray().also { it.reverse() }
        sb.append(result.joinToString(prefix = "[", separator = ",", postfix = "]")).append('\n')
    }
    print(sb)
}
