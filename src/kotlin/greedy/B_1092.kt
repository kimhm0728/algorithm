fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val m = readLine().toInt()
    val box = readLine().split(" ").map { it.toInt() }.sortedDescending().toMutableList()
    val crane = arr.filter { box.last() <= it }.sortedDescending().toIntArray()

    if (crane.isEmpty() || crane[0] < box[0]) {
        print(-1)
        return
    }

    val temp = mutableListOf<Int>()
    var answer = 0
    var idx = 0
    while (box.isNotEmpty() || temp.isNotEmpty()) {
        if (box.isEmpty() || idx == crane.size || box.last() > crane[idx]) {
            idx = 0
            answer++
            box.addAll(temp)
            temp.clear()
            box.sortDescending()
            continue
        }

        val now = box.first()
        box.removeAt(0)
        if (now <= crane[idx]) {
            idx++
        } else {
            temp.add(now)
        }
    }
    if (idx > 0) {
        answer++
    }
    print(answer)
}
