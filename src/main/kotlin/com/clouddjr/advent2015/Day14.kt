package com.clouddjr.advent2015

class Day14(input: List<String>) {

    private val reindeer = input.map { Reindeer.from(it) }

    private val initialState = RaceState(1, reindeer.associateWith { 0 }, reindeer.associateWith { it.speed })

    fun solvePart1() = race().elementAt(DURATION).distances.values.maxOf { it }

    fun solvePart2() = race().elementAt(DURATION).points.values.maxOf { it }

    private fun race() = generateSequence(initialState) { it.next() }

    private data class RaceState(val second: Int, val points: Map<Reindeer, Int>, val distances: Map<Reindeer, Int>) {
        fun next(): RaceState {
            val lead = distances.values.maxOf { it }
            return RaceState(
                second + 1,
                points.mapValues { if (distances[it.key] == lead) it.value + 1 else it.value },
                distances.mapValues { if (it.key.isFlying(second)) it.value + it.key.speed else it.value }
            )
        }
    }

    private data class Reindeer(val speed: Int, val seconds: Int, val rest: Int) {
        fun cycle() = seconds + rest

        fun isFlying(second: Int) = second % cycle() in 0 until seconds

        companion object {
            private val pattern = Regex(""".* (\d+) km/s.* (\d+) seconds.* (\d+) seconds\.""")

            fun from(line: String): Reindeer {
                val (speed, seconds, rest) = pattern.matchEntire(line)!!.destructured
                return Reindeer(speed.toInt(), seconds.toInt(), rest.toInt())
            }
        }
    }

    private companion object {
        const val DURATION = 2503
    }
}