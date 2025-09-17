package common

import java.io.BufferedReader

object Utils {
    fun String.isNumeric(): Boolean {
        return this.all { char -> char.isDigit() }
    }
    fun readResource(resource: String): BufferedReader {
        val inputStream = object {}.javaClass.getResourceAsStream(resource)
            ?: throw IllegalArgumentException("Resource not found")

        return inputStream.bufferedReader()
    }
}