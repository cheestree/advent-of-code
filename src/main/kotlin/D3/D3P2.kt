package D3

import java.io.File
import kotlin.math.absoluteValue

fun main(){
    val bufferedReader = File("src/main/kotlin/D3/input.txt").bufferedReader()
    var totalScore = 0
    var array = mutableListOf<CharArray>()

    bufferedReader.useLines { lines ->
        lines.forEach { l ->
            val line = l.toCharArray()
            if(l.isNotEmpty()) {
                if (array.size == 2) {
                    array += line
                    val charIntersect = array[0].intersect(array[1].toSet()).intersect(array[2].toSet()).first()
                    totalScore += if (charIntersect in 'a'..'z') (charIntersect - 96).code else (charIntersect - 38).code
                    array = mutableListOf()
                }else{
                    array += line
                }
            }
            println(totalScore)
        }
    }
}