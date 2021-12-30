package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 3")
class Day03Test {

    private val input = """
        ^v^v^v^v^v
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day03(input).solvePart1()

            assertEquals(2, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day03(resourceAsText("day03.txt")).solvePart1()

            assertEquals(2081, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day03(input).solvePart2()

            assertEquals(11, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day03(resourceAsText("day03.txt")).solvePart2()

            assertEquals(2341, answer)
        }
    }
}