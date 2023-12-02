package year2023.day2

import java.io.File

fun cubeConundrum2(): Int {
    val file = File("src/main/kotlin/year2023/day2/input.txt")
    var sumOfSets = 0
    file.forEachLine {
        val cubeHash = hashMapOf(
            "red" to 0,
            "green" to 0,
            "blue" to 0,
        )
        var gameStats = it.replace(";", ",").replace(":", ",").split(",").map { it.trim() }
        gameStats = gameStats.drop(1)
        gameStats.forEachIndexed { index, s ->
            val set = s.split(" ")
            if(cubeHash[set[1]] == 0){
                cubeHash[set[1]] = set[0].toInt()
            }else{
                cubeHash[set[1]] = maxOf(cubeHash[set[1]]!!, set[0].toInt())
            }
        }
        sumOfSets += cubeHash["red"]!! * cubeHash["green"]!! * cubeHash["blue"]!!
    }
    return sumOfSets
}

fun main(){
    println(cubeConundrum2())
}