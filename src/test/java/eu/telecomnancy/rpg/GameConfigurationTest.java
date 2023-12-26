package eu.telecomnancy.rpg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GameConfigurationTest {
    @Test
    public void testGetInstance() {
        Integer maxTeamSize = 6;
        GameConfiguration firstInstance = GameConfiguration.getInstance(Difficulty.HIGH, maxTeamSize);
        Integer newMaxTeamSize = 3;
        GameConfiguration secondInstance = GameConfiguration.getInstance(Difficulty.HIGH, newMaxTeamSize);
        assertEquals(6, firstInstance.getMaxTeamSize());
        assertEquals(6, secondInstance.getMaxTeamSize());
    }
}
