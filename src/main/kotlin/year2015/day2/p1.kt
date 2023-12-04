package year2015.day2

import java.io.File


fun iWasToldThereWasGonnaBeNoMath(): Int {
    val file = File("src/main/kotlin/year2015/day2/input.txt")
    var sumWrappingPaper = 0
    file.forEachLine {
        val values = it.split('x').map { it.toInt() }
        sumWrappingPaper += getWrappingPaper(values[0], values[1], values[2])
    }
    return sumWrappingPaper
}

fun getWrappingPaper(l: Int, w: Int, h: Int): Int = (2*l*w + 2*w*h + 2*h*l) + minOf(minOf(l*w, w*h), h*l)

fun main(){
    println(iWasToldThereWasGonnaBeNoMath())
}