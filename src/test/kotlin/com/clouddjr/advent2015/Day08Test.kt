package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 8")
class Day08Test {

    private val input = """
        ""
        "abc"
        "aaa\"aaa"
        "\x27"
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day08(input).solvePart1()

            assertEquals(12, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day08(resourceAsList("day08.txt")).solvePart1()

            assertEquals(1333, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day08(input).solvePart2()

            assertEquals(19, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day08(resourceAsList("day08.txt")).solvePart2()

            assertEquals(2046, answer)
        }
    }
}