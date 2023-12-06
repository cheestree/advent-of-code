package utils

fun String.isNumeric(): Boolean {
    return this.all { char -> char.isDigit() }
}