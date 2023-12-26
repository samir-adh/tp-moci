package eu.telecomnancy.rpg.gameCharacters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CharacterTest {
    @Test
    void testCreateCharacter() {
        Warrior warrior = new Warrior("test");
        assertEquals(100, warrior.getHealth());
    }
}
