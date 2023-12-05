package year2015.day5

import java.io.File

fun doesntHeHaveInternElvesForThis(): Int{
    val file = File("src/main/kotlin/year2015/day5/input.txt")
    var niceStrings = 0
    file.forEachLine { line ->
        val hasVowels = Regex("[aeiouAEIOU]").findAll(line).count() >= 3
        val hasForbiddenGroups = Regex("ab|cd|pq|xy").find(line) == null
        val hasDoubleLetter = Regex("(.)\\1").find(line) != null
        if(hasVowels && hasForbiddenGroups && hasDoubleLetter) niceStrings += 1
    }
    return niceStrings
}

fun main(){
    println(doesntHeHaveInternElvesForThis())
}