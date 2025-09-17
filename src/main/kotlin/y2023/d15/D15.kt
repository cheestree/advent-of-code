package y2023.d15

import java.io.File

object D15 {
    fun p1() {
        fun hashAlgorithm(toHash: String): Int{
            return toHash.fold(0) { acc: Int, c: Char -> ((acc+c.code)*17)%256 }
        }

        val file = File("src/main/kotlin/year2023/day15/input.txt")
        var acc = 0
        file.forEachLine { line ->
            val newLine = line.split(",")
            newLine.forEach { step ->
                acc += hashAlgorithm(step)
            }
        }
        return acc
    }

    fun p2() {

    }
}