package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 1")
class Day01Test {

    private val input = """
        ()())
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day01(input).solvePart1()

            assertEquals(-1, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day01(resourceAsText("day01.txt")).solvePart1()

            assertEquals(280, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day01(input).solvePart2()

            assertEquals(5, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day01(resourceAsText("day01.txt")).solvePart2()

            assertEquals(1797, answer)
        }
    }
}