package year2023.day4

import java.io.File
import kotlin.math.pow

fun scratchCard(): Int{
    val file = File("src/main/kotlin/year2023/day4/input.txt")
    var sumOfParts = 0.0
    file.forEachLine {
        val parsed = Regex("([0-9])+").findAll(it.split(":")[1]).map { it.value.toInt() }.toList().groupBy { it }.count { it.value.size >= 2 }
        if(parsed != 0) sumOfParts += 2.0.pow(parsed-1)
    }
    return sumOfParts.toInt()
}

fun main(){
    println(scratchCard())
}