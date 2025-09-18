package y2022.d04

import common.Day
import common.Utils.readInput
import java.io.File
import kotlin.sequences.forEach

object D04 : Day<Int, Int> {
    override fun p1(): Int {
        val input = readInput()
        var count = 0

        input.useLines { lines ->
            lines.forEach { l ->
                val vals = l.split("-",",").map { it.toInt() }
                val firstRange = ((vals[0]..vals[1]).toList())
                val secondRange = ((vals[2]..vals[3]).toList())
                //count += if(vals[0] <= vals[2] && vals[1] >= vals[3] || (vals[2] <= vals[0] && vals[3] >= vals[1] )) 1 else 0
                count += if(firstRange.containsAll(secondRange) || (secondRange).containsAll(firstRange)) 1 else 0
            }
        }

        return count
    }

    override fun p2(): Int {
        val input = readInput()
        var count = 0

        input.useLines { lines ->
            lines.forEach { l ->
                val vals = l.split("-",",").map { it.toInt() }
                val firstRange = ((vals[0]..vals[1]).toList())
                val secondRange = ((vals[2]..vals[3]).toList())
                //count += if(vals[0] <= vals[2] && vals[1] >= vals[3] || (vals[2] <= vals[0] && vals[3] >= vals[1] )) 1 else 0
                count += if(firstRange.intersect(secondRange).isNotEmpty() || (secondRange).intersect(firstRange).isNotEmpty()) 1 else 0
            }
        }

        return count
    }
}