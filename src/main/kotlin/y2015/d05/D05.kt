package y2015.d05

import common.Day
import common.Utils.readInput

object D05 : Day<Int, Int> {
    override fun p1(): Int {
        val input = readInput()
        var niceStrings = 0

        input.forEachLine { line ->
            val hasVowels = Regex("[aeiouAEIOU]").findAll(line).count() >= 3
            val hasForbiddenGroups = Regex("ab|cd|pq|xy").find(line) == null
            val hasDoubleLetter = Regex("(.)\\1").find(line) != null
            if(hasVowels && hasForbiddenGroups && hasDoubleLetter) niceStrings += 1
        }

        return niceStrings
    }


    override fun p2(): Int {
        val input = readInput()
        val niceStrings = 0

        input.forEachLine { line ->
            val hasDoubleLetter = Regex("(.)\\1").findAll(line).count()
            //  if(hasDoubleLetter) niceStrings += 1
        }

        return niceStrings
    }
}