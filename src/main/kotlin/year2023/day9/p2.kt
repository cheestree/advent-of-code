package year2023.day9

import java.io.File

fun mirageMaintenance2(): Int{
    val file = File("src/main/kotlin/year2023/day9/input.txt")
    var acc = 0
    file.forEachLine {
        val arr = it.split(" ").map { it.toInt() }
        acc += recursivelySubtract(arr.first(), arr).first
        println(acc)
    }
    return acc
}

fun recursivelySubtract(acc: Int, arr: List<Int>): Pair<Int, List<Int>> {
    if(arr.all { it == 0 }) return Pair(acc, arr)
    val newList = mutableListOf<Int>()
    for (i in 0 until arr.size-1){
        newList.add(arr[i+1] - arr[i])
    }
    val newAcc = acc - recursivelySubtract(newList.first(), newList).first
    return Pair(newAcc, newList)
}

fun main(){
    println(mirageMaintenance2())
}