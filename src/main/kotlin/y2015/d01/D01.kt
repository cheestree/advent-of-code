package y2015.d01

import common.Day
import common.Utils.readResource

object D01 : Day<Int, Int> {
    override fun p1(): Int {
        val file = readResource("/y2025/d01/input.txt")
        var floor = 0
        file.forEachLine { it.forEachIndexed { index, c -> if(c=='(') floor += 1 else floor -= 1 } }
        return floor
    }

    override fun p2(): Int {
        val file = readResource("/y2025/d01/input.txt")
        var floor = 0
        var idx = 0
        file.forEachLine {
            it.forEachIndexed { index, c -> if(floor <= -1 ) {
                idx = index
                return@forEachLine
            } else if(c=='(') floor += 1 else floor -= 1 }
        }
        return idx
    }

}