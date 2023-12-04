package year2015.day4

import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

fun theIdealStockingStuffer(): Int{
    val file = File("src/main/kotlin/year2015/day4/input.txt")
    val input = file.readLines()[0]
    var hash = ""
    var counter = 0
    while (!hash.startsWith("00000")){
        hash = md5(input+counter)
        counter++
    }
    println(hash)
    return counter
}

fun md5(input:String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}

fun main(){
    println(theIdealStockingStuffer())
}