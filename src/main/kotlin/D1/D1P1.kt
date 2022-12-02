package day1

import java.io.File

fun main() {
    val bufferedReader = File("C:\\Users\\Daniel Carvalho\\Documents\\Misc\\AoE2022\\AdventOfCode2022\\src\\main\\kotlin\\day1\\input.txt").bufferedReader()
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