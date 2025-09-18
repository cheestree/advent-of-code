package y2023.d06

import common.Day
import common.Utils.readInput
import java.io.File

object D06 : Day<Int, Int> {
    override fun p1(): Int {
        val input = readInput()
        var mult = 1
        val time = mutableListOf<Int>()
        val distance = mutableListOf<Int>()

        input.forEachLine {
            if(time.isEmpty()) time.addAll(Regex("([0-9]+)").findAll(it).toList().map { it.value.toInt() }) else distance.addAll(Regex("([0-9]+)").findAll(it).toList().map { it.value.toInt() })
        }
        time.forEachIndexed { index, i ->
            mult *= (1 until i).count { (i - it) * it > distance[index] }
        }

        return mult
    }

    override fun p2(): Int {
        val input = readInput()
        var time: Long? = null
        var distance: Long? = null

        input.forEachLine {
            if (time == null) time = it.split(":")[1].trim().replace(" ", "").toLong() else
                distance = it.split(":")[1].trim().replace(" ", "").toLong()
        }

        return (1 until time!!).count { (time!! - it) * it > distance!! }
    }
}