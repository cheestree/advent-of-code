package y2021.d02

import common.Day
import common.Utils.readInput
import java.io.File
import kotlin.sequences.forEach

object D02 : Day<Int, Int> {
    override fun p1(): Int {
        val input = readInput()
        var horizontal = 0
        var depth = 0

        input.useLines {
            lines -> lines.forEach { l ->
                val vals = l.split(" ")
                when(vals[0]){
                    "up" -> depth -= vals[1].toInt()
                    "down" -> depth += vals[1].toInt()
                    "forward" -> horizontal += vals[1].toInt()
                }
            }
        }

        return horizontal*depth
    }

    override fun p2(): Int {
        val input = readInput()
        var horizontal = 0
        var depth = 0
        var aim = 0

        input.useLines {
            lines -> lines.forEach { l ->
                val vals = l.split(" ")
                when(vals[0]){
                    "up" -> { aim -= vals[1].toInt() }
                    "down" -> { aim += vals[1].toInt() }
                    "forward" -> { horizontal += vals[1].toInt(); depth += aim * vals[1].toInt() }
                }
            }
        }

        return horizontal*depth
    }
}