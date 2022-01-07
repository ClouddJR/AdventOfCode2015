package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 18")
class Day18Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches actual`() {
            val answer = Day18(resourceAsList("day18.txt")).solvePart1()

            assertEquals(768, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches actual`() {
            val answer = Day18(resourceAsList("day18.txt")).solvePart2()

            assertEquals(781, answer)
        }
    }
}