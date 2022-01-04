package com.clouddjr.advent2015

import com.clouddjr.advent2015.utils.substringBetween

class Day15(input: List<String>) {

    private val ingredients = input.map { Ingredient.from(it) }

    fun solvePart1() = bestScore()

    fun solvePart2() = bestScore(withCalories = true)

    private fun bestScore(withCalories: Boolean = false): Int {
        return configurations().maxOf { config ->
            val cookie = config.zip(ingredients).map { it.second * it.first }.reduce { a, b -> a + b }
            when {
                withCalories && cookie.calories != 500 -> 0
                else -> cookie.score()
            }
        }
    }

    private fun configurations(n: Int = this.ingredients.size, current: List<Int> = emptyList()): List<List<Int>> {
        return when (n == 1) {
            true -> listOf(current + (100 - current.sum()))
            false -> (0..(100 - current.sum())).fold(emptyList()) { acc, i -> acc + configurations(n - 1, current + i) }
        }
    }

    private data class Ingredient(
        val capacity: Int, val durability: Int, val flavor: Int, val texture: Int, val calories: Int
    ) {
        operator fun times(teaspoons: Int) = Ingredient(
            teaspoons * capacity,
            teaspoons * durability,
            teaspoons * flavor,
            teaspoons * texture,
            teaspoons * calories
        )

        operator fun plus(other: Ingredient) = Ingredient(
            other.capacity + capacity,
            other.durability + durability,
            other.flavor + flavor,
            other.texture + texture,
            other.calories + calories
        )

        fun score() = listOf(capacity, durability, flavor, texture).map { maxOf(0, it) }.reduce { acc, i -> acc * i }

        companion object {
            fun from(line: String): Ingredient {
                return Ingredient(
                    line.substringBetween("capacity ", ",").toInt(),
                    line.substringBetween("durability ", ",").toInt(),
                    line.substringBetween("flavor ", ",").toInt(),
                    line.substringBetween("texture ", ",").toInt(),
                    line.substringBetween("calories ", ",").toInt(),
                )
            }
        }
    }
}