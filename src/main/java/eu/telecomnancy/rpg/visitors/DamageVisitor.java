package eu.telecomnancy.rpg.visitors;

import java.util.Collection;

import eu.telecomnancy.rpg.Team;
import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Warrior;
import eu.telecomnancy.rpg.gameCharacters.Wizard;
import eu.telecomnancy.rpg.gameCharacters.Healer;

public class DamageVisitor implements CharacterVisitor {
    Integer damage;
    public DamageVisitor(Integer damage){
        this.damage = damage;
    }

    private void updateHealth(GameCharacter gameCharacter){
        gameCharacter.takeDamage(damage);
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
    public void visit(Healer healer){
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
