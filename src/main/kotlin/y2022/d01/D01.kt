package y2022.d01

import common.Day
import common.Utils.readInput
import java.io.File
import kotlin.sequences.forEach

object D01 : Day<Int, Int> {
    override fun p1(): Int {
        val input = readInput()
        var bigElf = 0
        var bigCal = 0
        var currElf = 1
        var currCal = 0

        input.useLines {
            lines -> lines.forEach { l ->
                if(l.isNotEmpty()){
                    currCal += l.toInt()
                }else{
                    if(currCal > bigCal){
                        bigCal = currCal
                        bigElf = currElf
                    }
                    currCal = 0
                    currElf += 1
                }
            }
        }
        return bigCal
    }

    override fun p2(): Int {
        val input = readInput()
        var currElf = 1
        var currCal = 0
        val elfTrio = mutableListOf(0,0,0)

        input.useLines {
            lines -> lines.forEach { l ->
                if(l.isNotEmpty()){
                    currCal += l.toInt()
                }else{
                    when{
                        currCal > elfTrio[0] -> {
                            elfTrio[2] = elfTrio[1]; elfTrio[1] = elfTrio[0]; elfTrio[0] = currCal
                        }
                        currCal <= elfTrio[0] && currCal > elfTrio[1] -> {
                            elfTrio[2] = elfTrio[1]; elfTrio[1] = currCal
                        }
                        currCal <= elfTrio[1] && currCal > elfTrio[2] -> {
                            elfTrio[2] = currCal
                        }
                    }
                    currCal = 0
                    currElf += 1
                }
            }
        }

        return elfTrio.fold(0){acc, next -> acc + next}
    }
}