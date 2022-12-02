package D2

import java.io.File
import java.lang.Math.max
import kotlin.math.absoluteValue

fun main(){
    val bufferedReader = File("src/main/kotlin/D2/input.txt").bufferedReader()
    var enemy = 0
    var ally = 0
    //Rock, paper, scissor
    var movesEnemy = arrayOf(Pair("A", 1),Pair("B", 2),Pair("C", 3))
    var movesAlly = arrayOf(Pair("X", 1),Pair("Y", 2),Pair("Z", 3))


    bufferedReader.useLines { lines ->
        lines.forEach { l ->
            if(l.isNotEmpty()){
                var lineArray = l.split(" ")
                var moveEnemyIdx = movesEnemy.indexOf(movesEnemy.first { l -> l.first == lineArray[0] })
                var moveAllyIdx = movesAlly.indexOf(movesAlly.first { l -> l.first == lineArray[1] })

                when((moveEnemyIdx-moveAllyIdx).absoluteValue){
                    0 -> {
                        enemy += movesEnemy[moveEnemyIdx].second + 3
                        ally += movesAlly[moveAllyIdx].second + 3
                    }
                    1 -> {
                        if(moveEnemyIdx > moveAllyIdx){
                            enemy += movesEnemy[moveEnemyIdx].second + 6
                            ally += movesAlly[moveAllyIdx].second
                        }else{
                            enemy += movesEnemy[moveEnemyIdx].second
                            ally += movesAlly[moveAllyIdx].second + 6
                        }
                    }
                    2 -> {
                        if(moveEnemyIdx > moveAllyIdx){
                            enemy += movesEnemy[moveEnemyIdx].second
                            ally += movesAlly[moveAllyIdx].second + 6
                        }else{
                            enemy += movesEnemy[moveEnemyIdx].second + 6
                            ally += movesAlly[moveAllyIdx].second
                        }
                    }
                }
            }
        }
    }

    println("You: $ally  Enemy: $enemy")
}

//13446