package com.clouddjr.advent2015

class Day06(input: List<String>) {

    private val rectangles = input.map { Rectangle.from(it) }

    fun solvePart1(): Int {
        return solve { command, current ->
            when (command) {
                "turn on" -> 1
                "turn off" -> 0
                "toggle" -> 1 - current
                else -> error("Unsupported command")
            }
        }
    }

    fun solvePart2(): Int {
        return solve { command, current ->
            when (command) {
                "turn on" -> current + 1
                "turn off" -> maxOf(0, current - 1)
                "toggle" -> current + 2
                else -> error("Unsupported command")
            }
        }
    }

    private fun solve(handleCommand: (command: String, current: Int) -> Int): Int {
        val uniqueX = rectangles.flatMap { listOf(it.x1, it.x2) }.distinct().sorted()
        val uniqueY = rectangles.flatMap { listOf(it.y1, it.y2) }.distinct().sorted()
        val indexedX = uniqueX.withIndex().associateBy({ it.value }, { it.index })
        val indexedY = uniqueY.withIndex().associateBy({ it.value }, { it.index })
        val grid = Array(uniqueX.size) { Array(uniqueY.size) { 0 } }
        rectangles.forEach {
            (indexedX[it.x1]!! until indexedX[it.x2]!!).forEach { x ->
                (indexedY[it.y1]!! until indexedY[it.y2]!!).forEach { y ->
                    grid[x][y] = handleCommand(it.command, grid[x][y])
                }
            }
        }
        return (0 until uniqueX.lastIndex).sumOf { x ->
            (0 until uniqueY.lastIndex).sumOf { y ->
                grid[x][y] * (uniqueX[x + 1] - uniqueX[x]) * (uniqueY[y + 1] - uniqueY[y])
            }
        }
    }

    private class Rectangle(val command: String, val x1: Int, val x2: Int, val y1: Int, val y2: Int) {
        companion object {
            private const val pattern = """(.+) (\d+),(\d+) through (\d+),(\d+)"""

            fun from(line: String): Rectangle {
                val (command, x1, y1, x2, y2) = pattern.toRegex().matchEntire(line)!!.destructured
                return Rectangle(command, x1.toInt(), x2.toInt() + 1, y1.toInt(), y2.toInt() + 1)
            }
        }
    }
}