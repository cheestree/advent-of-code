package year2015.day3

import java.io.File

fun perfectlySphericalHousesInAVacuum2(): Int{
    val file = File("src/main/kotlin/year2015/day3/input.txt")
    val houseMap = hashMapOf(
        House(0, 0) to 1
    )
    var currentHouseSanta = House(0,0)
    var currentHouseRoboSanta = House(0, 0)
    file.forEachLine {
        it.forEachIndexed { idx, c ->
            if (idx % 2 == 0) {
                currentHouseSanta = houseMove(c, currentHouseSanta)
                houseMap[currentHouseSanta] = houseMap.getOrDefault(currentHouseSanta, 0) + 1
            } else {
                currentHouseRoboSanta = houseMove(c, currentHouseRoboSanta)
                houseMap[currentHouseRoboSanta] = houseMap.getOrDefault(currentHouseRoboSanta, 0) + 1
            }
        }
    }
    return houseMap.filterValues { it >= 1 }.size
}

fun main(){
    println(perfectlySphericalHousesInAVacuum2())
}