package rpg.combat.kata.domain

import rpg.combat.kata.domain.exceptions.InvalidCharacterActionException
import java.util.UUID
import kotlin.math.max
import kotlin.math.min

data class RPGCharacter(
    val health: Int,
    val level: Int,
    val id: RPGCharacterId
) {

    constructor() : this(
        health = INITIAL_HEALTH,
        level = 1,
        id =
    )

    val isAlive: Boolean get() = health > 0

    fun attack(victim: RPGCharacter, damage: Int): RPGCharacter {
        checkIsValidAction(victim)
        return victim.copy(health = max(victim.health - damage, 0))
    }

    private fun checkIsValidAction(victim: RPGCharacter) {
        if (victim == this) throw InvalidCharacterActionException()
    }

    fun heal(character: RPGCharacter, healthToAdd: Int) = if (character.isAlive) {
        character.copy(health = min(character.health + healthToAdd, INITIAL_HEALTH))
    } else character

    companion object {
        const val INITIAL_HEALTH = 1000
    }
}

data class RPGCharacterId(val uuid: UUID)
