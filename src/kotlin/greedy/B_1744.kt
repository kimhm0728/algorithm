fun main() = with(System.`in`.bufferedReader()) {
    val max = 1001
    val n = readLine().toInt()
    val arr = IntArray(n) { readLine().toInt() }.sorted()

    var zero = 0
    var negative = 0
    for (i in arr) {
        if (i == 0) {
            zero++
        } else if (i < 0) {
            negative++
        }
    }
    var answer = 0
    if (negative > 0) {
        var count = 0
        var temp = 0
        val block: () -> Boolean = if (zero > 0 && negative % 2 == 1) {
            { count + 1 == negative }
        } else {
            { count == negative }
        }
        for (i in 0..<n) {
            if (arr[i] < 0) {
                count++
                if (temp == 0) {
                    temp = arr[i]
                } else {
                    answer += temp * arr[i]
                    temp = 0
                }
                if (block()) {
                    break
                }
            }
        }
        if (temp != 0 && !(zero > 0 && negative % 2 == 1)) answer += temp
    }
    var temp = max
    for (i in n - 1 downTo 0) {
        if (arr[i] <= 0) {
            break
        }
        if (temp == max) {
            temp = arr[i]
        } else {
            if (temp == 1 || arr[i] == 1 || arr[i] == 0) {
                answer += temp + arr[i]
            } else {
                answer += temp * arr[i]
            }
            temp = max
        }
    }
    print(if (temp == max) answer else answer + temp)
}
