package y2015.d02

import common.Day
import common.Utils.readInput
import java.io.File

object D02 : Day<Int, Int> {
    private fun getWrappingPaper(l: Int, w: Int, h: Int): Int = (2*l*w + 2*w*h + 2*h*l) + minOf(minOf(l*w, w*h), h*l)

    fun getRibbon(l: Int, w: Int, h: Int): Int {
        val mins = listOf(l, w, h).sorted().dropLast(1)
        return l*w*h + mins[0]*2 + mins[1]*2
    }

    override fun p1(): Int {
        val input = readInput()
        var sumWrappingPaper = 0

        input.forEachLine {
            val values = it.split('x').map { it.toInt() }
            sumWrappingPaper += getWrappingPaper(values[0], values[1], values[2])
        }

        return sumWrappingPaper
    }

    override fun p2(): Int {
        TODO("Not yet implemented")
    }
}

