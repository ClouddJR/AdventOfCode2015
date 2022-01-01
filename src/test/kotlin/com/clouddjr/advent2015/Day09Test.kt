package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 9")
class Day09Test {

    private val input = """
        London to Dublin = 464
        London to Belfast = 518
        Dublin to Belfast = 141
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day09(input).solvePart1()

            assertEquals(605, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day09(resourceAsList("day09.txt")).solvePart1()

            assertEquals(141, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day09(input).solvePart2()

            assertEquals(982, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day09(resourceAsList("day09.txt")).solvePart2()

            assertEquals(736, answer)
        }
    }
}