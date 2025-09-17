package y2022.d01

import java.io.File
import kotlin.sequences.forEach

object D01 {
    fun p1() {
        val bufferedReader = File("src/main/kotlin/year2022/day1/input.txt").bufferedReader()
        var bigElf = 0
        var bigCal = 0
        var currElf = 1
        var currCal = 0

        bufferedReader.useLines {
                lines -> lines.forEach { l ->
            if(l.isNotEmpty()){
                currCal += l.toInt()
                println(currCal)
            }else{
                println("Empty! Checking...")
                if(currCal > bigCal){
                    bigCal = currCal
                    bigElf = currElf
                }
                currCal = 0
                currElf += 1
            }
        }
        }
        println(bigElf)
        print(bigCal)
    }

    fun p2() {
        val bufferedReader = File("src/main/kotlin/year2022/day1/input.txt").bufferedReader()
        var currElf = 1
        var currCal = 0
        val elfTrio = mutableListOf(0,0,0)

        bufferedReader.useLines {
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
        println(elfTrio)
        print(elfTrio.fold(0){acc, next -> acc + next})
    }
}