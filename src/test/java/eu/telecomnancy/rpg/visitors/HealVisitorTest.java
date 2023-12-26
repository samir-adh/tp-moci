package eu.telecomnancy.rpg.visitors;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.Team;
import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Warrior;
import eu.telecomnancy.rpg.gameCharacters.Wizard;

public class HealVisitorTest {
    HealVisitor instance = new HealVisitor(50);
    
    @Test
    void visitWarriorTest(){
        Warrior warrior = new Warrior("Usopp");
        int warriorInitialHealth = warrior.getHealth();
        warrior.accept(instance);
        int warriorUpdatedHealth = warrior.getHealth();
        assertTrue(warriorUpdatedHealth > warriorInitialHealth);
    }

    @Test
    void visitWizardTest(){
        Wizard wizard = new Wizard("Kenjaku");
        int wizardInitialHealth = wizard.getHealth();
        wizard.accept(instance);
        int wizardUpdatedHealth = wizard.getHealth();
        assertTrue(wizardUpdatedHealth > wizardInitialHealth);
    }

    @Test
    void visitTeamTest(){
        Team team = new Team("Team 7");
        Warrior naruto =new Warrior("Naruto");
        Warrior sasuke =new Warrior("Sasuke");
        Wizard sakura = new Wizard("Sakura");
        Wizard kakashi = new Wizard("Kakashi");

        List<GameCharacter> members = List.of(naruto,sasuke,sakura,kakashi);
        List<Integer> membersInitalHealth = members.stream().map(player -> player.getHealth()).toList();
        for (GameCharacter player : members) {
            team.addPlayer(player);
        }

        instance.visit(team);
        List<Integer> membersUpdatedHealth = members.stream().map(player -> player.getHealth()).toList();
        
        for (int i = 0; i < membersInitalHealth.size(); i++) {
            assertTrue(membersInitalHealth.get(i) < membersUpdatedHealth.get(i));
        }
    }
}
