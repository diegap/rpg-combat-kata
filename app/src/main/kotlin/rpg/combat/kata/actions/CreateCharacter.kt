package rpg.combat.kata.actions

import rpg.combat.kata.domain.rpgcharacter.RpgCharacterRepository
import rpg.combat.kata.domain.rpgcharacter.IdRepository
import rpg.combat.kata.domain.rpgcharacter.RpgCharacter

class CreateCharacter(
    private val idRepository: IdRepository,
    private val rpgCharacterRepository: RpgCharacterRepository
) {
    operator fun invoke(): RpgCharacter {
        val rpgCharacter = RpgCharacter(idRepository.nextId())
        rpgCharacterRepository.save(rpgCharacter)
        return rpgCharacter
    }
}