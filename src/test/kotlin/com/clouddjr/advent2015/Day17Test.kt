package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsListOfInt
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 17")
class Day17Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches actual`() {
            val answer = Day17(resourceAsListOfInt("day17.txt")).solvePart1()

            assertEquals(1638, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches actual`() {
            val answer = Day17(resourceAsListOfInt("day17.txt")).solvePart2()

            assertEquals(17, answer)
        }
    }
}