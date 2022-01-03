package com.clouddjr.advent2015

import com.clouddjr.advent2015.utils.permutations

class Day09(input: List<String>) {

    private val distances = input.associateBy(
        { it.substringBefore(" = ").split(" to ").toSet() },
        { it.substringAfter(" = ").toInt() }
    )

    private val locations = distances.keys.flatten().distinct()

    fun solvePart1() = findDistances().minOf { it }

    fun solvePart2() = findDistances().maxOf { it }

    private fun findDistances(): List<Int> {
        return locations.permutations().map { permutation ->
            permutation.windowed(2).sumOf { distances.getValue(it.toSet()) }
        }
    }
}