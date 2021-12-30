package com.clouddjr.advent2015

class Day01(private val input: String) {

    fun solvePart1() = input.count { it == '(' } - input.count { it == ')' }

    fun solvePart2(): Int {
        return generateSequence(input to 0) { (instructions, floor) ->
            instructions.drop(1) to floor + if (instructions.first() == '(') 1 else -1
        }.indexOfFirst { (_, floor) -> floor == -1 }
    }
}