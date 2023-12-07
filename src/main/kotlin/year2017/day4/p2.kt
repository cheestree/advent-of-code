package year2017.day4

import java.io.File

fun highEntropyPassphrases2(): Int{
    val file = File("src/main/kotlin/year2017/day4/input.txt")
    var count = 0
    file.forEachLine { line ->
        val words = Regex("([A-Za-z]+)").findAll(line).map { it.value }.toList()
        var isValidPassphrase = true
        for ((index, wordToCheck) in words.withIndex()) {
            val otherWords = words.filterIndexed { i, _ -> i != index }
            if (canFormWord(wordToCheck, *otherWords.toTypedArray())) {
                isValidPassphrase = false
                break
            }
        }
        if (isValidPassphrase) {
            count += 1
        }
    }
    return count
}

fun canFormWord(source: String, vararg words: String): Boolean {
    val sourceCharCount = source.groupingBy { it }.eachCount()
    for (word in words) {
        val wordCharCount = word.groupingBy { it }.eachCount()
        if (sourceCharCount == wordCharCount) {
            return true
        }
    }
    return false
}

fun main(){
    println(highEntropyPassphrases2())
}