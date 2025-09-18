package y2021.d01

import common.Day
import common.Utils.readInput
import java.io.File
import kotlin.sequences.forEach

object D01 : Day<Int,Int>{
    override fun p1(): Int{
        val input = readInput()
        var count = 0
        var prev = 0

        input.useLines {
            lines -> lines.forEach { l ->
                if(l.toInt() > prev) {
                    count++
                }
                prev = l.toInt()
            }
        }

        return count-1
    }

    override fun p2(): Int {
        val input = readInput()
        var count = 0
        var prev = mutableListOf<Int>()

        input.useLines {
            lines -> lines.forEach { l ->
                if(l.isNotEmpty()){
                    if(prev.size < 3){
                        prev.add(l.toInt())
                    }else{
                        if(prev.sum() < (prev.drop(1) + l.toInt()).sum()) count++
                    }
                    prev = (prev.drop(1) + l.toInt()).toMutableList()
                }
            }
        }
        return count
    }
}