package rpg.combat.kata.domain

class RpgCharacter() {
    companion object {
        const val FULL_HEALTH = 1000
        const val INITIAL_LEVEL = 1
    }

    val level: Int = INITIAL_LEVEL
    val health: Int = FULL_HEALTH
    val isAlive get() = health > 0
}