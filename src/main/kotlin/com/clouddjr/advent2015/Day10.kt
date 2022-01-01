package com.clouddjr.advent2015

class Day10(private val input: String) {

    fun solvePart1() = lookAndSay(40)

    fun solvePart2() = lookAndSay(50)

    private fun lookAndSay(steps: Int): Int {
        return (1..steps).fold(input) { current, _ ->
            """((\d)\2*)""".toRegex().findAll(current)
                .map { it.destructured.component1() }
                .joinToString("") { "${it.length}${it.first()}" }
        }.length
    }
}