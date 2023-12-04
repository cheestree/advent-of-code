package year2015.day1

import java.io.File

fun notQuiteLisp(): Int {
    val file = File("src/main/kotlin/year2015/day1/input.txt")
    var floor = 0
    file.forEachLine { it.forEachIndexed { index, c -> if(c=='(') floor += 1 else floor -= 1 } }
    return floor
}

fun main(){
    println(notQuiteLisp())
}