package year2017.day3

import java.io.File
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

fun spiralMemory(): Int{
    val file = File("src/main/kotlin/year2017/day3/input.txt")
    var idx = 0
    file.forEachLine {
        idx = it.toInt()
    }
    val (xCenter, yCenter) = spiral(1)
    val (x, y) = spiral(idx)
    println("$xCenter $yCenter")
    println("$x $y")
    return abs(x)+abs(y)
}

fun spiral(n: Int): Pair<Int, Int> {
    val k = ((sqrt(n.toDouble()) - 1) / 2).toInt()
    var t = (2 * k + 1)
    var m = t.toDouble().pow(2.0).toInt()
    t -= 1
    if (n >= m - t) {
        return Pair(k - (m - n), -k)
    } else {
        m -= t
    }
    if (n >= m - t) {
        return Pair(-k, -k + (m - n))
    } else {
        m -= t
    }
    return if (n >= m - t) {
        Pair(-k + (m - n), k)
    } else {
        Pair(k, k - (m - n - t))
    }
}

fun main(){
    println(spiralMemory())
}