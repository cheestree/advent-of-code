package year2023.day6

import java.io.File

fun waitForIt(): Int{
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

fun main(){
    println(waitForIt())
}