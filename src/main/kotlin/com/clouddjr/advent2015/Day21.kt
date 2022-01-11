package com.clouddjr.advent2015

import kotlin.math.ceil

class Day21(input: List<String>) {

    private val boss = Character(
        input[0].substringAfter(": ").toInt(),
        input[1].substringAfter(": ").toInt(),
        input[2].substringAfter(": ").toInt(),
    )

    private val player = Character(100, 0, 0)

    private val weapons = listOf(
        Equipment(8, 4, 0),
        Equipment(10, 5, 0),
        Equipment(25, 6, 0),
        Equipment(40, 7, 0),
        Equipment(74, 8, 0),
    )

    private val armors = listOf(
        Equipment(0, 0, 0),
        Equipment(13, 0, 1),
        Equipment(31, 0, 2),
        Equipment(53, 0, 3),
        Equipment(75, 0, 4),
        Equipment(102, 0, 5),
    )

    private val rings = listOf(
        Equipment(0, 0, 0),
        Equipment(0, 0, 0),
        Equipment(25, 1, 0),
        Equipment(50, 2, 0),
        Equipment(100, 3, 0),
        Equipment(20, 0, 1),
        Equipment(40, 0, 2),
        Equipment(80, 0, 3),
    )

    fun solvePart1(): Int {
        return equipmentCombinations()
            .sortedBy { it.cost }
            .first {
                player.withEquipment(it).let { player ->
                    player.roundsToWinWith(boss) <= boss.roundsToWinWith(player)
                }
            }.cost
    }

    fun solvePart2(): Int {
        return equipmentCombinations()
            .sortedByDescending { it.cost }
            .first {
                player.withEquipment(it).let { player ->
                    player.roundsToWinWith(boss) > boss.roundsToWinWith(player)
                }
            }.cost
    }

    private fun equipmentCombinations(): List<Equipment> {
        return weapons.flatMap { weapon ->
            armors.flatMap { armor ->
                rings.flatMap { ring1 ->
                    rings.mapNotNull { ring2 ->
                        when (ring1.cost != 0 && ring2.cost != 0 && ring1.cost == ring2.cost) {
                            true -> null
                            false -> weapon + armor + ring1 + ring2
                        }
                    }
                }
            }
        }
    }

    private data class Character(val hp: Int, val damage: Int, val armor: Int) {
        fun withEquipment(equipment: Equipment): Character {
            return Character(hp, damage + equipment.damage, armor + equipment.armor)
        }

        fun roundsToWinWith(other: Character) = ceil(other.hp / maxOf((damage - other.armor), 1).toDouble()).toInt()
    }

    private data class Equipment(val cost: Int, val damage: Int, val armor: Int) {
        operator fun plus(other: Equipment): Equipment {
            return Equipment(cost + other.cost, damage + other.damage, armor + other.armor)
        }
    }
}