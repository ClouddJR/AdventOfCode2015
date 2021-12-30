package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 2")
class Day02Test {

    private val input = """
        2x3x4
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day02(input).solvePart1()

            assertEquals(58, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day02(resourceAsList("day02.txt")).solvePart1()

            assertEquals(1606483, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day02(input).solvePart2()

            assertEquals(34, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day02(resourceAsList("day02.txt")).solvePart2()

            assertEquals(3842356, answer)
        }
    }
}