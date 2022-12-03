package D3

import java.io.File

fun main(){
    val bufferedReader = File("src/main/kotlin/D3/input.txt").bufferedReader()
    var totalScore = 0

    bufferedReader.useLines { lines ->
        lines.forEach { l ->
            val toCharArray = l.toCharArray()
            var firstHalf = toCharArray.dropLast(toCharArray.size/2)
            var secondHalf = toCharArray.drop(toCharArray.size/2)
            val charsIntersect = firstHalf.intersect(secondHalf.toSet()).first()
            totalScore += if(charsIntersect in 'a'..'z') (charsIntersect - 96).code else (charsIntersect - 38).code
        }
    }
    println(totalScore)
}