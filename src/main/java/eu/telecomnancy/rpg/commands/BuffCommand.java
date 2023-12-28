package eu.telecomnancy.rpg.commands;

import eu.telecomnancy.rpg.GameFacade;
import eu.telecomnancy.rpg.Team;
import eu.telecomnancy.rpg.gameCharacters.GameCharacter;

import java.util.Map;

public class BuffCommand implements Command {
    Team team;
    GameFacade gameFacade = new GameFacade();
    Map<GameCharacter, Integer> defendingInitialHealthMap;

    public BuffCommand(Team team) {
        this.team = team;
        gameFacade.addFellowship(team);

        this.team.getPlayers().forEach(c -> {
            this.defendingInitialHealthMap.put(c, c.getHealth());
        });
    }

    @Override
    public void execute() {
        gameFacade.buff(this.team);
    }

    @Override
    public void undo() {
        
    }
}
