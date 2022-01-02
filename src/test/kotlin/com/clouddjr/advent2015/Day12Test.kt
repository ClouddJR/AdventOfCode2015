package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 12")
class Day12Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches actual`() {
            val answer = Day12(resourceAsText("day12.txt")).solvePart1()

            assertEquals(156_366, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches actual`() {
            val answer = Day12(resourceAsText("day12.txt")).solvePart2()

            assertEquals(96_852, answer)
        }
    }
}