package y2021.d03

import common.Day
import common.Utils.readInput
import java.io.File
import kotlin.sequences.forEach

object D03 : Day<Int, String> {
    override fun p1(): Int {
        val input = readInput()
        val listsOfUnCommon = mutableListOf<MutableList<Int>>()
        var gammaRate = ""
        var epsilonRate = ""

        input.useLines {
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
            val mostCommonBit = listsOfUnCommon[i].groupingBy { it }.eachCount().maxBy { it.value }.component1()
            gammaRate += mostCommonBit
            epsilonRate += mostCommonBit xor 1
        }

        return gammaRate.toInt(2) * epsilonRate.toInt(2)
    }

    override fun p2(): String {
        val input = readInput()
        var listsOfUnCommon = mutableListOf<MutableList<Int>>()
        var oxyGenRating = ""

        input.useLines { lines ->
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

            val indexesToRemove: MutableList<Int> =
                listsOfUnCommon[i].mapIndexed { index, i -> if(i == mostCommon) index else -1}.filter { i -> i != -1 }.toMutableList()

            listsOfUnCommon = listsOfUnCommon.map { b -> b.filterIndexed{ index, _ -> indexesToRemove.contains(index) }.toMutableList() }.toMutableList()

            oxyGenRating += if(mostCommon == leastCommon) '1' else listsOfUnCommon[i].first()
        }

        return oxyGenRating
    }
}