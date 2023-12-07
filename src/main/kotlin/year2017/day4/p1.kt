package year2017.day4

import java.io.File

fun highEntropyPassphrases(): Int{
    val file = File("src/main/kotlin/year2017/day4/input.txt")
    var count = 0
    file.forEachLine {
        if(!Regex("([A-z]+)").findAll(it).map { it.value }.groupBy { it }.any { it.value.count() > 1 }) count += 1
    }
    return count
}

fun main(){
    println(highEntropyPassphrases())
}