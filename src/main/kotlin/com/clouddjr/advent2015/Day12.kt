package com.clouddjr.advent2015

class Day12(private val input: String) {

    fun solvePart1() = sumNumbers(input)

    fun solvePart2(): Int {
        return sumNumbers(
            generateSequence(input) { current ->
                """\{[^{}]*}""".toRegex().find(current)?.let {
                    current.replaceRange(it.range, if (":\"red\"" in it.value) "0" else "${sumNumbers(it.value)}")
                }
            }.last()
        )
    }

    private fun sumNumbers(s: String) = """-?\d+""".toRegex().findAll(s).sumOf { it.value.toInt() }
}