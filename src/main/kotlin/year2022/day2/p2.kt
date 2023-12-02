package year2022.day2

import java.io.File

fun main(){
    val bufferedReader = File("src/main/kotlin/year2022/day2/input.txt").bufferedReader()
    var ally = 0
    //Rock (0), paper (1), scissor (2)
    //Lose, draw, win
    var movesEnemy = arrayOf(Pair("A", 1),Pair("B", 2),Pair("C", 3))
    var movesAlly = arrayOf(Pair("X", 1),Pair("Y", 2),Pair("Z", 3))

    bufferedReader.useLines { lines ->
        lines.forEach { l ->
            if(l.isNotEmpty()){
                var lineArray = l.split(" ")
                var moveEnemyIdx = movesEnemy.indexOf(movesEnemy.first { l -> l.first == lineArray[0] })
                var moveAllyIdx = movesAlly.indexOf(movesAlly.first { l -> l.first == lineArray[1] })
                println(l)
                when{
                    moveAllyIdx == 0 -> {
                        ally += when(lineArray[0]){
                            "A" -> 3
                            "B" -> 1
                            "C" -> 2
                            else -> 0
                        }
                    }
                    moveAllyIdx == 1 -> {
                        ally += movesEnemy[moveEnemyIdx].second + 3
                    }
                    moveAllyIdx == 2 -> {
                        ally += when(lineArray[0]){
                            "A" -> 2
                            "B" -> 3
                            "C" -> 1
                            else -> 0
                        }
                        ally += 6
                    }
                }
            }
        }
    }
    println("You: $ally")
}

//