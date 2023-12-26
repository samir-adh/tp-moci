package eu.telecomnancy.rpg.visitors;

import eu.telecomnancy.rpg.Team;
import eu.telecomnancy.rpg.gameCharacters.*;

public interface CharacterVisitor {
    void visit(Warrior warrior);
    void visit(Wizard wizard);

    void visit(Healer healer);

    void visit(Team team);
}
