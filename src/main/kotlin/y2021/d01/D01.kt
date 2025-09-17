package y2021.d01

import java.io.File
import kotlin.sequences.forEach

object D01 {
    fun p1() {
        val bufferedReader = File("src/main/kotlin/year2022/day1/input.txt").bufferedReader()
        var count = 0
        var prev = 0

        bufferedReader.useLines {
                lines -> lines.forEach { l ->
            if(l.toInt() > prev) {
                count++
            }
            prev = l.toInt()
        }
        }
        println(count-1)
    }

    fun p2() {
        val bufferedReader = File("src/main/kotlin/year2022/day1/input.txt").bufferedReader()
        var count = 0
        var prev = mutableListOf<Int>()

        bufferedReader.useLines {
            lines -> lines.forEach { l ->
                if(l.isNotEmpty()){
                    if(prev.size < 3){
                        prev.add(l.toInt())
                    }else{
                        if(prev.sum() < (prev.drop(1) + l.toInt()).sum()) count++
                    }
                    prev = (prev.drop(1) + l.toInt()).toMutableList()
                }
            }
        }
        println(count)
    }
}