package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 20")
class Day20Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches actual`() {
            val answer = Day20(resourceAsText("day20.txt")).solvePart1()

            assertEquals(786_240, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches actual`() {
            val answer = Day20(resourceAsText("day20.txt")).solvePart2()

            assertEquals(831_600, answer)
        }
    }
}