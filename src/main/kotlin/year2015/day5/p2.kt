package year2015.day5

import java.io.File

fun doesntHeHaveInternElvesForThis2(): Int{
    val file = File("src/main/kotlin/year2015/day5/input.txt")
    var niceStrings = 0
    file.forEachLine { line ->
        val hasDoubleLetter = Regex("(.)\\1").findAll(line).count()
        //  println(hasDoubleLetter)
        //  if(hasDoubleLetter) niceStrings += 1
    }
    return niceStrings
}

fun main(){
    println(doesntHeHaveInternElvesForThis2())
}