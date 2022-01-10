package com.clouddjr.advent2015

import kotlin.math.sqrt

class Day20(input: String) {

    private val target = input.toInt()

    fun solvePart1() = houses().first { presentsPart1(it) >= target }

    fun solvePart2() = houses().first { presentsPart2(it) >= target }

    private fun houses() = generateSequence(1) { it + 1 }

    private fun presentsPart1(house: Int) = house.divisors().sum() * 10

    private fun presentsPart2(house: Int) = house.divisors().filter { it * 50 >= house }.sum() * 11

    private fun Int.divisors(): Set<Int> {
        return (1..sqrt(toDouble()).toInt()).filter { this % it == 0 }.flatMap { listOf(it, this / it) }.toSet()
    }
}