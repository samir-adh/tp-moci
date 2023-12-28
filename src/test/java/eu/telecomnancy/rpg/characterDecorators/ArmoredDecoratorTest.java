package eu.telecomnancy.rpg.characterDecorators;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Wizard;

public class ArmoredDecoratorTest {
    @Test
    public void testDecorator() {
        GameCharacter bruceWayne = new Wizard("Batman");

        int initialHealth = bruceWayne.getHealth();
        bruceWayne.takeDamage(100);
        int damageTakenWithoutArmor = initialHealth - bruceWayne.getHealth();

        bruceWayne = new ArmoredDecorator(bruceWayne);
        initialHealth = bruceWayne.getHealth();
        bruceWayne.takeDamage(100);
        int damageTakenWithArmor = initialHealth - bruceWayne.getHealth();

        assertTrue(damageTakenWithArmor < damageTakenWithoutArmor);
    }
}
