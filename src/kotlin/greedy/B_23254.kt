import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val a = readLine().split(" ").map { it.toInt() }
    val b = readLine().split(" ").map { it.toInt() }.toIntArray()

    val pq = PriorityQueue<Score> { o1, o2 -> o2.study - o1.study }
    repeat(m) {
        pq.offer(Score(a[it], b[it]))
    }

    var time = n * 24
    var answer = 0
    while (time > 0 && pq.isNotEmpty()) {
        val score = pq.poll()
        val studyTime = (100 - score.default) / score.study
        if (studyTime <= time) {
            time -= studyTime
            val studyScore = score.default + studyTime * score.study
            if (studyScore == 100) {
                answer += 100
            } else {
                pq.offer(Score(studyScore, 100 - studyScore))
            }
        } else {
            answer += time * score.study + score.default
            time = 0
        }
    }
    pq.forEach {
        answer += it.default
    }
    print(answer)
}

class Score(val default: Int, val study: Int)
