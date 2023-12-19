package year2023.day15

import java.io.File

fun lensLibrary(): Int{
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

fun hashAlgorithm(toHash: String): Int{
    return toHash.fold(0) { acc: Int, c: Char -> ((acc+c.code)*17)%256 }
}

fun main(){
    println(lensLibrary())
}