package eu.telecomnancy.rpg.creators;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Warrior;

public class WarriorCreatorTest {
    private static final WarriorCreator instance = new WarriorCreator();

    @Test
    public void createCharacterTest() {
        GameCharacter warrior = (Warrior) instance.createCharacter("Naruto");
        assertNotNull(warrior);
    }
}
