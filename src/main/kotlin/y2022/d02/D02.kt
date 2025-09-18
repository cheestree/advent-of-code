package y2022.d02

import common.Day
import common.Utils.readInput
import java.io.File
import kotlin.math.absoluteValue
import kotlin.sequences.forEach

object D02 : Day<Int, Int> {
    override fun p1(): Int {
        val input = readInput()
        var enemy = 0
        var ally = 0
        //Rock, paper, scissor
        val movesEnemy = arrayOf(Pair("A", 1),Pair("B", 2),Pair("C", 3))
        val movesAlly = arrayOf(Pair("X", 1),Pair("Y", 2),Pair("Z", 3))


        input.useLines { lines ->
            lines.forEach { l ->
                if(l.isNotEmpty()){
                    val lineArray = l.split(" ")
                    val moveEnemyIdx = movesEnemy.indexOf(movesEnemy.first { l -> l.first == lineArray[0] })
                    val moveAllyIdx = movesAlly.indexOf(movesAlly.first { l -> l.first == lineArray[1] })

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
        return ally
    }

    override fun p2(): Int {
        val input = readInput()
        var ally = 0
        //Rock (0), paper (1), scissor (2)
        //Lose, draw, win
        val movesEnemy = arrayOf(Pair("A", 1),Pair("B", 2),Pair("C", 3))
        val movesAlly = arrayOf(Pair("X", 1),Pair("Y", 2),Pair("Z", 3))

        input.useLines { lines ->
            lines.forEach { l ->
                if(l.isNotEmpty()){
                    val lineArray = l.split(" ")
                    val moveEnemyIdx = movesEnemy.indexOf(movesEnemy.first { l -> l.first == lineArray[0] })
                    val moveAllyIdx = movesAlly.indexOf(movesAlly.first { l -> l.first == lineArray[1] })

                    when (moveAllyIdx) {
                        0 -> {
                            ally += when(lineArray[0]){
                                "A" -> 3
                                "B" -> 1
                                "C" -> 2
                                else -> 0
                            }
                        }
                        1 -> {
                            ally += movesEnemy[moveEnemyIdx].second + 3
                        }
                        2 -> {
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

        return ally
    }
}