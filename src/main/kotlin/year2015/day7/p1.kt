package year2015.day7

import utils.isNumeric
import java.io.File
import java.util.*
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or

enum class OPERATIONS {
    AND {
        override fun operation(vararg numbers: Int): Int {
            return numbers.first().and(numbers.last())
        }
    },
    OR {
        override fun operation(vararg numbers: Int): Int {
            return numbers.first().or(numbers.last())
        }
    },
    RSHIFT {
        override fun operation(vararg numbers: Int): Int {
            return numbers.first().shr(numbers.last())
        }
    },
    LSHIFT {
        override fun operation(vararg numbers: Int): Int {
            return numbers.first().shl(numbers.last())
        }
    };

    open fun operation(vararg numbers: Int): Int { return 0 }

    companion object {
        fun fromString(text: String): OPERATIONS? {
            for (enum in values()) if (enum.name == text.uppercase(Locale.getDefault())) return enum
            return null
        }

        fun isIn(text: String): OPERATIONS? {
            for (enum in values()) {
                if (text.contains(enum.toString())){
                    return enum
                }
            }
            return null
        }
    }
}

fun someAssemblyRequired(): UShort? {
    val file = File("src/main/kotlin/year2015/day7/input.txt")
    val wires = hashMapOf<String, UShort?>()
    file.forEachLine {
        val (operation, destination) = it.split(" -> ")
        val leftSide = operation.split(" ")
        if(leftSide.size == 1 && leftSide[0].isNumeric()){
            wires[destination] = leftSide[0].toUShort()
        }
        if(leftSide.size == 1 && !leftSide[0].isNumeric()){
            wires[destination] = wires[leftSide[0]]
        }
        if(leftSide.size == 2){
            wires[destination] = wires[leftSide[1]]?.inv()
        }
        if(leftSide.size == 3){
            wires[destination] = when (leftSide[1]){
                "AND" -> wires[leftSide[2]]?.let { it1 -> wires[leftSide[0]]?.and(it1) }?.toUShort()
                "OR" -> wires[leftSide[2]]?.let { it1 -> wires[leftSide[0]]?.or(it1) }?.toUShort()
                "LSHIFT" -> wires[leftSide[0]]?.toInt()?.shl(leftSide[2].toInt())?.toUShort()
                "RSHIFT" -> wires[leftSide[0]]?.toInt()?.shr(leftSide[2].toInt())?.toUShort()
                else -> 0.toUShort()
            }
        }
    }
    println(wires)
    return wires["a"]
}

fun main() {
    println(someAssemblyRequired())
}