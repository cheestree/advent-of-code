package year2023.day6

import java.io.File

fun waitForIt2(): Int{
    val file = File("src/main/kotlin/year2023/day6/input.txt")
    var time: Long? = null
    var distance: Long? = null
    file.forEachLine {
        if (time == null) time = it.split(":")[1].trim().replace(" ", "").toLong() else
            distance = it.split(":")[1].trim().replace(" ", "").toLong()
    }
    return (1 until time!!).count { (time!! - it) * it > distance!! }
}

fun main(){
    println(waitForIt2())
}