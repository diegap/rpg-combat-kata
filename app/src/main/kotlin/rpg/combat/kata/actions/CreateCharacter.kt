package rpg.combat.kata.actions

import rpg.combat.kata.domain.RpgCharacter

class CreateCharacter() {
    fun invoke(): RpgCharacter {
        return RpgCharacter()
    }
}