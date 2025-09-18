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

        fun moveHouse(chr: Char) {
            when(chr){
                '^' -> { this.y += 1 }
                'v' -> { this.y -= 1 }
                '<' -> { this.x -= 1 }
                '>' -> { this.x += 1 }
            }
        }
    }

    override fun p1(): Int {
        val input = readInput()
        val houseMap = hashMapOf<Pair<Int, Int>, Int>(
            Pair(0, 0) to 1
        )
        val house = House(0,0)

        input.forEachLine {
            it.forEach { c ->
                house.moveHouse(c)
                val key = Pair(house.x, house.y)
                houseMap[key] = houseMap.getOrDefault(key, 0) + 1
            }
        }

        return houseMap.filterValues { it >= 1 }.size
    }

    override fun p2(): Int {
        val input = readInput()
        val houseMap = hashMapOf<Pair<Int, Int>, Int>(
            Pair(0, 0) to 1
        )
        val santaHouse = House(0, 0)
        val roboSantaHouse = House(0, 0)

        input.forEachLine {
            it.forEachIndexed { idx, c ->
                if (idx % 2 == 0) {
                    santaHouse.moveHouse(c)
                    val key = Pair(santaHouse.x, santaHouse.y)
                    houseMap[key] = houseMap.getOrDefault(key, 0) + 1
                } else {
                    roboSantaHouse.moveHouse(c)
                    val key = Pair(roboSantaHouse.x, roboSantaHouse.y)
                    houseMap[key] = houseMap.getOrDefault(key, 0) + 1
                }
            }

        }

        return houseMap.filterValues { it >= 1 }.size
    }
}