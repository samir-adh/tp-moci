package eu.telecomnancy.rpg.strategies;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.gameCharacters.Healer;
import eu.telecomnancy.rpg.gameCharacters.Warrior;
import eu.telecomnancy.rpg.visitors.HealVisitor;

public class DefensiveStrategyTest {
    Warrior attacker = new Warrior("Naruto");
    Healer defender = new Healer("Sakura");

        @Test
    public void defensiveStrategyAttackTest() {
        HealVisitor healVisitor = new HealVisitor(10000);
        defender.accept(healVisitor);

        int initialDefenderHealth = defender.getHealth();
        attacker.attack(defender);
        int newDefenderHealth = defender.getHealth();

        int neutralDamageDealt = initialDefenderHealth - newDefenderHealth;

        attacker.getContext().setStrategy(new DefensiveStrategy());
        initialDefenderHealth = defender.getHealth();
        attacker.attack(defender);
        newDefenderHealth = defender.getHealth();

        int defensiveDamageDealt = initialDefenderHealth - newDefenderHealth;

        assertTrue(defensiveDamageDealt < neutralDamageDealt);
    }

    @Test
    public void defensiveStrategyDefenseTest() {
        HealVisitor healVisitor = new HealVisitor(10000);
        defender.accept(healVisitor);

        int initialDefenderHealth = defender.getHealth();
        attacker.attack(defender);
        int newDefenderHealth = defender.getHealth();

        int neutralDamageTaken = initialDefenderHealth - newDefenderHealth;

        defender.getContext().setStrategy(new DefensiveStrategy());
        initialDefenderHealth = defender.getHealth();
        attacker.attack(defender);
        newDefenderHealth = defender.getHealth();

        int defensiveDamageTaken = initialDefenderHealth - newDefenderHealth;

        assertTrue(defensiveDamageTaken < neutralDamageTaken);
    }
}
