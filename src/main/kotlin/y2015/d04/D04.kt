package y2015.d04

import common.Day
import common.Utils.readInput
import java.math.BigInteger
import java.security.MessageDigest

object D04 : Day<Int, Int> {
    private fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    private fun theIdealStockingStuffer(isFirstHalf: Boolean): Int{
        val input = readInput()
        val str = input.readLines()[0]
        var hash: String
        var counter = 0

        while (true){
            hash = md5(str+counter)
            if(hash.startsWith("00000") && isFirstHalf) break
            if(hash.startsWith("000000") && !isFirstHalf) break
            counter++
        }

        return counter
    }

    override fun p1() : Int {
        return theIdealStockingStuffer(false)
    }

    override fun p2(): Int {
        return theIdealStockingStuffer(true)
    }
}

