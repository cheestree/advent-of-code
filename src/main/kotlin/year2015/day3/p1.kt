package year2015.day3

import java.io.File

data class House(var x: Int, var y: Int){
    override fun toString(): String {
        return "(x:$x, y:$y)"
    }
}

fun perfectlySphericalHousesInAVacuum(): Int{
    val file = File("src/main/kotlin/year2015/day3/input.txt")
    val houseMap = hashMapOf<String, Int>()
    var currentHouse = House(0,0)
    file.forEachLine {
        it.forEach { c ->
            currentHouse = houseMove(c, currentHouse)
            houseMap[currentHouse.toString()] = houseMap[currentHouse.toString()]?.plus(1) ?: 1
        }
    }
    return houseMap.filterValues { it >= 1 }.size
}

fun houseMove(chr: Char, house: House): House {
    val newHouse = house.copy()
    when(chr){
        '^' -> { newHouse.y += 1 }
        'v' -> { newHouse.y -= 1 }
        '<' -> { newHouse.x -= 1 }
        '>' -> { newHouse.x += 1 }
    }
    return newHouse
}

fun main(){
    println(perfectlySphericalHousesInAVacuum())
}