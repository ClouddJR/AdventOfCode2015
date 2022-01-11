package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 21")
class Day21Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches actual`() {
            val answer = Day21(resourceAsList("day21.txt")).solvePart1()

            assertEquals(91, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches actual`() {
            val answer = Day21(resourceAsList("day21.txt")).solvePart2()

            assertEquals(158, answer)
        }
    }
}