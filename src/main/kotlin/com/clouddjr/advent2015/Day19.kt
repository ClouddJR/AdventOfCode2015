package com.clouddjr.advent2015

class Day19(input: List<String>) {

    private val replacements = input.dropLast(2).map { it.split(" => ") }.groupBy({ it.first() }, { it.last() })

    private val reversedReplacements = input.dropLast(2)
        .map { it.split(" => ") }
        .sortedByDescending { it.last().length }
        .associate { it.last() to it.first() }

    private val initial = input.last()

    fun solvePart1(): Int {
        return buildSet {
            replacements.forEach { (pattern, replacements) ->
                addAll(
                    Regex(pattern).findAll(initial)
                        .flatMap { match -> replacements.map { initial.replaceRange(match.range, it) } }
                )
            }
        }.size
    }

    fun solvePart2() = minimumSteps()

    private fun minimumSteps(current: String = initial, cost: Int = 0, goal: String = "e"): Int? {
        if (current == goal) return cost
        return reversedReplacements.firstNotNullOfOrNull { (pattern, replacement) ->
            Regex(pattern).findAll(current)
                .map { match -> current.replaceRange(match.range, replacement) }
                .firstNotNullOfOrNull { minimumSteps(it, cost + 1) }
        }
    }
}