package common

import java.io.BufferedReader

object Utils {
    fun String.isNumeric(): Boolean {
        return this.all { char -> char.isDigit() }
    }
    fun readInput(pkg: String? = null): BufferedReader {
        //  Retrieves the class name based on the runtime stacktrace
        val callerClassName = Throwable().stackTrace
            .first { it.className != this::class.java.name }
            .className
        val callerClass = Class.forName(callerClassName)

        //  Fetches the class based on the name and then its package name
        val callerPackage = callerClass.packageName
        println(callerPackage)

        //  Formats package path to be relative to src
        val resourcePath = "/${callerPackage.replace('.', '/')}/input.txt"
        println("Caller: $callerClassName")
        println("Looking for resource at: $resourcePath")

        val inputStream = callerClass.getResourceAsStream(resourcePath)
            ?: throw IllegalArgumentException("Resource not found")

        return inputStream.bufferedReader()
    }
}