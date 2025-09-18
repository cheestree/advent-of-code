package y2022.d05

import common.Day
import common.Utils.readInput
import java.io.File
import kotlin.sequences.forEach

object D05 : Day<Int, Int> {
    override fun p1(): Int {
        val input = readInput()
        val stackLists = mutableListOf<MutableList<String>>(mutableListOf())

        input.useLines { lines ->
            lines.forEach { l ->
                if(l.isNotEmpty()){
                    val stackData = l.split("\\s{1,4}".toRegex())
                    val stack = l.trim().split("\\s{1,3}".toRegex())
                    if(stackData[0] != "move" && stack[0].toIntOrNull() == null){
                        stackData.forEachIndexed { index, s ->
                            if (s != "") {
                                if (stackLists.getOrNull(index) == null) {
                                    repeat(index-stackLists.size+1) { stackLists.add(mutableListOf()) }
                                    stackLists[index].add(s)
                                } else {
                                    stackLists[index].add(s)
                                }
                            }
                        }
                    }else{
                        if(stackData.size == 6){
                            val source = stackLists[stackData[3].toInt()-1]
                            val amount = stackData[1]
                            val end = stackLists[stackData[5].toInt()-1]
                            end.addAll(0,source.take(amount.toInt()).reversed())
                            stackLists[stackData[3].toInt()-1] = source.drop(amount.toInt()).toMutableList()
                        }
                    }
                }
            }
        }

        return 0
    }

    override fun p2(): Int {
        val input = readInput()
        val stackLists = mutableListOf<MutableList<String>>(mutableListOf())

        input.useLines { lines ->
            lines.forEach { l ->
                if(l.isNotEmpty()){
                    val stackData = l.split("\\s{1,4}".toRegex())
                    val stack = l.trim().split("\\s{1,3}".toRegex())
                    if(stackData[0] != "move" && stack[0].toIntOrNull() == null){
                        stackData.forEachIndexed { index, s ->
                            if (s != "") {
                                if (stackLists.getOrNull(index) == null) {
                                    repeat(index-stackLists.size+1) { stackLists.add(mutableListOf()) }
                                    stackLists[index].add(s)
                                } else {
                                    stackLists[index].add(s)
                                }
                            }
                        }
                    }else{
                        if(stackData.size == 6){
                            val source = stackLists[stackData[3].toInt()-1]
                            val amount = stackData[1]
                            val end = stackLists[stackData[5].toInt()-1]
                            end.addAll(0,source.take(amount.toInt()))
                            stackLists[stackData[3].toInt()-1] = source.drop(amount.toInt()).toMutableList()
                        }
                    }
                }
            }
        }

        return 0
    }
}