package com.clouddjr.advent2015

import com.clouddjr.advent2015.utils.Point2D

typealias House = Point2D

class Day03(private val input: String) {

    fun solvePart1() = input.scan(House(0, 0)) { house, dir -> house.next(dir) }.toSet().size

    fun solvePart2(): Int {
        val santaTurns = input.filterIndexed { index, _ -> index % 2 == 0 }
        val robotTurns = input.filterIndexed { index, _ -> index % 2 == 1 }

        val santaHouses = santaTurns.scan(House(0, 0)) { house, dir -> house.next(dir) }.toSet()
        val robotHouses = robotTurns.scan(House(0, 0)) { house, dir -> house.next(dir) }.toSet()

        return (santaHouses union robotHouses).size
    }

    private fun House.next(dir: Char): House {
        return when (dir) {
            '^' -> copy(y = y + 1)
            'v' -> copy(y = y - 1)
            '>' -> copy(x = x + 1)
            '<' -> copy(x = x - 1)
            else -> error("Unsupported direction")
        }
    }
}