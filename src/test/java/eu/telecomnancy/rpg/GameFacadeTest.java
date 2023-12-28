package eu.telecomnancy.rpg;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Healer;
import eu.telecomnancy.rpg.gameCharacters.Warrior;
import eu.telecomnancy.rpg.gameCharacters.Wizard;

public class GameFacadeTest {
    GameFacade gameFacade = new GameFacade();
    Team teamJJK = GameFacade.teamJJK();
    Team teamNaruto = GameFacade.teamNaruto();

    @Test
    public void testAddFellowship() {
        gameFacade.addFellowship(teamJJK);
        assertTrue(gameFacade.contains(teamJJK));
    }

    @Test
    public void testRemoveFellowship() {
        testAddFellowship();
        gameFacade.removeFellowship(teamJJK);
        assertFalse(gameFacade.contains(teamJJK));
    }

    @Test
    public void testAttack() {
        int teamNarutoInitialHealth = teamNaruto.getHealth();
        gameFacade.attack(teamJJK, teamNaruto);
        assertTrue(teamNarutoInitialHealth > teamNaruto.getHealth());
    }

}
