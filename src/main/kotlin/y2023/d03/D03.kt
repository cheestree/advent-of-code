package y2023.d03

import common.Utils.isNumeric
import java.io.File

object D03 {
    data class Present(val row: Int, val column: Int, val value: String)

    fun p1() {

        val file = File("src/main/kotlin/year2023/day3/input.txt")
        var sumOfParts = 0
        var lineLength = 0
        val symbols = mutableListOf<Present>()
        val parts = mutableListOf<Present>()
        var lineCount = 0
        file.forEachLine {
            if(lineLength==0) lineLength = it.length
            Regex("([^.0-9])").findAll(it).forEach {symbol -> symbols.add(Present(lineCount, symbol.range.first, symbol.value)) }
            Regex("([0-9]+)").findAll(it).forEach {symbol -> parts.add(Present(lineCount, symbol.range.first, symbol.value)) }
            lineCount++
        }
        parts.forEach { singlePart ->
            val symbolsAround = symbols.filter {
                it.row in singlePart.row-1..singlePart.row+1
                        && it.column in singlePart.column-1..singlePart.column+singlePart.value.length
            }
            if(symbolsAround.isNotEmpty()){
                sumOfParts += singlePart.value.toInt()
            }
        }
        return sumOfParts
    }

    fun p2() {

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
                it.value.isNumeric() &&
                        it.row in singleGear.row-1..singleGear.row+1
                        && it.column in singleGear.column-it.value.length..singleGear.column+singleGear.value.length
            }
            if(symbolsAround.size == 2){
                sumOfParts += symbolsAround.fold(1){ acc: Int, present: Present -> acc * present.value.toInt() }
            }
        }
        return sumOfParts
    }
}