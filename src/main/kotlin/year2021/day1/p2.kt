package year2021.day1

import java.io.File

fun main() {

    val bufferedReader = File("src/main/kotlin/D1/input.txt").bufferedReader()
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

//1362