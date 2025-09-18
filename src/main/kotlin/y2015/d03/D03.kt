package y2015.d03

import common.Day
import common.Utils.readInput
import java.io.File
import kotlin.text.forEach

object D03 : Day<Int, Int> {
    private data class House(var x: Int, var y: Int){
        override fun toString(): String {
            return "(x:$x, y:$y)"
        }
    }

    private fun houseMove(chr: Char, house: House): House {
        val newHouse = house.copy()
        when(chr){
            '^' -> { newHouse.y += 1 }
            'v' -> { newHouse.y -= 1 }
            '<' -> { newHouse.x -= 1 }
            '>' -> { newHouse.x += 1 }
        }
        return newHouse
    }

    override fun p1(): Int {
        val input = readInput()
        val houseMap = hashMapOf<String, Int>()
        var currentHouse = House(0,0)

        input.forEachLine {
            it.forEach { c ->
                currentHouse = houseMove(c, currentHouse)
                houseMap[currentHouse.toString()] = houseMap[currentHouse.toString()]?.plus(1) ?: 1
            }
        }

        return houseMap.filterValues { it >= 1 }.size
    }

    override fun p2(): Int {
        val input = readInput()
        val houseMap = hashMapOf(
            House(0, 0) to 1
        )
        var currentHouseSanta = House(0, 0)
        var currentHouseRoboSanta = House(0, 0)

        input.forEachLine {
            it.forEachIndexed { idx, c ->
                if (idx % 2 == 0) {
                    currentHouseSanta = houseMove(c, currentHouseSanta)
                    houseMap[currentHouseSanta] = houseMap.getOrDefault(currentHouseSanta, 0) + 1
                } else {
                    currentHouseRoboSanta = houseMove(c, currentHouseRoboSanta)
                    houseMap[currentHouseRoboSanta] = houseMap.getOrDefault(currentHouseRoboSanta, 0) + 1
                }
            }
        }

        return houseMap.filterValues { it >= 1 }.size
    }
}