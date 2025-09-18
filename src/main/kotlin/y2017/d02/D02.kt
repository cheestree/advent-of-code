package y2017.d02

import common.Day
import common.Utils.readInput
import java.io.File

object D02 : Day<Int, Int> {
    override fun p1(): Int{
        val input = readInput()
        var checkSum = 0

        input.forEachLine {
            val values = Regex("([0-9])+").findAll(it).map { it.value.toInt() }
            checkSum += (values.maxOrNull()?.minus(values.minOrNull()!!)!!)
        }

        return checkSum
    }

    override fun p2(): Int{
        val input = readInput()
        var checkSum = 0

        input.forEachLine {
            val values = Regex("([0-9])+").findAll(it).map { it.value.toInt() }.toList()
            checkSum += values.flatMap { num1 ->
                values.mapNotNull { num2 ->
                    if (num1 != num2 && (num1 % num2 == 0 || num2 % num1 == 0) && num1/num2 != 0) num1/num2 else null
                }
            }.first()
        }

        return checkSum
    }
}