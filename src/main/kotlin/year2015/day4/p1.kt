package year2015.day4

import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

fun theIdealStockingStuffer(isFirstHalf: Boolean): Int{
    val file = File("src/main/kotlin/year2015/day4/input.txt")
    val input = file.readLines()[0]
    var hash: String
    var counter = 0
    while (true){
        hash = md5(input+counter)
        if(hash.startsWith("00000") && isFirstHalf) break
        if(hash.startsWith("000000") && !isFirstHalf) break
        counter++
    }
    return counter
}

fun md5(input:String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}

fun main(){
    println(theIdealStockingStuffer(true))
}