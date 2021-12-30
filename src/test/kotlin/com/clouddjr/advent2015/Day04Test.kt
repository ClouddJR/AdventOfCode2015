package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 4")
class Day04Test {

    private val input = """
        pqrstuv
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day04(input).solvePart1()

            assertEquals(1_048_970, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day04(resourceAsText("day04.txt")).solvePart1()

            assertEquals(346_386, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day04(input).solvePart2()

            assertEquals(5_714_438, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day04(resourceAsText("day04.txt")).solvePart2()

            assertEquals(9_958_218, answer)
        }
    }
}