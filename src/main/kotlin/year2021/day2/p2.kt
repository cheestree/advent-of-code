package year2021.day2

import java.io.File

fun main() {

    val bufferedReader = File("src/main/kotlin/year2022/day2/input.txt").bufferedReader()
    var horizontal = 0
    var depth = 0
    var aim = 0

    bufferedReader.useLines {
            lines -> lines.forEach { l ->
        val vals = l.split(" ")
        when(vals[0]){
            "up" -> { aim -= vals[1].toInt() }
            "down" -> { aim += vals[1].toInt() }
            "forward" -> { horizontal += vals[1].toInt(); depth += aim * vals[1].toInt() }
        }
    }
    }
    println("$horizontal $depth")
    println(horizontal*depth)
}