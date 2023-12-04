package year2015.day2

import java.io.File

fun iWasToldThereWasGonnaBeNoMath2(): Int {
    val file = File("src/main/kotlin/year2015/day2/input.txt")
    var sumWrappingPaper = 0
    file.forEachLine {
        val values = it.split('x').map { it.toInt() }
        sumWrappingPaper += getRibbon(values[0], values[1], values[2])
    }
    return sumWrappingPaper
}

fun getRibbon(l: Int, w: Int, h: Int): Int {
    val mins = listOf(l, w, h).sorted().dropLast(1)
    return l*w*h + mins[0]*2 + mins[1]*2
}

fun main(){
    println(iWasToldThereWasGonnaBeNoMath2())
}