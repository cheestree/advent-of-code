package y2022.d06

import java.io.File
import kotlin.sequences.forEach

object D06 {
    fun p1() {
        val bufferedReader = File("src/main/kotlin/year2022/day6/input.txt").bufferedReader()
        var count = 0

        bufferedReader.useLines { lines ->
            lines.forEach { l ->
                val uniqueLine = l.toCharArray().toList()
                for(i in 0..uniqueLine.size){
                    if(uniqueLine.subList(i,i+4).distinct().size == 4) { count = i+4; break }
                }
            }
        }
        println(count)

    }

    fun p2() {
        val bufferedReader = File("src/main/kotlin/year2022/day6/input.txt").bufferedReader()
        var count = 0

        bufferedReader.useLines { lines ->
            lines.forEach { l ->
                val uniqueLine = l.toCharArray().toList()
                for(i in 0..uniqueLine.size){
                    if(uniqueLine.subList(i,i+14).distinct().size == 14) { count = i+14; break }
                }
            }
        }
        println(count)
    }
}