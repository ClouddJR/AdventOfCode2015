package com.clouddjr.advent2015

class Day02(input: List<String>) {

    private val presents = input.map { Present.from(it) }

    fun solvePart1() = presents.sumOf { present -> present.area() + present.smallestFaceArea() }

    fun solvePart2() = presents.sumOf { present -> present.smallestFacePerimeter() + present.volume() }

    private class Present(val length: Int, val width: Int, val height: Int) {
        val sides = arrayOf(length to width, length to height, width to height)

        fun area() = sides.fold(0) { acc, side -> acc + 2 * side.first * side.second }

        fun smallestFaceArea() = sides.minOf { it.first * it.second }

        fun smallestFacePerimeter() = sides.minOf { 2 * it.first + 2 * it.second }

        fun volume() = length * width * height

        companion object {
            fun from(line: String): Present {
                val dimensions = line.split("x").map { it.toInt() }
                return Present(dimensions[0], dimensions[1], dimensions[2])
            }
        }
    }
}