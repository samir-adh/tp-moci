package eu.telecomnancy.rpg.characterDecorators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Warrior;

public class InvincibleDecoratorTest {
    @Test
    public void testDecorator(){
        GameCharacter clarkKent = new Warrior("Superman");
        clarkKent = new InvincibleDecorator(clarkKent);
        int initialHealth = clarkKent.getHealth();
        clarkKent.takeDamage(10000);
        assertEquals(initialHealth, clarkKent.getHealth());
    }
}
