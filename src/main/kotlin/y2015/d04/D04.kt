package y2015.d04

import common.Utils.readResource
import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

object D04 {
    fun theIdealStockingStuffer(isFirstHalf: Boolean): Int{
        val file = readResource("/y2025/d04/input.txt")
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
}

