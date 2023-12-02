package year2023.day2

import java.io.File


fun cubeConundrum(): Int {
    val file = File("src/main/kotlin/year2023/day2/input.txt")
    var sumOfIds = 0
    val cubeHash = hashMapOf(
        "red" to 12,
        "green" to 13,
        "blue" to 14,
    )
    file.forEachLine {
        var gameStats = it.replace(";", ",").replace(":", ",").split(",").map { it.trim() }
        val gameId = gameStats[0].split(" ")[1]
        gameStats = gameStats.drop(1)
        gameStats.forEachIndexed { index, s ->
            val set = s.split(" ")
            if(cubeHash[set[1]]!! < set[0].toInt()) return@forEachLine
        }
        sumOfIds += gameId.toInt()
    }
    return sumOfIds
}

fun main(){
    println(cubeConundrum())
}