package year2022.day3

import java.io.File

fun main(){
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