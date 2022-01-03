package com.clouddjr.advent2015

import com.clouddjr.advent2015.utils.permutations

class Day13(input: List<String>) {

    private val happiness = input.associate {
        val (first, op, value, second) = Regex("""(\w+).+(gain|lose) (\d+).* (\w+)\.""").matchEntire(it)!!.destructured
        (first to second) to if (op == "gain") value.toInt() else -value.toInt()
    }

    private val people = happiness.keys.map { it.first }.distinct()

    fun solvePart1() = optimalHappiness()

    fun solvePart2() = optimalHappiness(
        people + "me",
        happiness + people.flatMap { listOf(("me" to it) to 0, (it to "me") to 0) }
    )

    private fun optimalHappiness(
        people: List<String> = this.people,
        happiness: Map<Pair<String, String>, Int> = this.happiness
    ): Int {
        return people.permutations().maxOf {
            it.indices.sumOf { i ->
                val left = happiness[it[i] to it[(i + 1) % it.size]]!!
                val right = happiness[it[(i + 1) % it.size] to it[i]]!!
                left + right
            }
        }
    }
}