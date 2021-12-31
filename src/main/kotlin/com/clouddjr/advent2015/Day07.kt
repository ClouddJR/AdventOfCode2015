package com.clouddjr.advent2015

class Day07(input: List<String>) {

    private val instructions = input.map { it.split(" -> ") }.associateBy({ it.last() }, { it.first() })

    private val signals = mutableMapOf<String, Int>()

    fun solvePart1() = signalTo("a")

    fun solvePart2(): Int {
        signals["b"] = signalTo("a").also { signals.clear() }
        return signalTo("a")
    }

    private fun signalTo(signal: String): Int {
        return signal.toIntOrNull() ?: signals.getOrPut(signal) {
            val operation = instructions.getValue(signal)
            when {
                "AND" in operation -> {
                    val w1 = operation.substringBefore(" AND")
                    val w2 = operation.substringAfter("AND ")
                    signalTo(w1) and signalTo(w2)
                }
                "OR" in operation -> {
                    val w1 = operation.substringBefore(" OR")
                    val w2 = operation.substringAfter("OR ")
                    signalTo(w1) or signalTo(w2)
                }
                "LSHIFT" in operation -> {
                    val w = operation.substringBefore(" LSHIFT")
                    val x = operation.substringAfter("LSHIFT ").toInt()
                    signalTo(w) shl x
                }
                "RSHIFT" in operation -> {
                    val w = operation.substringBefore(" RSHIFT")
                    val x = operation.substringAfter("RSHIFT ").toInt()
                    signalTo(w) shr x
                }
                "NOT" in operation -> {
                    val w = operation.substringAfter("NOT ")
                    signalTo(w).inv()
                }
                else -> signalTo(operation)
            }
        }
    }
}