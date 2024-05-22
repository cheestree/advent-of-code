package year2016.day1

import java.io.File
import kotlin.math.abs

data class Coords(var x: Int, var y: Int, var direction: DIRECTION){
    fun getDistance(): Int{
        return abs(x)+abs(y)
    }
}

enum class DIRECTION(val xFactor: Int, val yFactor: Int){
    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0)
}

fun noTimeForATaxicab(): Int{
    val file = File("src/main/kotlin/year2016/day1/input.txt")
    var startingPosition = Coords(0, 0, DIRECTION.NORTH)
    file.forEachLine {
        val directions = it.split(", ")
        directions.forEach {
            startingPosition = move(it, startingPosition)
        }
    }
    return startingPosition.getDistance()
}

fun move(move: String, coords: Coords): Coords {
    val direction = when (move[0]) {
        'L' -> turnLeft(coords.direction)
        'R' -> turnRight(coords.direction)
        else -> coords.direction
    }
    val distance = move.substring(1).toInt()
    coords.x += direction.xFactor * distance
    coords.y += direction.yFactor * distance
    coords.direction = direction
    return coords
}

fun turnLeft(currentDirection: DIRECTION): DIRECTION {
    val values = DIRECTION.values()
    val currentIndex = values.indexOf(currentDirection)
    val newIndex = (currentIndex - 1 + values.size) % values.size
    return values[newIndex]
}

fun turnRight(currentDirection: DIRECTION): DIRECTION {
    val values = DIRECTION.values()
    val currentIndex = values.indexOf(currentDirection)
    val newIndex = (currentIndex + 1) % values.size
    return values[newIndex]
}

fun main(){
    println(noTimeForATaxicab())
}