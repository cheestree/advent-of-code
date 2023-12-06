package year2017.day2

import java.io.File

fun corruptionChecksum2(): Int{
    val file = File("src/main/kotlin/year2017/day2/input.txt")
    var checkSum = 0
    file.forEachLine {
        val values = Regex("([0-9])+").findAll(it).map { it.value.toInt() }.toList()
        checkSum += values.flatMap { num1 ->
            values.mapNotNull { num2 ->
                if (num1 != num2 && (num1 % num2 == 0 || num2 % num1 == 0) && num1/num2 != 0) num1/num2 else null
            }
        }.first()
    }
    return checkSum
}

fun main(){
    println(corruptionChecksum2())
}