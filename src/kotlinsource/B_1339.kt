package kotlinsource

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val words = mutableListOf<CharArray>()
    val map = mutableMapOf<Char, Int>()

    for (i in 0 until n) {
        readLine().toCharArray().also { arr ->
            words.add(arr)

            val size = arr.size
            var value = 10

            for (j in size - 1 downTo 0) {
                map[arr[j]] = map.getOrDefault(arr[j], 0) + value
                value *= 10
            }
        }
    }

    val entries = map.entries.sortedWith(
        compareByDescending { it.value }
    )

    val match = IntArray(26)
    var num = 9

    entries.forEach { entry ->
        match[entry.key - 'A'] = num--
    }

    var answer = 0
    words.forEach { arr ->
        val sb = StringBuilder()
        arr.forEach { sb.append(match[it - 'A']) }
        answer += sb.toString().toInt()
    }

    print(answer)
}