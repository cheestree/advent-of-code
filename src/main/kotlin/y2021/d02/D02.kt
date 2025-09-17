package y2021.d02

import java.io.File
import kotlin.sequences.forEach

object D02 {
    fun p1() {
        val bufferedReader = File("src/main/kotlin/year2022/day2/input.txt").bufferedReader()
        var horizontal = 0
        var depth = 0

        bufferedReader.useLines {
                lines -> lines.forEach { l ->
            val vals = l.split(" ")
            when(vals[0]){
                "up" -> depth -= vals[1].toInt()
                "down" -> depth += vals[1].toInt()
                "forward" -> horizontal += vals[1].toInt()
            }
        }
        }
        println(horizontal*depth)
    }

    fun p2() {
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
}