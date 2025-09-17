package y2017.d02

import java.io.File

object D02 {
    fun corruptionChecksum(): Int{
        val file = File("/y2017/d02/input.txt")
        var checkSum = 0
        file.forEachLine {
            val values = Regex("([0-9])+").findAll(it).map { it.value.toInt() }
            checkSum += (values.maxOrNull()?.minus(values.minOrNull()!!)!!)
        }
        return checkSum
    }

    fun corruptionChecksum2(): Int{
        val file = File("/y2017/d02/input.txt")
        var checkSum = 0
        file.forEachLine {
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