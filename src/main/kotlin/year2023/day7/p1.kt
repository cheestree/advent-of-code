package year2023.day7

import java.io.File

data class Hand(val hand: String, val bid: Int) {
    var handValue = hand.map { CARD_VALUES.indexOf(it).toString() }.joinToString("")

    companion object {
        private val CARD_VALUES = listOf('A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2')

        fun quickSort(handList: List<Hand>): List<Hand> {
            if (handList.size <= 1) {
                return handList
            }

            val pivot = handList[handList.size / 2]
            val equal = handList.filter { it.handValue == pivot.handValue }
            val less = handList.filter { compareHands(it, pivot) < 0 }
            val greater = handList.filter { compareHands(it, pivot) > 0 }

            return quickSort(less) + equal + quickSort(greater)
        }

        private fun compareHands(hand1: Hand, hand2: Hand): Int {
            val typeComparison = hand1.type.compareTo(hand2.type)
            if (typeComparison != 0) {
                return typeComparison
            }

            val minLength = minOf(hand1.handValue.length, hand2.handValue.length)

            for (i in 0 until minLength) {
                val value1 = CARD_VALUES.indexOf(hand1.handValue[i])
                val value2 = CARD_VALUES.indexOf(hand2.handValue[i])

                if (value1 != value2) {
                    return value1 - value2
                }
            }

            return hand1.handValue.length - hand2.handValue.length
        }
    }

    private val type: HAND_TYPE by lazy { checkType() }

    fun checkType(): HAND_TYPE {
        return HAND_TYPE.values().firstOrNull { it.check(handValue) } ?: HAND_TYPE.HIGH_CARD
    }
}

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

fun camelCards(): Int{
    val file = File("src/main/kotlin/year2023/day7/input.txt")
    val totalHands = mutableListOf<Hand>()
    var totalMoneyWon = 0
    file.forEachLine {
        totalHands.add(Hand(it.split(" ")[0], it.split(" ")[1].toInt()))
    }
    val sortedHands = Hand.quickSort(totalHands)
    println(sortedHands)
    return totalMoneyWon
}

fun main(){
    println(camelCards())
}