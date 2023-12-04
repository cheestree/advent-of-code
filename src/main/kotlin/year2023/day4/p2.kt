package year2023.day4

import java.io.File

data class Card(val id: Int, val matchingNumbers: Int){
    override fun toString(): String {
        return "Card ${id+1} has $matchingNumbers matching numbers."
    }
}

fun scratchCard2(): Int{
    val file = File("src/main/kotlin/year2023/day4/input.txt")
    var sumOfParts = 0
    val totalCards = mutableListOf<Card>()
    file.forEachLine {
        val parsed = Regex("([0-9])+").findAll(it).map { it.value.toInt() }.toList()
        val matchingNumbersCount = parsed.drop(1).groupBy { it }.count { it.value.size >= 2 }
        totalCards.add(Card(parsed[0]-1, matchingNumbersCount))
    }
    totalCards.forEach {
        sumOfParts += if (it.matchingNumbers != 0) {
            scratchRecursively(it, totalCards)
        }else{
            1
        }
    }
    return sumOfParts
}

fun scratchRecursively(card: Card, listOfCards: List<Card>): Int {
    if(card.matchingNumbers==0) return 1
    var count = 1
    for (cardIndex in card.id+1..card.id+card.matchingNumbers){
        count += scratchRecursively(listOfCards[cardIndex], listOfCards)
    }
    return count
}

fun main(){
    println(scratchCard2())
}