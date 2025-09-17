package y2022.d05

import java.io.File
import kotlin.sequences.forEach

object D05 {
    fun p1() {
        val timeStart = System.currentTimeMillis()
        val bufferedReader = File("src/main/kotlin/year2022/day5/input.txt").bufferedReader()
        val stackLists = mutableListOf<MutableList<String>>(mutableListOf())

        bufferedReader.useLines { lines ->
            lines.forEach { l ->
                if(l.isNotEmpty()){
                    val stackData = l.split("\\s{1,4}".toRegex())
                    val stack = l.trim().split("\\s{1,3}".toRegex())
                    //println(stackData)
                    //println(stack)
                    if(stackData[0] != "move" && stack[0].toIntOrNull() == null){
                        stackData.forEachIndexed { index, s ->
                            if (s != "") {
                                //println("Letter $s Index $index")
                                if (stackLists.getOrNull(index) == null) {
                                    repeat(index-stackLists.size+1) { stackLists.add(mutableListOf()) }
                                    //println(stackLists)
                                    stackLists[index].add(s)
                                    //println("Copied")
                                } else {
                                    stackLists[index].add(s)
                                    //println("Added")
                                }
                            }
                            //stackLists.forEach { println(" $it ") }
                        }
                    }else{
                        if(stackData.size == 6){
                            //println("================")
                            //print("Original ->")
                            //stackLists.forEach { print(" $it ") }
                            //println()
                            val source = stackLists[stackData[3].toInt()-1]
                            //println("From -> $source")
                            val amount = stackData[1]
                            //println("Amount -> $amount")
                            val end = stackLists[stackData[5].toInt()-1]
                            //println("To -> $end")
                            end.addAll(0,source.take(amount.toInt()).reversed())
                            stackLists[stackData[3].toInt()-1] = source.drop(amount.toInt()).toMutableList()
                            //println("Result ->")
                            //stackLists.forEach { print(" $it ") }
                            //println()
                        }
                    }
                }
            }
        }
        println()
        stackLists.forEach { println("Stack ${stackLists.indexOf(it)+1} has crate ${it.firstOrNull()}. ") }
        val timeEnd = System.currentTimeMillis()
        println("Took ${(timeEnd-timeStart)/1000} seconds")

    }

    fun p2() {
        val timeStart = System.currentTimeMillis()
        val bufferedReader = File("src/main/kotlin/year2022/day5/input.txt").bufferedReader()
        val stackLists = mutableListOf<MutableList<String>>(mutableListOf())

        bufferedReader.useLines { lines ->
            lines.forEach { l ->
                if(l.isNotEmpty()){
                    val stackData = l.split("\\s{1,4}".toRegex())
                    val stack = l.trim().split("\\s{1,3}".toRegex())
                    //println(stackData)
                    //println(stack)
                    if(stackData[0] != "move" && stack[0].toIntOrNull() == null){
                        stackData.forEachIndexed { index, s ->
                            if (s != "") {
                                //println("Letter $s Index $index")
                                if (stackLists.getOrNull(index) == null) {
                                    repeat(index-stackLists.size+1) { stackLists.add(mutableListOf()) }
                                    //println(stackLists)
                                    stackLists[index].add(s)
                                    //println("Copied")
                                } else {
                                    stackLists[index].add(s)
                                    //println("Added")
                                }
                            }
                            //stackLists.forEach { println(" $it ") }
                        }
                    }else{
                        if(stackData.size == 6){
                            //println("================")
                            //print("Original ->")
                            //stackLists.forEach { print(" $it ") }
                            //println()
                            val source = stackLists[stackData[3].toInt()-1]
                            //println("From -> $source")
                            val amount = stackData[1]
                            //println("Amount -> $amount")
                            val end = stackLists[stackData[5].toInt()-1]
                            //println("To -> $end")
                            end.addAll(0,source.take(amount.toInt()))
                            stackLists[stackData[3].toInt()-1] = source.drop(amount.toInt()).toMutableList()
                            //println("Result ->")
                            //stackLists.forEach { print(" $it ") }
                            //println()
                        }
                    }
                }
            }
        }
        println()
        stackLists.forEach { println("Stack ${stackLists.indexOf(it)+1} has crate ${it.firstOrNull()}. ") }
        val timeEnd = System.currentTimeMillis()
        println("Took ${(timeEnd-timeStart)/1000} seconds")
    }
}