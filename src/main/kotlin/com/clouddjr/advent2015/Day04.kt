package com.clouddjr.advent2015

import java.math.BigInteger
import java.security.MessageDigest

class Day04(private val input: String) {

    fun solvePart1() = hashes().indexOfFirst { (hash, _) -> hash.take(5) == "00000" }

    fun solvePart2() = hashes().indexOfFirst { (hash, _) -> hash.take(6) == "000000" }

    private fun hashes() = generateSequence("" to 1) { (_, i) -> md5("$input${i}") to i + 1 }

    private fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}