package kotlinsource.dp

import kotlin.math.max
import kotlin.math.min

class B_2096 {
    operator fun invoke() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val maxDp = readLine().split(" ").map { it.toInt() }.toIntArray()
        val minDp = maxDp.clone()

        for (idx in 1 until n) {
            val (x0, x1, x2) = readLine().split(" ").map { it.toInt() }

            val (tempMax0, tempMax1) = maxDp
            maxDp[0] = max(maxDp[0], maxDp[1]) + x0
            maxDp[1] = max(tempMax0, max(maxDp[1], maxDp[2])) + x1
            maxDp[2] = max(tempMax1, maxDp[2]) + x2

            val (tempMin0, tempMin1) = minDp
            minDp[0] = min(minDp[0], minDp[1]) + x0
            minDp[1] = min(tempMin0, max(minDp[1], minDp[2])) + x1
            minDp[2] = min(tempMin1, minDp[2]) + x2
        }

        val max = maxDp.max()
        val min = minDp.min()
        print("$max $min")
    }
}

fun main() {
    B_2096()()
}