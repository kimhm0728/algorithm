fun main() = with(System.`in`.bufferedReader()) {
    val len = readLine().toInt()
    val s1 = readLine()
    val s2 = readLine()

    val arr = IntArray('Z' - 'A' + 1)
    repeat(len) {
        arr[s1[it] - 'a']++
        arr[s2[it] - 'a']--
    }
    repeat('Z' - 'A' + 1) {
        if (arr[it] != 0) {
            print("NO")
            return@with
        }
    }

    if (s1.toCharArray().toSet().size == 1 || s2.toCharArray().toSet().size == 1) {
        print("NO")
        return@with
    }

    if (s1.first() != s2.first() || s1.last() != s2.last()) {
        print("NO")
        return@with
    }

    if (replace(s1) != replace(s2)) {
        print("NO")
        return@with
    }

    print("YES")
}

private fun replace(s: String): String {
    return s.replace("a", "")
        .replace("e", "")
        .replace("i", "")
        .replace("o", "")
        .replace("u", "")
}
