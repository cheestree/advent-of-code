package y2022.d07

import common.Day

object D07 : Day<Int, Int> {
    override fun p1(): Int {
    /*
        val input = readInput()
        var memUsed = 0
        var previousOp = ""
        val directories = mutableListOf<FileDummy>()
        var currentDirectory = mutableListOf<FileDummy>()

        input.useLines { lines ->
            lines.forEach { l ->
                val line = l.split(" ")
                when (line[0]){
                    "$" -> when (line[1]){
                        "cd" -> when (line[2]){
                            "/" -> {
                                currentDirectory = directories;
                                previousOp = "cd";
                            }
                            ".." -> {
                            }
                            else -> {
                                currentDirectory = currentDirectory.first{ f -> f.name == line[2] }.list!!
                            }
                        }
                        "ls" -> {
                            previousOp = "ls"
                        }
                    }
                    else -> {
                        when (previousOp) {
                            "ls" -> {
                                if(line[0].all{ it.isDigit() }){
                                    memUsed += line[0].toInt()
                                    currentDirectory += FileDummy(line[1], line[0].toInt())
                                }else{
                                    currentDirectory += FileDummy(line[1], null)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

        data class FileDummy(val nameFF : String, var sizeFF : Int?){
            var size = sizeFF
            var name = nameFF
            var isDirectory = size == null
            var list : MutableList<FileDummy>? = if(isDirectory) mutableListOf() else null

            fun getSize() : Int? {
                return if(list == null) this.size else getSize()
        }
    */
        TODO()
    }

    override fun p2(): Int {
        TODO()
    }
}