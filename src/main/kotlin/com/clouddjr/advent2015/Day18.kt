package com.clouddjr.advent2015

import com.clouddjr.advent2015.utils.Point2D
import com.clouddjr.advent2015.utils.toInt

class Day18(input: List<String>) {

    private val initialConfig = input.flatMapIndexed { y, row -> row.mapIndexed { x, c -> Point2D(x, y) to c } }
        .associate { it.first to it.second }
        .mapValues { it.value == '#' }

    private val yMax = input.size - 1

    private val xMax = input.first().length - 1

    private val corners = setOf(Point2D(0, 0), Point2D(xMax, 0), Point2D(0, yMax), Point2D(xMax, yMax))

    fun solvePart1() = animate()

    fun solvePart2() = animate(freezeCorners = true)

    private fun animate(steps: Int = 100, freezeCorners: Boolean = false): Int {
        return (1..steps).fold(initialConfig) { config, _ ->
            config.mapValues { (point, isOn) ->
                if (freezeCorners && point in corners) return@mapValues true
                when (point.neighboursWithDiagonals().sumOf { config.getOrDefault(it, false).toInt() }) {
                    3 -> true
                    2 -> isOn
                    else -> false
                }
            }
        }.count { it.value }
    }
}