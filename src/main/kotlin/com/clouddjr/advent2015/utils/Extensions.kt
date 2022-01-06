package com.clouddjr.advent2015.utils

fun <T> List<T>.permutations(): List<List<T>> {
    if (size == 1) return listOf(this)
    return fold(emptyList()) { acc, s -> acc + (this - s).permutations().map { it + s } }
}

fun <T> List<T>.combinations(current: List<T> = emptyList()): List<List<T>> {
    return this.foldIndexed(emptyList<List<T>>()) { index, acc, next ->
        acc + listOf(current + next) + drop(index + 1).combinations(current + next)
    }.filterNot { it.isEmpty() }
}

fun String.substringBetween(startDelimiter: String, endDelimiter: String): String {
    return substringAfter(startDelimiter).substringBefore(endDelimiter)
}