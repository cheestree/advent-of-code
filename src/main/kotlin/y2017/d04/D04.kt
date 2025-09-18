package y2017.d04

import common.Day
import common.Utils.readInput
import java.io.File

object D04 : Day<Int, Int> {
    private fun canFormWord(source: String, vararg words: String): Boolean {
        val sourceCharCount = source.groupingBy { it }.eachCount()

        for (word in words) {
            val wordCharCount = word.groupingBy { it }.eachCount()
            if (sourceCharCount == wordCharCount) {
                return true
            }
        }

        return false
    }

    override fun p1(): Int {
        val input = readInput()
        var count = 0

        input.forEachLine {
            if(!Regex("([A-z]+)").findAll(it).map { it.value }.groupBy { it }.any { it.value.count() > 1 }) count += 1
        }

        return count
    }

    override fun p2(): Int {
        val input = readInput()
        var count = 0

        input.forEachLine { line ->
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
}