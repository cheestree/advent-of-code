package year2023.day7

import java.io.File

data class Hand(val hand: String, val bid: Int){
    private var type: HAND_TYPE? = null
    fun checkType(): HAND_TYPE? {
        type = hand.checkHand()
        return type
    }

    override fun toString(): String {
        return "Hand $hand is a $type, and bid $bid"
    }
}

val CARD_VALUES = listOf('A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2')

enum class HAND_TYPE {
    FIVE_OF_A_KIND {
        override fun check(handToCheck: String): Boolean {
            return handToCheck.groupBy { it }.count() == 1
        }
    },
    FOUR_OF_A_KIND {
        override fun check(handToCheck: String): Boolean {
            return handToCheck.groupBy { it }.any { it.value.size == 4 }
        }
    },
    FULL_HOUSE {
        override fun check(handToCheck: String): Boolean {
            return handToCheck.groupBy { it }.count() == 2 && handToCheck.groupBy { it }.any { it.value.size == 3 }
        }
    },
    THREE_OF_A_KIND {
        override fun check(handToCheck: String): Boolean {
            return handToCheck.groupBy { it }.count() == 3 && handToCheck.groupBy { it }.any { it.value.size == 3 }
        }
    },
    TWO_PAIR {
        override fun check(handToCheck: String): Boolean {
            return handToCheck.groupBy { it }.count() == 3 && handToCheck.groupBy { it }.filter { it.value.size == 2 }.count() == 2
        }
    },
    ONE_PAIR {
        override fun check(handToCheck: String): Boolean {
            return handToCheck.groupBy { it }.count() == 4
        }
    },
    HIGH_CARD {
        override fun check(handToCheck: String): Boolean {
            return handToCheck.groupBy { it }.count() == 5
        }
    };

    abstract fun check(handToCheck: String): Boolean
}


fun String.checkHand(): HAND_TYPE? {
    if (Regex("([A-Z]|[0-9])\\w+").findAll(this).map { it.value }.count() != 1) return null
    return HAND_TYPE.values().firstOrNull { it.check(this) }
}

fun camelCards(): Int{
    val file = File("src/main/kotlin/year2023/day7/input.txt")
    val totalHands = mutableListOf<Hand>()
    var totalMoneyWon = 0
    file.forEachLine {
        totalHands.add(Hand(it.split(" ")[0], it.split(" ")[1].toInt()))
    }
    totalHands.sortByDescending {
        it.checkType()
    }
    totalHands.forEachIndexed { index, hand ->
        totalMoneyWon += hand.bid * (index+1)
        println(hand)
    }
    return totalMoneyWon
}

fun main(){
    println(camelCards())
}