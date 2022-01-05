package com.clouddjr.advent2015

import com.clouddjr.advent2015.utils.substringBetween

class Day16(input: List<String>) {

    private val aunts = input.map { Aunt.from(it) }

    private val machineResultPart1 = mapOf(
        "children" to 3..3,
        "cats" to 7..7,
        "samoyeds" to 2..2,
        "pomeranians" to 3..3,
        "akitas" to 0..0,
        "vizslas" to 0..0,
        "goldfish" to 5..5,
        "trees" to 3..3,
        "cars" to 2..2,
        "perfumes" to 1..1,
    )

    private val machineResultPart2 = mapOf(
        "children" to 3..3,
        "cats" to 8..Int.MAX_VALUE,
        "samoyeds" to 2..2,
        "pomeranians" to 0..4,
        "akitas" to 0..0,
        "vizslas" to 0..0,
        "goldfish" to 0..4,
        "trees" to 4..Int.MAX_VALUE,
        "cars" to 2..2,
        "perfumes" to 1..1,
    )

    fun solvePart1() = matchingAuntNumber(machineResultPart1)

    fun solvePart2() = matchingAuntNumber(machineResultPart2)

    private fun matchingAuntNumber(machineResult: Map<String, IntRange>): Int {
        return aunts.first { aunt -> aunt.compounds.all { it.value in machineResult.getValue(it.key) } }.number
    }

    private data class Aunt(val number: Int, val compounds: Map<String, Int>) {
        companion object {
            fun from(line: String): Aunt {
                return Aunt(
                    line.substringBetween("Sue ", ":").toInt(),
                    line.substringAfter(": ").split(",").map { it.trim() }
                        .associateBy({ it.substringBefore(":") }, { it.substringAfter(": ").toInt() })
                )
            }
        }
    }
}