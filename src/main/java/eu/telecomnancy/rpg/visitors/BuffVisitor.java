package eu.telecomnancy.rpg.visitors;

import java.util.Collection;

import eu.telecomnancy.rpg.Team;
import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Healer;
import eu.telecomnancy.rpg.gameCharacters.Warrior;
import eu.telecomnancy.rpg.gameCharacters.Wizard;

public class BuffVisitor implements CharacterVisitor {
    Integer buffQuantity;

    public BuffVisitor(Integer buffQuantity){
        this.buffQuantity = buffQuantity;
    }

    @Override
    public void visit(Warrior warrior) {
        warrior.buff(buffQuantity);
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.buff(buffQuantity);
    }

    @Override
    public void visit(Healer healer){
       healer.buff(buffQuantity);
    }
    @Override
    public void visit(Team team) {
        Collection<GameCharacter> players = team.getPlayers();
        for (GameCharacter player : players) {
            player.accept(this);
        }
    }
}
