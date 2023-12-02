package year2023.day1

import java.io.File

val numbersStringToInt: LinkedHashMap<String, Int> = linkedMapOf(
    "zero" to 0,
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9
)

fun trebuchet2(path: String): Int{
    val file = File(path)
    var sum = 0
    file.forEachLine {
        var currentIndex = 0
        val numericValues = mutableListOf<Int>()

        while (currentIndex < it.length) {
            var foundMatch = false
            if(it[currentIndex].isDigit()) {
                numbersToInt[it[currentIndex]]?.let { it1 -> numericValues.add(it1) }
                currentIndex++
            }else {
                for (entry in numbersStringToInt) {
                    if (it.startsWith(entry.key, currentIndex)) {
                        numericValues.add(entry.value)
                        currentIndex += entry.key.length-1
                        foundMatch = true
                        break
                    }
                }
                if (!foundMatch) {
                    currentIndex++
                }
            }
        }
        sum += if(numericValues.size==1) numericValues.first() * 10 + numericValues.first() else numericValues.first() * 10 + numericValues.last()
    }
    return sum
}

fun main(){
    println(trebuchet2("src/main/kotlin/Y2023/day1/input.txt"))
}