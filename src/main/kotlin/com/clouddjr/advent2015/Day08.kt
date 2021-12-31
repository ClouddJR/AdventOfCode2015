package com.clouddjr.advent2015

class Day08(private val input: List<String>) {

    private val initialSize = input.sumOf { it.length }

    fun solvePart1(): Int {
        return initialSize - input.asSequence()
            .map { it.drop(1).dropLast(1) }
            .map { it.replace("""\\""", """\""") }
            .map { it.replace("""\"""", """"""") }
            .map { it.replace("""\\x[0-9a-f]{2}""".toRegex(), ".") }
            .sumOf { it.length }
    }

    fun solvePart2(): Int {
        return input.asSequence()
            .map { it.drop(1).dropLast(1) }
            .map { it.replace("""\\""", """\\\\""") }
            .map { it.replace("""\"""", """\\\"""") }
            .map { it.replace("""\\x[0-9a-f]{2}""".toRegex(), ".....") }
            .map { """"\"$it\""""" }
            .sumOf { it.length } - initialSize
    }
}