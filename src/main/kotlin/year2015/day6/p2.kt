package year2015.day6

import java.io.File

fun probablyAFireHazard2(): Int{
    val file = File("src/main/kotlin/year2015/day6/input.txt")
    val lightGrid = Array(ROW) { Array(COLUMN) { Lightbulb(false) } }
    file.forEachLine { line ->
        val operation = line.split(" ")
        val coords = operation.takeLast(3)
        val (xFrom, yFrom) = coords[0].split(",").map { it.toInt() }
        val (xTo, yTo) = coords[2].split(",").map { it.toInt() }
        for (h in yFrom..yTo) {
            for (w in xFrom..xTo) {
                when(operation[0]){
                    "toggle" -> lightGrid[h][w].toggle()
                    "turn" -> if (operation[1] == "on") lightGrid[h][w].turnOn() else lightGrid[h][w].turnOff()
                }
            }
        }
    }
    return lightGrid.flatten().fold(0){ acc: Int, lightbulb: Lightbulb -> acc + lightbulb.brightness }
}

fun main(){
    println(probablyAFireHazard2())
}