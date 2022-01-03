package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 14")
class Day14Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches actual`() {
            val answer = Day14(resourceAsList("day14.txt")).solvePart1()

            assertEquals(2660, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches actual`() {
            val answer = Day14(resourceAsList("day14.txt")).solvePart2()

            assertEquals(1256, answer)
        }
    }
}