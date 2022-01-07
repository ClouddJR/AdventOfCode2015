package com.clouddjr.advent2015.utils

data class Point2D(val x: Int, val y: Int) {
    fun neighboursWithDiagonals(): List<Point2D> {
        return (-1..1).flatMap { dy -> (-1..1).map { dx -> dx to dy } }
            .filterNot { (dx, dy) -> dx == 0 && dy == 0 }
            .map { (dx, dy) -> Point2D(x + dx, y + dy) }
    }
}