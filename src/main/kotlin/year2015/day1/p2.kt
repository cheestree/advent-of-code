package year2015.day1

import java.io.File

fun notQuiteLisp2(): Int {
    val file = File("src/main/kotlin/year2015/day1/input.txt")
    var floor = 0
    var idx = 0
    file.forEachLine {
        it.forEachIndexed { index, c -> if(floor <= -1 ) {
            idx = index
            return@forEachLine
        } else if(c=='(') floor += 1 else floor -= 1 }
    }
    return idx
}

fun main(){
    println(notQuiteLisp2())
}