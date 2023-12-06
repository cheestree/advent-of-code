package year2017.day2

import java.io.File

fun corruptionChecksum(): Int{
    val file = File("src/main/kotlin/year2017/day2/input.txt")
    var checkSum = 0
    file.forEachLine {
        val values = Regex("([0-9])+").findAll(it).map { it.value.toInt() }
        checkSum += (values.maxOrNull()?.minus(values.minOrNull()!!)!!)
    }
    return checkSum
}

fun main(){
    println(corruptionChecksum())
}