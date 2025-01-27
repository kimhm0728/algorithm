fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine()
        .split(" ")
        .map { it.toInt() }
        .filter { it != 0 }
        .toIntArray()

    if (arr.isEmpty()) {
        print(0)
        return
    }

    var answer = 0
    while (true) {
        for (i in arr.indices) {
            if (arr[i] % 2 == 1) {
                arr[i] -= 1
                answer++
            }
        }
        if (arr.all { it == 0 }) {
            break
        }
        for (i in arr.indices) {
            arr[i] /= 2
        }
        answer++
    }
    print(answer)
}
