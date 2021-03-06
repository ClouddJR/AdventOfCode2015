package com.clouddjr.advent2015

import com.clouddjr.advent2015.utils.allCombinations

class Day17(private val input: List<Int>) {

    fun solvePart1() = correctCombinations().size

    fun solvePart2(): Int {
        return correctCombinations().let { combinations ->
            val minimum = combinations.minOf { it.size }
            combinations.count { it.size == minimum }
        }
    }

    private fun correctCombinations() = input.allCombinations().filter { it.sum() == 150 }
}