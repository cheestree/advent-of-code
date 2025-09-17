package y2015.d02

import common.Utils.readResource
import java.io.File

object D02 {
    fun getWrappingPaper(l: Int, w: Int, h: Int): Int = (2*l*w + 2*w*h + 2*h*l) + minOf(minOf(l*w, w*h), h*l)

    fun iWasToldThereWasGonnaBeNoMath(): Int {
        val file = readResource("/y2025/d02/input.txt")
        var sumWrappingPaper = 0
        file.forEachLine {
            val values = it.split('x').map { it.toInt() }
            sumWrappingPaper += getWrappingPaper(values[0], values[1], values[2])
        }
        return sumWrappingPaper
    }

    fun getRibbon(l: Int, w: Int, h: Int): Int {
        val mins = listOf(l, w, h).sorted().dropLast(1)
        return l*w*h + mins[0]*2 + mins[1]*2
    }
}

