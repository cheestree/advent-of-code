package D5

import java.io.File

fun main(){
    val bufferedReader = File("src/main/kotlin/D5/input.txt").bufferedReader()
    var stackLists = Array<MutableList<String>?>(1) { mutableListOf() }

    bufferedReader.useLines { lines ->
        lines.forEach { l ->
            if(l.isNotEmpty()){
                var stackData = l.split("\\s{1,4}".toRegex())
                var stack = l.trim().split("\\s{1,3}".toRegex())
                if(stackData[0] != "move" && stack[0].toIntOrNull() == null){
                    stackData.forEachIndexed { index, s ->
                        if (s != "") {
                            println("Letter $s Index $index")
                            if (stackLists.getOrNull(index) == null) {
                                stackLists = stackLists.copyOf(index+1)
                                stackLists[index] = mutableListOf(s)
                            } else {
                                stackLists[index]?.plusAssign(s)
                            }
                        }
                    }
                }else{
                    if(stackData.size == 6){
                        println("================")
                        print("Original ->")
                        stackLists.forEach { print(" $it ") }
                        println()
                        val source = stackLists[stackData[3].toInt()-1]
                        println("From -> $source")
                        val amount = stackData[1]
                        println("Amount -> $amount")
                        var end = stackLists[stackData[5].toInt()-1]
                        println("To -> $end")
                        if (end != null) {
                            if (source != null) {
                                //end += (source.take(amount.toInt())).reversed()
                                end.addAll(0,source.take(amount.toInt()).reversed())
                            }
                        }
                        stackLists[stackData[3].toInt()-1] = source?.drop(amount.toInt())?.toMutableList()
                        println("Result ->")
                        stackLists.forEach { print(" $it ") }
                        println()
                    }
                }
            }
        }
    }
    stackLists.forEach { println("Stack ${stackLists.indexOf(it)} has crate ${it?.firstOrNull()}. ") }
}
