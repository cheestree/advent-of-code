package year2023.day3

import java.io.File

fun gearRatios2(): Int{
    val file = File("src/main/kotlin/year2023/day3/input.txt")
    var sumOfParts = 0
    var lineLength = 0
    val symbols = mutableListOf<Present>()
    var lineCount = 0
    file.forEachLine {
        if(lineLength==0) lineLength = it.length
        Regex("([^.0-9])|([0-9]+)").findAll(it).forEach {symbol -> symbols.add(Present(lineCount, symbol.range.first, symbol.value)) }
        lineCount++
    }
    symbols.forEach { singleGear ->
        val symbolsAround = symbols.filter {
            it.isNumeric() &&
            it.row in singleGear.row-1..singleGear.row+1
                    && it.column in singleGear.column-it.value.length..singleGear.column+singleGear.value.length
        }
        if(symbolsAround.size == 2){
            sumOfParts += symbolsAround.fold(1){ acc: Int, present: Present -> acc * present.value.toInt() }
        }
    }
    return sumOfParts
}

fun main(){
    println(gearRatios2())
}