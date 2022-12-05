package D5

import java.io.File

fun main(){
    val bufferedReader = File("src/main/kotlin/D4/input.txt").bufferedReader()
    var count = 0

    bufferedReader.useLines { lines ->
        lines.forEach { l ->
            val vals = l.split("-",",").map { it.toInt() }
            val firstRange = ((vals[0]..vals[1]).toList())
            val secondRange = ((vals[2]..vals[3]).toList())
            //count += if(vals[0] <= vals[2] && vals[1] >= vals[3] || (vals[2] <= vals[0] && vals[3] >= vals[1] )) 1 else 0
            count += if(firstRange.containsAll(secondRange) || (secondRange).containsAll(firstRange)) 1 else 0
        }
    }
    println(count)
}

//433