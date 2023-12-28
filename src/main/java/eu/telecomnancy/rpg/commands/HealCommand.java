package eu.telecomnancy.rpg.commands;

import java.util.Map;

import eu.telecomnancy.rpg.GameFacade;
import eu.telecomnancy.rpg.Team;
import eu.telecomnancy.rpg.gameCharacters.GameCharacter;

public class HealCommand implements Command {
    Team team;
    GameFacade gameFacade = new GameFacade();
    Map<GameCharacter, Integer> defendingInitialHealthMap;

    public HealCommand(Team team) {
        this.team = team;
        gameFacade.addFellowship(team);

        this.team.getPlayers().forEach(c -> {
            this.defendingInitialHealthMap.put(c, c.getHealth());
        });
    }

    @Override
    public void execute() {
        gameFacade.heal(this.team);
    }

    @Override
    public void undo() {
        this.team.getPlayers().forEach(c -> {
            c.setHealth(defendingInitialHealthMap.get(c));
        });
    }
}
