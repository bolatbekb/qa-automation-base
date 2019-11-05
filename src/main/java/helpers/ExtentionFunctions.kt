package helpers

fun String.extractInt(): Int {
    return this.filter { it.isDigit() }.toInt()
}