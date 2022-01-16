package com.clouddjr.advent2015

import com.clouddjr.advent2015.utils.combinations

class Day24(private val input: List<Long>) {

    fun solvePart1() = balanceTheSleigh(input.sum() / 3)

    fun solvePart2() = balanceTheSleigh(input.sum() / 4)

    private fun balanceTheSleigh(requiredSum: Long): Long {
        return (1..input.size).firstNotNullOf { size ->
            input.combinations(size).filter { it.sum() == requiredSum }.minOfOrNull { it.reduce { acc, i -> acc * i } }
        }
    }
}