package y2023.d06

import java.io.File

object D06 {
    fun p1() {
        val file = File("src/main/kotlin/year2023/day6/input.txt")
        var mult = 1
        val time = mutableListOf<Int>()
        val distance = mutableListOf<Int>()
        file.forEachLine {
            if(time.isEmpty()) time.addAll(Regex("([0-9]+)").findAll(it).toList().map { it.value.toInt() }) else distance.addAll(Regex("([0-9]+)").findAll(it).toList().map { it.value.toInt() })
        }
        time.forEachIndexed { index, i ->
            mult *= (1 until i).count { (i - it) * it > distance[index] }
        }
        return mult
    }

    fun p2() {
        val file = File("src/main/kotlin/year2023/day6/input.txt")
        var time: Long? = null
        var distance: Long? = null
        file.forEachLine {
            if (time == null) time = it.split(":")[1].trim().replace(" ", "").toLong() else
                distance = it.split(":")[1].trim().replace(" ", "").toLong()
        }
        return (1 until time!!).count { (time!! - it) * it > distance!! }
    }
}