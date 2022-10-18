package rpg.combat.kata.domain.rpgcharacter

interface IdRepository {
    fun nextId(): String
}
