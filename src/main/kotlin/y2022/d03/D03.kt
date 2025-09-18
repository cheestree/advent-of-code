package y2022.d03

import common.Day
import common.Utils.readInput
import java.io.File
import kotlin.sequences.forEach

object D03 : Day<Int, Int> {
    override fun p1(): Int {
        val input = readInput()
        var totalScore = 0

        input.useLines { lines ->
            lines.forEach { l ->
                val toCharArray = l.toCharArray()
                val firstHalf = toCharArray.dropLast(toCharArray.size/2).toSet()
                val secondHalf = toCharArray.drop(toCharArray.size/2).toSet()
                val charsIntersect = firstHalf.intersect(secondHalf).first()
                totalScore += if(charsIntersect in 'a'..'z') (charsIntersect - 96).code else (charsIntersect - 38).code
            }
        }

        return totalScore
    }

    override fun p2(): Int  {
        val input = readInput()
        var totalScore = 0
        val array = mutableListOf<Set<Char>>()

        input.useLines { lines ->
            lines.forEach { l ->
                if(l.isNotEmpty()) {
                    val line = l.toCharArray().toSet()
                    if (array.size == 2) {
                        val charIntersect = (array[0] intersect array[1] intersect array[2]).first()
                        totalScore += if (charIntersect in 'a'..'z') (charIntersect - 96).code else (charIntersect - 38).code
                        array.clear()
                    }else{
                        array += line
                    }
                }
            }
        }

        return totalScore
    }
}