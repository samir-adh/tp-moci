package eu.telecomnancy.rpg.commands;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.GameFacade;
import eu.telecomnancy.rpg.Team;

public class AttackCommandTest {

    @Test
    public void testExecute() {
        Team teamNaruto = GameFacade.teamNaruto();
        Team teamJJK = GameFacade.teamJJK();
        AttackCommand command = new AttackCommand(teamJJK, teamNaruto);
        int teamNarutoInitialHealth = teamNaruto.getHealth();
        command.execute();
        assertTrue(teamNarutoInitialHealth > teamNaruto.getHealth());
    }

    @Test
    public void testUndo() {
        Team teamNaruto = GameFacade.teamNaruto();
        Team teamJJK = GameFacade.teamJJK();
        AttackCommand command = new AttackCommand(teamJJK, teamNaruto);
        int teamNarutoInitialHealth = teamNaruto.getHealth();
        command.execute();
        assertTrue(teamNarutoInitialHealth > teamNaruto.getHealth());
        command.undo();
        assertTrue(teamNarutoInitialHealth == teamNaruto.getHealth());
    }
}
