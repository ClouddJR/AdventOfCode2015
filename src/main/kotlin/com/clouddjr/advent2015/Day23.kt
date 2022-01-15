package com.clouddjr.advent2015

import com.clouddjr.advent2015.utils.substringBetween

class Day23(private val input: List<String>) {

    fun solvePart1() = execute(initialAValue = 0)

    fun solvePart2() = execute(initialAValue = 1)

    private fun execute(initialAValue: Int): Int {
        val registers = mutableMapOf("a" to initialAValue, "b" to 0)
        var pointer = 0

        while (pointer < input.size) {
            val cmd = input[pointer++]
            when {
                "hlf" in cmd -> registers.compute(cmd.substringAfter(" ")) { _, value -> value!! / 2 }
                "tpl" in cmd -> registers.compute(cmd.substringAfter(" ")) { _, value -> value!! * 3 }
                "inc" in cmd -> registers.compute(cmd.substringAfter(" ")) { _, value -> value!! + 1 }
                "jmp" in cmd -> pointer += cmd.substringAfter(" ").toInt() - 1
                "jie" in cmd -> {
                    registers.getValue(cmd.substringBetween(" ", ","))
                        .takeIf { it % 2 == 0 }
                        ?.let { pointer += cmd.substringAfter(", ").toInt() - 1 }
                }
                "jio" in cmd -> {
                    registers.getValue(cmd.substringBetween(" ", ","))
                        .takeIf { it == 1 }
                        ?.let { pointer += cmd.substringAfter(", ").toInt() - 1 }
                }
            }
        }

        return registers.getValue("b")
    }
}