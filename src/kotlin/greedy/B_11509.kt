import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val map = HashMap<Int, Int>() // 화살 높이, 개수

    var answer = 0
    repeat(n) {
        val h = st.nextToken().toInt()
        val count = map[h + 1]
        if (count != null) {
            if (count == 1) {
                map.remove(h + 1)
            } else {
                map[h + 1] = count - 1
            }
            map[h] = map.getOrPut(h) { 0 } + 1
        } else {
            map[h] = map.getOrPut(h) { 0 } + 1
            answer++
        }
    }
    print(answer)
}
