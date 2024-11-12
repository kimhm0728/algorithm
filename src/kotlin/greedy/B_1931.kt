fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { IntArray(2) }
    repeat(n) {
        arr[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    arr.sortWith { o1, o2 ->
        if (o1[1] == o2[1]) {
            o1[0].compareTo(o2[0])
        } else {
            o1[1].compareTo(o2[1])
        }
    }

    var end = arr[0][1]
    var count = 1
    for (i in 1..<n) {
        if (arr[i][0] < end) {
            continue
        }
        end = arr[i][1]
        count++
    }
    print(count)
}
