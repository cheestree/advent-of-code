package year2022.day1

import java.io.File

fun main() {
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

//198551