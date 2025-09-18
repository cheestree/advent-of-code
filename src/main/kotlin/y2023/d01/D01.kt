package y2023.d01

import common.Day
import common.Utils.readInput
import java.io.File

object D01 : Day<Int, Int> {
    private val numbersToInt: Map<Char, Int> = mapOf(
        '0' to 0,
        '1' to 1,
        '2' to 2,
        '3' to 3,
        '4' to 4,
        '5' to 5,
        '6' to 6,
        '7' to 7,
        '8' to 8,
        '9' to 9
    )

    override fun p1(): Int {
        val input = readInput()
        var sum = 0
        var resultingFilter: String

        input.forEachLine {
            resultingFilter = it.filter { it.isDigit() }
            sum += resultingFilter.first().digitToInt()*10 + resultingFilter.last().digitToInt()
        }

        return sum
    }

    override fun p2(): Int {
        val input = readInput()
        var sum = 0
        var currentIndex = 0
        val numericValues = mutableListOf<Int>()
        var foundMatch = false

        input.forEachLine {
            while (currentIndex < it.length) {
                if(it[currentIndex].isDigit() && numbersToInt.containsKey(it[currentIndex])) {
                    numericValues.add(numbersToInt[it[currentIndex]]!!)
                    currentIndex++
                }else {
                    for (entry in numbersToInt) {
                        if (it.startsWith(entry.key.toString(), currentIndex)) {
                            numericValues.add(entry.value)
                            currentIndex += entry.key.toString().length-1
                            foundMatch = true
                            break
                        }
                    }
                    if (!foundMatch) {
                        currentIndex++
                    }
                }
                foundMatch = false
            }
            sum += numericValues.first()*10 + numericValues.last()
            numericValues.clear()
        }

        return sum
    }
}