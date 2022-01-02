package com.clouddjr.advent2015

class Day11(private val input: String) {

    fun solvePart1() = nextPassword()

    fun solvePart2() = nextPassword(nextPassword().incremented())

    private fun nextPassword(current: String = input): String {
        return generateSequence(current) { it.incremented() }
            .first { password ->
                password.windowed(3).any { it[2] - it[1] == 1 && it[1] - it[0] == 1 }
                        && !password.contains("[iol]".toRegex())
                        && password.contains("""(.)\1.*(.)\2""".toRegex())
            }
    }

    private fun String.incremented(): String {
        val z = takeLastWhile { it == 'z' }
        return dropLast(z.length + 1) + get(lastIndex - z.length).inc() + "a".repeat(z.length)
    }
}