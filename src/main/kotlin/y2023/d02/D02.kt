package y2023.d02

import java.io.File

object D02 {
    fun p1() {
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

    fun p2() {
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
}