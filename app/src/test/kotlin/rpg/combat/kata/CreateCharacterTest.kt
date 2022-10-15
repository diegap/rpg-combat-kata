package rpg.combat.kata

import org.junit.Test
import rpg.combat.kata.actions.CreateCharacter
import rpg.combat.kata.domain.RpgCharacter
import rpg.combat.kata.domain.RpgCharacter.Companion.FULL_HEALTH
import rpg.combat.kata.domain.RpgCharacter.Companion.INITIAL_LEVEL
import kotlin.test.assertEquals


class CreateCharacterTest {

    private lateinit var character: RpgCharacter

    private lateinit var action: CreateCharacter
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
    fun `another created character should have different id`() {
        TODO()
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

    private fun whenActionIsInvoked() {
        character = action.invoke()
    }

    private fun givenAnAction() {
        action = CreateCharacter()
    }

}




