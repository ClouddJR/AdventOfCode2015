package com.clouddjr.advent2015

class Day05(private val input: List<String>) {

    fun solvePart1() = input.count { it.isNicePart1() }

    fun solvePart2() = input.count { it.isNicePart2() }

    private fun String.isNicePart1(): Boolean {
        val vowels = "aeiou".toCharArray()
        val forbidden = arrayOf("ab", "cd", "pq", "xy")

        val rule1 = count { it in vowels } >= 3
        val rule2 = windowed(2).any { it.first() == it.last() }
        val rule3 = windowed(2).none { it in forbidden }

        return rule1 && rule2 && rule3
    }

    private fun String.isNicePart2(): Boolean {
        val rule1 = windowed(2).any { pair -> contains("""$pair.*$pair""".toRegex()) }
        val rule2 = windowed(3).any { it.first() == it.last() }

        return rule1 && rule2
    }
}