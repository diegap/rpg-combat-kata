package rpg.combat.kata.domain.rpgcharacter

interface RpgCharacterRepository {
    fun save(rpgCharacter: RpgCharacter)
}
