package rpg.combat.kata

import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import rpg.combat.kata.actions.CreateCharacter
import rpg.combat.kata.domain.rpgcharacter.IdRepository
import rpg.combat.kata.domain.rpgcharacter.RpgCharacter
import rpg.combat.kata.domain.rpgcharacter.RpgCharacter.Companion.FULL_HEALTH
import rpg.combat.kata.domain.rpgcharacter.RpgCharacter.Companion.INITIAL_LEVEL
import rpg.combat.kata.domain.rpgcharacter.RpgCharacterRepository
import rpg.combat.kata.infra.InMemoryIdRepository
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue


class CreateCharacterTest {

    private lateinit var character: RpgCharacter
    private lateinit var anotherCharacter: RpgCharacter

    private lateinit var createCharacter: CreateCharacter
    private lateinit var rpgCharacterRepository: RpgCharacterRepository

    @Test
    fun `created character should have initial health`() {
        givenAnAction()

        whenActionIsInvoked()

        thenCharacterHasInitialHealth()
    }

    @Test
    fun `created character should have initial level`() {
        givenAnAction()

        whenActionIsInvoked()

        thenCharacterHasInitialLevel()
    }

    @Test
    fun `created character should be alive`() {
        givenAnAction()

        whenActionIsInvoked()

        thenCharacterShouldBeAlive()
    }

    @Test
    fun `created character should have an id`() {
        givenAnAction()

        whenActionIsInvoked()

        thenCharacterShouldHaveAnId()
    }

    @Test
    fun `created characters should have different ids`() {
        givenAnAction()
        givenACreatedCharacter()

        whenActionIsInvoked()

        thenCharactersHaveDifferentIds()
    }

    @Test
    fun `created character should be saved`() {
        givenAnAction()

        whenActionIsInvoked()

        thenCharacterIsSaved()
    }



    private fun givenACreatedCharacter() {
        anotherCharacter = createCharacter.invoke()
    }

    private fun givenAnAction() {
        val idRepository: IdRepository = InMemoryIdRepository()
        rpgCharacterRepository = mockk {
            justRun { save(any()) }
        }
        createCharacter = CreateCharacter(idRepository, rpgCharacterRepository)
    }

    private fun whenActionIsInvoked() {
        character = createCharacter()
    }

    private fun thenCharacterIsSaved() {
        verify(exactly = 1) {
            rpgCharacterRepository.save(character)
        }
    }

    private fun thenCharactersHaveDifferentIds() {
        assertNotEquals(character.id, anotherCharacter.id)
    }

    private fun thenCharacterShouldHaveAnId() {
        assertTrue(character.id.isNotEmpty())
    }

    private fun thenCharacterShouldBeAlive() {
        assert(character.isAlive)
    }

    private fun thenCharacterHasInitialLevel() {
        assertEquals(INITIAL_LEVEL, character.level)
    }

    private fun thenCharacterHasInitialHealth() {
        assertEquals(FULL_HEALTH, character.health)
    }

}




