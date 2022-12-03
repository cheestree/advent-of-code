package D3

import java.io.File

fun main(){
    val bufferedReader = File("src/main/kotlin/D3/input.txt").bufferedReader()
    var totalScore = 0
    val array = mutableListOf<CharArray>()

    bufferedReader.useLines { lines ->
        lines.forEach { l ->
            if(l.isNotEmpty()) {
                val line = l.toCharArray()
                if (array.size == 2) {
                    val sets = array.map { l -> l.toSet() }
                    val charIntersect = (sets[0] intersect sets[1] intersect sets[2]).first()
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