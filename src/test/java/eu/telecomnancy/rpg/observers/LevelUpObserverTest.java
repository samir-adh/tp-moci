package eu.telecomnancy.rpg.observers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.events.EventType;
import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Warrior;

public class LevelUpObserverTest {
    LevelUpObserver levelUpObserver = new LevelUpObserver();

    @Test
    public void testLevelUp(){
        GameCharacter character = new Warrior("Yuji");
        character.getEventManager().subscribe(EventType.LEVEL_UP, levelUpObserver);
        character.levelUp();
        assertTrue(levelUpObserver.getLevel(character)>0);
    }
}
