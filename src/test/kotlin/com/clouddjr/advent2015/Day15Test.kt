package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 15")
class Day15Test {

    private val input = """
        Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8
        Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day15(input).solvePart1()

            assertEquals(62_842_880, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day15(resourceAsList("day15.txt")).solvePart1()

            assertEquals(13_882_464, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day15(input).solvePart2()

            assertEquals(57_600_000, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day15(resourceAsList("day15.txt")).solvePart2()

            assertEquals(11_171_160, answer)
        }
    }
}