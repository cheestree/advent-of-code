package year2021.day3

import java.io.File

fun main() {

    val bufferedReader = File("src/main/kotlin/year2022/day3/input.txt").bufferedReader()
    val listsOfUnCommon = mutableListOf<MutableList<Int>>()
    var gammaRate = ""
    var epsilonRate = ""

    bufferedReader.useLines {
        lines -> lines.forEach { l ->
            val bits = l.toCharArray().map { it.code - 48 }
            if(l.isNotEmpty()){
                if(listsOfUnCommon.isEmpty()){
                    repeat(bits.size){ listsOfUnCommon += mutableListOf<Int>() }
                }
                listsOfUnCommon.map { lists -> lists.add(bits[listsOfUnCommon.indexOf(lists)]) }
            }
        }
    }
    for(i in 0 until listsOfUnCommon.size){
        //println(listsOfUnCommon[i].groupingBy { it }.eachCount().maxBy { it.value }.component1())
        val mostCommonBit = listsOfUnCommon[i].groupingBy { it }.eachCount().maxBy { it.value }.component1()
        gammaRate += mostCommonBit
        epsilonRate += mostCommonBit xor 1
    }
    println(gammaRate)
    println(epsilonRate)
    println("${gammaRate.toInt(2)} * ${epsilonRate.toInt(2)} = ${gammaRate.toInt(2) * epsilonRate.toInt(2)}")
}