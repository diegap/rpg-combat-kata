package rpg.combat.kata.infra

import rpg.combat.kata.domain.rpgcharacter.IdRepository
import java.util.*

class InMemoryIdRepository : IdRepository {
    override fun nextId(): String {
        return UUID.randomUUID().toString()
    }

}