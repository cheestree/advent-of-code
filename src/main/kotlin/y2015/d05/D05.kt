package y2015.d05

import common.Utils.readResource
import java.io.File

object D05 {
    fun doesntHeHaveInternElvesForThis(): Int{
        val file = readResource("/y2025/d05/input.txt")
        var niceStrings = 0
        file.forEachLine { line ->
            val hasVowels = Regex("[aeiouAEIOU]").findAll(line).count() >= 3
            val hasForbiddenGroups = Regex("ab|cd|pq|xy").find(line) == null
            val hasDoubleLetter = Regex("(.)\\1").find(line) != null
            if(hasVowels && hasForbiddenGroups && hasDoubleLetter) niceStrings += 1
        }
        return niceStrings
    }


    fun doesntHeHaveInternElvesForThis2(): Int{
        val file = readResource("/y2025/d05/input.txt")
        var niceStrings = 0
        file.forEachLine { line ->
            val hasDoubleLetter = Regex("(.)\\1").findAll(line).count()
            //  println(hasDoubleLetter)
            //  if(hasDoubleLetter) niceStrings += 1
        }
        return niceStrings
    }
}