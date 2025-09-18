package y2015.d01

import common.Day
import common.Utils.readInput

object D01 : Day<Int, Int> {
    override fun p1(): Int {
        val input = readInput()
        var floor = 0

        input.forEachLine { it.forEachIndexed { index, c -> if(c=='(') floor += 1 else floor -= 1 } }

        return floor
    }

    override fun p2(): Int {
        val input = readInput()
        var floor = 0
        var idx = 0

        input.forEachLine {
            it.forEachIndexed { index, c -> if(floor <= -1 ) {
                idx = index
                return@forEachLine
            } else if(c=='(') floor += 1 else floor -= 1 }
        }

        return idx
    }

}