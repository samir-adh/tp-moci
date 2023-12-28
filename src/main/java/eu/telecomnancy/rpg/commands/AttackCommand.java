package eu.telecomnancy.rpg.commands;

import java.util.HashMap;
import java.util.Map;

import eu.telecomnancy.rpg.GameFacade;
import eu.telecomnancy.rpg.Team;
import eu.telecomnancy.rpg.gameCharacters.GameCharacter;

public class AttackCommand implements Command {
    Team attacking;
    Team defending;
    GameFacade gameFacade = new GameFacade();
    Map<GameCharacter, Integer> defendingInitialHealthMap;

    public AttackCommand(Team attacking, Team defending) {
        this.attacking = attacking;
        this.defending = defending;
        gameFacade.addFellowship(attacking);
        gameFacade.addFellowship(defending);
        this.defendingInitialHealthMap = new HashMap<>();

        this.defending.getPlayers().forEach(c -> {
            this.defendingInitialHealthMap.put(c, c.getHealth());
        });
    }

    @Override
    public void execute() {
        gameFacade.attack(attacking, defending);
    }

    @Override
    public void undo() {
        defending.getPlayers().forEach(c -> {
            c.setHealth(defendingInitialHealthMap.get(c));
        });
    }
}
