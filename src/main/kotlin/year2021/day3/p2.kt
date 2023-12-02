package year2021.day3

import java.io.File

fun main() {

    val bufferedReader = File("src/main/kotlin/year2022/day3/input.txt").bufferedReader()
    var listsOfUnCommon = mutableListOf<MutableList<Int>>()
    var oxyGenRating = ""
    var coScrubRating = ""
    var tempList = mutableListOf<Int>()

    bufferedReader.useLines { lines ->
        lines.forEach { l ->
            val bits = l.toCharArray().map { it.code - 48 }
            if (l.isNotEmpty()) {
                if (listsOfUnCommon.isEmpty()) {
                    repeat(bits.size) { listsOfUnCommon += mutableListOf<Int>() }
                }
                listsOfUnCommon.map { lists -> lists.add(bits[listsOfUnCommon.indexOf(lists)]) }
            }
        }
    }
    for (i in 0 until listsOfUnCommon.size) {
        val mostCommon = listsOfUnCommon[i].groupingBy { it }.eachCount().maxBy { it.value }.component1()
        val leastCommon = listsOfUnCommon[i].groupingBy { it }.eachCount().minBy { it.value }.component1()

        println("Most common $mostCommon")
        println("Most common $leastCommon")

        var indexesToRemove: MutableList<Int> =
            listsOfUnCommon[i].mapIndexed { index, i -> if(i == mostCommon) index else -1}.filter { i -> i != -1 }.toMutableList()

        println("-------")
        println("Before filtering")
        listsOfUnCommon.forEach { i -> println(i) }
        println("After filtering")

        listsOfUnCommon = listsOfUnCommon.map { b -> b.filterIndexed{ index, _ -> indexesToRemove.contains(index) }.toMutableList() }.toMutableList()

        println("Indexes to stay -> $indexesToRemove")
        listsOfUnCommon.forEach { i -> println(i) }
        if(mostCommon == leastCommon) oxyGenRating += '1' else oxyGenRating += listsOfUnCommon[i].first()
    }
    println(oxyGenRating)
}