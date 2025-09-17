package y2015.d06

import java.io.File
import kotlin.collections.get

object D06 {
    //  Dev note: I love this problem :) It's so simple but so cute

    const val ROW = 1000
    const val COLUMN = 1000

    data class Lightbulb(var isOn: Boolean){
        var brightness = 0
        override fun toString(): String {
            return if(isOn) "☼" else "•"
        }
        fun toggle(){
            this.brightness += 2
            this.isOn = !isOn
        }
        fun turnOn(){
            this.brightness += 1
            this.isOn = true
        }
        fun turnOff(){
            this.brightness = if(brightness!=0) brightness-1 else 0
            this.isOn = false
        }
    }

    fun probablyAFireHazard(): Int{
        val file = File("/y2015/d06/input.txt")
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
        //  lightGrid.forEach { it.forEach { print(it) }; println() }
        return lightGrid.flatten().count { it.isOn }
    }

    fun probablyAFireHazard2(): Int{
        val file = File("/y2015/d06/input.txt")
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
}