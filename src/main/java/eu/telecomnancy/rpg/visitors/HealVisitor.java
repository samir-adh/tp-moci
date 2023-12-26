package eu.telecomnancy.rpg.visitors;

import java.util.Collection;

import eu.telecomnancy.rpg.Team;
import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Healer;
import eu.telecomnancy.rpg.gameCharacters.Warrior;
import eu.telecomnancy.rpg.gameCharacters.Wizard;

public class HealVisitor implements CharacterVisitor {
    Integer hpHeal;

    public HealVisitor(Integer hpHeal) {
        this.hpHeal = hpHeal;
    }

    private void updateHealth(GameCharacter gameCharacter) {
        gameCharacter.heal(hpHeal);
    }

    @Override
    public void visit(Warrior warrior) {
        this.updateHealth((GameCharacter) warrior);
    }

    @Override
    public void visit(Wizard wizard) {
        this.updateHealth((GameCharacter) wizard);
    }

    @Override
    public void visit(Healer healer) {
        this.updateHealth((GameCharacter) healer);
    }

    @Override
    public void visit(Team team) {
        Collection<GameCharacter> players = team.getPlayers();
        for (GameCharacter player : players) {
            player.accept(this);
        }
    }

}
