package com.clouddjr.advent2015

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

    private fun List<String>.permutations(): Set<List<String>> {
        if (size == 1) return setOf(this)
        return fold(emptySet()) { acc, s -> acc + (this - s).permutations().map { it + s } }
    }
}