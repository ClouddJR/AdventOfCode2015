package com.clouddjr.advent2015

import com.clouddjr.advent2015.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 19")
class Day19Test {

    private val inputPart1 = """
        H => HO
        H => OH
        O => HH
        
        HOH
    """.trimIndent().lines()

    private val inputPart2 = """
        e => H
        e => O
        H => HO
        H => OH
        O => HH
        
        HOHOHO
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day19(inputPart1).solvePart1()

            assertEquals(4, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day19(resourceAsList("day19.txt")).solvePart1()

            assertEquals(535, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day19(inputPart2).solvePart2()

            assertEquals(6, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day19(resourceAsList("day19.txt")).solvePart2()

            assertEquals(212, answer)
        }
    }
}