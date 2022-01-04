package com.clouddjr.advent2015.utils

fun List<String>.permutations(): Set<List<String>> {
    if (size == 1) return setOf(this)
    return fold(emptySet()) { acc, s -> acc + (this - s).permutations().map { it + s } }
}

fun String.substringBetween(startDelimiter: String, endDelimiter: String): String {
    return substringAfter(startDelimiter).substringBefore(endDelimiter)
}