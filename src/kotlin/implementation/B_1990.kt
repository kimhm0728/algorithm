import kotlin.math.sqrt

val isPrime = BooleanArray(100_000_001)

fun main() = with(System.`in`.bufferedReader()) {
    val (a, b) = readLine().split(" ").map { it.toInt() }
    primes(b)
    val sb = StringBuilder()
    for (i in a..b) {
        if (!isPrime[i] && isPalindrome(i.toString())) {
            sb.append(i).append('\n')
        }
    }
    sb.append(-1)
    print(sb)
}

fun primes(max: Int) {
    for (i in 2..sqrt(max.toDouble()).toInt()) {
        if (isPrime[i]) {
            continue
        }
        for (j in i * i..max step (i)) {
            isPrime[j] = true
        }
    }
}

fun isPalindrome(s: String): Boolean {
    if (s.length == 1) {
        return true
    }
    val reverse = StringBuilder(s).reverse().toString()
    return reverse == s
}
