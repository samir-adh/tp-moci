package eu.telecomnancy.rpg.creators;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Wizard;

public class WizardCreatorTest {
    private static final WizardCreator instance = new WizardCreator();

    @Test
    public void createCharacterTest() {
        GameCharacter wizard = (Wizard) instance.createCharacter("Sasuke");
        assertNotNull(wizard);
    }
}
