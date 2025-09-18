package y2022.d06

import common.Day
import common.Utils.readInput
import java.io.File
import kotlin.sequences.forEach

object D06 : Day<Int, Int> {
    override fun p1(): Int {
        val input = readInput()
        var count = 0

        input.useLines { lines ->
            lines.forEach { l ->
                val uniqueLine = l.toCharArray().toList()
                for(i in 0..uniqueLine.size){
                    if(uniqueLine.subList(i,i+4).distinct().size == 4) { count = i+4; break }
                }
            }
        }

        return count
    }

    override fun p2(): Int {
        val input = readInput()
        var count = 0

        input.useLines { lines ->
            lines.forEach { l ->
                val uniqueLine = l.toCharArray().toList()
                for(i in 0..uniqueLine.size){
                    if(uniqueLine.subList(i,i+14).distinct().size == 14) { count = i+14; break }
                }
            }
        }

        return count
    }
}