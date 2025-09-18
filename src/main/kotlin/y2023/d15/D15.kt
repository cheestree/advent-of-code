package y2023.d15

import common.Day
import common.Utils.readInput
import java.io.File

object D15 : Day<Int, Int> {
    override fun p1(): Int {
        fun hashAlgorithm(toHash: String): Int{
            return toHash.fold(0) { acc: Int, c: Char -> ((acc+c.code)*17)%256 }
        }

        val input = readInput()
        var acc = 0

        input.forEachLine { line ->
            val newLine = line.split(",")
            newLine.forEach { step ->
                acc += hashAlgorithm(step)
            }
        }

        return acc
    }

    override fun p2(): Int {
        TODO()
    }
}