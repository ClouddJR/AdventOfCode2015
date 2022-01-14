package com.clouddjr.advent2015

class Day22(input: List<String>) {

    private val boss = Boss(input[0].substringAfter(": ").toInt(), input[1].substringAfter(": ").toInt())

    private val mage = Mage(50, 0, 500)

    private val cache = mutableMapOf<GameState, Int>()

    fun solvePart1() = play(isHard = false)

    fun solvePart2() = play(isHard = true)

    private fun play(state: GameState = GameState(mage, boss), usedMana: Int = 0, isHard: Boolean): Int {
        return when (state.hasWinner()) {
            true -> if (state.boss.hp <= 0) usedMana else Int.MAX_VALUE
            false -> cache.getOrPut(state) {
                state.nextStates(isHard).minOf { (next, cost) -> play(next, usedMana + cost, isHard) }
            }
        }
    }

    private data class Boss(val hp: Int, val damage: Int)

    private data class Mage(val hp: Int, val armor: Int, val mana: Int, val effects: List<EffectInUse> = emptyList())

    private sealed class Spell(val cost: Int) {
        abstract fun cast(mage: Mage, boss: Boss): Pair<Mage, Boss>

        companion object {
            val options = setOf(MagicMissile, Drain, Shield, Poison, Recharge)
        }
    }

    private sealed class Effect(cost: Int, val turns: Int) : Spell(cost)

    private object MagicMissile : Spell(53) {
        override fun cast(mage: Mage, boss: Boss) = mage.copy() to boss.copy(hp = boss.hp - 4)
    }

    private object Drain : Spell(73) {
        override fun cast(mage: Mage, boss: Boss) = mage.copy(hp = mage.hp + 2) to boss.copy(hp = boss.hp - 2)
    }

    private object Shield : Effect(113, 6) {
        override fun cast(mage: Mage, boss: Boss) = mage.copy(armor = 7) to boss.copy()
    }

    private object Poison : Effect(173, 6) {
        override fun cast(mage: Mage, boss: Boss) = mage.copy() to boss.copy(hp = boss.hp - 3)
    }

    private object Recharge : Effect(229, 5) {
        override fun cast(mage: Mage, boss: Boss) = mage.copy(mana = mage.mana + 101) to boss.copy()
    }

    private data class EffectInUse(val effect: Effect, val remainingTurns: Int)

    private data class GameState(val mage: Mage, val boss: Boss, val p1Turn: Boolean = true) {
        fun hasWinner() = mage.hp <= 0 || boss.hp <= 0

        fun nextStates(isHard: Boolean): List<Pair<GameState, Int>> {
            val punishedMage = mage.copy(hp = if (p1Turn && isHard) mage.hp - 1 else mage.hp)

            if (punishedMage.hp <= 0) {
                return listOf(copy(mage = punishedMage) to 0)
            }

            val (effectedMage, effectedBoss) = punishedMage.effects.fold(punishedMage to boss) { (mage, boss), effectInUse ->
                effectInUse.effect.cast(mage, boss)
            }

            val activeEffects = effectedMage.effects.map { it.copy(remainingTurns = it.remainingTurns - 1) }
                .filter { it.remainingTurns > 0 }

            return when (p1Turn) {
                false -> listOf(
                    GameState(
                        effectedMage.copy(
                            hp = effectedMage.hp - effectedBoss.damage + effectedMage.armor,
                            armor = 0,
                            effects = activeEffects
                        ), effectedBoss, true
                    ) to 0
                )
                true -> {
                    Spell.options.filter { it.cost <= effectedMage.mana }
                        .filterNot { spell -> spell in activeEffects.map { it.effect } }
                        .takeIf { it.isNotEmpty() }?.let { possibleSpells ->
                            val statesWithEffects = possibleSpells.filterIsInstance<Effect>()
                                .map { spell ->
                                    GameState(
                                        effectedMage.copy(
                                            mana = effectedMage.mana - spell.cost,
                                            armor = 0,
                                            effects = activeEffects + EffectInUse(spell, spell.turns)
                                        ), effectedBoss, false
                                    ) to spell.cost
                                }
                            val statesWithRegularSpells = possibleSpells.filterNot { it is Effect }
                                .map { spell ->
                                    spell.cast(effectedMage, effectedBoss).let { (castMage, castBoss) ->
                                        GameState(
                                            castMage.copy(
                                                mana = castMage.mana - spell.cost,
                                                armor = 0,
                                                effects = activeEffects
                                            ), castBoss, false
                                        ) to spell.cost
                                    }
                                }
                            statesWithEffects + statesWithRegularSpells
                        } ?: listOf(GameState(effectedMage.copy(hp = 0), effectedBoss, false) to 0)
                }
            }
        }
    }
}