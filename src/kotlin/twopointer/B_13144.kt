fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    var count = 0L

    var l = 0
    var e = 0
    val set = HashSet<Int>()
    while (e < n) {
        if (set.contains(arr[e])) {
            while (set.contains(arr[e])) {
                set.remove(arr[l++])
            }
            count += e - l + 1
            set.add(arr[e++])
        } else {
            count += e - l + 1
            set.add(arr[e++])
        }
    }
    print(count)
}
