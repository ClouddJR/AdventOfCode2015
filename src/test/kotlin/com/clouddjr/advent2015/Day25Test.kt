package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 25")
class Day25Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches actual`() {
            val answer = Day25(resourceAsText("day25.txt")).solvePart1()

            assertEquals(2_650_453, answer)
        }
    }
}