import kotlin.math.pow

val set = HashMap<String, Int>()

fun main() {
    val str = System.`in`.bufferedReader().readLine()
    val n = str.length
    var max = ""
    var m = 0
    var hasK = false
    for (i in n - 1 downTo 0) {
        if (str[i] == 'K') {
            if (hasK) {
                max = "5" + "0".repeat(m) + max
                m = 0
            } else {
                hasK = true
            }
        } else {
            if (hasK) {
                m++
            } else {
                max = "1$max"
            }
        }
    }
    if (hasK) {
        max = "5" + "0".repeat(m) + max
    }

    var min = ""
    m = 0
    for (i in 0..<n) {
        if (str[i] == 'M') {
            m++
        } else {
            if (m > 0) {
                min += "1" + "0".repeat(m - 1)
                m = 0
            }
            min += "5"
        }
    }
    if (m > 0) {
        min += "1" + "0".repeat(m - 1)
    }
    print("$max\n$min")
}
