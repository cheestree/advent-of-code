package y2023.d09

import java.io.File

object D09 {
    fun p1() {
        fun recursivelyAdd(acc: Int, arr: List<Int>): Pair<Int, List<Int>> {
            if(arr.all { it == 0 }) return Pair(acc, arr)
            val newList = mutableListOf<Int>()
            for (i in 0 until arr.size-1){
                newList.add(arr[i+1] - arr[i])
            }
            val newAcc = acc + recursivelyAdd(newList.last(), newList).first
            return Pair(newAcc, newList)
        }

        val file = File("src/main/kotlin/year2023/day9/input.txt")
        var acc = 0
        file.forEachLine {
            val arr = it.split(" ").map { it.toInt() }
            acc += recursivelyAdd(arr.last(), arr).first
        }
        return acc
    }

    fun p2() {
        fun recursivelySubtract(acc: Int, arr: List<Int>): Pair<Int, List<Int>> {
            if(arr.all { it == 0 }) return Pair(acc, arr)
            val newList = mutableListOf<Int>()
            for (i in 0 until arr.size-1){
                newList.add(arr[i+1] - arr[i])
            }
            val newAcc = acc - recursivelySubtract(newList.first(), newList).first
            return Pair(newAcc, newList)
        }

        val file = File("src/main/kotlin/year2023/day9/input.txt")
        var acc = 0
        file.forEachLine {
            val arr = it.split(" ").map { it.toInt() }
            acc += recursivelySubtract(arr.first(), arr).first
        }
        return acc
    }
}