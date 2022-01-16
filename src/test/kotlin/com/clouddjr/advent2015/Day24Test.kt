package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsListOfLong
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 24")
class Day24Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches actual`() {
            val answer = Day24(resourceAsListOfLong("day24.txt")).solvePart1()

            assertEquals(11_846_773_891, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches actual`() {
            val answer = Day24(resourceAsListOfLong("day24.txt")).solvePart2()

            assertEquals(80_393_059, answer)
        }
    }
}