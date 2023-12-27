package eu.telecomnancy.rpg.observers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.events.EventType;
import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Wizard;

public class DeathObserverTest {
    DeathObserver deathObserver = new DeathObserver();

    @Test
    public void testDeath() {
        GameCharacter character = new Wizard("Satoru");
        character.getEventManager().subscribe(EventType.DEATH, deathObserver);
        character.takeDamage(1000);
        assertTrue(deathObserver.isDead(character));
    }
}
