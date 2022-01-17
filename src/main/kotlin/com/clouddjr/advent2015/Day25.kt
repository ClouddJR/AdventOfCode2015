package com.clouddjr.advent2015

import com.clouddjr.advent2015.utils.sequenceSum
import com.clouddjr.advent2015.utils.substringBetween

class Day25(input: String) {

    private val row = input.substringBetween("row ", ",").toInt() - 1

    private val col = input.substringBetween("column ", ".").toInt() - 1

    private val start = 20151125L

    fun solvePart1() = (2..(row + col + 1).sequenceSum() - row).fold(start) { acc, _ -> (acc * 252533) % 33554393 }
}