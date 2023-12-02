package year2021.day1

import java.io.File

fun main() {

    val bufferedReader = File("src/main/kotlin/D1/input.txt").bufferedReader()
    var count = 0
    var prev = 0

    bufferedReader.useLines {
        lines -> lines.forEach { l ->
            if(l.toInt() > prev) {
                count++
            }
        prev = l.toInt()
        }
    }
    println(count-1)
}