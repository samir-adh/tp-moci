package eu.telecomnancy.rpg.creators;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Healer;

public class HealerCreatorTest {

    private static final HealerCreator instance = new HealerCreator();

    @Test
    public void createCharacterTest() {
        GameCharacter healer = (Healer) instance.createCharacter("Sakura");
        assertNotNull(healer);
    }
}
