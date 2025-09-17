package y2022.d03

import java.io.File
import kotlin.sequences.forEach

object D03 {
    fun p1() {
        val bufferedReader = File("src/main/kotlin/year2022/day3/input.txt").bufferedReader()
        var totalScore = 0

        bufferedReader.useLines { lines ->
            lines.forEach { l ->
                val toCharArray = l.toCharArray()
                val firstHalf = toCharArray.dropLast(toCharArray.size/2).toSet()
                val secondHalf = toCharArray.drop(toCharArray.size/2).toSet()
                val charsIntersect = firstHalf.intersect(secondHalf).first()
                totalScore += if(charsIntersect in 'a'..'z') (charsIntersect - 96).code else (charsIntersect - 38).code
            }
        }
        println(totalScore)
    }

    fun p2() {
        val bufferedReader = File("src/main/kotlin/year2022/day3/input.txt").bufferedReader()
        var totalScore = 0
        val array = mutableListOf<Set<Char>>()

        bufferedReader.useLines { lines ->
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
                println(totalScore)
            }
        }
    }
}