package kotlin.practice

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val m = readLine().split(" ")[1].toInt()

    val truth = mutableSetOf<Int>()

    var st = StringTokenizer(readLine())
    val truthSize = st.nextToken().toInt()

    for (i in 0 until truthSize) {
        truth.add(st.nextToken().toInt())
    }

    val party = mutableListOf<List<Int>>()
    for (i in 0 until m) {
        st = StringTokenizer(readLine())
        val size = st.nextToken().toInt()

        val list = mutableListOf<Int>()
        var flag = false
        for (j in 0 until size) {
            val num = st.nextToken().toInt()
            list.add(num)
            if (!flag && truth.contains(num)) {
                flag = true
            }
        }

        if (flag) truth.addAll(list)
        else party.add(list)
    }

    while (true) {
        val size = party.size
        val remove = mutableListOf<Int>()

        var flag = false
        for (i in 0 until size) {
            if (party[i].any { truth.contains(it) }) {
                truth.addAll(party[i])
                remove.add(i)
                flag = true
            }
        }

        remove.sortDescending()
        for (idx in remove) party.removeAt(idx)
        if (!flag) break
    }

    print(party.size)
}