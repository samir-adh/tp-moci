package eu.telecomnancy.rpg.visitors;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import eu.telecomnancy.rpg.gameCharacters.Healer;
import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.Team;
import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Warrior;
import eu.telecomnancy.rpg.gameCharacters.Wizard;

public class BuffVisitorTest {
    BuffVisitor instance = new BuffVisitor(5);

    @Test
    void visitWarriorTest() {
        Warrior warrior = new Warrior("Usopp");
        int warriorInitialStrength = warrior.getStrength();
        warrior.accept(instance);
        int warriorUpdatedStrength = warrior.getStrength();
        assertTrue(warriorUpdatedStrength > warriorInitialStrength);
    }

    @Test
    void visitWizardTest() {
        Wizard wizard = new Wizard("Kenjaku");
        int wizardInitialIntelligence = wizard.getIntelligence();
        wizard.accept(instance);
        int wizardUpdatedHealth = wizard.getIntelligence();
        assertTrue(wizardUpdatedHealth > wizardInitialIntelligence);
    }

    @Test
    void visitTeamTest() {
        Team team = new Team("Team 7");
        Warrior naruto = new Warrior("Naruto");
        Warrior sasuke = new Warrior("Sasuke");
        Healer sakura = new Healer("Sakura");
        Wizard kakashi = new Wizard("Kakashi");

        List<GameCharacter> members = List.of(naruto, sasuke, sakura, kakashi);
        for (GameCharacter player : members) {
            team.addPlayer(player);
        }

        List<Integer> membersInitialStats = members.stream().map(player -> getSpecialStat(player)).toList();
        team.accept(instance);

        List<Integer> membersUpdatedStats = members.stream().map(player -> getSpecialStat(player)).toList();

        for (int i = 0; i < members.size(); i++) {
             assertTrue(membersInitialStats.get(i) < membersUpdatedStats.get(i));   
        }

    }

    private int getSpecialStat(GameCharacter player) {
        if (player instanceof Warrior) {
            return ((Warrior) player).getStrength();
        } else if (player instanceof Wizard) {
            return ((Wizard) player).getIntelligence();
        } else if (player instanceof  Healer) {
            return ((Healer) player).getWisdom();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
